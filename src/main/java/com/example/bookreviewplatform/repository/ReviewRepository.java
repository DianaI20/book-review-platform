package com.example.bookreviewplatform.repository;

import com.example.bookreviewplatform.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT b from Review b where b.book.id = :id")
    List<Review> findAllByBook(Long id);
}
