package com.callanga.movie_streaming_service.controller;

import com.callanga.movie_streaming_service.client.MovieCatalogClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/streams")
public class MovieStreamController {

    private static final String VIDEO_DIRECTORY = "C:\\Users\\QC-SDO\\Desktop\\Microservice\\videos\\";
    private Logger logger = LoggerFactory.getLogger(MovieStreamController.class);
    private final MovieCatalogClient movieCatalogClient;

    public MovieStreamController(MovieCatalogClient movieCatalogClient) {
        this.movieCatalogClient = movieCatalogClient;
    }

    @GetMapping("/path/{videoPath}")
    public ResponseEntity<InputStreamResource> streamVideo(@PathVariable String videoPath) throws FileNotFoundException {
        File file = new File(VIDEO_DIRECTORY + videoPath);
        if (file.exists()) {
            InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                                 .contentType(MediaType.parseMediaType("video/mp4"))
                                 .body(inputStreamResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<InputStreamResource> streamMovie(@PathVariable Long movieId) throws FileNotFoundException {
        String path = movieCatalogClient.getMoviePath(movieId);
        logger.info("Path: " + path);
        return streamVideo(path);
    }
}
