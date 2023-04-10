package com.jung.domain.comparecart;

import lombok.*;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class CartProduct{
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private CompareCart compareCart;
    @Column(nullable = false)
    private long productId;

    public void connectCompareCart(CompareCart compareCart){
       this.compareCart=compareCart;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartProduct that = (CartProduct) o;
        return productId == that.productId && compareCart.getOwnerId().equals(that.compareCart.getOwnerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(compareCart.getOwnerId(), productId);
    }
}
