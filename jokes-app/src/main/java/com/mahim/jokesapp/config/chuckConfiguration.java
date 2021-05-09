package com.mahim.jokesapp.config;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class chuckConfiguration {
    @Bean
    public ChuckNorrisQuotes getChuckNorrisQuotes() {
        return new ChuckNorrisQuotes();
    }
}
