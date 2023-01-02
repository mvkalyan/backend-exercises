package com.jpa.movie.moviejpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Movie {
    @Id
    private int movieId;
    private String movieName;
    private String movieDirector;
    private String movieGenre;
    private Date releaseDate;

    public Movie() {
    }

    public Movie(int movieId, String movieName, String movieDirector, String movieGenre,Date releaseDate) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDirector = movieDirector;
        this.movieGenre = movieGenre;
        this.releaseDate=releaseDate;
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

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieGenre='" + movieGenre + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
