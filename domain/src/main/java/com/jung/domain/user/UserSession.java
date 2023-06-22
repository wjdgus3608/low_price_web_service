package com.jung.domain.user;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


@RedisHash(value = "user_sessions", timeToLive = 1200L)
@Builder
@Getter
public class UserSession {
    @Id
    private String sessionValue;
    @Indexed
    private String userId;
}
