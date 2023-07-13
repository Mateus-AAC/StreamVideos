package br.com.desafio.videos.domain.dto;

import br.com.desafio.videos.domain.entity.Responsavel;
import lombok.Data;

@Data
public class ResponsavelResponse {
    private Integer IdResponsavel;
    private String NomeResponsavel;

    public ResponsavelResponse(Responsavel responsavel) {
        this.IdResponsavel = responsavel.getIdResponsavel();
        this.NomeResponsavel = responsavel.getNomeResponsavel();
    }
}
