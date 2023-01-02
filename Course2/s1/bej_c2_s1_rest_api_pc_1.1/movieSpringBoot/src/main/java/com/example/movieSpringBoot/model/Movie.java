package com.example.movieSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    private int movieId;
    private String movieName;
    private String movieHero;

    public Movie() {
    }

    public Movie(int movieId, String movieName, String movieHero) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieHero = movieHero;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieHero() {
        return movieHero;
    }

    public void setMovieHero(String movieHero) {
        this.movieHero = movieHero;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieHero='" + movieHero + '\'' +
                '}';
    }
}
