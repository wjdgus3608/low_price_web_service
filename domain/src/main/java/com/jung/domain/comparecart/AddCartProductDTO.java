package com.jung.domain.comparecart;

import com.sun.istack.NotNull;
import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddCartProductDTO {
    private int responseCode;
    private String responseMessage;
    @NotNull
    private String ownerId;
    @NotNull
    private long productId;
}
