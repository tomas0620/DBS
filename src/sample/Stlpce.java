package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by Tomáš on 8.4.2015.
 */
public class Stlpce {
    private SimpleIntegerProperty id =  new SimpleIntegerProperty();
    private SimpleStringProperty nazov =  new SimpleStringProperty("");
    private SimpleDoubleProperty cena =  new SimpleDoubleProperty();
    private SimpleStringProperty typ = new SimpleStringProperty("");
    private SimpleIntegerProperty velkost =  new SimpleIntegerProperty();
    private SimpleIntegerProperty id_objednavky =  new SimpleIntegerProperty();
    private SimpleIntegerProperty pocet_poloziek =  new SimpleIntegerProperty();
    private SimpleDoubleProperty celkova_cena = new SimpleDoubleProperty();


    public Stlpce(Integer fid, String nazov, Double mcena, String typ, Integer velkost) {
        this.id = new SimpleIntegerProperty(fid);
        this.nazov = new SimpleStringProperty(nazov);
        this.cena = new SimpleDoubleProperty(mcena);
        this.typ = new SimpleStringProperty(typ);
        this.velkost = new SimpleIntegerProperty(velkost);
    }

    public Stlpce(String nazov, Double mcena, String typ, Integer velkost, Integer id_objednavky, Integer pocet_poloziek, Double celk_cena) {
        this.nazov = new SimpleStringProperty(nazov);
        this.cena = new SimpleDoubleProperty(mcena);
        this.typ = new SimpleStringProperty(typ);
        this.velkost = new SimpleIntegerProperty(velkost);
        this.id_objednavky = new SimpleIntegerProperty(id_objednavky);
        this.pocet_poloziek = new SimpleIntegerProperty(pocet_poloziek);
        this.celkova_cena = new SimpleDoubleProperty(celk_cena);

    }

    public Stlpce(Integer fid, String nazov, Double mcena, String typ) {
        this.id = new SimpleIntegerProperty(fid);
        this.nazov = new SimpleStringProperty(nazov);
        this.cena = new SimpleDoubleProperty(mcena);
        this.typ = new SimpleStringProperty(typ);
    }

    public Stlpce(Integer id_objednavky, Integer pocet_poloziek, Double celk_cena){
        this.id_objednavky = new SimpleIntegerProperty(id_objednavky);
        this.pocet_poloziek = new SimpleIntegerProperty(pocet_poloziek);
        this.celkova_cena = new SimpleDoubleProperty(celk_cena);
    }

    public Stlpce(Integer fid,Double mcena) {
        this.id = new SimpleIntegerProperty(fid);
        this.cena = new SimpleDoubleProperty(mcena);
    }

    public Stlpce(Integer fid,String typ) {
        this.id = new SimpleIntegerProperty(fid);
        this.typ = new SimpleStringProperty(typ);
    }

    public Stlpce(Integer fid){
        this.id = new SimpleIntegerProperty(fid);
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer pomid) {
        id.set(pomid);
    }

    public String getNazov() {
        return nazov.get();
    }

    public void setNazov(String pomnazov) {
        nazov.set(pomnazov);
    }

    public Double getCena() {
        return cena.get();
    }

    public void setCena(Double pomcena) {
        cena.set(pomcena);
    }

    public String getTyp() {
        return typ.get();
    }

    public void setTyp(String pomtyp) {
        typ.set(pomtyp);
    }

    public Integer getVelkost(){
        return velkost.get();
    }

    public void setVelkost(Integer pomvelkost) {
        velkost.set(pomvelkost);
    }

    public Integer getId_objednavky() { return id_objednavky.get(); }

    public void ssetId_objednavky(Integer pomid_obj) { id_objednavky.set(pomid_obj); }

    public Integer getPocet_poloziek() { return pocet_poloziek.get(); }

    public void setPocet_poloziek(Integer pomitems) { pocet_poloziek.set(pomitems); }

    public Double getCelkova_cena() { return celkova_cena.get(); }

    public void setCelkova_cena(Double pomcelkova_cena) { celkova_cena.set(pomcelkova_cena); }

}
