package com.jung.domain.user;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResUserDTO {
    private int responseCode;
    private String responseMessage;
    @NotNull
    private String userId;
    @NotNull
    private String userName;
    @NotNull
    private UserType userType;
    @NotNull
    private ApprovalState state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ResUserDTO entityToDTO(User user){
        return ResUserDTO.builder()
                .userId(user.getUserId())
                .userType(user.getUserType())
                .userName(user.getUserName())
                .state(user.getState())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
