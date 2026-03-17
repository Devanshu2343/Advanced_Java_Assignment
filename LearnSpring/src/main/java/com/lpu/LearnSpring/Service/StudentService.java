package com.lpu.LearnSpring.Service;

import com.lpu.LearnSpring.DTO.RequestDTO;
import com.lpu.LearnSpring.DTO.ResponseDTO;
import com.lpu.LearnSpring.Entity.Student;
import com.lpu.LearnSpring.repository.IStudentRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService{
    private IStudentRepo iStudentRepo;

    public StudentService(IStudentRepo iStudentRepo) {
        this.iStudentRepo = iStudentRepo;
    }


    @Override
    public ResponseDTO saveStudent(RequestDTO student) {
        Student student1 = new Student();
        student1.setEmail(student.getEmail());
        student1.setName(student.getName());

        Student savedStudent = iStudentRepo.save(student1);

        return new ResponseDTO(savedStudent.getId(), savedStudent.getName(), savedStudent.getEmail());
    }
}
