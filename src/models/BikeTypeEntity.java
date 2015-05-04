package models;

import javax.persistence.*;

/**
 * Created by Tomáš on 27.4.2015.
 */
@Entity
@Table(name = "bike_type", schema = "", catalog = "dbs_projekt")
public class BikeTypeEntity {
    private int idT;
    private String typ;


    @Id
    @Column(name = "id_t")
    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
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

        BikeTypeEntity that = (BikeTypeEntity) o;

        if (idT != that.idT) return false;
        if (typ != null ? !typ.equals(that.typ) : that.typ != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idT;
        result = 31 * result + (typ != null ? typ.hashCode() : 0);
        return result;
    }
}
