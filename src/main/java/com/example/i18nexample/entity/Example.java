package com.example.i18nexample.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Example {


    // primitives + wrappers
    // String
    // entity
    // collection<entity>

    // converter
    // enum -> integer


    @Id
    private Long id;

    @Convert(converter = ListConverter.class)
    private List<String> names;

}

@Converter(autoApply = true)
class ListConverter implements AttributeConverter<List<String>, String> {

    // jackson
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // objectMapper: object -> json | json -> object

    @SneakyThrows
    public static void main(String[] args) {
        String json = "[{\"id\":null,\"firstName\":\"aaa\",\"language\":null},{\"id\":null,\"firstName\":\"bbb\",\"language\":null},{\"id\":null,\"firstName\":\"ccc\",\"language\":null}]";
//        String json = "{\"id\":100500,\"firstName\":\"aaa\",\"language\":null}";

        List<Person> names = List.of(
                Person.builder().firstName("aaa").build(),
                Person.builder().firstName("bbb").build(),
                Person.builder().firstName("ccc").build()
        );
        System.out.println(
                objectMapper.writeValueAsString(names)
        );

        List<Person> people = objectMapper.readValue(json, new TypeReference<List<Person>>() {});

        System.out.println(
                people
        );


    }

    @Override
    @SneakyThrows
    public String convertToDatabaseColumn(List<String> strings) {
        return objectMapper.writeValueAsString(strings);
        // list -> json
    }

    @Override
    @SneakyThrows
    public List<String> convertToEntityAttribute(String s) {
        // ["abc", "xyz"]

        return objectMapper.readValue(s, new TypeReference<List<String>>() {});

        // json array -> list
    }
}
