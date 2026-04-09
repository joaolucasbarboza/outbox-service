package com.joaobarboza.outbox_service.core.dto;

import com.fasterxml.jackson.databind.JsonNode;

public record EventDto(String topic, JsonNode payload) {
}
