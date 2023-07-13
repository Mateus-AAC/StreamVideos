package br.com.desafio.videos.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdVideo;

    @Column(name = "TituloVideo")
    private String TituloVideo;

    @Column(name = "URL")
    private String URL;

    @Column(name = "IdadeMinima")
    private Integer IdadeMinima;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdResponsavel", referencedColumnName = "IdResponsavel")
    private Responsavel IdResponsavel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCategoria", referencedColumnName = "IdCategoria")
    private Categoria IdCategoria;
}
