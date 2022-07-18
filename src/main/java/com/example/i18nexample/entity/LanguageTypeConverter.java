package com.example.i18nexample.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LanguageTypeConverter implements AttributeConverter<LanguageType, String> {

    @Override
    public String convertToDatabaseColumn(LanguageType languageType) {
        return languageType == null ? null : languageType.getLanguageType();
    }

    @Override
    public LanguageType convertToEntityAttribute(String s) {
        return s == null ? null : LanguageType.getByType(s);
    }
}
