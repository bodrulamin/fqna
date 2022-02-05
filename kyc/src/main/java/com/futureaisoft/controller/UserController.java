package com.futureaisoft.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.futureaisoft.exception.ResourceNotFoundException;
import com.futureaisoft.model.User;
import com.futureaisoft.repository.UserRepository;
import com.futureaisoft.security.CurrentUser;
import com.futureaisoft.security.UserPrincipal;
import com.futureaisoft.util.ApiResponse;
import com.futureaisoft.util.GlobalVariable;

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
	
	@PostMapping("/auth/registration")
    public ResponseEntity<?> registration(@RequestBody User payload) {
		ApiResponse response = new ApiResponse();
		
		if(userRepository.existsByEmail(payload.getEmail())) {
			response.setStatus(GlobalVariable.FAILED);
			response.setMessage("Email already exist");
		}
		
		payload = userRepository.save(payload);
		response.setStatus(GlobalVariable.SUCCESS);
		response.setMessage("Saved successful");
		response.setData(payload);
		
		return ResponseEntity.ok(response);
    }
}