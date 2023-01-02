package com.example.movieSpringBoot.controller;

import com.example.movieSpringBoot.model.Movie;
import com.example.movieSpringBoot.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello/api")
public class MovieController {

    @Autowired
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.save(movie), HttpStatus.CREATED);
    }

    @GetMapping("/movie")
    public ResponseEntity<?> getMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(),HttpStatus.OK);
    }
}
