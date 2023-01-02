package com.niit.usermovieservice.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Movie {
    @Id
    private String movieId;
    private String movieName;
    private String genre;
    private List<String> leadActors;
    private String director;
    private int yearOfRelease;
    private int rating;

    public Movie() {
    }

    public Movie(String movieId, String movieName, String genre, List<String> leadActors, String director, int yearOfRelease, int rating) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.genre = genre;
        this.leadActors = leadActors;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<String> getLeadActors() {
        return leadActors;
    }

    public void setLeadActors(List<String> leadActors) {
        this.leadActors = leadActors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
