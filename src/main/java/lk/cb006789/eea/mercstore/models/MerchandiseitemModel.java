package lk.cb006789.eea.mercstore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "merchandiseitem", schema = "merc_store_db", catalog = "")
public class MerchandiseitemModel {

    private String mercItemId;
    private Integer qtyAvaiable;
    private String colour;
    private String size;

    @JsonManagedReference
    private Collection<ItemreviewModel> itemreviewsByMercItemId;
    @JsonBackReference
    private MerchandiseModel merchandiseByMercandiseid;
    @JsonBackReference
    private ItemtypeModel itemtypeByItemtype;
    @JsonManagedReference
    private Collection<OfferModel> offersByMercItemId;
    @JsonManagedReference
    private Collection<SaleitemModel> saleitemsByMercItemId;
    @JsonManagedReference
    private Collection<ShoppingcartitemModel> shoppingcartitemsByMercItemId;
    @JsonManagedReference
    private Collection<WishlistitemModel> wishlistitemsByMercItemId;


    @Id
    @Column(name = "merc_item_id")
    public String getMercItemId() {
        return mercItemId;
    }

    public void setMercItemId(String mercItemId) {
        this.mercItemId = mercItemId;
    }

    @Basic
    @Column(name = "qty_avaiable")
    public Integer getQtyAvaiable() {
        return qtyAvaiable;
    }

    public void setQtyAvaiable(Integer qtyAvaiable) {
        this.qtyAvaiable = qtyAvaiable;
    }

    @Basic
    @Column(name = "colour")
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Basic
    @Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchandiseitemModel that = (MerchandiseitemModel) o;
        return

                Objects.equals(mercItemId, that.mercItemId) &&
                Objects.equals(qtyAvaiable, that.qtyAvaiable) &&
                Objects.equals(colour, that.colour) &&
                Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash( mercItemId, qtyAvaiable, colour, size);
    }

    @OneToMany(mappedBy = "merchandiseitemByItemId")
    public Collection<ItemreviewModel> getItemreviewsByMercItemId() {
        return itemreviewsByMercItemId;
    }

    public void setItemreviewsByMercItemId(Collection<ItemreviewModel> itemreviewsByMercItemId) {
        this.itemreviewsByMercItemId = itemreviewsByMercItemId;
    }

    @ManyToOne
    @JoinColumn(name = "mercandiseid", referencedColumnName = "mercandiseid", nullable = false)
    public MerchandiseModel getMerchandiseByMercandiseid() {
        return merchandiseByMercandiseid;
    }

    public void setMerchandiseByMercandiseid(MerchandiseModel merchandiseByMercandiseid) {
        this.merchandiseByMercandiseid = merchandiseByMercandiseid;
    }

    @ManyToOne
    @JoinColumn(name = "itemtype", referencedColumnName = "itemtype_id", nullable = false)
    public ItemtypeModel getItemtypeByItemtype() {
        return itemtypeByItemtype;
    }

    public void setItemtypeByItemtype(ItemtypeModel itemtypeByItemtype) {
        this.itemtypeByItemtype = itemtypeByItemtype;
    }

    @OneToMany(mappedBy = "merchandiseitemByItemId")
    public Collection<OfferModel> getOffersByMercItemId() {
        return offersByMercItemId;
    }

    public void setOffersByMercItemId(Collection<OfferModel> offersByMercItemId) {
        this.offersByMercItemId = offersByMercItemId;
    }

    @OneToMany(mappedBy = "merchandiseitemByItemId")
    public Collection<SaleitemModel> getSaleitemsByMercItemId() {
        return saleitemsByMercItemId;
    }

    public void setSaleitemsByMercItemId(Collection<SaleitemModel> saleitemsByMercItemId) {
        this.saleitemsByMercItemId = saleitemsByMercItemId;
    }

    @OneToMany(mappedBy = "merchandiseitemByItemId")
    public Collection<ShoppingcartitemModel> getShoppingcartitemsByMercItemId() {
        return shoppingcartitemsByMercItemId;
    }

    public void setShoppingcartitemsByMercItemId(Collection<ShoppingcartitemModel> shoppingcartitemsByMercItemId) {
        this.shoppingcartitemsByMercItemId = shoppingcartitemsByMercItemId;
    }

    @OneToMany(mappedBy = "merchandiseitemByItemId")
    public Collection<WishlistitemModel> getWishlistitemsByMercItemId() {
        return wishlistitemsByMercItemId;
    }

    public void setWishlistitemsByMercItemId(Collection<WishlistitemModel> wishlistitemsByMercItemId) {
        this.wishlistitemsByMercItemId = wishlistitemsByMercItemId;
    }
}
