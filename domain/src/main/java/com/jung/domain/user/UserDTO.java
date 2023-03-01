package com.jung.domain.user;

import com.sun.istack.NotNull;
import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    int responseCode;
    String responseMessage;
    @NotNull
    private String userId;
    @NotNull
    private String userPw;
    @NotNull
    private String userName;
    @NotNull
    private UserType userType;

}
