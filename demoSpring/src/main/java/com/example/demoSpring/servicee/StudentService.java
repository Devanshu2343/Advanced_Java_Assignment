package com.example.demoSpring.servicee;


import com.example.demoSpring.Student;
import com.example.demoSpring.repository.IStudentRepo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;




//@Component
@Service
public class StudentService implements  IStudentService{

    private final IStudentRepo isStudentRepo ;

    public StudentService(IStudentRepo isStudentRepo) {
        this.isStudentRepo = isStudentRepo;
    }

    @Override
    public Student save(Student student) {
        System.out.println(student.getId());
        System.out.println(student.getName());
        return  isStudentRepo.save(student) ;
    }
}
