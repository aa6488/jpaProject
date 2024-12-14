package com.jpaProject.study.user.service;

import com.jpaProject.study.user.domain.User;
import com.jpaProject.study.user.dto.UserDTO;
import com.jpaProject.study.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    private LocalDateTime localDateTime;

    public UserService(UserRepository userRepository,
                       ModelMapper modelMapper,
                       PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO saveUser(UserDTO userDTO) {

        userDTO.setUserCreateDate(LocalDateTime.now());
        userDTO.setUserPwd(passwordEncoder.encode(userDTO.getUserPwd()));

        User saveUser = userRepository.save(convertEntity(userDTO));

        System.out.println("user 저장결과는 : " + saveUser.toString());

        return convertDto(saveUser);
    }

    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }


    // Entity , DTO 간 converter
    private User convertEntity(UserDTO userDTO) {

        return modelMapper.map(userDTO, User.class);
    }

    private UserDTO convertDto(User user) {

        return modelMapper.map(user, UserDTO.class);
    }






}
