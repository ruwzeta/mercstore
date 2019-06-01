package lk.cb006789.eea.mercstore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "wishlist", schema = "merc_store_db", catalog = "")
public class WishlistModel {

    private String wishlistId;
    @JsonBackReference
    private UseraccModel useraccByUserid;
    @JsonManagedReference
    private Collection<WishlistitemModel> wishlistitemsByWishlistId;



    @Id
    @Column(name = "wishlist_id")
    public String getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(String wishlistId) {
        this.wishlistId = wishlistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishlistModel that = (WishlistModel) o;
        return
                Objects.equals(wishlistId, that.wishlistId);
    }

    @Override
    public int hashCode() {
        return Objects.hash( wishlistId);
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    public UseraccModel getUseraccByUserid() {
        return useraccByUserid;
    }

    public void setUseraccByUserid(UseraccModel useraccByUserid) {
        this.useraccByUserid = useraccByUserid;
    }

    @OneToMany(mappedBy = "wishlistByWishlistId")
    public Collection<WishlistitemModel> getWishlistitemsByWishlistId() {
        return wishlistitemsByWishlistId;
    }

    public void setWishlistitemsByWishlistId(Collection<WishlistitemModel> wishlistitemsByWishlistId) {
        this.wishlistitemsByWishlistId = wishlistitemsByWishlistId;
    }
}
