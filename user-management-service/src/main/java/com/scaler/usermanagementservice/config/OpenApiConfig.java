package com.scaler.usermanagementservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("User Management API")
                        .description("This is a sample User Management Service")
                        .version("1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("User Management  API")
                        .url("http://localhost:8081/"));
    }
}
