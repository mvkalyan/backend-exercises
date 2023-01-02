package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Track;
import com.stackroute.muzixservice.exception.TrackAlreadyExistsException;
import com.stackroute.muzixservice.exception.TrackNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MuzixService {

    /*
     * Should not modify this interface. You have to implement these methods in
     * corresponding Impl classes
     */

    Track SaveTrackToWishList(Track track) throws TrackAlreadyExistsException;
    boolean deleteTrackFromWishList(String id) throws TrackNotFoundException;

    Track updateCommentForTrack(String comments , String id) throws TrackNotFoundException;
    List<Track> getAllTracksByArtistName(String artistName) throws TrackNotFoundException;
    List<Track> getAllTrackFromWishList() throws Exception;
}
