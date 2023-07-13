package br.com.desafio.videos.repository;

import br.com.desafio.videos.domain.entity.Responsavel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends PagingAndSortingRepository<Responsavel, Integer> {
}
