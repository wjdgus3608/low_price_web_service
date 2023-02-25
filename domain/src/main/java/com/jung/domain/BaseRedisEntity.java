package com.jung.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.redis.core.TimeToLive;

import javax.persistence.Column;
import java.time.LocalDateTime;

abstract public class BaseRedisEntity {
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt = LocalDateTime.now();
    @TimeToLive
    private long expiredTime;
}
