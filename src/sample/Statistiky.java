package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.AccessoriesEntity;
import models.BycikelEntity;
import models.ObjednavkaEntity;
import models.PolozkyEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.persistence.OrderBy;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * Created by Tom� on 12.4.2015.
 */
public class Statistiky {

    public void statistika_top5(TableView tableview1){
        List list_pom = null;
        ObservableList<Stlpce> stlpce_data = FXCollections.observableArrayList();

        Session session = OpenSession.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            ArrayList<Integer> top5_obj = new ArrayList<>();
            Criteria criteria = session.createCriteria(ObjednavkaEntity.class);
            criteria.addOrder(Order.desc("celkovaCena"));
            criteria.setMaxResults(5);
            list_pom = criteria.list();
            for (Iterator iterator = list_pom.iterator(); iterator.hasNext(); ){
                ObjednavkaEntity obj = (ObjednavkaEntity) iterator.next();
                top5_obj.add(obj.getId());
            }

            for(Integer i:top5_obj) {
                criteria = session.createCriteria(PolozkyEntity.class);
                criteria.add(Restrictions.like("id_odbjednavkyByIdO.id", i));
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
                criteria.add(Restrictions.like("id_odbjednavkyByIdO.id", i));
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

    public void statistika_top3products(TableView tableview1){
        List<Object[]> list_pom = null;
        ObservableList<Stlpce> stlpce_data = FXCollections.observableArrayList();

        Session session = OpenSession.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            ArrayList<Integer> top3_obj = new ArrayList<>();
            Criteria criteria = session.createCriteria(PolozkyEntity.class);
            criteria.add(Restrictions.eq("bike", 1));
            criteria.setProjection(Projections.projectionList()
                    .add(Projections.groupProperty("idProduct"))
                    .add(Projections.count("idProduct"), "cnt")
            );
            criteria.addOrder(Order.desc("cnt"));
            criteria.setMaxResults(3);
            list_pom = criteria.list();

            for (Object[] id : list_pom) {

                // stmt = conn.prepareStatement("SELECT id_product, COUNT(id_product) AS cnt FROM polozky WHERE is_bike=1 GROUP BY id_product HAVING (cnt>1) ORDER BY id_product LIMIT 3");

                Criteria criteriapom = session.createCriteria(BycikelEntity.class);
                criteriapom.add(Restrictions.eq("idB", (Integer) id[0]));
                List list_pom2 = criteriapom.list();
                BycikelEntity e = (BycikelEntity) list_pom2.iterator().next();
                stlpce_data.addAll(FXCollections.observableArrayList(new Stlpce(e.getIdB(), e.getNazov(), e.getCenaByIdC().getCena(), e.getBikeTypeByIdT().getTyp(), e.getVelkost())));
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
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

    public void statistika_defined(TableView tableview1, String find){
            List list_pom = null;
            ObservableList<Stlpce> stlpce_data = FXCollections.observableArrayList();

            Session session = OpenSession.getSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                Criteria criteria = session.createCriteria(BycikelEntity.class);
                criteria.add(Restrictions.eq("nazov", find));
                int id = ((BycikelEntity) criteria.list().iterator().next()).getIdB();

                criteria = session.createCriteria(PolozkyEntity.class);
                criteria.add(Restrictions.eq("idProduct", id));
                list_pom = criteria.list();

                for (Iterator iterator = list_pom.iterator(); iterator.hasNext(); ) {
                    PolozkyEntity pol = (PolozkyEntity) iterator.next();
                    stlpce_data.addAll(FXCollections.observableArrayList(new Stlpce(pol.getId_odbjednavkyByIdO().getId(), pol.getId_odbjednavkyByIdO().getItems(), pol.getId_odbjednavkyByIdO().getCelkovaCena())));
                }
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }


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
            tableview1.getColumns().addAll(stl_obj, stl_poloziek, stl_celkom);




    }
}
