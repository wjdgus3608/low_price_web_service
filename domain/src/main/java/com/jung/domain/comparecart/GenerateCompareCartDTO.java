package com.jung.domain.comparecart;

import com.jung.domain.BaseDTO;
import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GenerateCompareCartDTO extends BaseDTO {
    private String ownerId;
}
