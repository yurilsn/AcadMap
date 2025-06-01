package com.acadmap.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfiguracao {

    @Bean
    public ModelMapper getModel(){
        return new ModelMapper();
    }
}
