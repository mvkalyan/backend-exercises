package com.example.movieSpringBoot.repository;

import com.example.movieSpringBoot.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Integer> {

}
