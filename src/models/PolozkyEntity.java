package models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Tomáš on 27.4.2015.
 */
@Entity
@Table(name = "polozky", schema = "", catalog = "dbs_projekt")
public class PolozkyEntity {
    private int id;
    private int idProduct;
    private int isBike;
    private int isAccessories;
    private ObjednavkaEntity id_odbjednavkyByIdO;

    @Id  @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_product")
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Column(name = "is_bike")
    public int isBike() {
        return isBike;
    }

    public void setBike(int isBike) {
        this.isBike = isBike;
    }


    @Column(name = "is_accessories")
    public int isAccessories() {
        return isAccessories;
    }

    public void setAccessories(int isAccessories) {
        this.isAccessories = isAccessories;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PolozkyEntity that = (PolozkyEntity) o;

        if (id != that.id) return false;
        if (idProduct != that.idProduct) return false;
        if (isBike != that.isBike) return false;
        if (isAccessories != that.isAccessories) return false;
        if (id_odbjednavkyByIdO != that.id_odbjednavkyByIdO) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idProduct;
        result = 31 * result + isBike ;
        result = 31 * result + isAccessories;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_objednavky", referencedColumnName = "id", nullable = false)
    public ObjednavkaEntity getId_odbjednavkyByIdO() {
        return id_odbjednavkyByIdO;
    }

    public void setId_odbjednavkyByIdO(ObjednavkaEntity idObjednavky) {
        this.id_odbjednavkyByIdO = idObjednavky;
    }

}
