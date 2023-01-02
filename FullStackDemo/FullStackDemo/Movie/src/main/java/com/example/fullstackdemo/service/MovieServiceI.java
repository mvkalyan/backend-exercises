package com.example.fullstackdemo.service;

import com.example.fullstackdemo.domain.Movie;

import java.util.List;

public interface MovieServiceI {
    public List<Movie> getAllMovies();
    public Movie getMovieByMovieId(int movieId);
    public Boolean deleteAMovieById(int movieId);
    public Movie updateAMovie(Movie movie);
    public Movie insertAMovie(Movie movie);
}
