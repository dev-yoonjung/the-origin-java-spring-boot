package theorigin.javaspringboot.gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

//@Configuration
public class RoutingConfig {

//    @Bean
    public RouteLocator getewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("community-shop", predicate ->
                        predicate
                            .path("/api/shop/**")
                            .filters(filter ->
                                    filter.rewritePath(
                                            "/api/(?<path>.*)",
                                            "/${path}"
                                    ))
                            .uri("http://localhost:8081")
                )
                .build();
    }

}
