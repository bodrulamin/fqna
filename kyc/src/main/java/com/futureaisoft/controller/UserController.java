package com.futureaisoft.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futureaisoft.exception.ResourceNotFoundException;
import com.futureaisoft.model.User;
import com.futureaisoft.repository.UserRepository;
import com.futureaisoft.security.CurrentUser;
import com.futureaisoft.security.UserPrincipal;

@RestController
public class UserController {
	@Autowired
    private UserRepository userRepository;  


	@GetMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}