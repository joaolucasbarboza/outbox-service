package com.joaobarboza.outbox_service.core.repository;

import com.joaobarboza.outbox_service.core.entity.EventEntity;
import com.joaobarboza.outbox_service.core.enums.EStatusEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    List<EventEntity> findByStatus(EStatusEvent status);
}
