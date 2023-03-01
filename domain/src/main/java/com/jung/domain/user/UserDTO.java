package com.jung.domain.user;

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
    private String userId;
    private String userPw;
    private String userName;
    private UserType userType;

}
