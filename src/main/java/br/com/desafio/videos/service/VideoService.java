package br.com.desafio.videos.service;

import br.com.desafio.videos.domain.dto.*;
import br.com.desafio.videos.domain.entity.Video;
import br.com.desafio.videos.domain.entity.Categoria;
import br.com.desafio.videos.domain.entity.Responsavel;
import br.com.desafio.videos.repository.CategoriaRepository;
import br.com.desafio.videos.repository.ResponsavelRepository;
import br.com.desafio.videos.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository repositoryVideo;
    private final ResponsavelRepository repositoryResponse;
    private final CategoriaRepository repositoryCategoria;

    public ResponseBase<VideoResponse> register(VideoCreateRequest filter) {
        Video newVideo = new Video();

        Optional<Responsavel> responsavelOptional = repositoryResponse.findById(filter.getIdResponsavel());
        Responsavel responsavel = responsavelOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "responsavel não encontrado"));

        Optional<Categoria> categoriaOptional = repositoryCategoria.findById(filter.getIdCategoria());
        Categoria categoria = categoriaOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "categoria não encontrado"));

        newVideo.setTituloVideo(filter.getTituloVideo());
        newVideo.setURL(filter.getURL());
        newVideo.setIdadeMinima(filter.getIdadeMinima());
        newVideo.setIdResponsavel(responsavel);
        newVideo.setIdCategoria(categoria);

        Video videoSave = repositoryVideo.save(newVideo);

        VideoResponse modelResponse = new VideoResponse(videoSave);

        return new ResponseBase<>(modelResponse);
    }

    public ResponseBase<VideoResponse> update(Integer IdVideo, VideoUpdate putModel) {
        Optional<Video> putModelSearch = repositoryVideo.findById(IdVideo);

        if (putModelSearch.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "video não encontrado");
        }

        Video putModels = putModelSearch.get();
        putModels.setURL(putModel.getURL());

        Video putModelSave = repositoryVideo.save(putModels);

        VideoResponse modelResponse = new VideoResponse(putModelSave);

        return new ResponseBase<>(modelResponse);
    }

    public ResponseBase<Page<VideoResponse>> search(PaginatedSearchRequest searchRequest) {

        if (searchRequest.getPaginaAtual() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O indice da página atual deve começar em 0");
        }

        if (searchRequest.getQtdPorPagina() < 1 || searchRequest.getQtdPorPagina() > 50) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade de itens por página deve ser entre 1 e 50 itens");
        }

        PageRequest pageRequest = PageRequest.of(searchRequest.getPaginaAtual(), searchRequest.getQtdPorPagina());

        Page<Video> listDate = repositoryVideo.findAll(pageRequest);

        Page<VideoResponse> listResponse = listDate.map(VideoResponse::new);

        return new ResponseBase<>(listResponse);
    }

    public ResponseBase<VideoResponse> searchId(Integer IdVideo) {

        Optional<Video> videoOptional = repositoryVideo.findById(IdVideo);

        Video video = videoOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Objeto Não encontrado"));

        VideoResponse videoSalvo = new  VideoResponse(video);

        return new ResponseBase<>(videoSalvo);
    }
}
