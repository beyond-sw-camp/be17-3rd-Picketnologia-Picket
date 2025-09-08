package com.picketlogia.picket.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {

        Info info = new Info()
                .title("PICKET API 명세서")
                .description("굉장하고 엄청난 티켓팅 사이트")
                .version("1.0.0");

        Server server = new Server();
        server.setUrl("https://api.picket.o-r.kr");

        return new OpenAPI()
                .info(info)
                .servers(List.of(server));
    }
}
