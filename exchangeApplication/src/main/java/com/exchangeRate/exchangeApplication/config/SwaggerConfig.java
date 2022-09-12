package com.exchangeRate.exchangeApplication.config;


import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springdoc.core.Constants.ALL_PATTERN;



@Configuration

public class SwaggerConfig {


    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("Bitcoin Rate")
                .pathsToMatch(ALL_PATTERN)
                .addOpenApiCustomiser(openApi ->
                        openApi.info(
                                new Info()
                                        .title("BITCOIN RATE")
                                        .version("1.0")
                                        .description("Bitcoin")
                                        .license(new License().name("Apache 2.0"))
                                        .contact(new Contact().name("Coral Pay").email("Coral Pay").url("Coral Pay"))
                        )
                )
                .build();
    }
}
