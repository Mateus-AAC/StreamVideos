package br.com.desafio.videos.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class VideoCreateRequest {

    @NotEmpty
    private String TituloVideo;

    @NotEmpty
    private String URL;

    @NotNull
    private Integer IdadeMinima;

    @NotNull
    private Integer IdResponsavel;

    @NotNull
    private Integer IdCategoria;
}
