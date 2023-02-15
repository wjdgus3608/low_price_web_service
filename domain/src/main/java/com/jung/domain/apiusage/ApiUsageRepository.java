package com.jung.domain.apiusage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApiUsageRepository extends JpaRepository<ApiUsage,Long> {
    List<ApiUsage> findByApiType(ApiType apiType);
}
