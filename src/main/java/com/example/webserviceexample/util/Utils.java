package com.example.webserviceexample.util;

public class Utils {

    public static Boolean validation(String[] value){

        if(value.length > 2 || value.length<1){
           return false;
        }else{
            return true;
        }


    }
}
