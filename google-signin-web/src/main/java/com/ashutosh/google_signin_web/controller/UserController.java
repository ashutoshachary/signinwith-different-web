package com.ashutosh.google_signin_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashutosh.google_signin_web.exception.ResourceNotFoundException;
import com.ashutosh.google_signin_web.model.User;
import com.ashutosh.google_signin_web.repository.UserRepository;
import com.ashutosh.google_signin_web.security.CurrentUser;
import com.ashutosh.google_signin_web.security.UserPrincipal;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
