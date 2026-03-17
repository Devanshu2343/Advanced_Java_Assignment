package com.example.demoSpring.controller;

import com.example.demoSpring.Student;
import com.example.demoSpring.servicee.IStudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final IStudentService isIStudentService;

    public StudentController(IStudentService isIStudentService) {
        this.isIStudentService = isIStudentService;
    }

    @PostMapping(path = "/saveStudent")
    public Student saveStudent(@RequestBody Student student) {
        return isIStudentService.save(student);

    }
}
