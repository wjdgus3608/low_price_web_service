package com.jung.domain.user;

import org.springframework.data.repository.CrudRepository;

public interface UserSessionRepository extends CrudRepository<UserSession,String> {
    boolean existBySessionValue(String sessionValue);
}
