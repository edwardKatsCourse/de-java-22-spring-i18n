package com.example.i18nexample.repository;

import com.example.i18nexample.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
