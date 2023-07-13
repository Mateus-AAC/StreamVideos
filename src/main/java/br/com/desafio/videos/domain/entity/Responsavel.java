package br.com.desafio.videos.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Responsavel")
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdResponsavel;

    @Column(name = "NomeResponsavel")
    private String NomeResponsavel;

    @OneToMany(mappedBy = "IdResponsavel", fetch = FetchType.LAZY)
    private List<Video> videos;
}
