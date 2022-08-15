package com.dpw.nexteducation.controller;

import com.dpw.nexteducation.dto.UserDto;
import com.dpw.nexteducation.entity.User;
import com.dpw.nexteducation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @GetMapping("/{name}")
    public User getUser(@PathVariable String name){
        return userService.getUserByName(name);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User user, @PathVariable int id){
        userService.updateUser(user,id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
