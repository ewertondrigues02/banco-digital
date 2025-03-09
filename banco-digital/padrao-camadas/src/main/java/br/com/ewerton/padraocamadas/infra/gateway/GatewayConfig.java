package br.com.ewerton.padraocamadas.infra.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes().route("example_route", r -> r.path("/pessoas_fisicas/**")
                        .uri("http://localhost:8081/pessoas_fisicas"))
                .build();

    }
}
