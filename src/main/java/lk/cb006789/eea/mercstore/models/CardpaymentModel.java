package lk.cb006789.eea.mercstore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cardpayment", schema = "merc_store_db", catalog = "")
public class CardpaymentModel {
    private String cardId;
    private int csv;
    private String cardType;
    private Date expiryDate;
    private String userid;
    @JsonBackReference
    private UseraccModel useraccByUserid;
    @JsonManagedReference
    private Collection<SaleModel> salesByCardId;

    @Id
    @Column(name = "card_id")
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "csv")
    public int getCsv() {
        return csv;
    }

    public void setCsv(int csv) {
        this.csv = csv;
    }

    @Basic
    @Column(name = "card_type")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Basic
    @Column(name = "expiry_date")
    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardpaymentModel that = (CardpaymentModel) o;
        return csv == that.csv &&
                Objects.equals(cardId, that.cardId) &&
                Objects.equals(cardType, that.cardType) &&
                Objects.equals(expiryDate, that.expiryDate) &&
                Objects.equals(userid, that.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, csv, cardType, expiryDate, userid);
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    public UseraccModel getUseraccByUserid() {
        return useraccByUserid;
    }

    public void setUseraccByUserid(UseraccModel useraccByUserid) {
        this.useraccByUserid = useraccByUserid;
    }

    @OneToMany(mappedBy = "cardpaymentByCardId")
    public Collection<SaleModel> getSalesByCardId() {
        return salesByCardId;
    }

    public void setSalesByCardId(Collection<SaleModel> salesByCardId) {
        this.salesByCardId = salesByCardId;
    }
}
