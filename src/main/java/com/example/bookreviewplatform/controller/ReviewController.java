package com.example.bookreviewplatform.controller;

import com.example.bookreviewplatform.controller.dto.ReviewDTO;
import com.example.bookreviewplatform.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ReviewController {

    private ReviewService reviewService;


    @GetMapping("/reviews")
    public ResponseEntity findByBook(@RequestParam(value = "id") Long id){
        return reviewService.findByBookId(id);
    }

    @PostMapping("/add/review")
    public ResponseEntity save(@RequestBody ReviewDTO reviewDTO){
        return reviewService.save(reviewDTO);
    }

}
