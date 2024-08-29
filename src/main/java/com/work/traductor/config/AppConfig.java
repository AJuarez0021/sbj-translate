package com.work.traductor.config;

import feign.Request;
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
}
