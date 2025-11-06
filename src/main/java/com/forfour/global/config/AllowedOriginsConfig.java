package com.forfour.global.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AllowedOriginsConfig {

    public String[] getAllowedOrigins(){
        return new String[]{
            "localhost:3000",
            "localhost:5173"
        };
    }

}
