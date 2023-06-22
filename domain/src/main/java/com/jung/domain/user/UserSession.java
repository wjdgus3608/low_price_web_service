package com.jung.domain.user;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


@RedisHash("user_sessions")
@Builder
@Getter
public class UserSession {
    @Id
    private String sessionValue;
    @Indexed
    private String userId;
}
