package com.movie.model;

public class Movie {
    private int movieId;
    private String movieName;
    private String movieDirector;
    private String movieHero;

    public Movie() {
    }

    public Movie(int movieId, String movieName, String movieDirector, String movieHero) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDirector = movieDirector;
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

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
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
                ", movieDirector='" + movieDirector + '\'' +
                ", movieHero='" + movieHero + '\'' +
                '}';
    }
}
