package com.niit.movieapp.controller;

import com.niit.movieapp.dao.MovieDAO;
import com.niit.movieapp.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

// Annotate the class with @Controller
public class MovieController {
    //Autowire the DAO dependency
    private MovieDAO movieDAO;
    public MovieController(MovieDAO movieDAO) {

    }

    // Provide methods for get and post mapping
    // get mapping - must return all the movies from the database to the view
    // post mapping - must save the Movie object provided by the view in the database


    @GetMapping("/")
    public String homepage() {
        return null;
    }

    @PostMapping("/addMovie")
    public String addMovie()
    {
        return "null";
    }

}
