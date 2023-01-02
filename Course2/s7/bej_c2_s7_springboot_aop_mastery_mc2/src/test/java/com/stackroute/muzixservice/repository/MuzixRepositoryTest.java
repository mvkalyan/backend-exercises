package com.stackroute.muzixservice.repository;


import com.stackroute.muzixservice.domain.Artist;
import com.stackroute.muzixservice.domain.Image;
import com.stackroute.muzixservice.domain.Track;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class MuzixRepositoryTest {



    @Autowired
    private MuzixRepository muzixRepository;





    private Image image;
    private Artist artist;
    private Track track;

    @BeforeEach
    public void setUp(){

        image = new Image(1,"http:url","large");

        artist = new Artist(101,"Jonhn","new url",image);
        track = new Track("Track1","Mynewtrack","new comments","123","new track url",artist);
    }

    @AfterEach
    public void tearDown(){

        image = null;
        artist=null;
        track=null;
        muzixRepository.deleteAll();
    }

    @Test
    public void givenTrackToSaveShouldReturnTrack(){

        muzixRepository.insert(track);
        Track fetchTrack = muzixRepository.findById(track.getTrackId()).get();
        assertEquals(fetchTrack.getTrackName(),track.getTrackName());

    }


    @Test
    public void givenTrackCommentsToUpdateShouldReturnTrack(){
        muzixRepository.insert(track);
        Track fetchTrack = muzixRepository.findById(track.getTrackId()).get();
        fetchTrack.setComments("updating the comments");
        muzixRepository.save(fetchTrack);
        Track fetchTrackobj = muzixRepository.findById(track.getTrackId()).get();
        assertEquals("updating the comments" , fetchTrackobj.getComments());
    }

    @Test
    public void givenTrackToDeleteShouldDeleteTrack(){
        muzixRepository.insert(track);
        Track fetchTrack = muzixRepository.findById(track.getTrackId()).get();
        muzixRepository.delete(fetchTrack);
        assertEquals(Optional.empty(),muzixRepository.findById(track.getTrackId()));

    }

    @Test
    public void givenTrackReturnGetAllTrack(){

        muzixRepository.insert(track);
        Image image = new Image(2,"http:url:another","extralarge");
        Artist artist = new Artist(102,"Joahna","new url",image);
        track = new Track("Track2","Mynewanothertrack","new updated comments","123","new track url",artist);
        muzixRepository.insert(track);
        List<Track> list = muzixRepository.findAll();
        assertEquals(2,list.size());
        assertEquals("Track2",list.get(1).getTrackId());

    }

}
