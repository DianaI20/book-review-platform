package com.example.bookreviewplatform.mapper;


import com.example.bookreviewplatform.controller.dto.UserDTO;
import com.example.bookreviewplatform.model.User;
import com.example.bookreviewplatform.service.validator.PasswordManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UserMapper implements ObjectMapper<User, UserDTO> {

    private final PasswordManager passwordManager;

    @Override
    public User convertFromDTO(UserDTO userDTO) {

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(passwordManager.encrypt(userDTO.getPassword()));
        user.setDescription(userDTO.getDescription());
        user.setEmail(userDTO.getEmail());
        user.setProfilePicture(userDTO.getProfilePicture());
        user.setUserType(userDTO.getType());
        return user;
    }

    @Override
    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO(user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getUserType(),
                user.getProfilePicture(),
                user.getDescription());
        return userDTO;
    }
}
