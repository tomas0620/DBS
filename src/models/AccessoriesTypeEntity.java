package models;

import javax.persistence.*;

/**
 * Created by Tomáš on 27.4.2015.
 */
@Entity
@Table(name = "accessories_type", schema = "", catalog = "dbs_projekt")
public class AccessoriesTypeEntity {
    private int id;
    private String typ;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "typ")
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessoriesTypeEntity that = (AccessoriesTypeEntity) o;

        if (id != that.id) return false;
        if (typ != null ? !typ.equals(that.typ) : that.typ != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typ != null ? typ.hashCode() : 0);
        return result;
    }
}
