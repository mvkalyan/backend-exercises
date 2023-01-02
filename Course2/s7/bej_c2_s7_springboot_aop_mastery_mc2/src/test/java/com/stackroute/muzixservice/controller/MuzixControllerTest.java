
package com.stackroute.muzixservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.muzixservice.domain.Artist;
import com.stackroute.muzixservice.domain.Image;
import com.stackroute.muzixservice.domain.Track;
import com.stackroute.muzixservice.exception.TrackAlreadyExistsException;
import com.stackroute.muzixservice.service.MuzixService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class MuzixControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MuzixService muzixService;

    private Artist artist;
    private Image image;
    private Track track;
    private List<Track> trackList;
    @InjectMocks
    private MuzixController muzixController;


    @BeforeEach
    public void setUp(){

        trackList = new ArrayList<>();
        image = new Image(1,"http:url","large");


        artist = new Artist(101,"Jonhn","new url",image);
        track = new Track("Track1","Mynewtrack","new comments","123","new track url",artist);

        trackList.add(track);
        image = new Image(2,"http:url","large");


        artist = new Artist(102,"Jonhnny","new url",image);
        track = new Track("Track2","Mynewtrack123","new comments updated","123","new track url",artist);
        trackList.add(track);
        mockMvc = MockMvcBuilders.standaloneSetup(muzixController).build();

    }

    @AfterEach
    public void tearDown(){

        image = null;
        artist = null;
        track=null;
    }

    @Test
    public void testSaveTrackSuccess() throws Exception {
        when(muzixService.SaveTrackToWishList(any())).thenReturn(track);
        mockMvc.perform(post("/api/v1/muzixservice/track")
                .contentType(MediaType.APPLICATION_JSON).
                        content(jsonToString(track)))
                .andExpect(status().isCreated())
                .andDo(print());
        verify(muzixService,times(1)).SaveTrackToWishList(any());

    }


    @Test
    public void testUpdateCommentSuccess() throws Exception {
        when(muzixService.updateCommentForTrack((track.getComments()),(track.getTrackId()))).thenReturn(track);
        mockMvc.perform(put("/api/v1/muzixservice/track/Track2")
                .contentType(MediaType.APPLICATION_JSON).
                        content(jsonToString(track)))
                .andExpect(status().isOk())
                .andDo(print());

        verify(muzixService,times(1)).updateCommentForTrack(track.getComments(),track.getTrackId());
    }

    @Test
    public void testDeleteTrack() throws Exception {
        when(muzixService.deleteTrackFromWishList(track.getTrackId())).thenReturn(true);
        mockMvc.perform(delete("/api/v1/muzixservice/track/Track2")
                .contentType(MediaType.APPLICATION_JSON).
                        content(jsonToString(track)))
                .andExpect(status().isOk())
                .andDo(print());

        verify(muzixService,times(1)).deleteTrackFromWishList(track.getTrackId());
    }

    @Test
    public void getAllTrackFromWishList() throws Exception{

        when(muzixService.getAllTrackFromWishList()).thenReturn(trackList);
        mockMvc.perform(get("/api/v1/muzixservice/tracks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(track)))
                .andExpect(status().isOk())
                .andDo(print());
        verify(muzixService,times(1)).getAllTrackFromWishList();
    }







    private static String jsonToString(final Object ob) throws JsonProcessingException {
        String result;

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonContent = mapper.writeValueAsString(ob);
            result = jsonContent;
        } catch(JsonProcessingException e) {
            result = "JSON processing error";
        }

        return result;
    }
}
