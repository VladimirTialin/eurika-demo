package ru.gb.Timer;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimerAspect {

    @Pointcut("within(@ru.gb.Timer *)")
    public void beansAnnotatedWithTimer() {}

    @Pointcut("@annotation(ru.gb.Timer)")
    public void methodsAnnotatedWithTimer() {
    }

    @Around("beansAnnotatedWithTimer() || methodsAnnotatedWithTimer()")
    public Object methodExecutionTime(ProceedingJoinPoint joinPoint) {

        long startTime = System.currentTimeMillis();

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
        long totalExecutionTime = System.currentTimeMillis() - startTime;

        log.info(joinPoint.getTarget().getClass().getName() +
                " - " +
                joinPoint.getSignature().getName() +
                " #(" +
                (double) totalExecutionTime / 1000 +
                " sec)");

        return result;
    }
}
