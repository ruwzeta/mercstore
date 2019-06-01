package lk.cb006789.eea.mercstore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "useracc", schema = "merc_store_db", catalog = "")
public class UseraccModel {
    private String userid;
    private String username;
    private String useremail;
    private String password;
    private Date dob;
    private String gender;
    private String email;
    private String address;
    @JsonManagedReference
    private Collection<CardpaymentModel> cardpaymentsByUserid;
    @JsonManagedReference
    private Collection<ItemreviewModel> itemreviewsByUserid;
    @JsonManagedReference
    private Collection<SaleModel> salesByUserid;
    @JsonManagedReference
    private Collection<ShoppingcartModel> shoppingcartsByUserid;
    @JsonBackReference
    private UserroleModel userroleByUserroleid;
    @JsonManagedReference
    private Collection<WishlistModel> wishlistsByUserid;

    @Id
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "useremail")
    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Basic
    @Column(name = "dob")
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UseraccModel that = (UseraccModel) o;
        return Objects.equals(userid, that.userid) &&
                Objects.equals(username, that.username) &&
                Objects.equals(useremail, that.useremail) &&
                Objects.equals(password, that.password) &&
                Objects.equals(dob, that.dob) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(email, that.email) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, username, useremail, password, dob, gender, email, address);
    }

    @OneToMany(mappedBy = "useraccByUserid")
    public Collection<CardpaymentModel> getCardpaymentsByUserid() {
        return cardpaymentsByUserid;
    }

    public void setCardpaymentsByUserid(Collection<CardpaymentModel> cardpaymentsByUserid) {
        this.cardpaymentsByUserid = cardpaymentsByUserid;
    }

    @OneToMany(mappedBy = "useraccByUserid")
    public Collection<ItemreviewModel> getItemreviewsByUserid() {
        return itemreviewsByUserid;
    }

    public void setItemreviewsByUserid(Collection<ItemreviewModel> itemreviewsByUserid) {
        this.itemreviewsByUserid = itemreviewsByUserid;
    }

    @OneToMany(mappedBy = "useraccByUserid")
    public Collection<SaleModel> getSalesByUserid() {
        return salesByUserid;
    }

    public void setSalesByUserid(Collection<SaleModel> salesByUserid) {
        this.salesByUserid = salesByUserid;
    }

    @OneToMany(mappedBy = "useraccByUserid")
    public Collection<ShoppingcartModel> getShoppingcartsByUserid() {
        return shoppingcartsByUserid;
    }

    public void setShoppingcartsByUserid(Collection<ShoppingcartModel> shoppingcartsByUserid) {
        this.shoppingcartsByUserid = shoppingcartsByUserid;
    }

    @ManyToOne
    @JoinColumn(name = "userroleid", referencedColumnName = "userroleid", nullable = false)
    public UserroleModel getUserroleByUserroleid() {
        return userroleByUserroleid;
    }

    public void setUserroleByUserroleid(UserroleModel userroleByUserroleid) {
        this.userroleByUserroleid = userroleByUserroleid;
    }

    @OneToMany(mappedBy = "useraccByUserid")
    public Collection<WishlistModel> getWishlistsByUserid() {
        return wishlistsByUserid;
    }

    public void setWishlistsByUserid(Collection<WishlistModel> wishlistsByUserid) {
        this.wishlistsByUserid = wishlistsByUserid;
    }
}
