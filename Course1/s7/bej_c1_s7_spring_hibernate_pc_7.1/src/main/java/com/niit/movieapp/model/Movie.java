package com.niit.movieapp.model;

import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;

/**
 Add the appropriate annotations for the model class
 Annotate the class with @Entity
 Annotate each field with @Column
 For the datePlayed field add the annotation @DateTimeFormat(pattern = "yyyy-MM-dd").
    Ensure the date is accepted in the index.jsp in the same pattern
 */
public class Movie {
    private String movieName;

    private LocalDateTime datePlayed;

    private String directorName;

    public Movie() {
    }

    public Movie(String movieName, LocalDateTime datePlayed, String directorName) {
       // initialize the variales
    }

    // Getters and Setters

    public String getMovieName() {
        return " ";
    }

    public void setMovieName(String movieName) {
        this.movieName = "";
    }

    public LocalDateTime getDatePlayed() {
        return null;
    }

    public void setDatePlayed(LocalDateTime datePlayed) {
        this.datePlayed = null;
    }

    public String getDirectorName() {
        return " ";
    }

    public void setDirectorName(String directorName) {
        this.directorName = "";
    }


}
