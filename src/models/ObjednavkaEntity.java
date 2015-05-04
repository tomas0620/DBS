package models;

import javax.persistence.*;

/**
 * Created by Tomáš on 27.4.2015.
 */
@Entity
@Table(name = "objednavka", schema = "", catalog = "dbs_projekt")
public class ObjednavkaEntity {
    private int id;
    private double celkovaCena;
    private int items;

    public ObjednavkaEntity(){}
    public ObjednavkaEntity(Double celkovaCena, int items){
        this.celkovaCena = celkovaCena;
        this.items = items;
    }

    @Id @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "celkova_cena")
    public double getCelkovaCena() {
        return celkovaCena;
    }

    public void setCelkovaCena(double celkovaCena) {
        this.celkovaCena = celkovaCena;
    }

    @Basic
    @Column(name = "items")
    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjednavkaEntity that = (ObjednavkaEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.celkovaCena, celkovaCena) != 0) return false;
        if (items != that.items) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(celkovaCena);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + items;
        return result;
    }
}
