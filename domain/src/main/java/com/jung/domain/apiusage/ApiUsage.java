package com.jung.domain.apiusage;


import com.jung.domain.BaseEntity;
import com.jung.domain.BaseRedisEntity;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@RedisHash(value = "ApiUsage", timeToLive = 600)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class ApiUsage extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    ApiType apiType;

    @Column(nullable = false)
    long currentUsage;

    @Column(nullable = false)
    long maxUsage;


    public void increaseUsage(){
        this.currentUsage++;
    }

    public void initUsage(){
        this.currentUsage=0;
    }

}
