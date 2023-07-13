package br.com.desafio.videos.domain.dto;

import lombok.Data;

@Data
public class PaginatedSearchRequest {

    private Integer PaginaAtual;

    private Integer QtdPorPagina;

}
