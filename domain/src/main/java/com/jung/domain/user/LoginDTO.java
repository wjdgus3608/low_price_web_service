package com.jung.domain.user;

import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    @NotNull
    private String userId;
    @NotNull
    private String userPw;
}
