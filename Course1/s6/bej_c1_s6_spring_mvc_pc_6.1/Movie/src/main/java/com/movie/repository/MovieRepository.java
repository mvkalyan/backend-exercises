package com.movie.repository;

import com.movie.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    private List<Movie> movieList;


    public MovieRepository() {
        this.movieList = new ArrayList<>();
    }

    public List<Movie> getMovieList() {
        System.out.println("this is get method");
        return movieList;
    }

//    public void setMovieList(List<Movie> movieList) {
//        this.movieList = movieList;
//    }

    public void addMovie(Movie movie)
    {
        System.out.println("this is add method");
        this.movieList.add(movie);
    }

//    public void deleteMovie(int movieName)
//    {
//        this.movieList.remove(movieName);
//    }
//
//    public void updateMovie(Movie movie)
//    {
//        this.movieList.add(movie);
//    }
}
