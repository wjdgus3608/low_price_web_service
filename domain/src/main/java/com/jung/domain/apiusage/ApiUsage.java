package com.jung.domain.apiusage;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class ApiUsage {
    @Id @GeneratedValue
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
