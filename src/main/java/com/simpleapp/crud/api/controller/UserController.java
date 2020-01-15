package com.simpleapp.crud.api.controller;

import com.simpleapp.crud.dto.response.ModalResponse;
import com.simpleapp.crud.dto.response.UserResponse;
import com.simpleapp.crud.repository.UserRepository;
import com.simpleapp.crud.modals.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/byId/{userId}")
    public ModalResponse getUserById(@PathVariable String userId) {
        Optional<User> entry = userRepository.findById(userId);
        return entry.map(user -> new UserResponse().fromModal(user)).orElse(null);
    }

    @GetMapping("/byFirstName/{firstName}")
    public List<? extends ModalResponse> getUserByFirstName(@PathVariable String firstName) {
        List<User> userList = userRepository.findAllByFirstName(firstName);
        return new UserResponse().fromModal(userList);
    }

    @GetMapping("/byLastName/{lastName}")
    public List<? extends ModalResponse> getUserByLastName(@PathVariable String lastName) {
        List<User> userList = userRepository.findAllByLastName(lastName);
        return new UserResponse().fromModal(userList);
    }
}
