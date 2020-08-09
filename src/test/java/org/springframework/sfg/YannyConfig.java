package org.springframework.sfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YannyConfig {
    @Bean
    YannyWordProducer yannyWordProducer() {
        return new YannyWordProducer();
    }
}
