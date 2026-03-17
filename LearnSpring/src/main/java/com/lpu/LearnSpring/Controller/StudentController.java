package com.lpu.LearnSpring.Controller;


import com.lpu.LearnSpring.DTO.ApiResponse;
import com.lpu.LearnSpring.DTO.RequestDTO;
import com.lpu.LearnSpring.DTO.ResponseDTO;
import com.lpu.LearnSpring.Service.IStudentService;
import com.lpu.LearnSpring.Entity.Student;
import com.lpu.LearnSpring.repository.IStudentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

     private final IStudentService iStudentService;
    private final IStudentRepo iStudentRepo;


    public StudentController(IStudentService iStudentService, IStudentRepo iStudentRepo) {
        this.iStudentService = iStudentService;
        this.iStudentRepo = iStudentRepo;
    }

    @PostMapping("/requestDto")
    public ResponseDTO saveStudent(@RequestBody RequestDTO requestDTO){

        return  iStudentService.saveStudent(requestDTO);
    }

    @GetMapping("/success")
    public String msg(){
        return "Sucessfully added !!!";
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<ApiResponse<ResponseDTO>> saveStudentNew(@RequestBody RequestDTO requestDTO){
        ResponseDTO responseDTO= iStudentService.saveStudent(requestDTO);
        return new ResponseEntity<>(new ApiResponse<>(
                "200","Student save",responseDTO
        ), HttpStatus.ACCEPTED);

    }

    @GetMapping("/getAll")

    public List<Student> findAll() {
        return iStudentRepo.findAll();
    }
}
