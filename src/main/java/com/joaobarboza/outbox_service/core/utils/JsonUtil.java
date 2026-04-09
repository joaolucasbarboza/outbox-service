package com.joaobarboza.outbox_service.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaobarboza.outbox_service.core.dto.EventDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class JsonUtil {

    private final ObjectMapper objectMapper;

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.error("Error converting object to JSON: {}", object, e);
            return "";
        }
    }

    public EventDto toEvent(String json) {
        try {
            return objectMapper.readValue(json, EventDto.class);
        } catch (Exception e) {
            log.error("Error converting JSON to Event: {}", json, e);
            return null;
        }
    }
}
