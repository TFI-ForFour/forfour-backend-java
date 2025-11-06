package com.forfour.global.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AllowedOriginsConfig {

    public String[] getAllowedOrigins(){
        return new String[]{
            "http://localhost:3000",
            "http://localhost:5173"
        };
    }

}
