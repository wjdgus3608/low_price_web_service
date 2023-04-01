package com.jung.domain.comparecart;

import com.jung.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class CompareCart extends BaseEntity {
    @Id
    @GeneratedValue
    private long cartId;
    @Column(nullable = false)
    private String ownerId;
    @OneToMany(mappedBy = "cartId")
    private List<CartProduct> cartProducts = new ArrayList<CartProduct>();
    @ColumnDefault("0")
    private long totalCnt;
}
