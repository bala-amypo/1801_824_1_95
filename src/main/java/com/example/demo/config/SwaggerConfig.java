package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// @Configuration
// public class SwaggerConfig {

//     @Bean
//     public OpenAPI customOpenAPI() {
//         return new OpenAPI()

//                 // API Info
//                 .info(new Info()
//                         .title("JWT Demo API")
//                         .version("1.0")
//                         .description("Simple JWT Demo Project for Students"))

//                 // Server Configuration
//                 .servers(List.of(
//                         new Server().url("https://9004.32procr.amypo.ai/")
//                 ))

//                 // Security Configuration (JWT Bearer)
//                 .components(new Components()
//                         .addSecuritySchemes("bearerAuth",
//                                 new SecurityScheme()
//                                         .type(SecurityScheme.Type.HTTP)
//                                         .scheme("bearer")
//                                         .bearerFormat("JWT")
//                                         .description("Enter JWT token")));
//     }
// }

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            // API basic information
            .info(new Info()
                .title("Personal Finance Budget Planner API")
                .version("1.0")
                .description("JWT secured REST APIs"))

            // Server URL (optional)
            .servers(List.of(
                new Server().url("https://9004.32procr.amypo.ai/")
            ))

            // JWT Security definition
            .components(new Components()
                .addSecuritySchemes("bearerAuth",
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                ));
    }
}
