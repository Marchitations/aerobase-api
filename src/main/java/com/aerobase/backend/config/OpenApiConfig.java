package com.aerobase.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Controle de Aeronaves")
                        .description("API para gerenciamento de aeronaves e histórico de alterações")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Igor Marchito")
                                .email("marchito.igor@gmail.com")
                        )
                );
    }
}
