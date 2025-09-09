package com.callanga.movie_catalog_service.repository;

import com.callanga.movie_catalog_service.entity.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieInfoRepository extends JpaRepository<MovieInfo, Long> {
}
