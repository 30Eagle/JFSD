package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.entity.Person;
import com.klu.model.PersonManager;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonManager PM;

    @PostMapping("/register")
    public String register(@RequestBody Person pu) {
        // Check if the username already exists
        Person existingUser = PM.findByUsername(pu.getUsername());
        // Check if the email already exists
        Person existingEmail = PM.findByEmail(pu.getEmail());

        if (existingUser != null) {
            return "Username already exists";
        } else if (existingEmail != null) {
            return "Email is already taken";
        } else {
            // Proceed with registration if neither the username nor email exists
            return PM.Registration(pu);
        }
    }

    @Autowired
    private HttpSession httpSession;

    @PostMapping("/login")
    public String login(@RequestBody Person loginUser) {
        Person foundPerson = PM.findByUsername(loginUser.getUsername());
        if (foundPerson != null && foundPerson.getPassword().equals(loginUser.getPassword())) {
            // Store user details in the session
            httpSession.setAttribute("loggedInUser", foundPerson);
            return "Successfully logged in";
        } else {
            return "Invalid username or password";
        }
    }
}