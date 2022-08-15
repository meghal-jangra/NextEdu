package com.dpw.nexteducation.service;

import com.dpw.nexteducation.dto.UserDto;
import com.dpw.nexteducation.entity.User;
import com.dpw.nexteducation.mapper.UserMapper;
import com.dpw.nexteducation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(int id){
        return userRepository.findById(id);
    }


    public ResponseEntity<User> addUser(UserDto userDto) {
        return new ResponseEntity<>(userRepository.save(userMapper.dtoTOEntity(userDto)), HttpStatus.CREATED);
    }

    public void updateUser(User user, int id) {
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }
}
