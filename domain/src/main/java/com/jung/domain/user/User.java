package com.jung.domain.user;


import com.jung.domain.BaseEntity;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class User extends BaseEntity {
    @Id
    @NotNull
    private String userId;
    @NotNull
    private String userPw;
    @NotNull
    private String userName;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Enumerated(EnumType.STRING)
    private ApprovalState state;
}
