package lk.cb006789.eea.mercstore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "shoppingcart", schema = "merc_store_db", catalog = "")
public class ShoppingcartModel {
    private String cartId;
    private int cartDuration;
    private Double cartTotal;
    private int totalQty;
    @JsonManagedReference
    private Collection<SaleModel> salesByCartId;
    @JsonBackReference
    private UseraccModel useraccByUserid;
    @JsonManagedReference
    private Collection<ShoppingcartitemModel> shoppingcartitemsByCartId;

    @Id
    @Column(name = "cart_id")
    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    @Basic
    @Column(name = "cart_duration")
    public int getCartDuration() {
        return cartDuration;
    }

    public void setCartDuration(int cartDuration) {
        this.cartDuration = cartDuration;
    }

    @Basic
    @Column(name = "cart_total")
    public Double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(Double cartTotal) {
        this.cartTotal = cartTotal;
    }

    @Basic
    @Column(name = "total_qty")
    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingcartModel that = (ShoppingcartModel) o;
        return cartDuration == that.cartDuration &&
                totalQty == that.totalQty &&
                Objects.equals(cartId, that.cartId) &&
                Objects.equals(cartTotal, that.cartTotal) ;

    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, cartDuration, cartTotal, totalQty);
    }

    @OneToMany(mappedBy = "shoppingcartByCartId")
    public Collection<SaleModel> getSalesByCartId() {
        return salesByCartId;
    }

    public void setSalesByCartId(Collection<SaleModel> salesByCartId) {
        this.salesByCartId = salesByCartId;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    public UseraccModel getUseraccByUserid() {
        return useraccByUserid;
    }

    public void setUseraccByUserid(UseraccModel useraccByUserid) {
        this.useraccByUserid = useraccByUserid;
    }

    @OneToMany(mappedBy = "shoppingcartByCartId")
    public Collection<ShoppingcartitemModel> getShoppingcartitemsByCartId() {
        return shoppingcartitemsByCartId;
    }

    public void setShoppingcartitemsByCartId(Collection<ShoppingcartitemModel> shoppingcartitemsByCartId) {
        this.shoppingcartitemsByCartId = shoppingcartitemsByCartId;
    }
}
