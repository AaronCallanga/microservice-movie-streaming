package com.callanga.movie_catalog_service.controller;

import com.callanga.movie_catalog_service.entity.MovieInfo;
import com.callanga.movie_catalog_service.repository.MovieInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

    private final MovieInfoRepository movieInfoRepository;

    public MovieInfoController(MovieInfoRepository movieInfoRepository) {
        this.movieInfoRepository = movieInfoRepository;
    }

    @PostMapping
    public List<MovieInfo> saveAllMovieInfo(@RequestBody List<MovieInfo> movieInfoList) {
        return movieInfoRepository.saveAll(movieInfoList);
    }

    @GetMapping
    public List<MovieInfo> getAllMovieInfos() {
        return movieInfoRepository.findAll();
    }
}
