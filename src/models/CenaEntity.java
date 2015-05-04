package models;

import javax.persistence.*;

/**
 * Created by Tomáš on 27.4.2015.
 */
@Entity
@Table(name = "cena", schema = "", catalog = "dbs_projekt")
public class CenaEntity {
    private int id;
    private Double cena;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cena")
    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CenaEntity that = (CenaEntity) o;

        if (id != that.id) return false;
        if (cena != null ? !cena.equals(that.cena) : that.cena != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cena != null ? cena.hashCode() : 0);
        return result;
    }
}
