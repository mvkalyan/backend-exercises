package com.jpa.movie.moviejpa.service;

import com.jpa.movie.moviejpa.model.Movie;
import com.jpa.movie.moviejpa.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovieService implements MovieServiceI{

    private MovieRepository movieRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovieReleaseDate(Movie movie,int id) {
        if(movieRepository.findById(id).isEmpty()){
            return null;
        }
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> findMovieByMovieName(String movieName) {
        return movieRepository.findMovieByMovieName(movieName);
    }

    @Override
    public String deleteMovieDetails(int id) {
        if(movieRepository.findById(id).isEmpty())
        {
            return "No movie found with ID :(";
        }
        else
        {
            movieRepository.deleteById(id);
            return "Movie deleted Successfully";
        }
    }

    @Override
    public List<Movie> getAllMoviesByGenre(String genreName) {
        return movieRepository.findByMovieGenre(genreName);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
