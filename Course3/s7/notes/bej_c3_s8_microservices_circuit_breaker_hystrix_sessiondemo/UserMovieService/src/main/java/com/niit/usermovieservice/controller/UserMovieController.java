package com.niit.usermovieservice.controller;

import com.niit.usermovieservice.domain.Movie;
import com.niit.usermovieservice.domain.User;
import com.niit.usermovieservice.exception.MovieNotFoundException;
import com.niit.usermovieservice.exception.UserAlreadyExistsException;
import com.niit.usermovieservice.exception.UserNotFoundException;
import com.niit.usermovieservice.service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/")
public class UserMovieController {
private UserMovieService userMovieService;
private ResponseEntity<?> responseEntity;
@Autowired
    public UserMovieController(UserMovieService userMovieService) {
        this.userMovieService = userMovieService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
    try {
        responseEntity =  new ResponseEntity<>(userMovieService.registerUser(user), HttpStatus.CREATED);
    }
    catch(UserAlreadyExistsException e)
    {
        throw new UserAlreadyExistsException();
    }
    return responseEntity;
    }
    @PostMapping("/user/movie/{email}")
    public ResponseEntity<?> saveUserMovieToList(@RequestBody Movie movie, @PathVariable String email) throws UserNotFoundException {
    try {
        responseEntity = new ResponseEntity<>(userMovieService.saveUserMovieToList(movie, email), HttpStatus.CREATED);
    }
    catch (UserNotFoundException e)
    {
        throw new UserNotFoundException();
    }
    return responseEntity;
    }
    @GetMapping("/user/movies/{email}")
    public ResponseEntity<?> getAllUserMoviesFromList(@PathVariable String email) throws UserNotFoundException {
    try{
        responseEntity = new ResponseEntity<>(userMovieService.getAllUserMovies(email), HttpStatus.OK);
    }catch(UserNotFoundException e)
    {
        throw new UserNotFoundException();
    }
       return responseEntity;
    }
    @DeleteMapping("/user/{email}/{movieId}")
    public ResponseEntity<?> deleteUserProductFromList(@PathVariable String email,@PathVariable String movieId)
            throws UserNotFoundException, MovieNotFoundException
    {
        try {
            responseEntity = new ResponseEntity<>(userMovieService.deleteUserMovieFromList(email, movieId), HttpStatus.OK);
        } catch (UserNotFoundException | MovieNotFoundException m) {
            throw new MovieNotFoundException();
        }
        return responseEntity;
    }
}

