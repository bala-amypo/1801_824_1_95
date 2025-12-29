// package com.example.demo.config;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.servers.Server;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import java.util.List;

// @Configuration
// public class OpenApiConfig {

//     @Bean
//     public OpenAPI customOpenAPI() {
//         return new OpenAPI()
//                 // You need to change the port as per your server
//                 .servers(List.of(
//                         new Server().url("https://9004.32procr.amypo.ai/")
//                 ));
//         }
// }
 package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // 🔐 Define JWT Bearer authentication scheme
        SecurityScheme bearerScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER)
                .name("Authorization");

        return new OpenAPI()
                // 📘 API metadata
                .info(new Info()
                        .title("Personal Finance Budget Planner API")
                        .version("1.0")
                        .description("JWT secured APIs with Swagger Authorize button"))

                // 🌍 Server URL (your hosted URL)
                .servers(List.of(
                        new Server().url("https://9004.32procr.amypo.ai/")
                ))

                // 🔐 Enable Authorize button globally
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))

                // 🔐 Register security scheme
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", bearerScheme));
    }
}
