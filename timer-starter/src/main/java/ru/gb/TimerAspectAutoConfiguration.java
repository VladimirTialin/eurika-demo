package ru.gb;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gb.timer.TimerAspect;

@Configuration
@ConditionalOnProperty(value = "timer.enabled", havingValue = "true")
public class TimerAspectAutoConfiguration {
    @Bean
    TimerAspect timerAspect() {
        return new TimerAspect();
    }
}