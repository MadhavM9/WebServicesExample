package com.example.webserviceexample.services.addition;

import org.springframework.stereotype.Service;

@Service
public class Addition {

    public float add(float a,float b){

        return a+b;
    }
}
