package com.niit.usermovieservice.service;

import com.niit.usermovieservice.domain.Movie;
import com.niit.usermovieservice.domain.User;
import com.niit.usermovieservice.exception.MovieNotFoundException;
import com.niit.usermovieservice.exception.UserAlreadyExistsException;
import com.niit.usermovieservice.exception.UserNotFoundException;

import java.util.List;

public interface UserMovieService {
User registerUser(User user) throws UserAlreadyExistsException;
User saveUserMovieToList(Movie movie,String email) throws UserNotFoundException;
User deleteUserMovieFromList(String email,String movieId) throws UserNotFoundException, MovieNotFoundException;
List<Movie> getAllUserMovies(String email) throws UserNotFoundException;
List<Movie> getAllMoviesByGenre(String genre);
List<Movie> getAllMovies();
}
