package com.example.challenge_9.controllers;

import com.example.challenge_9.entities.User;
import com.example.challenge_9.payloads.responses.MessageResponse;
import com.example.challenge_9.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
//@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> saveNewUser(@RequestBody User user)
    {
        User savedUser =  this.userService.saveNewUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> listUsers = this.userService.getAllUsers();
        return new ResponseEntity<>(listUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserByID(@PathVariable("id") long id)
    {
        User user = this.userService.findUserByID(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> updateUserByID(@PathVariable("id") long id, @RequestBody User user)
    {
        String message = this.userService.updateUserByID(id, user);
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteUserById(@PathVariable("id") long id)
    {
        String message = this.userService.deleteUserById(id);
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }
/*
    // Affecter Role to user
    @PutMapping("/affect-role/{idUser}/{idRole}")
    public ResponseEntity<MessageResponse> affectUserToRole(long idUser, long idRole) {
        String message = this.userService.affectUserToRole(idUser, idRole);
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }

    // Affecter Details to user
    @PutMapping("/affect-details/{idUser}/{idDetails}")
    public ResponseEntity<MessageResponse> affectUserToUserDetails(long idUser, long idDetails) {
        String message = this.userService.affectUserToDetails(idUser, idDetails);
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }

    // Affecter Post to user
    @PutMapping("/affect-post/{idUser}/{idPost}")
    public ResponseEntity<MessageResponse> affectUserToPost(long idUser, long idPost) {
        String message = this.userService.affectUserToPost(idUser, idPost);
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }*/

}
