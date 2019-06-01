package lk.cb006789.eea.mercstore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shoppingcartitem", schema = "merc_store_db", catalog = "")
public class ShoppingcartitemModel {

    private int cartItemId;
    private Integer cartQty;
    @JsonBackReference
    private ShoppingcartModel shoppingcartByCartId;
    @JsonBackReference
    private MerchandiseitemModel merchandiseitemByItemId;


    @Id
    @Column(name = "cart_item_id")
    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    @Basic
    @Column(name = "cart_qty")
    public Integer getCartQty() {
        return cartQty;
    }

    public void setCartQty(Integer cartQty) {
        this.cartQty = cartQty;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingcartitemModel that = (ShoppingcartitemModel) o;
        return cartItemId == that.cartItemId &&

                Objects.equals(cartQty, that.cartQty) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash( cartItemId, cartQty);
    }

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id", nullable = false)
    public ShoppingcartModel getShoppingcartByCartId() {
        return shoppingcartByCartId;
    }

    public void setShoppingcartByCartId(ShoppingcartModel shoppingcartByCartId) {
        this.shoppingcartByCartId = shoppingcartByCartId;
    }

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "merc_item_id", nullable = false)
    public MerchandiseitemModel getMerchandiseitemByItemId() {
        return merchandiseitemByItemId;
    }

    public void setMerchandiseitemByItemId(MerchandiseitemModel merchandiseitemByItemId) {
        this.merchandiseitemByItemId = merchandiseitemByItemId;
    }
}
