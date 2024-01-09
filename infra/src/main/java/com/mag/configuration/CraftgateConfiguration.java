package com.mag.configuration;

import io.craftgate.Craftgate;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Setter
@Configuration
@ConfigurationProperties(prefix = "craftgate")
public class CraftgateConfiguration {

    private String apiKey;

    private String secretKey;

    private String baseUrl;

    @Bean
    public Craftgate craftgate() {
        return new Craftgate(apiKey, secretKey, baseUrl);
    }


}
