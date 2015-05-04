package models;

import javax.persistence.*;

/**
 * Created by Tomáš on 27.4.2015.
 */
@Entity
@Table(name = "accessories", schema = "", catalog = "dbs_projekt")
public class AccessoriesEntity {
    private int id;
    private String nazov;
    private AccessoriesTypeEntity accessoriesTypeByIdT;
    private CenaEntity cenaByIdC;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nazov")
    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessoriesEntity that = (AccessoriesEntity) o;

        if (id != that.id) return false;
        if (nazov != null ? !nazov.equals(that.nazov) : that.nazov != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nazov != null ? nazov.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_t", referencedColumnName = "id", nullable = false)
    public AccessoriesTypeEntity getAccessoriesTypeByIdT() {
        return accessoriesTypeByIdT;
    }

    public void setAccessoriesTypeByIdT(AccessoriesTypeEntity accessoriesTypeByIdT) {
        this.accessoriesTypeByIdT = accessoriesTypeByIdT;
    }

    @ManyToOne
    @JoinColumn(name = "id_c", referencedColumnName = "id", nullable = false)
    public CenaEntity getCenaByIdC() {
        return cenaByIdC;
    }

    public void setCenaByIdC(CenaEntity cenaByIdC) {
        this.cenaByIdC = cenaByIdC;
    }
}
