package com.jung.domain.apiusage;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class ApiUsage {
    @Id
    long id;
    @Enumerated(EnumType.STRING)
    ApiType apiType;
    long currentUsage;
    long maxUsage;


    public void increaseUsage(){
        this.currentUsage++;
    }

    public void initUsage(){
        this.currentUsage=0;
    }

}
