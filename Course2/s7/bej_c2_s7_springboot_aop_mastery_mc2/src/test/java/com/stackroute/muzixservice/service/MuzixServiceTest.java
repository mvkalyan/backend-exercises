package com.stackroute.muzixservice.service;


import com.stackroute.muzixservice.domain.Artist;
import com.stackroute.muzixservice.domain.Image;
import com.stackroute.muzixservice.domain.Track;
import com.stackroute.muzixservice.exception.TrackAlreadyExistsException;
import com.stackroute.muzixservice.exception.TrackNotFoundException;
import com.stackroute.muzixservice.repository.MuzixRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class MuzixServiceTest {


    @Mock
    private MuzixRepository muzixRepository;



    private Track track;

    private Optional optional;
    private Image image;
    private Artist artist;

    private List<Track> listTrack=null;

    @InjectMocks
    private MuzixServiceImpl muzixService;

    @BeforeEach
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        image = new Image(1,"http:url","large");


        artist = new Artist(101,"Jonhn","new url",image);
        track = new Track("Track1","Mynewtrack","new comments","123","new track url",artist);

        listTrack = new ArrayList<>();
        listTrack.add(track);
        optional = Optional.of(track);
    }

    @AfterEach
    public void tearDown()
    {
        image = null;
        artist = null;
        track = null;
    }

    @Test
    public void givenTrackToSaveReturnSavedTrackSuccess() throws TrackAlreadyExistsException {
        when(muzixRepository.findById(track.getTrackId())).thenReturn(Optional.ofNullable(null));
        when(muzixRepository.insert(track)).thenReturn(track);

        Track fetchTrack = muzixService.SaveTrackToWishList(track);
        assertEquals(track,fetchTrack);
        verify(muzixRepository,times(1)).insert(track);
        verify(muzixRepository,times(1)).findById(track.getTrackId());

    }

    @Test
    public void givenTrackToSaveReturnSaveTrackFailure() throws TrackAlreadyExistsException {

        when(muzixRepository.findById(track.getTrackId())).thenReturn(Optional.ofNullable(track));
        assertThrows(TrackAlreadyExistsException.class,()->muzixService.SaveTrackToWishList(track));
        verify(muzixRepository,times(0)).insert(track);
        verify(muzixRepository,times(1)).findById(track.getTrackId());


    }

    @Test
    public void givenTrackToUpdateReturnUpdatedTrackSuccess() throws TrackNotFoundException {
        when(muzixRepository.findById(track.getTrackId())).thenReturn(optional);
        track.setComments("comments updated");
        Track fetchTrack = muzixService.updateCommentForTrack(track.getComments(),track.getTrackId());
        System.out.println("fetch track" +fetchTrack.toString());
        assertEquals(fetchTrack.getComments() ,"comments updated" );

        verify(muzixRepository,times(1)).save(track);
        verify(muzixRepository,times(1)).findById(track.getTrackId());
    }

    @Test
    public void givenTrackToDeleteReturnSuccess() throws TrackNotFoundException {
        when(muzixRepository.findById(track.getTrackId())).thenReturn(Optional.ofNullable(track));
        boolean fetchTrack = muzixService.deleteTrackFromWishList(track.getTrackId());
        assertEquals(true,fetchTrack);
        verify(muzixRepository,times(1)).findById(track.getTrackId());
        verify(muzixRepository,times(1)).deleteById(track.getTrackId());
    }

    @Test
    public void giventestGetAllTrackSuccess() throws Exception {
        when(muzixRepository.findAll()).thenReturn(listTrack);
        List<Track> list = muzixService.getAllTrackFromWishList();
        assertEquals(list,listTrack);
        verify(muzixRepository,times(1)).findAll();
    }
}
