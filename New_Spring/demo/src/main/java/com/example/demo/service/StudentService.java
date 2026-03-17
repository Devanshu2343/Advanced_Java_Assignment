package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.IStudentRepo;

public class StudentService implements  IStudentService{

    private  final  IStudentService iStudentService ;

    public StudentService (IStudentRepo iStudentRepo){
        this.iStudentRepo= iStudentRepo ;
    }





}
