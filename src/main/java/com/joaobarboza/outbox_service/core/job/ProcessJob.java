package com.joaobarboza.outbox_service.core.job;

import com.joaobarboza.outbox_service.core.service.OutboxService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class ProcessJob {

    private final OutboxService outboxService;

    @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void ProcessEvents() {
        outboxService.execute();
    }
}
