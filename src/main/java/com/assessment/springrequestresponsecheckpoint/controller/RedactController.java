package com.assessment.springrequestresponsecheckpoint.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;

@RestController
public class RedactController {
    @GetMapping("/redact")
    public String doRedact(@RequestParam MultiValueMap<String, String> queryString) {
        String result = queryString.getFirst("original");
        for (String element:
             queryString.get("badWord"))
            result=result.replaceAll(element, this.replaceWithStars(element));
        return result;
    }

    public String replaceWithStars(String element) {
        StringBuilder starts = new StringBuilder();
        for (int i = 0; i < element.length(); i++) starts.append("*");
        return starts.toString();
    }
}
