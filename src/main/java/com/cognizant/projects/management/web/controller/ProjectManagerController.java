package com.cognizant.projects.management.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProjectManagerController {


    @GetMapping("/students/{studentId}")
    public void retrieveCoursesForStudent(@PathVariable String studentId) {


    }



}
