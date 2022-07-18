package com.example.i18nexample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum LanguageType {

    ENGLISH("en"),
    RUSSIAN("ru")
    ;

    private final String languageType;

    public static LanguageType getByType(String type) {
        if (type == null) {
            return null;
        }

        return Arrays.stream(LanguageType.values())
                .filter(langType -> langType.getLanguageType().equals(type))
                .findFirst()
                .orElse(null);
    }
}
