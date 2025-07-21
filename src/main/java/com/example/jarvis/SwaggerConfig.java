package com.example.jarvis;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Government ID API", version = "1.0", description = "API to fetch user details based on government ID"))
public class SwaggerConfig {
}
