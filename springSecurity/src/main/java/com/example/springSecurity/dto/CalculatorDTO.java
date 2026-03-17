package com.example.springSecurity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorDTO {

    private Double num1 ;
    private Double num2 ;
    private Double num3 ;
    @JsonProperty("num41") //this annotation is used when JSON variable name is different from java class variable name
    private Double num4 ;
}
