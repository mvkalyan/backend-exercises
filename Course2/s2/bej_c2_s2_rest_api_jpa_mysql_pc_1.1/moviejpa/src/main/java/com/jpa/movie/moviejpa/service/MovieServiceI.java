package com.jpa.movie.moviejpa.service;

import com.jpa.movie.moviejpa.model.Movie;

import java.util.Date;
import java.util.List;

public interface MovieServiceI {
    public Movie saveMovie(Movie movie);
    public Movie updateMovieReleaseDate(Movie movie,int id);
    public List<Movie> findMovieByMovieName(String movieName);
    public String deleteMovieDetails(int id);
    public List<Movie> getAllMoviesByGenre(String genreName);

    public List<Movie> getAllMovies();
}
