package com.example.i18nexample.configuration;

import com.example.i18nexample.entity.LanguageType;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LanguageConverter());
    }
}

class LanguageConverter implements Converter<String, LanguageType> {

    @Override
    public LanguageType convert(String source) {
        return LanguageType.getByType(source);
    }
}
