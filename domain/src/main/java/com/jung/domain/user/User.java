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
@Table(name = "myuser")
public class User extends BaseEntity {
    @Id
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private String userPw;
    @Column(nullable = false)
    private String userName;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Enumerated(EnumType.STRING)
    private ApprovalState state;
}
