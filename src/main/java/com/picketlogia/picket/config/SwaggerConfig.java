package com.picketlogia.picket.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("PICKET API 명세서")
                        .description("굉장하고 엄청난 티켓팅 사이트")
                        .version("1.0.0"));
    }
}
