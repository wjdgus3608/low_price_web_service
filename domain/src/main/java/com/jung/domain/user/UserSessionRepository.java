package com.jung.domain.user;

import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableRedisRepositories
public interface UserSessionRepository extends CrudRepository<UserSession,String> {
//    boolean existBySessionValue(String sessionValue);
    Optional<UserSession> findByUserId(String userId);
}
