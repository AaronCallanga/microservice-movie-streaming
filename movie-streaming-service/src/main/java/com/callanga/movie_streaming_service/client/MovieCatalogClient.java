package com.callanga.movie_streaming_service.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieCatalogClient {

    private final RestTemplate restTemplate;
    private static final String CATALOG_SERVICE_URL = "http://movie-catalog-service";      // application.name

    public MovieCatalogClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getMoviePath(Long movieId) {
        MovieInfoDTO movieInfoDTO = restTemplate.getForEntity(CATALOG_SERVICE_URL + "/movies/" + movieId, MovieInfoDTO.class).getBody();
        return movieInfoDTO.getPath();
    }
}
