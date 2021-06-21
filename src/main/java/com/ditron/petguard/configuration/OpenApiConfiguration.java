package com.ditron.petguard.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenApiConfiguration {
    @Bean(name = "petguardOpenApi")
    public OpenAPI petGuardOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("PetGuard Application API")
                        .description("PetGuard API Implementation"));
    }
}
