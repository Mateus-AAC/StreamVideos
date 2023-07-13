package br.com.desafio.videos.domain.dto;

import br.com.desafio.videos.domain.entity.Video;
import lombok.Data;

@Data
public class VideoResponse {
    private Integer IdVideo;

    private String TituloVideo;

    private String URL;

    private Integer IdadeMinima;

    private Integer IdResponsavel;

    private Integer IdCategoria;

    public VideoResponse(Video video) {
        this.IdVideo = video.getIdVideo();
        this.TituloVideo = video.getTituloVideo();
        this.URL = video.getURL();
        this.IdadeMinima = video.getIdadeMinima();
        this.IdResponsavel = video.getIdResponsavel().getIdResponsavel();
        this.IdCategoria = video.getIdCategoria().getIdCategoria();
    }
}
