package com.jung.domain.comparecart;

import com.jung.domain.BaseEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        if(cartProducts.contains(cartProduct))
            return false;
        cartProduct.connectCompareCart(this);
        cartProducts.add(cartProduct);
        totalCnt=cartProducts.size();
        return true;
    }

    public boolean removeProduct(CartProduct cartProduct){
        if (cartProducts.contains(cartProduct)) {
            cartProducts.remove(cartProduct);
            totalCnt=cartProducts.size();
            return true;
        }
        return false;
    }

    public void clearCart(){
        cartProducts.clear();
        totalCnt=0;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompareCart that = (CompareCart) o;
        return ownerId.equals(that.ownerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId);
    }
}
