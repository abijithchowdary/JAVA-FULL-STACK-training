package com.pharmacy.gateway.monitoring;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * Beginner-friendly custom metric example:
 * Counts how many REST calls pass through the API Gateway.
 *
 * Why this helps a demo:
 * You can generate traffic (curl /api/...) and immediately see the metric change in Grafana.
 */
@Component
public class ApiCallCounterFilter implements WebFilter {

    private final Counter apiCallsCounter;

    public ApiCallCounterFilter(MeterRegistry meterRegistry) {
        // A simple counter without labels to keep Grafana queries beginner-friendly.
        this.apiCallsCounter = Counter.builder("pharmacy_api_calls_total")
                .description("Total number of /api/** calls received by the gateway")
                .register(meterRegistry);
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();

        // Only count API requests (skip actuator, swagger, etc.)
        if (path != null && path.startsWith("/api/")) {
            apiCallsCounter.increment();
        }

        return chain.filter(exchange);
    }
}

