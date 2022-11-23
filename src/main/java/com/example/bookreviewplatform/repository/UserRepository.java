package com.example.bookreviewplatform.repository;

import com.example.bookreviewplatform.model.User;
import com.example.bookreviewplatform.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByIdAndUserType(Long id, UserType userType);
}

