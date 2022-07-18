package com.example.i18nexample;

import com.example.i18nexample.entity.LanguageType;
import com.example.i18nexample.entity.Person;
import com.example.i18nexample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;
import java.util.Locale;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        Person person1 = Person.builder()
                .firstName("Jack")
                .lastName("Smith")
                .language(LanguageType.ENGLISH)
                .build();

        Person person2 = Person.builder()
                .firstName("Паша")
                .lastName("Воробьёв")
                .language(LanguageType.RUSSIAN)
                .build();

        Person person3 = Person.builder()
                .firstName("Анна")
                .lastName("Слуцкая")
                .language(LanguageType.RUSSIAN)
                .build();

        personRepository.saveAll(List.of(person1, person2, person3));

        int morningMaxHour = 11;
        int afternoonMaxHour = 17;
        int eveningMaxHour = 23;

        String codeSuffix;
        LocalTime now = LocalTime.of(6, 0);
        if (now.getHour() <= morningMaxHour) {
            codeSuffix = "morning";
        } else if (now.getHour() <= afternoonMaxHour) {
            codeSuffix = "afternoon";
        } else {
            codeSuffix = "evening";
        }





        personRepository.findAll()
                .forEach(person -> {


                    String covidColor = messageSource.getMessage(
                            "status.red",
                            null,
                            new Locale(person.getLanguage().getLanguageType())
                    );

                    String covidMessage = messageSource.getMessage(
                            "status.baseMessage",
                            new Object[]{covidColor},
                            new Locale(person.getLanguage().getLanguageType())
                    );

                    var greeting = getGreetingMessage("message.greeting." + codeSuffix, person);
                    System.out.println(greeting);
                    System.out.println(covidMessage);
                });
    }


    private String getMessage(String code, LanguageType language, Object...args) {
        return messageSource.getMessage(
                code,
                args,
                new Locale(language.getLanguageType())
        );
    }

    private String getGreetingMessage(String code, Person person) {
        return messageSource.getMessage(
                code,
                new Object[]{person.getFirstName(), person.getLastName()},
                new Locale(person.getLanguage().getLanguageType())
        );
    }


}
