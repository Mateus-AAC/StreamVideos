package br.com.desafio.videos.repository;

import br.com.desafio.videos.domain.entity.Video;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends PagingAndSortingRepository<Video, Integer> {
}
