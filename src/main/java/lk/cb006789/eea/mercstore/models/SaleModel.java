package lk.cb006789.eea.mercstore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "sale", schema = "merc_store_db", catalog = "")
public class SaleModel {

    private String saleId;
    private Timestamp saleDate;
    private double totalBill;
    private int totalQty;

    @JsonBackReference
    private UseraccModel useraccByUserid;
    @JsonBackReference
    private ShoppingcartModel shoppingcartByCartId;
    @JsonBackReference
    private CardpaymentModel cardpaymentByCardId;
    @JsonManagedReference
    private Collection<SaleitemModel> saleitemsBySaleId;



    @Id
    @Column(name = "sale_id")
    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    @Basic
    @Column(name = "sale_date")
    public Timestamp getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }

    @Basic
    @Column(name = "total_bill")
    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
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
        SaleModel saleModel = (SaleModel) o;
        return Double.compare(saleModel.totalBill, totalBill) == 0 &&
                totalQty == saleModel.totalQty &&

                Objects.equals(saleId, saleModel.saleId) &&
                Objects.equals(saleDate, saleModel.saleDate) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash( saleId, saleDate, totalBill, totalQty);
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    public UseraccModel getUseraccByUserid() {
        return useraccByUserid;
    }

    public void setUseraccByUserid(UseraccModel useraccByUserid) {
        this.useraccByUserid = useraccByUserid;
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
    @JoinColumn(name = "card_id", referencedColumnName = "card_id", nullable = false)
    public CardpaymentModel getCardpaymentByCardId() {
        return cardpaymentByCardId;
    }

    public void setCardpaymentByCardId(CardpaymentModel cardpaymentByCardId) {
        this.cardpaymentByCardId = cardpaymentByCardId;
    }

    @OneToMany(mappedBy = "saleBySaleId")
    public Collection<SaleitemModel> getSaleitemsBySaleId() {
        return saleitemsBySaleId;
    }

    public void setSaleitemsBySaleId(Collection<SaleitemModel> saleitemsBySaleId) {
        this.saleitemsBySaleId = saleitemsBySaleId;
    }
}
