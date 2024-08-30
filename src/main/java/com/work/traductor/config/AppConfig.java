package com.work.traductor.config;

import feign.Request;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author linux
 */
@Configuration
@Slf4j
public class AppConfig {

    private static final int TIMEOUT = 30;

    @Bean
    public Request.Options requestOptions() {
        return new Request.Options(Duration.ofSeconds(TIMEOUT),
                Duration.ofSeconds(TIMEOUT),
                true);
    }

    @Bean
    public CircuitBreakerRegistry circuitBreakerRegistry() {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED) // Define si la ventana esta basada en un número de llamadas
                .slidingWindowSize(100) //Establece el tamaño de la ventana
                .failureRateThreshold(50) //Define el umbral de tasa de fallos en porcentaje
                .waitDurationInOpenState(Duration.ofSeconds(10)) //Especifica la duración que permanecerá en estado "Open"
                .permittedNumberOfCallsInHalfOpenState(3) //Define el número de llamadas que se permiten cuando el Circuit Breaker está en estado "Half-Open"
                .minimumNumberOfCalls(5) //Define el número mínimo de llamadas que deben realizarse antes de que el Circuit Breaker evalúe la tasa de fallos.
                .build();

        return CircuitBreakerRegistry.of(circuitBreakerConfig);
    }
}
