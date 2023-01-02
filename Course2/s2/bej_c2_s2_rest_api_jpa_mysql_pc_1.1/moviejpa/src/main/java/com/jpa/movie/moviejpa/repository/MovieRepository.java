package com.jpa.movie.moviejpa.repository;

import com.jpa.movie.moviejpa.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    //public Movie updateReleaseDate(int id, Date date);

    public List<Movie> findMovieByMovieName(String movieName);

    public List<Movie> findByMovieGenre(String genreName);
}
