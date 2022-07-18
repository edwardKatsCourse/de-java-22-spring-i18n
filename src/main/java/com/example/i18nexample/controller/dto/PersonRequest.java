package com.example.i18nexample.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonRequest {
    private String name;
    private Integer age;


    @Future(message = "error.future")
    private LocalDate date;

}
