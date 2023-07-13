package br.com.desafio.videos.Controller;

import br.com.desafio.videos.domain.dto.PaginatedSearchRequest;
import br.com.desafio.videos.domain.dto.ResponsavelCreateRequest;
import br.com.desafio.videos.domain.dto.ResponsavelResponse;
import br.com.desafio.videos.domain.dto.ResponseBase;
import br.com.desafio.videos.service.ResponsavelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ResponsavelController {
    @Autowired
    private final ResponsavelService service;

    @GetMapping(value = "api/responsavel/search")
    public ResponseEntity search(PaginatedSearchRequest searchRequest) {

        ResponseBase<Page<ResponsavelResponse>> ListReturn = service.search(searchRequest);

        return ResponseEntity.ok(ListReturn);
    }

    @PostMapping(value = "api/responsavel/register")
    public ResponseEntity register(@Valid @RequestBody ResponsavelCreateRequest postModel) {

        ResponseBase<ResponsavelResponse> registerReturn = service.register(postModel);

        return ResponseEntity.ok(registerReturn);
    }
}
