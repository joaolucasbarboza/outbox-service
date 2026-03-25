package com.joaobarboza.outbox_service.core.service;

import com.joaobarboza.outbox_service.core.entity.EventEntity;
import com.joaobarboza.outbox_service.core.enums.EStatusEvent;
import com.joaobarboza.outbox_service.core.producer.EventProducer;
import com.joaobarboza.outbox_service.core.repository.EventRepository;
import com.joaobarboza.outbox_service.core.utils.JsonUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
@Service
@RequiredArgsConstructor
public class OutboxService {

    private final EventRepository eventRepository;
    private final EventProducer producer;
    private final JsonUtil jsonUtil;

    @Transactional
    public void execute() {
        List<EventEntity> events = eventRepository
                .findByStatus(EStatusEvent.PENDING);

        if (!isEmpty(events)) {
            events.forEach(event -> {
                String eventJson = jsonUtil.toJson(event);
                event.setStatus(EStatusEvent.SUCCESS);
                eventRepository.save(event);
                producer.send(event.getTopic(), eventJson);
            });
        }
    }
}
