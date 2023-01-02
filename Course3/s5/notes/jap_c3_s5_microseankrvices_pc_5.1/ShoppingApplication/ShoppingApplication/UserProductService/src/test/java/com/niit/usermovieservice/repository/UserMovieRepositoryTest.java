// package com.niit.usermovieservice.repository;

// import com.niit.usermovieservice.domain.Movie;
// import com.niit.usermovieservice.domain.User;
// import com.niit.usermovieservice.service.UserMovieServiceImpl;
// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// import java.util.Arrays;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

// @ExtendWith(SpringExtension.class)
// @DataMongoTest
// public class UserMovieRepositoryTest {

//     @Autowired
//     private UserMovieRepository userMovieRepository;
//     private UserMovieServiceImpl userMovieService;
//     private Movie movie1,movie2;
//     private User user;
//     List<Movie> movies;

//     @BeforeEach
//     public void setUp(){

//         movie1 = new Movie("m001","Shawshank Redemption","DRAMA",
//                 Arrays.asList("Robert","DeNiro"),"Frank",1994,8);
//         movie2 = new Movie("m002","Shawshank Redemption","DRAMA",
//                 Arrays.asList("Robert","DeNiro"),"Frank",1994,8);

//         movies = Arrays.asList(movie1,movie2);

//         user = new User("sam@gmail.com","Sammy","111","8756473635",movies);
//     }

//     @AfterEach
//     public void tearDown()
//     {
//         userMovieRepository.deleteAll();
//     }

//     @Test
//     public void registerUserSuccess()
//     {
//         userMovieRepository.insert(user);
//         User u = userMovieRepository.findById(user.getEmail()).get();
//         assertNotNull(u);
//         assertEquals(user.getEmail(),u.getEmail());
//     }

//     @Test
//     public void getUserByEmailSuccess()
//     {
//         userMovieRepository.insert(user);
//         User u = userMovieRepository.findByEmail(user.getEmail());
//         assertNotNull(u);
//         assertEquals(user.getUserName(),u.getUserName());
//     }
//     @Test
//     public void getMoviesByUserEmailSuccess()
//     {
//         userMovieRepository.insert(user);
//         User u = userMovieRepository.findByEmail(user.getEmail());
//         List<Movie> list = u.getMovieList();
//         assertEquals(2,list.size());
//     }
//     @Test
//     public void deleteMoviesByUserEmailSuccess()
//     {
//         userMovieRepository.insert(user);
//         User u = userMovieRepository.findByEmail(user.getEmail());
//         List<Movie> list = u.getMovieList();
//         list.removeIf(r->r.getMovieId().equals("m001"));
//         assertEquals(1,list.size());
//     }
// }
