package com.jung.domain.user;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class User {
    @Id
    @NotNull
    private String userId;
    @NotNull
    private String userPw;
    @NotNull
    private String userName;
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
