package com.example.fullstackdemo.controller;

import com.example.fullstackdemo.domain.Movie;
import com.example.fullstackdemo.service.MovieServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("*")
@RestController
@RequestMapping("/movie-app/v1")
public class MovieController {
    @Autowired
    private MovieServiceI movieServiceI;
    @GetMapping("/movies")
    public ResponseEntity<?> getAllMovies(){
        return new ResponseEntity<>(movieServiceI.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<?> getAllMovies(@PathVariable int movieId){
        return new ResponseEntity<>(movieServiceI.getMovieByMovieId(movieId), HttpStatus.OK);
    }

    @PutMapping("/movie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieServiceI.updateAMovie(movie), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-movie/{movieId}")
    public ResponseEntity<?> deleteAMovie(@PathVariable int movieId){
        return new ResponseEntity<>(movieServiceI.deleteAMovieById(movieId), HttpStatus.OK);
    }

    @PostMapping("/movie")
    public ResponseEntity<?> insertAMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieServiceI.insertAMovie(movie), HttpStatus.OK);
    }

}
