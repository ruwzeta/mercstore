package lk.cb006789.eea.mercstore.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "itemtype", schema = "merc_store_db", catalog = "")
public class ItemtypeModel {
    private String itemtype;
    private String itemtypeId;
    @JsonManagedReference
    private Collection<MerchandiseitemModel> merchandiseitemsByItemtypeId;

    @Basic
    @Column(name = "itemtype")
    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }

    @Id
    @Column(name = "itemtype_id")
    public String getItemtypeId() {
        return itemtypeId;
    }

    public void setItemtypeId(String itemtypeId) {
        this.itemtypeId = itemtypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemtypeModel that = (ItemtypeModel) o;
        return Objects.equals(itemtype, that.itemtype) &&
                Objects.equals(itemtypeId, that.itemtypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemtype, itemtypeId);
    }

    @OneToMany(mappedBy = "itemtypeByItemtype")
    public Collection<MerchandiseitemModel> getMerchandiseitemsByItemtypeId() {
        return merchandiseitemsByItemtypeId;
    }

    public void setMerchandiseitemsByItemtypeId(Collection<MerchandiseitemModel> merchandiseitemsByItemtypeId) {
        this.merchandiseitemsByItemtypeId = merchandiseitemsByItemtypeId;
    }
}
