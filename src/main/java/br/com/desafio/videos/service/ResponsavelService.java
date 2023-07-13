package br.com.desafio.videos.service;

import br.com.desafio.videos.domain.dto.PaginatedSearchRequest;
import br.com.desafio.videos.domain.dto.ResponsavelCreateRequest;
import br.com.desafio.videos.domain.dto.ResponsavelResponse;
import br.com.desafio.videos.domain.dto.ResponseBase;
import br.com.desafio.videos.domain.entity.Responsavel;
import br.com.desafio.videos.repository.ResponsavelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ResponsavelService {
    private final ResponsavelRepository repository;

    public ResponseBase<Page<ResponsavelResponse>> search(PaginatedSearchRequest searchRequest) {

        if (searchRequest.getPaginaAtual() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O indice da página atual deve começar em 0");
        }

        if (searchRequest.getQtdPorPagina() < 1 || searchRequest.getQtdPorPagina() > 50) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade de itens por página deve ser entre 1 e 50 itens");
        }

        PageRequest pageRequest = PageRequest.of(searchRequest.getPaginaAtual(), searchRequest.getQtdPorPagina());

        Page<Responsavel> listDate = repository.findAll(pageRequest);

        Page<ResponsavelResponse> listResponse = listDate.map(ResponsavelResponse::new);

        return new ResponseBase<>(listResponse);
    }

    public ResponseBase<ResponsavelResponse> register(ResponsavelCreateRequest news) {
        Responsavel modelDb = new Responsavel();

        modelDb.setNomeResponsavel(news.getNomeResponsavel());

        Responsavel modelSave = repository.save(modelDb);

        ResponsavelResponse modelResponse = new ResponsavelResponse(modelSave);

        return new ResponseBase<>(modelResponse);
    }
}
