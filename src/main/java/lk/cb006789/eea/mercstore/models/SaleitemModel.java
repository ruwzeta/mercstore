package lk.cb006789.eea.mercstore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "saleitem", schema = "merc_store_db", catalog = "")
public class SaleitemModel {

    private int saleItemId;
    private Integer saleQty;
    @JsonBackReference
    private MerchandiseitemModel merchandiseitemByItemId;
    @JsonBackReference
    private SaleModel saleBySaleId;



    @Id
    @Column(name = "sale_item_id")
    public int getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(int saleItemId) {
        this.saleItemId = saleItemId;
    }

    @Basic
    @Column(name = "sale_qty")
    public Integer getSaleQty() {
        return saleQty;
    }

    public void setSaleQty(Integer saleQty) {
        this.saleQty = saleQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleitemModel that = (SaleitemModel) o;
        return saleItemId == that.saleItemId &&

                Objects.equals(saleQty, that.saleQty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleItemId, saleQty);
    }

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "merc_item_id", nullable = false)
    public MerchandiseitemModel getMerchandiseitemByItemId() {
        return merchandiseitemByItemId;
    }

    public void setMerchandiseitemByItemId(MerchandiseitemModel merchandiseitemByItemId) {
        this.merchandiseitemByItemId = merchandiseitemByItemId;
    }

    @ManyToOne
    @JoinColumn(name = "sale_id", referencedColumnName = "sale_id", nullable = false)
    public SaleModel getSaleBySaleId() {
        return saleBySaleId;
    }

    public void setSaleBySaleId(SaleModel saleBySaleId) {
        this.saleBySaleId = saleBySaleId;
    }
}
