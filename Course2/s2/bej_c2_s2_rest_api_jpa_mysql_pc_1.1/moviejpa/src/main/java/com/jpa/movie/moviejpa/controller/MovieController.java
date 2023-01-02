package com.jpa.movie.moviejpa.controller;

import com.jpa.movie.moviejpa.model.Movie;
import com.jpa.movie.moviejpa.service.MovieService;
import com.jpa.movie.moviejpa.service.MovieServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/boxoffice")
public class MovieController {
    @Autowired
    private MovieServiceI movieServiceI;

    public MovieController(MovieService movieServiceI) {
        this.movieServiceI = movieServiceI;
    }

    @PostMapping("/movie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieServiceI.saveMovie(movie), HttpStatus.CREATED);
    }

    @GetMapping("/movie")
    public ResponseEntity<?> getAllMovies(){
        return new ResponseEntity<>(movieServiceI.getAllMovies(),HttpStatus.OK);
    }

    @GetMapping("/movie/{movieName}")
    public ResponseEntity<?> getMovieByName(@PathVariable String movieName){
        return new ResponseEntity<>(movieServiceI.findMovieByMovieName(movieName),HttpStatus.OK);
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<?> deleteMovieById(@PathVariable int id){
        return new ResponseEntity<>(movieServiceI.deleteMovieDetails(id),HttpStatus.OK);
    }

    @GetMapping("/movie/genre/{genre}")
    public ResponseEntity<?> getMovieByGenre(@PathVariable String genre){
        return new ResponseEntity<>(movieServiceI.getAllMoviesByGenre(genre),HttpStatus.OK);
    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<?> updateReleaseDate(@PathVariable int id,@RequestBody Movie movie){
        return new ResponseEntity<>(movieServiceI.updateMovieReleaseDate(movie,id),HttpStatus.CREATED);
    }

}
