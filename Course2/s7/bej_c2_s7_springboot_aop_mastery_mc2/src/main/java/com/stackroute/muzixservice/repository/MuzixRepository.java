package com.stackroute.muzixservice.repository;

import com.stackroute.muzixservice.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * This interface is extending the MongoRepository interface for Track.
 * Annotate this class with @Repository annotation
 * */


@Repository
public interface MuzixRepository extends MongoRepository<Track,String> {

// write a query method to find the tracks by a particular artist
    @Query("{'artist.artistName':{$eq:?0}}")
    public List<Track> getAllTracksByArtistName(String artistName);
}
