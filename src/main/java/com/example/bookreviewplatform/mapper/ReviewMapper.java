package com.example.bookreviewplatform.mapper;

import com.example.bookreviewplatform.controller.dto.BookDTO;
import com.example.bookreviewplatform.controller.dto.ReviewDTO;
import com.example.bookreviewplatform.controller.dto.UserDTO;
import com.example.bookreviewplatform.model.Book;
import com.example.bookreviewplatform.model.Review;
import com.example.bookreviewplatform.model.User;
import com.example.bookreviewplatform.repository.BookRepository;
import com.example.bookreviewplatform.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ReviewMapper implements ObjectMapper<Review, ReviewDTO> {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Review convertFromDTO(ReviewDTO reviewDTO) {

        Review review = new Review();

        if(reviewDTO.getBook().getId() !=null){
            Book book = bookRepository.findById(reviewDTO.getBook().getId()).get();
            review.setBook(book);
        }
        review.setAuthor(userRepository.getById(reviewDTO.getAuthor().getId()));
        review.setDetails(reviewDTO.getDetails());
        review.setSubject(reviewDTO.getSubject());
        return review;
    }

    @Override
    public ReviewDTO convertToDTO(Review review) {

        BookDTO bookDTO = bookMapper.convertToDTO(review.getBook());
        UserDTO userDTO = userMapper.convertToDTO(review.getAuthor());
        ReviewDTO reviewDTO = new ReviewDTO(review.getId(), review.getSubject(), review.getDetails(), bookDTO, userDTO);

        return reviewDTO;
    }

    public List<ReviewDTO> convertToDTO(List<Review> reviews) {
        return reviews.stream().map(r -> convertToDTO(r)).collect(Collectors.toList());
    }
}
