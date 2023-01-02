// package com.niit.userauthenticationservice.repository;

// import com.niit.userauthenticationservice.domain.User;

// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.test.context.junit.jupiter.SpringExtension;



// import static org.junit.jupiter.api.Assertions.assertEquals;
// @ExtendWith(SpringExtension.class)
// @DataJpaTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// public class UserRepositoryTest {

//     @Autowired
//     private UserRepository userRepository;

//     private User user;

//     @BeforeEach
//     public void setUp() throws Exception {
//         user = new User("sam@gmail.com", "111");

//     }

//     @AfterEach
//     public void tearDown() throws Exception {
//         userRepository.deleteAll();
//     }


//     @Test
//     public void testSaveUserSuccess() {
//         userRepository.save(user);
//         User object = userRepository.findById(user.getEmail()).get();
//         assertEquals(user.getEmail(), object.getEmail());
//     }

//     @Test
//     public void testLoginUserSuccess() {
//         userRepository.save(user);
//         User object = userRepository.findById(user.getEmail()).get();
//         assertEquals(user.getEmail(), object.getEmail());
//     }
// }
