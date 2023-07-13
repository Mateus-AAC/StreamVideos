package br.com.desafio.videos.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class VideoUpdate {
    @NotEmpty
    private String URL;
}
