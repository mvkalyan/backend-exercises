package com.example.fullstackdemo.service;

import com.example.fullstackdemo.domain.Movie;
import com.example.fullstackdemo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements MovieServiceI{
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieByMovieId(int movieId) {
        return movieRepository.findById(movieId).get();
    }

    @Override
    public Boolean deleteAMovieById(int movieId) {
        movieRepository.deleteById(movieId);
        return true;
    }
    @Override
    public Movie updateAMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie insertAMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}