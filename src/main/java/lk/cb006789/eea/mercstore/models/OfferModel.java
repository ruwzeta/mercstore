package lk.cb006789.eea.mercstore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "offer", schema = "merc_store_db", catalog = "")
public class OfferModel {
    private String offerid;
    private double offeramount;
    private Date offerStartDate;
    private Date offerEndDate;

    @JsonBackReference
    private MerchandiseitemModel merchandiseitemByItemId;

    @Id
    @Column(name = "offerid")
    public String getOfferid() {
        return offerid;
    }

    public void setOfferid(String offerid) {
        this.offerid = offerid;
    }

    @Basic
    @Column(name = "offeramount")
    public double getOfferamount() {
        return offeramount;
    }

    public void setOfferamount(double offeramount) {
        this.offeramount = offeramount;
    }

    @Basic
    @Column(name = "offer_start_date")
    public Date getOfferStartDate() {
        return offerStartDate;
    }

    public void setOfferStartDate(Date offerStartDate) {
        this.offerStartDate = offerStartDate;
    }

    @Basic
    @Column(name = "offer_end_date")
    public Date getOfferEndDate() {
        return offerEndDate;
    }

    public void setOfferEndDate(Date offerEndDate) {
        this.offerEndDate = offerEndDate;
    }

    /*@Basic
    @Column(name = "item_id")
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferModel that = (OfferModel) o;
        return Double.compare(that.offeramount, offeramount) == 0 &&
                Objects.equals(offerid, that.offerid) &&
                Objects.equals(offerStartDate, that.offerStartDate) &&
                Objects.equals(offerEndDate, that.offerEndDate) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerid, offeramount, offerStartDate, offerEndDate);
    }

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "merc_item_id")
    public MerchandiseitemModel getMerchandiseitemByItemId() {
        return merchandiseitemByItemId;
    }

    public void setMerchandiseitemByItemId(MerchandiseitemModel merchandiseitemByItemId) {
        this.merchandiseitemByItemId = merchandiseitemByItemId;
    }
}
