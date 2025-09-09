package com.callanga.movie_streaming_service.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/streams")
public class MovieStreamController {

    @GetMapping("/videoPath}")
    public ResponseEntity<InputStreamResource> streamVideo(@PathVariable String videoPath) {


    }
}
