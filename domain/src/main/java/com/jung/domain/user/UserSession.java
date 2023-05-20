package com.jung.domain.user;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@RedisHash("user_sessions")
public class UserSession {
    @Id
    private String userId;
    private String sessionValue;
}
