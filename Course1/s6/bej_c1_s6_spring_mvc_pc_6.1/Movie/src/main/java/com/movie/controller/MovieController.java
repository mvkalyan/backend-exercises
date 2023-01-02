package com.movie.controller;

import com.movie.model.Movie;
import com.movie.repository.MovieRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    Movie movie = context.getBean("movie", Movie.class);
    MovieRepository movieRepository = context.getBean("movieRepository", MovieRepository.class);


    public MovieController()
    {
        System.out.println("Movie Controller Instantiated ...");
    }

    @GetMapping(path="/")
    public String getMovieHomePage()
    {
        System.out.println("Taking to home Page");
        return "index";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(@ModelAttribute("movie") Movie movie, ModelMap model)
    {
        System.out.println("Taking to the save Movie Page");
        System.out.println("Taking to the save Movie Page ...."+movie);

        this.movieRepository.addMovie(movie);
        System.out.println("***********************************");
        System.out.println(this.movieRepository.getMovieList());
        model.addAttribute("movieList",this.movieRepository.getMovieList());

        return "index";
    }
}
