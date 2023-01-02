package com.niit.movieapp.test.dao;

import com.niit.movieapp.config.AppConfig;

import com.niit.movieapp.dao.MovieDAO;
import com.niit.movieapp.dao.MovieDAOImpl;
import com.niit.movieapp.model.Movie;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@Transactional
@ContextConfiguration(classes = { AppConfig.class })
public class MovieDAOTest {
    @Autowired
    private SessionFactory sessionFactory;
    private MovieDAO movieDAO;
    private Movie movie;
    @BeforeEach
    void setUp()
    {
        movieDAO = new MovieDAOImpl(sessionFactory);
        movie = new Movie();
        movie.setMovieName("Shawshank Redemption");
        movie.setDatePlayed(LocalDateTime.of(1994,10,14,0,0));
        movie.setDirectorName("Frank Darabont");
    }
    @AfterEach
    void tearDown()
    {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Movie");
        query.executeUpdate();
    }
    @Test

    public void testSaveMovieSuccess() {
        movieDAO.addMovie(movie);
        List<Movie> movieList = movieDAO.listAllMovies();
        assertEquals("Shawshank Redemption", movieList.get(0).getMovieName());
    }

    @Test

    public void testSaveMovieFailure() {
        movieDAO.addMovie(movie);
        List<Movie> movieList = movieDAO.listAllMovies();
        assertNotEquals("not equal", movieList.get(0).getMovieName());
    }

    @Test

    public void testGetAllMovies() {
        Movie movie1 = new Movie();
        movie1.setMovieName("Shawshank Redemption");
        movie1.setDatePlayed(LocalDateTime.of(1994,10,14,0,0));
        movie1.setDirectorName("Frank Darabont");
        Movie movie2 = new Movie();
        movie2.setMovieName("Signs");
        movie2.setDatePlayed(LocalDateTime.of(2002,07,29,0,0));
        movie2.setDirectorName("Night Shyamalan");

       movieDAO.addMovie(movie1);
       movieDAO.addMovie(movie2);

        List<Movie> movies = movieDAO.listAllMovies();
        assertEquals(2, movies.size());

      }

}
