package com.jung.domain.user;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("user_sessions")
@Builder
@Getter
public class UserSession {
    @Id
    private final String userId;
    private final String sessionValue;
}
