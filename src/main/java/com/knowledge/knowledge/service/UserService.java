package com.knowledge.knowledge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.knowledge.knowledge.dto.UserDto;
import com.knowledge.knowledge.entity.UserEntity;
import com.knowledge.knowledge.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity(userDto);
        userRepository.save(userEntity);
    }

    public UserDto updateUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity(userDto);
        return new UserDto(userRepository.save(userEntity));
    }

    public void deleteUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userRepository.delete(userEntity);
        System.out.printf("User %s with id %d deleted.", userEntity.getName(), id);
    }

    public UserDto getUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        return new UserDto(userEntity);
    }

    public List<UserDto> getAllUser() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(User -> new UserDto(User)).toList();
    }
}
