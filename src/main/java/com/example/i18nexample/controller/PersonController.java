package com.example.i18nexample.controller;

import com.example.i18nexample.entity.LanguageType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/example")
    public void enumConverterExample(@RequestParam("lang")LanguageType languageType) {

        System.out.println(languageType);
    }
}
