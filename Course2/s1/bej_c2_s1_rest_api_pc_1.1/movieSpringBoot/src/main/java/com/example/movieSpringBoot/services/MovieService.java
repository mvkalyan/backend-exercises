package com.example.movieSpringBoot.services;

import com.example.movieSpringBoot.model.Movie;

import java.util.List;

public interface MovieService {
    public Movie save(Movie movie);

    public List<Movie> getAllMovies();
}
