package com.assessment.springrequestresponsecheckpoint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class CamelizeController {
    @GetMapping("/camelize")
    public String doCamelize(@RequestParam String original,@RequestParam(defaultValue="false") boolean initialCap){

        if(initialCap==false){
            String content[]=original.split("_");
            final StringBuilder camelize=new StringBuilder();
            Arrays.stream(content).forEach(element ->
                {
                    camelize.append(element.replaceFirst(Character.toString(element.charAt(0)),Character.toString(element.charAt(0)).toUpperCase()));
                });
             return camelize.toString().replaceFirst(Character.toString(camelize.charAt(0)),Character.toString(camelize.charAt(0)).toLowerCase());
        }
        else {
            String content[]=original.split("_");
            final StringBuilder camelize=new StringBuilder();
            Arrays.stream(content).forEach(element ->
            {
                camelize.append(element.replaceFirst(Character.toString(element.charAt(0)),Character.toString(element.charAt(0)).toUpperCase()));
            });
            return camelize.toString();
        }
    }
}
