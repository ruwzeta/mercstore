package lk.cb006789.eea.mercstore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "itemreview", schema = "merc_store_db", catalog = "")
public class ItemreviewModel {

    private int reviewId;
    private Date reviewDate;
    private Integer description;
    private int rating;

    @JsonBackReference
    private UseraccModel useraccByUserid;
    @JsonManagedReference
    private MerchandiseitemModel merchandiseitemByItemId;



    @Id
    @Column(name = "review_id")
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    @Basic
    @Column(name = "review_date")
    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Basic
    @Column(name = "description")
    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    @Basic
    @Column(name = "rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemreviewModel that = (ItemreviewModel) o;
        return reviewId == that.reviewId &&
                rating == that.rating &&

                Objects.equals(reviewDate, that.reviewDate) &&
                Objects.equals(description, that.description) ;

    }

    @Override
    public int hashCode() {
        return Objects.hash( reviewId, reviewDate, description, rating);
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
    @JoinColumn(name = "item_id", referencedColumnName = "merc_item_id", nullable = false)
    public MerchandiseitemModel getMerchandiseitemByItemId() {
        return merchandiseitemByItemId;
    }

    public void setMerchandiseitemByItemId(MerchandiseitemModel merchandiseitemByItemId) {
        this.merchandiseitemByItemId = merchandiseitemByItemId;
    }
}
