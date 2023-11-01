package com.scaler.usermanagementservice.config;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean
    public Cache<String, String> tokenCache() {
        return CacheBuilder.newBuilder()
                .expireAfterWrite(10, TimeUnit.DAYS) // set expiration to 10 days
                .maximumSize(1000) // set max size
                .build();
    }
}

