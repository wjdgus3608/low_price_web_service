package com.jung.domain.user;


import com.jung.domain.BaseEntity;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
//ColumnDefault 기능 작동하려면 필요
@DynamicInsert
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
    @ColumnDefault(value = "USER")
    private UserType userType;
    @Enumerated(EnumType.STRING)
    private ApprovalState state;

    public void approve(){
        this.state = ApprovalState.ACCEPTED;
    }
}
