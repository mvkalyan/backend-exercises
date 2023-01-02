package com.stackroute.muzixservice.controller;


import com.stackroute.muzixservice.domain.Track;
import com.stackroute.muzixservice.exception.TrackAlreadyExistsException;
import com.stackroute.muzixservice.exception.TrackNotFoundException;
import com.stackroute.muzixservice.service.MuzixService;
import com.stackroute.muzixservice.service.MuzixServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * As in this assignment, we are working with creating RESTful web service, hence annotate
 * the class with @RestController annotation.A class annotated with @Controller annotation
 * has handler methods which returns a view. However, if we use @ResponseBody annotation along
 * with @Controller annotation, it will return the data directly in a serialized
 * format. Starting from Spring 4 and above, we can use @RestController annotation which
 * is equivalent to using @Controller and @ResposeBody annotation
 */
@RestController
@RequestMapping("/api")
public class MuzixController {


    /*
     * Autowiring should be implemented for the MuzixService. (Use
     * Constructor-based autowiring) Please note that we should not create any
     * object using the new keyword
     */
    @Autowired
    private MuzixService muzixService;

    /*
     * Define a handler method which will read the
     * track object from request body and save the track in
     * database..This
     * handler method should return any one of the status messages basis on
     * different situations:
     * 1.201(CREATED - In case of successful creation of the track object
     * 2.409(CONFLICT) - In case of duplicate track.
     * 3.500(InternalServerError) - In case of any other issue
     *
     *
     * This handler method should map to the URL "/api/v1/muzixservice/track" using HTTP POST
     * method".
     */
    @PostMapping("/v1/muzixservice/track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
        return new ResponseEntity<>(muzixService.SaveTrackToWishList(track),HttpStatus.CREATED);
    }

    /*
     * Define a handler method which will delete a track from a database.
     *
     * This handler method should return any one of the status messages basis on
     * different situations:
     * 1. 200(OK) - If the track is deleted successfully from database.
     * 2. 404(NOT FOUND) - If the track with specified trackId is not found.
     * 3. 500(InternalServerError) - In case of any other issue
     *
     * This handler method should map to the URL "/api/v1/muzixservice/track/{id}" using HTTP Delete
     * method.
     */
    @DeleteMapping("/v1/muzixservice/track/{id}")
    public ResponseEntity<?> deleteATrack(@PathVariable String id) throws TrackNotFoundException {
        return new ResponseEntity<>(muzixService.deleteTrackFromWishList(id),HttpStatus.OK);
    }

    /*
     * Define a handler method which will update a comment from the track by reading the
     * object from request body and save the updated track details in
     * database. This handler method should return any one of the status
     * messages basis on different situations:
     * 1. 200(OK) - If the comment updated successfully.
     * 2. 404(NOT FOUND) - If the track with specified trackId is not found.
     * 3. 500(InternalServerError) - In case of any other issue
     * This handler method should map to the URL "/api/v1/muzixservice/track/{id}" using HTTP PUT
     * method.
     */
    @PutMapping("/v1/muzixservice/track/{id}")
    public ResponseEntity<?> updateATrack(@RequestBody String comment,@PathVariable String id) throws TrackNotFoundException {
        return new ResponseEntity<>(muzixService.updateCommentForTrack(comment,id),HttpStatus.OK);
    }

    /*
     * Define a handler method which will get us all the tracks.
     *
     * This handler method should return any one of the status messages basis on
     * different situations:
     * 1. 200(OK) - If the track found successfully.
     * 2. 500(InternalServerError) - In case of any other issue
     *
     *
     * This handler method should map to the URL "/api/v1/muzixservice/tracks" using HTTP GET method
     */
    @GetMapping("/v1/muzixservice/tracks")
    public ResponseEntity<?> getAllTracks() throws Exception {
        return new ResponseEntity<>(muzixService.getAllTrackFromWishList(),HttpStatus.OK);
    }
    /*
     * Define a handler method which will get us all the tracks for a specific artist.
     *
     * This handler method should return any one of the status messages basis on
     * different situations:
     * 1. 200(OK) - If the track found successfully.
     * 2. 404(NOT FOUND) - If the track with specified is not found.
     * 3. 500(InternalServerError) - In case of any other issue
     *
     *
     * This handler method should map to the URL "/api/v1/muzixservice/tracks/{artistName}" using HTTP GET method
     */
    @GetMapping("/v1/muzixservice/tracks/{artistName}")
    public ResponseEntity<?> getTracksOfArtist(@PathVariable String artistName) throws TrackNotFoundException {
        return new ResponseEntity<>(muzixService.getAllTracksByArtistName(artistName),HttpStatus.OK);
    }






}
