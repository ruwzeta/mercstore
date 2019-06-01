package lk.cb006789.eea.mercstore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "wishlistitem", schema = "merc_store_db", catalog = "")
public class WishlistitemModel {

    private String wishListItemId;
    @JsonBackReference
    private WishlistModel wishlistByWishlistId;
    @JsonBackReference
    private MerchandiseitemModel merchandiseitemByItemId;

    @Id
    @Column(name = "wish_list_item_id")
    public String getWishListItemId() {
        return wishListItemId;
    }

    public void setWishListItemId(String wishListItemId) {
        this.wishListItemId = wishListItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishlistitemModel that = (WishlistitemModel) o;
        return
                Objects.equals(wishListItemId, that.wishListItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash( wishListItemId);
    }

    @ManyToOne
    @JoinColumn(name = "wishlist_id", referencedColumnName = "wishlist_id", nullable = false)
    public WishlistModel getWishlistByWishlistId() {
        return wishlistByWishlistId;
    }

    public void setWishlistByWishlistId(WishlistModel wishlistByWishlistId) {
        this.wishlistByWishlistId = wishlistByWishlistId;
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
