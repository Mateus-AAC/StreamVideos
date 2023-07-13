package br.com.desafio.videos.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdCategoria;

    @Column(name = "NomeCategoria")
    private String NomeCategoria;

    @OneToMany(mappedBy = "IdCategoria", fetch = FetchType.LAZY)
    private List<Video> videos;
}
