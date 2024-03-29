package com.example.i18nexample.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class I18nExampleConfiguration {

    @Bean
    public MessageSource messageSource() {
        var messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:greetings");
        messageSource.setDefaultEncoding("UTF-8");

        messageSource.setUseCodeAsDefaultMessage(true);

        return messageSource;
    }

}

