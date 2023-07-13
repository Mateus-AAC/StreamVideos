package br.com.desafio.videos.Controller;

import br.com.desafio.videos.domain.dto.CategoriaCreateRequest;
import br.com.desafio.videos.domain.dto.CategoriaResponse;
import br.com.desafio.videos.domain.dto.PaginatedSearchRequest;
import br.com.desafio.videos.domain.dto.ResponseBase;
import br.com.desafio.videos.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class CategoriaController {

    @Autowired
    private final CategoriaService service;

    @GetMapping(value = "api/categoria/search")
    public ResponseEntity search(PaginatedSearchRequest searchRequest) {

        ResponseBase<Page<CategoriaResponse>> ListReturn = service.search(searchRequest);

        return ResponseEntity.ok(ListReturn);
    }

    @PostMapping(value = "api/categoria/register")
    public ResponseEntity register(@Valid @RequestBody CategoriaCreateRequest postModel) {

        ResponseBase<CategoriaResponse> registerReturn = service.register(postModel);

        return ResponseEntity.ok(registerReturn);
    }
}
