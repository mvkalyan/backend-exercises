package com.niit.movieapp.test.controller;

import com.niit.movieapp.config.AppConfig;
import com.niit.movieapp.controller.MovieController;
import com.niit.movieapp.dao.MovieDAO;
import com.niit.movieapp.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppConfig.class })
public class MovieControllerTest {
    LocalDateTime localDate = LocalDateTime.now();
    private MockMvc mockMvc;
    private Movie movie;
    DateTimeFormatter fmt;
    @Mock
    private MovieDAO movieDAO;
    @InjectMocks
    private MovieController movieController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
        movie = new Movie("Shawshank Redemption",LocalDateTime.of(1994,10,14,0,0),"Frank");
        fmt = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd")
                .optionalStart()
                .appendPattern(" HH:mm")
                .optionalEnd()
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .toFormatter();
    }

    @Test
    public void testIndexPage() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(forwardedUrl("index"));
    }

    @Test
    public void testAddMovieSuccess() throws Exception {
        when(movieDAO.addMovie(any(Movie.class))).thenReturn(true);
        mockMvc.perform(post("/addMovie")
                .param("movieName", movie.getMovieName())
                .param("datePlayed",movie.getDatePlayed().format(fmt))
                .param("directorName", movie.getDirectorName()))
                .andExpect(status().isFound()).andExpect(redirectedUrl("/"));
    }



}
