package com.example.demoSpring.repository;

import com.example.demoSpring.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student , Integer> {



}
