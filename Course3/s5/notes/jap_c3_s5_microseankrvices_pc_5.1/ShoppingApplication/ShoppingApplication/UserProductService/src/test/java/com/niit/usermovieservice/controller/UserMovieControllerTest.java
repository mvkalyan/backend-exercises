// package com.niit.usermovieservice.controller;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.niit.usermovieservice.domain.Movie;
// import com.niit.usermovieservice.domain.User;
// import com.niit.usermovieservice.exception.MovieNotFoundException;
// import com.niit.usermovieservice.exception.UserAlreadyExistsException;
// import com.niit.usermovieservice.exception.UserNotFoundException;
// import com.niit.usermovieservice.repository.UserMovieRepository;
// import com.niit.usermovieservice.service.UserMovieService;
// import com.niit.usermovieservice.service.UserMovieServiceImpl;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// import java.util.Arrays;
// import java.util.List;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.anyString;
// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @ExtendWith(MockitoExtension.class)
// public class UserMovieControllerTest {

// @Autowired
//     private MockMvc mockMvc;

// @Mock
//     private UserMovieServiceImpl userMovieService;
//     private Movie movie1,movie2;
//     private User user;
//     List<Movie> movies;

// @InjectMocks
//     private UserMovieController userMovieController;

//     @BeforeEach
//     public void setUp(){

//         mockMvc = MockMvcBuilders.standaloneSetup(userMovieController).build();
//         movie1 = new Movie("m001","Shawshank Redemption","DRAMA",
//                 Arrays.asList("Robert","DeNiro"),"Frank",1994,8);
//         movie1 = new Movie("m002","Shawshank Redemption","DRAMA",
//                 Arrays.asList("Robert","DeNiro"),"Frank",1994,8);

//         movies = Arrays.asList(movie1,movie2);

//         user = new User("sam@gmail.com","Sammy","111","8756473635",movies);
//     }

//     @AfterEach
//     public void tearDown()
//     {
//         movie1 = null;
//         movie2 = null;
//         movies = null;
//     }
//     @Test
//     public void registerUserSuccess() throws Exception {
//         when(userMovieService.registerUser(any())).thenReturn(user);
//         mockMvc.perform(post("/api/v1/register")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(asJSONString(user)))
//                 .andExpect(status().isCreated())
//                 .andDo(MockMvcResultHandlers.print());
//     }

// //    @Test
// //    public void registerUserFailure() throws Exception {
// //        when(userMovieService.registerUser(user)).thenThrow(UserAlreadyExistsException.class);
// //        mockMvc.perform(post("/api/v1/register")
// //                .contentType(MediaType.APPLICATION_JSON)
// //                .content(asJSONString(user)))
// //                .andExpect(status().isConflict())
// //                .andDo(MockMvcResultHandlers.print());
// //    }

//     @Test
//     public void saveMovieSuccess() throws Exception, UserNotFoundException {
//         when(userMovieService.saveUserMovieToList(any(),any())).thenReturn(user);
//         mockMvc.perform(post("/api/v1/user/sam@gmail.com/movie")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(asJSONString(user)))
//                 .andExpect(status().isCreated())
//                 .andDo(MockMvcResultHandlers.print());
//     }

// //    @Test
// //    public void saveMovieFailure() throws Exception, UserNotFoundException {
// //        when(userMovieService.saveUserMovieToList(any(),any())).thenThrow(UserNotFoundException.class);
// //        mockMvc.perform(post("/api/v1/user/sam@gmail.com/movie")
// //                .contentType(MediaType.APPLICATION_JSON)
// //                .content(asJSONString(user)))
// //                .andExpect(status().isCreated())
// //                .andDo(MockMvcResultHandlers.print());
// //    }

//     @Test
//     public void getAllMoviesTest() throws Exception, UserNotFoundException {
//         when(userMovieService.getAllUserMovies("sam@gmail.com")).thenReturn(movies);
//         mockMvc.perform(get("/api/v1/user/sam@gmail.com/movies")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(asJSONString(movies)))
//                 .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//     }

//     @Test
//     public void givenProductCodeDeleteProductSuccess() throws Exception, MovieNotFoundException, UserNotFoundException {
//         when(userMovieService.deleteUserMovieFromList(anyString(),anyString())).thenReturn(user);
//         mockMvc.perform(delete("/api/v1/user/sam@gmail.com/m001")
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk())
//                 .andDo(MockMvcResultHandlers.print());

//     }
//     private static String asJSONString(Object user) {
//         try {
//             return new ObjectMapper().writeValueAsString(user);
//         } catch (Exception e) {
//             throw new RuntimeException(e);
//         }
//     }
// }
