package com.jung.domain.apiusage;


import com.jung.domain.BaseEntity;
import com.jung.domain.BaseRedisEntity;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@RedisHash(value = "api-usage")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class ApiUsage extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    ApiType apiType;

    @NotNull
    long currentUsage;

    @NotNull
    long maxUsage;


    public void increaseUsage(){
        this.currentUsage++;
    }

    public void initUsage(){
        this.currentUsage=0;
    }

}
