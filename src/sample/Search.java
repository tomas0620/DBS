package sample;

import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import models.AccessoriesEntity;
import models.BycikelEntity;
import models.ObjednavkaEntity;
import models.PolozkyEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Access;

public class Search {
    private ObservableList<ObservableList> list_search;


    public void search_allbikes(TableView tableview1){
            List allbikes = null;
            ObservableList<Stlpce> stlpce_data = FXCollections.observableArrayList();

            Session session = OpenSession.getSession();
            Transaction tx = null;

            try{
                tx = session.beginTransaction();
                Criteria criteria = session.createCriteria(BycikelEntity.class);
                allbikes = criteria.list();

                for (Iterator iterator =
                    allbikes.iterator(); iterator.hasNext();){
                    BycikelEntity myb = (BycikelEntity) iterator.next();
                    stlpce_data.addAll(FXCollections.observableArrayList(new Stlpce(myb.getIdB(), myb.getNazov(), myb.getCenaByIdC().getCena(),  myb.getBikeTypeByIdT().getTyp(), myb.getVelkost())));
                }
                tx.commit();
            }catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            }finally {
                session.close();
            }

            TableColumn stl_id = new TableColumn("ID");
            stl_id.setMinWidth(30);
            stl_id.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Integer>("id"));

            TableColumn stl_nazov = new TableColumn("Nazov");
            stl_nazov.setMinWidth(100);
            stl_nazov.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, String>("nazov"));

            TableColumn stl_typ = new TableColumn("Typ");
            stl_typ.setMinWidth(100);
            stl_typ.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, String>("typ"));

            TableColumn stl_velkost = new TableColumn("Velkost");
          stl_velkost.setMinWidth(100);
            stl_velkost.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Integer>("velkost"));

            TableColumn stl_cena = new TableColumn("Cena");
          stl_cena.setMinWidth(100);
            stl_cena.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Double>("cena"));


          tableview1.setItems(stlpce_data);
            tableview1.getColumns().addAll(stl_id, stl_nazov, stl_typ, stl_velkost, stl_cena);

    }

    public void search_defined(TableView tableview1, String find) throws SQLException {
        List allbikes = null;
        ObservableList<Stlpce> stlpce_data = FXCollections.observableArrayList();

        Session session = OpenSession.getSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(BycikelEntity.class);
            criteria.add(Restrictions.like("nazov", "%" + find + "%"));
            allbikes = criteria.list();

            for (Iterator iterator =
                 allbikes.iterator(); iterator.hasNext();){
                BycikelEntity myb = (BycikelEntity) iterator.next();
                stlpce_data.addAll(FXCollections.observableArrayList(new Stlpce(myb.getIdB(), myb.getNazov(), myb.getCenaByIdC().getCena(),  myb.getBikeTypeByIdT().getTyp(), myb.getVelkost())));
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

            TableColumn stl_id = new TableColumn("ID");
            stl_id.setMinWidth(30);
            stl_id.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Integer>("id"));

            TableColumn stl_nazov = new TableColumn("Nazov");
            stl_nazov.setMinWidth(100);
            stl_nazov.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, String>("nazov"));

            TableColumn stl_typ = new TableColumn("Typ");
            stl_typ.setMinWidth(100);
            stl_typ.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Integer>("typ"));

            TableColumn stl_velkost = new TableColumn("Velkost");
            stl_velkost.setMinWidth(100);
            stl_velkost.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Integer>("velkost"));

            TableColumn stl_cena = new TableColumn("Cena");
            stl_cena.setMinWidth(100);
            stl_cena.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Integer>("cena"));

            tableview1.setItems(stlpce_data);
            tableview1.getColumns().addAll(stl_id, stl_nazov, stl_typ, stl_velkost, stl_cena);

    }

    public void search_accessories(TableView tableview1, String find) throws SQLException {
        List list_pom = null;
        ObservableList<Stlpce> stlpce_data = FXCollections.observableArrayList();

        Session session = OpenSession.getSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(AccessoriesEntity.class);
            criteria.add(Restrictions.like("nazov", "%" + find + "%"));
            list_pom = criteria.list();

            for (Iterator iterator = list_pom.iterator(); iterator.hasNext();){
                AccessoriesEntity mya = (AccessoriesEntity) iterator.next();
                stlpce_data.addAll(FXCollections.observableArrayList(new Stlpce(mya.getId(), mya.getNazov(), mya.getCenaByIdC().getCena(),  mya.getAccessoriesTypeByIdT().getTyp())));
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

            TableColumn stl_id = new TableColumn("ID");
            stl_id.setMinWidth(30);
            stl_id.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Integer>("id"));

            TableColumn stl_nazov = new TableColumn("Nazov");
            stl_nazov.setMinWidth(100);
            stl_nazov.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, String>("nazov"));

            TableColumn stl_typ = new TableColumn("Typ");
            stl_typ.setMinWidth(100);
            stl_typ.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Integer>("typ"));

            TableColumn stl_cena = new TableColumn("Cena");
            stl_cena.setMinWidth(100);
            stl_cena.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Integer>("cena"));

            tableview1.setItems(stlpce_data);
            tableview1.getColumns().addAll(stl_id, stl_nazov, stl_typ, stl_cena);
    }

    public void search_objednavka(TableView tableview1, Integer find) throws SQLException {
        List list_pom = null;
        ObservableList<Stlpce> stlpce_data = FXCollections.observableArrayList();

        Session session = OpenSession.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(PolozkyEntity.class);
            criteria.add(Restrictions.like("id_odbjednavkyByIdO.id", find));
            criteria.add(Restrictions.eq("bike", 1));
            list_pom = criteria.list();

            for (Iterator iterator = list_pom.iterator(); iterator.hasNext(); ) {
                PolozkyEntity myp = (PolozkyEntity) iterator.next();
                Criteria criteriapom = session.createCriteria(BycikelEntity.class);
                criteriapom.add(Restrictions.eq("idB", myp.getIdProduct()));
                List list_pom2 = criteriapom.list();
                BycikelEntity e = (BycikelEntity) list_pom2.iterator().next();
                stlpce_data.addAll(FXCollections.observableArrayList(new Stlpce(e.getNazov(), e.getCenaByIdC().getCena(), e.getBikeTypeByIdT().getTyp(), e.getVelkost(), myp.getId_odbjednavkyByIdO().getId(), myp.getId_odbjednavkyByIdO().getItems(), myp.getId_odbjednavkyByIdO().getCelkovaCena())));
            }

            criteria = session.createCriteria(PolozkyEntity.class);
            criteria.add(Restrictions.like("id_odbjednavkyByIdO.id", find));
            criteria.add(Restrictions.eq("accessories", 1));
            list_pom = criteria.list();

            for (Iterator iterator = list_pom.iterator(); iterator.hasNext(); ) {
                PolozkyEntity myp = (PolozkyEntity) iterator.next();
                Criteria criteriapom = session.createCriteria(AccessoriesEntity.class);
                criteriapom.add(Restrictions.eq("id", myp.getIdProduct()));
                List list_pom2 = criteriapom.list();
                AccessoriesEntity e = (AccessoriesEntity) list_pom2.iterator().next();
                stlpce_data.addAll(FXCollections.observableArrayList(new Stlpce(e.getNazov(), e.getCenaByIdC().getCena(), e.getAccessoriesTypeByIdT().getTyp(), 0, myp.getId_odbjednavkyByIdO().getId(), myp.getId_odbjednavkyByIdO().getItems(), myp.getId_odbjednavkyByIdO().getCelkovaCena())));
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


        TableColumn stl_nazov = new TableColumn("Nazov");
        stl_nazov.setMinWidth(100);
        stl_nazov.setCellValueFactory(
                new PropertyValueFactory<Stlpce, String>("nazov"));

        TableColumn stl_typ = new TableColumn("Typ");
        stl_typ.setMinWidth(100);
        stl_typ.setCellValueFactory(
                new PropertyValueFactory<Stlpce, Integer>("typ"));

        TableColumn stl_velkost = new TableColumn("Velkost");
        stl_velkost.setMinWidth(100);
        stl_velkost.setCellValueFactory(
                new PropertyValueFactory<Stlpce, Integer>("velkost"));

        TableColumn stl_cena = new TableColumn("Cena");
        stl_cena.setMinWidth(100);
        stl_cena.setCellValueFactory(
                new PropertyValueFactory<Stlpce, Integer>("cena"));

        TableColumn stl_obj = new TableColumn("Objednavka");
        stl_obj.setMinWidth(100);
        stl_obj.setCellValueFactory(
                new PropertyValueFactory<Stlpce, Integer>("id_objednavky"));

        TableColumn stl_poloziek = new TableColumn("Pocet poloziek");
        stl_poloziek.setMinWidth(100);
        stl_poloziek.setCellValueFactory(
                new PropertyValueFactory<Stlpce, Integer>("pocet_poloziek"));

        TableColumn stl_celkom = new TableColumn("Celkova cena");
        stl_celkom.setMinWidth(100);
        stl_celkom.setCellValueFactory(
                new PropertyValueFactory<Stlpce, Integer>("celkova_cena"));

        tableview1.setItems(stlpce_data);
        tableview1.getColumns().addAll(stl_nazov, stl_typ, stl_velkost, stl_cena, stl_obj, stl_poloziek, stl_celkom);

    }

    public void search_allobjednavka(TableView tableview1) throws SQLException {
        List list_pom = null;
        ObservableList<Stlpce> stlpce_data = FXCollections.observableArrayList();

        Session session = OpenSession.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(PolozkyEntity.class);
            criteria.add(Restrictions.eq("bike", 1));
            list_pom = criteria.list();

            for (Iterator iterator = list_pom.iterator(); iterator.hasNext(); ) {
                PolozkyEntity myp = (PolozkyEntity) iterator.next();
                Criteria criteriapom = session.createCriteria(BycikelEntity.class);
                criteriapom.add(Restrictions.eq("idB", myp.getIdProduct()));
                List list_pom2 = criteriapom.list();
                BycikelEntity e = (BycikelEntity) list_pom2.iterator().next();
                stlpce_data.addAll(FXCollections.observableArrayList(new Stlpce(e.getNazov(), e.getCenaByIdC().getCena(), e.getBikeTypeByIdT().getTyp(), e.getVelkost(), myp.getId_odbjednavkyByIdO().getId(), myp.getId_odbjednavkyByIdO().getItems(), myp.getId_odbjednavkyByIdO().getCelkovaCena())));
            }

            criteria = session.createCriteria(PolozkyEntity.class);
            criteria.add(Restrictions.eq("accessories", 1));
            list_pom = criteria.list();

            for (Iterator iterator = list_pom.iterator(); iterator.hasNext(); ) {
                PolozkyEntity myp = (PolozkyEntity) iterator.next();
                Criteria criteriapom = session.createCriteria(AccessoriesEntity.class);
                criteriapom.add(Restrictions.eq("id", myp.getIdProduct()));
                List list_pom2 = criteriapom.list();
                AccessoriesEntity e = (AccessoriesEntity) list_pom2.iterator().next();
                stlpce_data.addAll(FXCollections.observableArrayList(new Stlpce(e.getNazov(), e.getCenaByIdC().getCena(), e.getAccessoriesTypeByIdT().getTyp(), 0, myp.getId_odbjednavkyByIdO().getId(), myp.getId_odbjednavkyByIdO().getItems(), myp.getId_odbjednavkyByIdO().getCelkovaCena())));
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        TableColumn stl_nazov = new TableColumn("Nazov");
        stl_nazov.setMinWidth(100);
        stl_nazov.setCellValueFactory(
                new PropertyValueFactory<Stlpce, String>("nazov"));

        TableColumn stl_typ = new TableColumn("Typ");
        stl_typ.setMinWidth(100);
        stl_typ.setCellValueFactory(
                new PropertyValueFactory<Stlpce, Integer>("typ"));

        TableColumn stl_velkost = new TableColumn("Velkost");
        stl_velkost.setMinWidth(100);
        stl_velkost.setCellValueFactory(
                new PropertyValueFactory<Stlpce, Integer>("velkost"));

        TableColumn stl_cena = new TableColumn("Cena");
        stl_cena.setMinWidth(100);
        stl_cena.setCellValueFactory(
                new PropertyValueFactory<Stlpce, Integer>("cena"));

        TableColumn stl_obj = new TableColumn("Objednavka");
        stl_obj.setMinWidth(100);
        stl_obj.setCellValueFactory(
                new PropertyValueFactory<Stlpce, Integer>("id_objednavky"));

        TableColumn stl_poloziek = new TableColumn("Pocet poloziek");
        stl_poloziek.setMinWidth(100);
        stl_poloziek.setCellValueFactory(
                new PropertyValueFactory<Stlpce, Integer>("pocet_poloziek"));

        TableColumn stl_celkom = new TableColumn("Celkova cena");
        stl_celkom.setMinWidth(100);
        stl_celkom.setCellValueFactory(
                new PropertyValueFactory<Stlpce, Integer>("celkova_cena"));

        tableview1.setItems(stlpce_data);
        stl_obj.setSortType(TableColumn.SortType.ASCENDING);
        tableview1.getColumns().addAll(stl_nazov, stl_typ, stl_velkost, stl_cena, stl_obj, stl_poloziek, stl_celkom);
        tableview1.getSortOrder().add(stl_obj);
    }

}
