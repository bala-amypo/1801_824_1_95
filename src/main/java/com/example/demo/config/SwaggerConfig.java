// package com.example.demo.config;

// import io.swagger.v3.oas.models.Components;
// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Info;
// import io.swagger.v3.oas.models.security.SecurityScheme;
// import io.swagger.v3.oas.models.servers.Server;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import java.util.List;

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

package com.example.demo.config;

// Import classes needed to build OpenAPI documentation
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

// Spring annotations
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/*
 * @Configuration
 * Tells Spring that this class contains configuration (bean definitions).
 * Spring will load this class at application startup.
 */
@Configuration
public class SwaggerConfig {

    /*
     * @Bean
     * This method creates a Spring Bean of type OpenAPI.
     * Spring uses this bean to generate Swagger UI documentation.
     *
     * Bean name: customOpenAPI
     */
    @Bean
    public OpenAPI customOpenAPI() {

        /*
         * new OpenAPI()
         * Main object representing the OpenAPI (Swagger) configuration
         */
        return new OpenAPI()

                /*
                 * .info(...)
                 * Adds basic information about your API
                 * This information is shown at the top of Swagger UI
                 */
                .info(new Info()
                        .title("JWT Demo API")                 // API title shown in Swagger UI
                        .version("1.0")                         // API version
                        .description("Simple JWT Demo Project for Students")) // API description

                /*
                 * .servers(...)
                 * Defines the server (base URL) where APIs are hosted
                 * Useful when application runs behind proxy or cloud
                 */
                .servers(List.of(
                        new Server()
                                .url("https://9004.32procr.amypo.ai/") // Base URL of your API
                ))

                /*
                 * .components(...)
                 * Used to define reusable components like security schemes
                 */
                .components(new Components()

                        /*
                         * addSecuritySchemes("bearerAuth", ...)
                         * Defines a security scheme named "bearerAuth"
                         * This name is later referenced in controllers if needed
                         */
                        .addSecuritySchemes("bearerAuth",

                                /*
                                 * SecurityScheme
                                 * Defines how authentication works in Swagger
                                 */
                                new SecurityScheme()

                                        // Type HTTP authentication
                                        .type(SecurityScheme.Type.HTTP)

                                        // Scheme = bearer (used for JWT)
                                        .scheme("bearer")

                                        // Format = JWT (just informational)
                                        .bearerFormat("JWT")

                                        // Description shown in Swagger UI
                                        .description("Enter JWT token")
                        )
                );
    }
}
