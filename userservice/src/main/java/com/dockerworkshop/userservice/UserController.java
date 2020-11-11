package com.dockerworkshop.userservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

//    @GetMapping("/{username}")
//    public User byID(@PathVariable("username") String username) {
//        return repository.findUserByUsername(username)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User was not found"));
//    }

    @GetMapping("/{id}")
    public User byID(@PathVariable("id") UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User was not found!"));
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return repository.save(user);
    }
}
