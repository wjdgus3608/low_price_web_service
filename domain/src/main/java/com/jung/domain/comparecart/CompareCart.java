package com.jung.domain.comparecart;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class CompareCart {
    @Id
    @GeneratedValue
    private long cartId;
    @Column(nullable = false)
    private String ownerId;
    @ColumnDefault("0")
    private long totalCnt;
}
