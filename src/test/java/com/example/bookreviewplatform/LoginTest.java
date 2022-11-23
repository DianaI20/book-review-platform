package com.example.bookreviewplatform;

import com.example.bookreviewplatform.controller.LoginController;
import com.example.bookreviewplatform.service.UserService;
import com.example.bookreviewplatform.service.exception.WrongPasswordException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private LoginController loginController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginFailureWithWrongEmail() {

        String email = "abcdsdal@gmail.com";
        String password = "12345678910";
        ResponseEntity responseEntity = ResponseEntity.noContent().build();

        try {
            when(userService.findByEmailAndPassword(email, password)).thenReturn(responseEntity);
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        }

        ResponseEntity actualValue = loginController.login(email, password);
        assertEquals(responseEntity, actualValue);
    }

    @Test
    public void testLoginFailureWithWrongPassword() {

        String email = "a@yahoo.com";
        String password = "4";
        ResponseEntity responseEntity = ResponseEntity.noContent().build();

        try {
            when(userService.findByEmailAndPassword(email, password)).thenReturn(responseEntity);
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        }

        ResponseEntity actualValue = loginController.login(email, password);
        assertEquals(responseEntity, actualValue);
    }

    @Test
    public void testSuccessfulLogin() {

        String email = "a@yahoo.com";
        String password = "1234567890";
        ResponseEntity responseEntity = ResponseEntity.noContent().build();

        try {
            when(userService.findByEmailAndPassword(email, password)).thenReturn(responseEntity);
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        }

        ResponseEntity actualValue = loginController.login(email, password);
        assertEquals(responseEntity, actualValue);
    }


}
