package ru.gb.Timer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "custom-starter.timer.enabled", havingValue = "true")
public class TimerAspectAutoConfiguration {
    @Bean
    TimerAspect timerAspect() {
        return new TimerAspect();
    }
}