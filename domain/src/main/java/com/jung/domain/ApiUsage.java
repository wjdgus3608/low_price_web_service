package com.jung.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ApiUsage {
    @Id
    long id;

    @Enumerated(EnumType.STRING)
    ApiType apiType;

    long currentUsage;

    long maxUsage;

}
