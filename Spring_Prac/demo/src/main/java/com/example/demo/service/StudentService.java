package com.example.demo.service;

import com.example.demo.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service

public class StudentService implements  IStudentService{

    @Override
    public Student save(Student student) {
        System.out.println(student.getId());
        System.out.println(student.getName());
        return  student ;
    }
}
