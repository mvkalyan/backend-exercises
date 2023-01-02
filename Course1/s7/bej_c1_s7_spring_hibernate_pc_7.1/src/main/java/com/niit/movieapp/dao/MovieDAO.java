package com.niit.movieapp.dao;

import com.niit.movieapp.model.Movie;

import java.util.List;

//Do not change this interface

public interface MovieDAO {
    public boolean addMovie(Movie movie);
    public List<Movie> listAllMovies();

}
