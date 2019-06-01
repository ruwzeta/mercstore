package lk.cb006789.eea.mercstore.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "userrole", schema = "merc_store_db", catalog = "")
public class UserroleModel {
    private String userroleid;
    private String userrole;
    @JsonManagedReference
    private Collection<UseraccModel> useraccsByUserroleid;

    @Id
    @Column(name = "userroleid")
    public String getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(String userroleid) {
        this.userroleid = userroleid;
    }

    @Basic
    @Column(name = "userrole")
    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserroleModel that = (UserroleModel) o;
        return Objects.equals(userroleid, that.userroleid) &&
                Objects.equals(userrole, that.userrole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userroleid, userrole);
    }

    @OneToMany(mappedBy = "userroleByUserroleid")
    public Collection<UseraccModel> getUseraccsByUserroleid() {
        return useraccsByUserroleid;
    }

    public void setUseraccsByUserroleid(Collection<UseraccModel> useraccsByUserroleid) {
        this.useraccsByUserroleid = useraccsByUserroleid;
    }
}
