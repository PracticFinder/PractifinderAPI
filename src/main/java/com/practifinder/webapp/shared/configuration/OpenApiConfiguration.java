package com.practifinder.webapp.shared.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    public OpenAPI customOpenApi(
            String applicationDescription,
            String applicationVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("Practifinder API")
                        .version(applicationVersion)
                        .description(applicationDescription)
                        .termsOfService("https://practifinder.com/tos")
                        .license(new License().name("Apache 2.0 License").url("https://practifinder.com/license"))
                        .contact(new Contact()
                                .url("https://practifinder.com/contact")
                                .name("Practifinder")));
    }
}
