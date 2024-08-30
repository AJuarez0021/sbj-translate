package com.work.traductor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author linux
 */
@Configuration
@Slf4j
public class SwaggerConfig {

    /**
     * Open API.
     *
     * @return the open API
     */
    @Bean
    OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("Translate").version("1.0.0")
                .description("Aplicacion para traducir textos a otros idiomas").contact(getContact()));
    }

    /**
     * Gets the contact.
     *
     * @return the contact
     */
    private Contact getContact() {
        return new Contact().name("Translate")
                .url("https://www.music.com/")
                .email("mail@mail.com");
    }
}
