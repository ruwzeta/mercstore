package lk.cb006789.eea.mercstore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "merchandise", schema = "merc_store_db", catalog = "")
public class MerchandiseModel {
    private String mercandiseid;
    private String merchandisename;
    private Date dateofregistration;
    private String merchandiseCountry;
    private String description;
    @JsonManagedReference
    private Collection<MerchandiseitemModel> merchandiseitemsByMercandiseid;

    @Id
    @Column(name = "mercandiseid")
    public String getMercandiseid() {
        return mercandiseid;
    }

    public void setMercandiseid(String mercandiseid) {
        this.mercandiseid = mercandiseid;
    }

    @Basic
    @Column(name = "merchandisename")
    public String getMerchandisename() {
        return merchandisename;
    }

    public void setMerchandisename(String merchandisename) {
        this.merchandisename = merchandisename;
    }

    @Basic
    @Column(name = "dateofregistration")
    public Date getDateofregistration() {
        return dateofregistration;
    }

    public void setDateofregistration(Date dateofregistration) {
        this.dateofregistration = dateofregistration;
    }

    @Basic
    @Column(name = "merchandise_country")
    public String getMerchandiseCountry() {
        return merchandiseCountry;
    }

    public void setMerchandiseCountry(String merchandiseCountry) {
        this.merchandiseCountry = merchandiseCountry;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchandiseModel that = (MerchandiseModel) o;
        return Objects.equals(mercandiseid, that.mercandiseid) &&
                Objects.equals(merchandisename, that.merchandisename) &&
                Objects.equals(dateofregistration, that.dateofregistration) &&
                Objects.equals(merchandiseCountry, that.merchandiseCountry) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mercandiseid, merchandisename, dateofregistration, merchandiseCountry, description);
    }

    @OneToMany(mappedBy = "merchandiseByMercandiseid")
    public Collection<MerchandiseitemModel> getMerchandiseitemsByMercandiseid() {
        return merchandiseitemsByMercandiseid;
    }

    public void setMerchandiseitemsByMercandiseid(Collection<MerchandiseitemModel> merchandiseitemsByMercandiseid) {
        this.merchandiseitemsByMercandiseid = merchandiseitemsByMercandiseid;
    }
}
