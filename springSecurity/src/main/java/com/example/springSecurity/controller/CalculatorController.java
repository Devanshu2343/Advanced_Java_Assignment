package com.example.springSecurity.controller;


import com.example.springSecurity.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculators")
public class CalculatorController {

    //http://localhost:9090/calculators/add?a=6.5&b=9
    @GetMapping("/add")
    public Double add(
            @RequestParam("a") Double a ,@RequestParam("b") Double b ){

        return a+b ;
    }

    //using path variable
    //http://localhost:9090/calculators/sub/9/9
    @GetMapping("/sub/{a}/{b}")
    public Double sub (
            @PathVariable("a") Double a , @PathVariable ("b") Double b ){
        Double res = null ;
        if (a> b){
            res = a-b;
        }
        else {
            res = b-a ;
        }

        return  res ;
    }

    //http://localhost:9090/calculators/addition/8?a=2&b=4
    @GetMapping("/addition/{c}")
    public  Double addition (
            @RequestParam("a") Double a ,@RequestParam("b") Double b ,@PathVariable("c") Double c) {
        return  a + b + c ;
    }

//    @PostMapping("/mul")
//    public Double multiply(@RequestBody CalculatorDTO calculatorDTO){
//        Double result = null ;
//        result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4() ;
//
//        return result ;
//
//    }

    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result = null ;
        result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4() ;

        return new ResponseEntity<Double>(result , HttpStatus.CREATED);

    }
}
