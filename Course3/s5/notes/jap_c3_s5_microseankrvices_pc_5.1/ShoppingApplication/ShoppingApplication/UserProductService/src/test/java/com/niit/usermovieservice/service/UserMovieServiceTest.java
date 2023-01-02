// package com.niit.usermovieservice.service;

// import com.niit.usermovieservice.domain.Movie;
// import com.niit.usermovieservice.domain.User;
// import com.niit.usermovieservice.exception.MovieNotFoundException;
// import com.niit.usermovieservice.exception.UserAlreadyExistsException;
// import com.niit.usermovieservice.exception.UserNotFoundException;
// import com.niit.usermovieservice.repository.UserMovieRepository;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;
// import static org.mockito.Mockito.times;

// @ExtendWith(MockitoExtension.class)
// public class UserMovieServiceTest {
//     @Mock
//     private UserMovieRepository userMovieRepository;
//     @InjectMocks
//     private UserMovieServiceImpl userMovieService;
//     private Movie movie1,movie2;
//     private User user;
//     List<Movie> movies;
//     @BeforeEach
//     public void setUp(){

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
// //        movie1 = null;
// //        movie2 = null;
// //        movies = null;
//     }

//     @Test
//     public void givenUserToSaveReturnSavedUserSuccess() throws UserAlreadyExistsException {
//         when(userMovieRepository.findById(any())).thenReturn(Optional.ofNullable(null));
//         when(userMovieRepository.save(any())).thenReturn(user);
//         assertEquals(user,userMovieService.registerUser(user));
//         verify(userMovieRepository,times(1)).findById(any());
//         verify(userMovieRepository,times(1)).save(any());
//     }
//     @Test
//     public void givenUserToSaveReturnSavedUserFailure() throws UserAlreadyExistsException {
//         when(userMovieRepository.findById(any())).thenReturn(Optional.ofNullable(user));
//         assertThrows(UserAlreadyExistsException.class,()->userMovieService.registerUser(user));
//         verify(userMovieRepository,times(1)).findById(any());
//         verify(userMovieRepository,times(0)).save(any());
//     }
// //    @Test
// //    public void givenMovieToDeleteSuccess() throws MovieNotFoundException, UserNotFoundException {
// //        when(userMovieRepository.findById(user.getEmail())).thenReturn(Optional.ofNullable(user));
// //        userMovieService.deleteUserMovieFromList(user.getEmail(),"m002");
// //        verify(userMovieRepository,times(1)).findById(any());
// //        verify(userMovieRepository,times(1)).deleteById(any());
// //    }
// //
// //    @Test
// //    public void givenMovieToDeleteFailure()
// //    {
// //        when(userMovieRepository.findById(any())).thenReturn(null);
// //        assertThrows(UserNotFoundException.class,()->
// //                userMovieService.deleteUserMovieFromList(user.getEmail(),"m00"));
// //        verify(userMovieRepository,times(1)).findById(any());
// //        verify(userMovieRepository,times(0)).deleteById(any());
// //    }
//     @Test
//     public void givenGetAllUsersReturnListOfAllUsers() {

//     }
// }
