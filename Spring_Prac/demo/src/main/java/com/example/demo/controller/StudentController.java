package com.example.demo.controller;

import com.example.demo.Student;
import com.example.demo.service.IStudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private  final IStudentService isIStudentService;

    public StudentController(IStudentService isIStudentService) {
        this.isIStudentService = isIStudentService;
    }

    @PostMapping(path = "/saveStudent")
    public Student saveStudent (@RequestBody Student student){
        return  isIStudentService.save(student);

    }



}
