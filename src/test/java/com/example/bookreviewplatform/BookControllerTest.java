package com.example.bookreviewplatform;

import com.example.bookreviewplatform.controller.BookController;
import com.example.bookreviewplatform.controller.dto.BookDTO;
import com.example.bookreviewplatform.controller.dto.UserDTO;
import com.example.bookreviewplatform.model.BookCategory;
import com.example.bookreviewplatform.model.UserType;
import com.example.bookreviewplatform.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @Test
    public void testSave() {
        UserDTO userDTO = new UserDTO(1L,
                "some_email",
                "name",
                "lastname",
                "123456789",
                UserType.READER, "a", "some fancy bio");
        BookDTO bookDTO = new BookDTO(225L,
                "Title",
                "link",
                "description",
                "isbn",
                BookCategory.THRILLER, userDTO);

        ResponseEntity expectedValue = ResponseEntity.noContent().build();
        when(bookService.save(bookDTO)).thenReturn(expectedValue);

        ResponseEntity actualValue = bookController.save(bookDTO);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testFindAll() {


        ResponseEntity expectedValue = ResponseEntity.noContent().build();

        when(bookService.findAll()).thenReturn(expectedValue);

        ResponseEntity actualValue = bookController.findAll();

        assertEquals(expectedValue, actualValue);
    }
}
