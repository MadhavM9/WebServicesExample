package com.example.webserviceexample.controller;

import com.example.webserviceexample.services.addition.Addition;
import com.example.webserviceexample.services.division.Division;
import com.example.webserviceexample.services.multiplication.Multiplication;
import com.example.webserviceexample.services.subtration.Substration;
import com.example.webserviceexample.util.Utils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.Arrays;

@RestController
@AllArgsConstructor
public class CalculatorController {
    private final Multiplication multiplication;
    private final Addition addition;

    private final Substration substration;
    private final Division division;


//    @GetMapping("/callCalulator/{value}")
//    Float one(@PathParam String  value) {
    @GetMapping("/callCalulator")
    String calculator(@QueryParam("value") String  value) {
        String result;
        try {
            result = String.valueOf(templateMethod(value));
        }catch(Exception e){
            result = e.getMessage();
        }
        return result;

    }

    @PostMapping("/callCalulator")
    String calculatorPost(@RequestBody String  value) {
        String result;
        try {
            result = String.valueOf(templateMethod(value));
        }catch(Exception e){
            result = e.getMessage();
        }
        return result;
    }

    private float templateMethod(String value) throws Exception {
        float result = 0.0F;
        if(value.contains("*")){
           String[] data =  value.split("\\*");
            Boolean isValid = Utils.validation(data);
            if(isValid) {
                result = multiplication.multiplication(Float.parseFloat(data[0]), Float.parseFloat(data[1]));
            }else{
                throw new Exception("Invalid Input");
            }
        }
        if(value.contains("-")){
            String[] data =  value.split("\\-");
            Boolean isValid = Utils.validation(data);
            if(isValid) {
                result = substration.substration(Float.parseFloat(data[0]), Float.parseFloat(data[1]));
            }else{
                throw new Exception("Invalid Input");
            }
        }
        if(value.contains("+")){
            String[] data =  value.split("\\+");
            Boolean isValid = Utils.validation(data);
            if(isValid) {
                result = addition.add(Float.parseFloat(data[0]), Float.parseFloat(data[1]));
            }else{
                throw new Exception("Invalid Input");
            }
        }
        if(value.contains("/")){
            String[] data =  value.split("\\/");
            Boolean isValid = Utils.validation(data);
            if(isValid) {
                result = division.division(Float.parseFloat(data[0]), Float.parseFloat(data[1]));
            }else{
                throw new Exception("Invalid Input");
            }
        }
        return result;
    }

}
