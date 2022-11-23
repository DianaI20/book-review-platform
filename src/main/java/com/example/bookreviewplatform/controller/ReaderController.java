package com.example.bookreviewplatform.controller;

import com.example.bookreviewplatform.model.Reader;
import com.example.bookreviewplatform.service.ReaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReaderController {

    private ReaderService readerService;

    public ResponseEntity getReadBooks(Reader reader){
        return ResponseEntity.ok(readerService.getReadBooks(reader));
    }
}
