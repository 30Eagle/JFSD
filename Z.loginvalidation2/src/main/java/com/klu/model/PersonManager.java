package com.klu.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Person;
import com.klu.repositry.PersonRepositry;

@Service
public class PersonManager {
    @Autowired
    PersonRepositry personRepositry;

    public String Registration(Person pu) {
        personRepositry.save(pu);
        return "success";
    }

    public Person findByUsername(String username) {
        return personRepositry.findByUsername(username);
    }

    public Person findByEmail(String email) {
        return personRepositry.findByEmail(email);
    }
    
    public List<Person> getAllPersons() {
        // Retrieve all registered persons from the database
        return personRepositry.findAll();
    }
    
    public long countStudents() {
        // Use the personRepositry to count students where registerAs is "student"
        return personRepositry.countByRegisterAs("student");
    }
    
    public long countCompanies() {
        // Use the personRepositry to count companies where registerAs is "company"
        return personRepositry.countByRegisterAs("company");
    }


   
    
}
