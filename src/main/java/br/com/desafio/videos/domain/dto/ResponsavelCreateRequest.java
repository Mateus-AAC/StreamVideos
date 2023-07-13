package br.com.desafio.videos.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ResponsavelCreateRequest {
    @NotEmpty
    private String NomeResponsavel;
}
