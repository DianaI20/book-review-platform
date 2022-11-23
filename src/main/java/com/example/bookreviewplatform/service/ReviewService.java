package com.example.bookreviewplatform.service;

import com.example.bookreviewplatform.controller.dto.ReviewDTO;
import com.example.bookreviewplatform.mapper.ReviewMapper;
import com.example.bookreviewplatform.model.Review;
import com.example.bookreviewplatform.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    private ReviewRepository reviewRepository;
    private ReviewMapper reviewMapper;

    public ResponseEntity findAll() {
        List <ReviewDTO> reviewDTOList = reviewMapper.convertToDTO(reviewRepository.findAll());
        return ResponseEntity.ok().body(reviewDTOList);

    }

    public ResponseEntity findByBookId(Long id) {

        List<ReviewDTO> reviewDTOList = reviewMapper.convertToDTO(reviewRepository.findAllByBook(id));
        return ResponseEntity.ok().body(reviewDTOList);
    }

    public ResponseEntity save(ReviewDTO reviewDTO) {

        Review review = reviewMapper.convertFromDTO(reviewDTO);
        reviewRepository.save(review);

        return ResponseEntity.ok().build();
    }
}
