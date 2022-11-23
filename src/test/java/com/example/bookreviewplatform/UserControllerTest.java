package com.example.bookreviewplatform;

import com.example.bookreviewplatform.controller.UserController;
import com.example.bookreviewplatform.controller.dto.UserDTO;
import com.example.bookreviewplatform.model.UserType;
import com.example.bookreviewplatform.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {


    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testRegister() {

        // when
        UserDTO userDTO = new UserDTO(1L,
                "some_email",
                "name",
                "lastname",
                "123456789",
                UserType.READER, "a", "some fancy bio");
        ResponseEntity expectedValue = ResponseEntity.noContent().build();
        when(userService.register(userDTO)).thenReturn(expectedValue);

        // given
        ResponseEntity actualValue = userController.register(userDTO);

        // then
        verify(userService, times(1)).register(userDTO);
        assertEquals(expectedValue, actualValue);
    }
}
