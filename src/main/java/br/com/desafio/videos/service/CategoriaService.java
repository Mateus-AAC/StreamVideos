package br.com.desafio.videos.service;

import br.com.desafio.videos.domain.dto.CategoriaCreateRequest;
import br.com.desafio.videos.domain.dto.CategoriaResponse;
import br.com.desafio.videos.domain.dto.PaginatedSearchRequest;
import br.com.desafio.videos.domain.dto.ResponseBase;
import br.com.desafio.videos.domain.entity.Categoria;
import br.com.desafio.videos.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;

    public ResponseBase<Page<CategoriaResponse>> search(PaginatedSearchRequest searchRequest) {

        if (searchRequest.getPaginaAtual() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O indice da página atual deve começar em 0");
        }

        if (searchRequest.getQtdPorPagina() < 1 || searchRequest.getQtdPorPagina() > 50) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade de itens por página deve ser entre 1 e 50 itens");
        }

        PageRequest pageRequest = PageRequest.of(searchRequest.getPaginaAtual(), searchRequest.getQtdPorPagina());

        Page<Categoria> listDate = repository.findAll(pageRequest);

        Page<CategoriaResponse> listResponse = listDate.map(CategoriaResponse::new);

        return new ResponseBase<>(listResponse);
    }

    public ResponseBase<CategoriaResponse> register(CategoriaCreateRequest news) {
        Categoria modelDb = new Categoria();

        modelDb.setNomeCategoria(news.getNomeCategoria());

        Categoria modelSave = repository.save(modelDb);

        CategoriaResponse modelResponse = new CategoriaResponse(modelSave);

        return new ResponseBase<>(modelResponse);
    }
}
