package br.com.desafio.videos.Controller;

import br.com.desafio.videos.domain.dto.*;
import br.com.desafio.videos.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class VideosController {
    @Autowired
    private VideoService service;

    @PostMapping(value = "api/video/register")
    public ResponseEntity  register(@Valid @RequestBody VideoCreateRequest postModel) {

        ResponseBase<VideoResponse> registerReturn = service.register(postModel);

        return ResponseEntity.ok(registerReturn);
    }

    @PutMapping(value = "api/video/update/{IdVideo}")
    public ResponseEntity update(@PathVariable Integer IdVideo, @RequestBody @Valid VideoUpdate putModel) {

        ResponseBase<VideoResponse> updateReturn = service.update(IdVideo, putModel);

        return ResponseEntity.ok(updateReturn);
    }

    @GetMapping(value = "api/video/search")
    public ResponseEntity search(PaginatedSearchRequest searchRequest) {

        ResponseBase<Page<VideoResponse>> listReturn = service.search(searchRequest);

        return ResponseEntity.ok(listReturn);
    }

    @GetMapping(value = "api/video/search/{IdVideo}")
    public ResponseEntity searchId(@PathVariable Integer IdVideo) {

        ResponseBase<VideoResponse> listIdReturn = service.searchId(IdVideo);

        return ResponseEntity.ok(listIdReturn);
    }

}
