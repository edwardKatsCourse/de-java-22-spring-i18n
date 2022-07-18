package com.example.i18nexample.entity;

import lombok.*;

import javax.persistence.*;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Convert(converter = LanguageTypeConverter.class)
    private LanguageType language;


    // messages_XX, где XX - это код языка
    // en
    // message.greeting.morning=Good morning!
    // message.greeting.afternoon=Good afternoon!
    // message.greeting.evening=Good evening!
    //
    // ru
    // message.greeting.morning=Доброе утро!
    // message.greeting.afternoon=Добрый день!
    // message.greeting.evening=Добрый вечер!
    //
}
