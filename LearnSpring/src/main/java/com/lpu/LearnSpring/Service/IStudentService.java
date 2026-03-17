package com.lpu.LearnSpring.Service;

import com.lpu.LearnSpring.DTO.RequestDTO;
import com.lpu.LearnSpring.DTO.ResponseDTO;
import com.lpu.LearnSpring.Entity.Student;

public interface IStudentService {

    ResponseDTO saveStudent(RequestDTO student);
}
