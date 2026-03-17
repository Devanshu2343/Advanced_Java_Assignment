package com.lpu.LearnSpring.repository;

import com.lpu.LearnSpring.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student,Integer> {
}
