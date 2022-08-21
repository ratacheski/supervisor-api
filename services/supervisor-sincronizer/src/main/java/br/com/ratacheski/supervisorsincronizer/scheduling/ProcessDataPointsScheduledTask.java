package br.com.ratacheski.supervisorsincronizer.scheduling;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableAsync
@Component
public class ProcessDataPointsScheduledTask {

    @Async
    @Scheduled(fixedRate = 1000)
    public void processDataPoints() {
        System.out.println("Implementation of obtaining measurements from data sources");
    }
}
