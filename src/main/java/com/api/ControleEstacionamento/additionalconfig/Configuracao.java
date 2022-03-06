package com.api.ControleEstacionamento.additionalconfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.format.DateTimeFormatter;

@Configuration
public class Configuracao {

    //Formatação global da data para obedecer o padrão ISO 8601 UTC
    public static final String DATE_TIME_UTC = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static LocalDateTimeSerializer DATE_TIME_SERIALIZER = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_TIME_UTC));

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        JavaTimeModule modulo = new JavaTimeModule();
        modulo.addSerializer(DATE_TIME_SERIALIZER);
        return new ObjectMapper().registerModule(modulo);
    }

}
