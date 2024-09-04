package org.riwi.Spring_Workshop_Week_3.configurations;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Academy Riwi media and courses manager",
        version = "1.0",
        description = "This is an API REST app that manage students, courses, lessons and media archives from those lessons"
))
public class OpenApiConfiguration {

}
