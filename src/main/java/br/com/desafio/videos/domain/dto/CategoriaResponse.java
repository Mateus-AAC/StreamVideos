package br.com.desafio.videos.domain.dto;

import br.com.desafio.videos.domain.entity.Categoria;
import lombok.Data;

@Data
public class CategoriaResponse {

    private Integer IdCategoria;

    private String NomeCategoria;

    public CategoriaResponse(Categoria categoria) {
        this.IdCategoria = categoria.getIdCategoria();
        this.NomeCategoria = categoria.getNomeCategoria();
    }
}
