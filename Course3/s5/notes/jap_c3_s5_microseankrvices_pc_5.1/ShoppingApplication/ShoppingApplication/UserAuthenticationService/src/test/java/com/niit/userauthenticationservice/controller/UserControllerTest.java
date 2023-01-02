// package com.niit.userauthenticationservice.controller;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.niit.userauthenticationservice.domain.User;
// import com.niit.userauthenticationservice.exception.InvalidCredentialsException;
// import com.niit.userauthenticationservice.exception.UserAlreadyExistsException;
// import com.niit.userauthenticationservice.service.UserService;
// import com.niit.userauthenticationservice.service.UserServiceImpl;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @ExtendWith(MockitoExtension.class)
// public class UserControllerTest {
//     @Autowired
//     private MockMvc mockMvc;

//     @Mock
//     private UserServiceImpl userService;
//     private User user;

//     @InjectMocks
//     UserController userController;

//     @BeforeEach
//     void setUp()
//     {
//         user = new User("sam@gmail.com","111");
//         mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//     }
//     @AfterEach
//     public void tearDown() {
//     user = null;
//     }

//     @Test
//     public void givenUserToSaveReturnUserSuccess() throws Exception, UserAlreadyExistsException {
//         when(userService.saveUser(any())).thenReturn(user);
//         mockMvc.perform(post("/api/v1/user")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(asJSONString(user)))
//                 .andExpect(status().isCreated())
//                 .andDo(MockMvcResultHandlers.print());
//     }
// //    @Test
// //    public void givenUserToSaveReturnUserFailure() throws Exception, UserAlreadyExistsException {
// //        when(userService.saveUser(any())).thenThrow(User.class);
// //        mockMvc.perform(post("/api/v1/user")
// //                .contentType(MediaType.APPLICATION_JSON)
// //                .content(asJSONString(user)))
// //                .andExpect(status().isConflict())
// //                .andDo(MockMvcResultHandlers.print());
// //    }

// //    @Test
// //    public void testLoginUser() throws Exception, UserAlreadyExistsException {
// //        String email = "sam@gmail.com";
// //        String password = "111";
// //        when(userService.findByEmailAndPassword(email,password)).thenReturn(user);
// //        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/login")
// //                .contentType(MediaType.APPLICATION_JSON).content(asJSONString(user)))
// //                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
// //    }


//     private static String asJSONString(Object user) {
//         try {
//             return new ObjectMapper().writeValueAsString(user);
//         } catch (Exception e) {
//             throw new RuntimeException(e);
//         }
//     }
// }
