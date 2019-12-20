package com.project.library.service;

import com.project.library.controller.Exception.UserNotFoundException;
import com.project.library.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTestSuite {
    private User userOne = new User(1L, "paula", "kurkova", LocalDate.now(), new ArrayList<>());
    private User userTwo = new User(2L, "paul", "lik", LocalDate.now(), new ArrayList<>());

    @Autowired
    private UserService userService;

    @Before
    public void before() {
        userService.saveUser(userOne);
        userService.saveUser(userTwo);
    }

    @Test
    public void getAllUsersTest() {
        //Given
        //When
        int count = userService.getAllUsers().size();
        //Then
        assertEquals(2, count);
    }

    @Test
    public void getUserTest() throws UserNotFoundException {
        //Given
        //When
        User user = userService.getUser(2L);
        //Then
        assertEquals(user.getName(), userTwo.getName());
    }

    @Test
    public void saveUserTest() {
        //Given
        User userThree = new User(3L, "pawel", "bot", LocalDate.now(), new ArrayList<>());
        userService.saveUser(userThree);
        //When
        int count = userService.getAllUsers().size();
        //Then
        assertEquals(3, count);
    }
}
