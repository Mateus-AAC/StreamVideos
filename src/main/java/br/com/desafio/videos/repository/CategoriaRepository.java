package br.com.desafio.videos.repository;

import br.com.desafio.videos.domain.entity.Categoria;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Integer> {
}
