package models;

import javax.persistence.*;

/**
 * Created by Tomáš on 27.4.2015.
 */
@Entity
@Table(name = "bycikel", schema = "", catalog = "dbs_projekt")
public class BycikelEntity {
    private int idB;
    private String nazov;
    private int velkost;
    private CenaEntity cenaByIdC;
    private BikeTypeEntity bikeTypeByIdT;


    @Id
    @Column(name = "id_b")
    public int getIdB() {
        return idB;
    }

    public void setIdB(int idB) {
        this.idB = idB;
    }

    @Basic
    @Column(name = "nazov")
    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    @Basic
    @Column(name = "velkost")
    public int getVelkost() {
        return velkost;
    }

    public void setVelkost(int velkost) {
        this.velkost = velkost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BycikelEntity that = (BycikelEntity) o;

        if (idB != that.idB) return false;
        if (velkost != that.velkost) return false;
        if (nazov != null ? !nazov.equals(that.nazov) : that.nazov != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idB;
        result = 31 * result + (nazov != null ? nazov.hashCode() : 0);
        result = 31 * result + velkost;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_c", referencedColumnName = "id", nullable = false)
    public CenaEntity getCenaByIdC() {
        return cenaByIdC;
    }

    public void setCenaByIdC(CenaEntity cenaByIdC) {
        this.cenaByIdC = cenaByIdC;
    }

    @ManyToOne
    @JoinColumn(name = "id_t", referencedColumnName = "id_t", nullable = false)
    public BikeTypeEntity getBikeTypeByIdT() {
        return bikeTypeByIdT;
    }

    public void setBikeTypeByIdT(BikeTypeEntity bikeTypeByIdT) {
        this.bikeTypeByIdT = bikeTypeByIdT;
    }
}
