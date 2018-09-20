package com.thoughtworks.beijingGrad.springbootuserWithContacts.controller;

import com.thoughtworks.beijingGrad.springbootuserWithContacts.domain.Contact;
import com.thoughtworks.beijingGrad.springbootuserWithContacts.repository.UserRepository;
import com.thoughtworks.beijingGrad.springbootuserWithContacts.repository.impl.UserRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserRepository userRepository = new UserRepositoryImpl();

    @GetMapping("/users/{userId}/contacts")
    public ResponseEntity<?> getContactsByUserId(@PathVariable int userId){
        return new ResponseEntity<>(userRepository.getContactsByUserId(userId),
                HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/contacts")
    public ResponseEntity<?> createContactByUserId(@PathVariable int userId, @RequestBody Contact contact){
        return new ResponseEntity<>(userRepository.createContactByUserId(userId, contact),
                HttpStatus.CREATED);
    }

    @PutMapping("/users/{userId}/contacts/{contactId}")
    public ResponseEntity<?> updateContactByUserId(@PathVariable int userId, @PathVariable int contactId,
                                                   @RequestBody Contact contact){
        return new ResponseEntity<>(userRepository.updateContactByUserId(userId, contactId, contact),
                HttpStatus.OK);
    }
}
