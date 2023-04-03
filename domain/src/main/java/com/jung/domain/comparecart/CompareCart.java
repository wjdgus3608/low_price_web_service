package com.jung.domain.comparecart;

import com.jung.domain.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.http.ResponseEntity;

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
    @Column(name = "cart_id")
    private long cartId;
    @Column(nullable = false)
    private String ownerId;
    @OneToMany(mappedBy = "compareCart")
    private List<CartProduct> cartProducts = new ArrayList<>();
    @ColumnDefault("0")
    private long totalCnt;

    public boolean addProduct(CartProduct cartProduct){
        if(this.cartProducts.contains(cartProduct))
            return false;
        this.cartProducts.add(cartProduct);
        return true;
    }
}
