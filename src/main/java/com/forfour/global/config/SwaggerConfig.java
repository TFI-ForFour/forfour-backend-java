package com.forfour.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private static final String SCHEMA_NAME = "BearerAuth";

    @Bean
    public OpenAPI openAPI() {
        SecurityScheme accessSecurityScheme = getAccessSecurityScheme();
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(SCHEMA_NAME);

        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .schemaRequirement(SCHEMA_NAME, accessSecurityScheme)
                .addSecurityItem(securityRequirement)
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Tech For Impact 4조 ForFour")
                .description("Tech For Impact 4조 ForFour API 명세서")
                .version("1.0.0");
    }

    private SecurityScheme getAccessSecurityScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER)
                .name("Authorization");
    }
}