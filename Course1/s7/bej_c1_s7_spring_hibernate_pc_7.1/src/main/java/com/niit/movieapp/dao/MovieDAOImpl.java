package com.niit.movieapp.dao;

import com.niit.movieapp.model.Movie;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 Annotate the class with @Component and @Transactional annotations
 */
public class MovieDAOImpl implements MovieDAO {

    // Autowire sessionFactory
    private SessionFactory sessionFactory;
    public MovieDAOImpl(SessionFactory sessionFactory)
    {

    }

    @Override
    public boolean addMovie(Movie movie) {
        // add a new Movie object to the database
             return false;
    }


    @Override
    public List<Movie> listAllMovies() {
        // return all the movies from the database table
        return null;

    }


}
