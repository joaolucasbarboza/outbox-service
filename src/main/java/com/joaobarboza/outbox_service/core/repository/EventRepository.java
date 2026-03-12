package com.joaobarboza.outbox_service.core.repository;

import com.joaobarboza.outbox_service.core.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
