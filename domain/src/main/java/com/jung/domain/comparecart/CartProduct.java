package com.jung.domain.comparecart;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class CartProduct {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @ManyToOne
    private long cartId;
    @Column(nullable = false)
    private long productId;

}
