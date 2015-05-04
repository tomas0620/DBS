package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;


import javafx.stage.Stage;
import models.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.sql.Connection;


public class Controller {
    @FXML
    private Menu insertMenu1;
    @FXML
    private StackPane stackpane1;
    @FXML
    private Pane Bicykelpane1;
    @FXML
    private Pane Bicykelpane2;
    @FXML
    private Pane Typpane2;
    @FXML
    private Pane Typpaneaccessories2;
    @FXML
    private Pane PrislusenstvoPane1;
    @FXML
    private Pane PrislusenstvoPane2;
    @FXML
    private Pane CenaPane2;
    @FXML
    private Pane Bicykel_ubdatePane;
    @FXML
    private Pane Typ_ubdatePane;
    @FXML
    private Pane Cena_ubdatePane;
    @FXML
    private Pane Prislusenstvo_ubdatePane;
    @FXML
    private Pane Bicykel_deletePane;
    @FXML
    private Pane Accessories_deletePane;
    @FXML
    private Pane BikeType_deletePane;
    @FXML
    private Pane AccessoriesType_deletePane;
    @FXML
    private Pane Price_deletePane;
    @FXML
    private Pane ObjednavkaPane2;
    @FXML
    private Pane ObjednavkaPane1;


    @FXML
    private ComboBox<String> select_price1;
    @FXML
    private ComboBox<String> select_price2;
    @FXML
    private ComboBox<String> select_type1;
    @FXML
    private ComboBox<String> select_type2;
    @FXML
    private ComboBox<String> select_updateprice;
    @FXML
    private ComboBox<String> select_bike_objednavka;
    @FXML
    private ComboBox<String> select_accessories_objednavka;
    @FXML
    private ComboBox<String> select_updatetype;
    @FXML
    private ComboBox<?> insertCBox;
    @FXML
    private ComboBox<?> findCBox1;
    @FXML
    private ComboBox<?> updateCBox;
    @FXML
    private ComboBox<?> removeCBox;

    @FXML
    private Button insertbutton;

    @FXML
    private Button inserttype;
    @FXML
    private Button inserttypeaccessories;
    @FXML
    private Button insertprice;
    @FXML
    private Button findbutton1;
    @FXML
    private Button insertbike;
    @FXML
    private Button searchall;
    @FXML
    private Button searchbike1;
    @FXML
    private Button searchaccessories1;
    @FXML
    private Button searchobjednavka1;
    @FXML
    private Button search3top;
    @FXML
    private Button search3tail;
    @FXML
    private Button updatebutton1;
    @FXML
    private Button updatebutton2;
    @FXML
    private Button updatebutton3;
    @FXML
    private Button updatebutton4;
    @FXML
    private Button deletebutton1;
    @FXML
    private Button deletebutton2;
    @FXML
    private Button deletebutton3;

    @FXML
    private TextField textfield_cena;
    @FXML
    private TextField textfield_type;
    @FXML
    private TextField textfield_typeaccessories;
    @FXML
    private TextField textfield_bikename;
    @FXML
    private TextField textfield_searchbike;
    @FXML
    private TextField textfield_searchaccessories;
    @FXML
    private TextField textfield_searchobjednavka;
    @FXML
    private TextField textfield_updateID1;
    @FXML
    private TextField textfield_updateID2;
    @FXML
    private TextField textfield_updateID3;
    @FXML
    private TextField textfield_updateID4;
    @FXML
    private TextField textfield_updateName;
    @FXML
    private TextField textfield_updatePrice;
    @FXML
    private TextField textfield_updateType;
    @FXML
    private TextField textfield_accessoriesname;
    @FXML
    private TextField textfield_deleteName;
    @FXML
    private TextField textfield_deleteID1;
    @FXML
    private TextField textfield_deleteID2;
    @FXML
    private TextField textfield_deleteID3;
    @FXML
    private TextField textfield_deleteID4;
    @FXML
    private TextField textfield_deleteID5;
    @FXML
    private TextField textfield_deletebiketype;
    @FXML
    private TextField textfield_deleteaccessories;
    @FXML
    private TextField textfield_deleteaccessoriestype;
    @FXML
    private TextField textfield_deleteprice;
    @FXML
    private TextField textfield_bikesize;
    @FXML
    private TextField textfield_statistikabike;

    @FXML
    private TableView tableviewbike1;
    @FXML
    private TableView tableviewaccessories1;
    @FXML
    private TableView tableviewobjednavka1;
    @FXML
    private TableView tableviewbikeUPD;
    @FXML
    private TableView tableviewpriceUPD;
    @FXML
    private TableView tableviewtypeUPD;
    @FXML
    private TableView tableviewprislUPD;
    @FXML
    private TableView tableviewbikeDEL;
    @FXML
    private TableView tableviewbiketypeDEL;
    @FXML
    private TableView tableviewaccessoriesDEL;
    @FXML
    private TableView tableviewaccessoriestypeDEL;
    @FXML
    private TableView tableviewpriceDEL;
    @FXML
    private TableView<Stlpce> tableview_objednavka;
    @FXML
    private TableView tableviewstatistika;

    @FXML
    private Label total_price_label;
    @FXML
    private Label total_items_label;


    private double cena;
    private String typ;
    private String bike_name;
    private ObservableList<String> list_cena = FXCollections.observableArrayList();
    private ObservableList<String> list_typ = FXCollections.observableArrayList();
    private ObservableList<String> list_bikes = FXCollections.observableArrayList();
    private ObservableList<String> list_accessories = FXCollections.observableArrayList();
    private final ObservableList<Stlpce> items = FXCollections.observableArrayList();
    private ArrayList<Integer> list_objbikes = new ArrayList<Integer>();
    private ArrayList<Integer> list_objaccessories = new ArrayList<Integer>();
    private Double total_price=0.0;
    private Integer total_items=0;


    @FXML
    void showInsertPane(ActionEvent event) {
    }

    @FXML
    void show_find_SubPane(ActionEvent event) {
        switch (findCBox1.getValue().toString()) {
            case "Bicykel":
                            Bicykelpane1.setVisible(true);
                            PrislusenstvoPane1.setVisible(false);
                            ObjednavkaPane1.setVisible(false);
                            break;
            case "Prislusenstvo":
                                    Bicykelpane1.setVisible(false);
                                    PrislusenstvoPane1.setVisible(true);
                                    ObjednavkaPane1.setVisible(false);
                                    break;
            case "Objednavka":  Bicykelpane1.setVisible(false);
                                PrislusenstvoPane1.setVisible(false);
                                ObjednavkaPane1.setVisible(true);
                                break;
        }
    }

    @FXML
    void show_insert_SubPane(ActionEvent event) {
        switch (insertCBox.getValue().toString()){
            case "Bicykel" : Bicykelpane2.setVisible(true);
                             PrislusenstvoPane2.setVisible(false);
                             Typpane2.setVisible(false);
                             CenaPane2.setVisible(false);
                             Typpaneaccessories2.setVisible(false);
                             ObjednavkaPane2.setVisible(false);

                                try {
                                    filcombo_cena(select_price1);
                                    filcombo_bikeType(select_type1);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                break;
            case "Prislusenstvo" : Bicykelpane2.setVisible(false);
                                   PrislusenstvoPane2.setVisible(true);
                                   Typpane2.setVisible(false);
                                   CenaPane2.setVisible(false);
                                   Typpaneaccessories2.setVisible(false);
                                   ObjednavkaPane2.setVisible(false);

                                    try {
                                        filcombo_cena(select_price2);
                                        filcombo_accessoriesType(select_type2);
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                   break;
            case "Typ bicykla" : Bicykelpane2.setVisible(false);
                                 PrislusenstvoPane2.setVisible(false);
                                 Typpane2.setVisible(true);
                                 CenaPane2.setVisible(false);
                                 Typpaneaccessories2.setVisible(false);
                                 ObjednavkaPane2.setVisible(false);
                                 break;
            case "Typ prislusenstva" :  Bicykelpane2.setVisible(false);
                                        PrislusenstvoPane2.setVisible(false);
                                        Typpane2.setVisible(false);
                                        CenaPane2.setVisible(false);
                                        Typpaneaccessories2.setVisible(true);
                                        ObjednavkaPane2.setVisible(false);
                                        break;
            case "Cena" : Bicykelpane2.setVisible(false);
                          PrislusenstvoPane2.setVisible(false);
                          Typpane2.setVisible(false);
                          CenaPane2.setVisible(true);
                          Typpaneaccessories2.setVisible(false);
                          ObjednavkaPane2.setVisible(false);
                          break;
            case "Objednavka" :
                                Bicykelpane2.setVisible(false);
                                PrislusenstvoPane2.setVisible(false);
                                Typpane2.setVisible(false);
                                CenaPane2.setVisible(false);
                                Typpaneaccessories2.setVisible(false);
                                ObjednavkaPane2.setVisible(true);

                                try {
                                    filcombo_objednavka_bike(select_bike_objednavka);
                                    filcombo_objednavka_accessories(select_accessories_objednavka);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                items.clear();
                                list_objaccessories.clear();
                                list_objbikes.clear();
                                total_price = 0.0;
                                total_items = 0;
                                tableviewbike1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
                                tableview_objednavka.getColumns().clear();
                                Update_tableview inst;
                                inst = new Update_tableview();
                                inst.objednavka_table(tableview_objednavka);
                                tableview_objednavka.setVisible(true);
                                break;
        }
    }

    @FXML
    void show_update_SubPane(ActionEvent event) {
        Update_tableview inst;
        switch (updateCBox.getValue().toString()){

            case "Bicykel" :    Bicykel_ubdatePane.setVisible(true);
                                Prislusenstvo_ubdatePane.setVisible(false);
                                Typ_ubdatePane.setVisible(false);
                                Cena_ubdatePane.setVisible(false);
                                try {
                                    filcombo_cena(select_updateprice);
                                    filcombo_bikeType(select_updatetype);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                tableviewbikeUPD.getColumns().clear();
                                inst = new Update_tableview();
                                inst.for_bike(tableviewbikeUPD);

                                break;
            case "Prislusenstvo" :  Bicykel_ubdatePane.setVisible(false);
                                    Prislusenstvo_ubdatePane.setVisible(true);
                                    Typ_ubdatePane.setVisible(false);
                                    Cena_ubdatePane.setVisible(false);
                                    try {
                                        filcombo_cena(select_updateprice);
                                        filcombo_bikeType(select_updatetype);
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    break;
            case "Typ bicykla" :    Bicykel_ubdatePane.setVisible(false);
                                    Prislusenstvo_ubdatePane.setVisible(false);
                                    Typ_ubdatePane.setVisible(true);
                                    Cena_ubdatePane.setVisible(false);
                                    try {
                                        filcombo_cena(select_updateprice);
                                        filcombo_bikeType(select_updatetype);
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    tableviewtypeUPD.getColumns().clear();
                                    inst = new Update_tableview();
                                    inst.for_bikeType(tableviewtypeUPD);
                                    break;
            case "Cena" :   Bicykel_ubdatePane.setVisible(false);
                            Prislusenstvo_ubdatePane.setVisible(false);
                            Typ_ubdatePane.setVisible(false);
                            Cena_ubdatePane.setVisible(true);
                            try {
                                filcombo_cena(select_updateprice);
                                filcombo_bikeType(select_updatetype);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            tableviewpriceUPD.getColumns().clear();
                            inst = new Update_tableview();
                            inst.for_price(tableviewpriceUPD);
                            break;
        }
    }

    @FXML
    void show_delete_SubPane(ActionEvent event) {
        Update_tableview inst;
        switch (removeCBox.getValue().toString()) {
            case "Bicykel":
                                Bicykel_deletePane.setVisible(true);
                                Accessories_deletePane.setVisible(false);
                                BikeType_deletePane.setVisible(false);
                                AccessoriesType_deletePane.setVisible(false);
                                Price_deletePane.setVisible(false);

                                tableviewbikeDEL.getColumns().clear();
                                inst = new Update_tableview();
                                inst.for_bike(tableviewbikeDEL);
                                break;
            case "Prislusenstvo":
                                    Bicykel_deletePane.setVisible(false);
                                    Accessories_deletePane.setVisible(true);
                                    BikeType_deletePane.setVisible(false);
                                    AccessoriesType_deletePane.setVisible(false);
                                    Price_deletePane.setVisible(false);


                                    tableviewaccessoriesDEL.getColumns().clear();
                                    inst = new Update_tableview();
                                    inst.for_accessories(tableviewaccessoriesDEL);
                                    break;
            case "Typ bicykla" :    Bicykel_deletePane.setVisible(false);
                                    Accessories_deletePane.setVisible(false);
                                    BikeType_deletePane.setVisible(true);
                                    AccessoriesType_deletePane.setVisible(false);
                                    Price_deletePane.setVisible(false);


                                    tableviewbiketypeDEL.getColumns().clear();
                                    inst = new Update_tableview();
                                    inst.for_bikeType(tableviewbiketypeDEL);
                                    break;
            case "Typ prislusenstva" :  Bicykel_deletePane.setVisible(false);
                                        Accessories_deletePane.setVisible(false);
                                        BikeType_deletePane.setVisible(false);
                                        AccessoriesType_deletePane.setVisible(true);
                                        Price_deletePane.setVisible(false);

                                        tableviewaccessoriestypeDEL.getColumns().clear();
                                        inst = new Update_tableview();
                                        inst.for_accessoriesType(tableviewaccessoriestypeDEL);
                                        break;
            case "Cena" :   Bicykel_deletePane.setVisible(false);
                            Accessories_deletePane.setVisible(false);
                            AccessoriesType_deletePane.setVisible(false);
                            BikeType_deletePane.setVisible(false);
                            Price_deletePane.setVisible(true);

                            tableviewpriceDEL.getColumns().clear();
                            inst = new Update_tableview();
                            inst.for_price(tableviewpriceDEL);
                            break;
        }
    }

    //----------------------------INSERT-----------------------------

    @FXML
    void insert_newprice(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(!textfield_cena.getText().isEmpty()) {
            try {
                cena = Double.parseDouble(textfield_cena.getText());
            } catch (NumberFormatException e) {
                error_window("Cena nie je desatinne cislo (double).");
            }

            Session session = OpenSession.getSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                CenaEntity novacena = new CenaEntity();
                novacena.setCena(cena);
                session.save(novacena);
                tx.commit();

                textfield_cena.clear();

            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
        else{
            error_window("Chyba pri vkladani ceny");
        }
    }

    @FXML
    void insert_newtype(ActionEvent event) throws SQLException {
        if(!textfield_type.getText().isEmpty()) {
            typ = textfield_type.getText();

            Session session = OpenSession.getSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                BikeTypeEntity novytyp = new BikeTypeEntity();
                novytyp.setTyp(typ);
                session.save(novytyp);
                tx.commit();

                textfield_type.clear();

            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
        else{
            error_window("Chyba pri vkladani typu bicykla");
        }
    }

    @FXML
    void insert_newtype_accessories(ActionEvent event) throws SQLException {
        if(!textfield_typeaccessories.getText().isEmpty()) {

            Session session = OpenSession.getSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                AccessoriesTypeEntity novytyp = new AccessoriesTypeEntity();
                novytyp.setTyp(typ);
                session.save(novytyp);
                tx.commit();

                textfield_typeaccessories.clear();

            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
        else{
            error_window("Chyba pri vkladani typu prislusenstva");
        }
    }

    @FXML
    void insert_newbike(ActionEvent event) throws SQLException {
        if((!textfield_bikename.getText().isEmpty()) && (!(select_price1.getValue()==null)) && (!select_type1.getValue().isEmpty()) && (!textfield_bikesize.getText().isEmpty())) {
            bike_name = textfield_bikename.getText();
            int velkost = 0;
            CenaEntity id_cena = null;
            BikeTypeEntity id_typ = null;

            try {
                velkost = Integer.parseInt(textfield_bikesize.getText());
            } catch (NumberFormatException e) {
                error_window("Velkost bicykla nie je cislo");
            }

            List helpList = null;
            Session session = OpenSession.getSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                Criteria criteria = session.createCriteria(CenaEntity.class);
                criteria.add(Restrictions.eq("cena", select_price1.getValue()));
                helpList = criteria.list();

                for (Iterator iterator = helpList.iterator(); iterator.hasNext(); ) {
                    CenaEntity myc = (CenaEntity) iterator.next();
                    id_cena = myc;
                }

                helpList = null;
                criteria = session.createCriteria(BikeTypeEntity.class);
                criteria.add(Restrictions.like("typ", select_type1.getValue().toString()));
                helpList = criteria.list();

                for (Iterator iterator = helpList.iterator(); iterator.hasNext(); ) {
                    BikeTypeEntity myt = (BikeTypeEntity) iterator.next();
                    id_typ = myt;
                }

                BycikelEntity novyBicykel = new BycikelEntity();
                novyBicykel.setBikeTypeByIdT(id_typ);
                novyBicykel.setCenaByIdC(id_cena);
                novyBicykel.setNazov(bike_name);
                novyBicykel.setVelkost(velkost);

                session.save(novyBicykel);
                tx.commit();

                textfield_bikename.clear();
                textfield_bikesize.clear();

            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }

        }
        else{
            error_window("Chyba v pri vkladani bicykla");
        }

    }

    @FXML
    void insert_newaccessories(ActionEvent event) throws SQLException {
        if((!textfield_accessoriesname.getText().isEmpty()) && (!(select_price2.getValue()==null)) && (!select_type2.getValue().isEmpty())) {
            CenaEntity id_cena = null;
            AccessoriesTypeEntity id_typ = null;

            List helpList = null;
            Session session = OpenSession.getSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                Criteria criteria = session.createCriteria(CenaEntity.class);
                criteria.add(Restrictions.eq("cena", select_price2.getValue()));
                helpList = criteria.list();

                for (Iterator iterator = helpList.iterator(); iterator.hasNext(); ) {
                    CenaEntity myc = (CenaEntity) iterator.next();
                    id_cena = myc;
                }
                helpList = null;
                criteria = session.createCriteria(AccessoriesTypeEntity.class);
                criteria.add(Restrictions.eq("typ", select_type2.getValue().toString()));
                helpList = criteria.list();

                for (Iterator iterator = helpList.iterator(); iterator.hasNext(); ) {
                    AccessoriesTypeEntity myt = (AccessoriesTypeEntity) iterator.next();
                    id_typ = myt;
                }
                AccessoriesEntity novePrisl = new AccessoriesEntity();
                novePrisl.setCenaByIdC(id_cena);
                novePrisl.setAccessoriesTypeByIdT(id_typ);
                novePrisl.setNazov(textfield_accessoriesname.getText());

                session.save(novePrisl);
                tx.commit();

                textfield_accessoriesname.clear();

            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
        else{
            error_window("Chyba pri vkladani prislusenstva");
        }

    }

    @FXML
    void insert_newobjednavka(ActionEvent event) throws SQLException {
        if (total_items != 0) {
            Session session = OpenSession.getSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                ObjednavkaEntity novaObj = new ObjednavkaEntity(total_price, total_items);
                session.save(novaObj);

                tx.commit();
                set_items(novaObj);
                list_objaccessories.clear();
                list_objbikes.clear();
                tableview_objednavka.getItems().clear();
                total_items_label.setText("");
                total_price_label.setText("");
                total_items = 0;
                total_price = 0.0;
                obj_window();

            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
        else {
            error_window("Chyba pri vytvarani objednavky");
        }

    }

    //----------------------------SEARCH-----------------------------

    @FXML
    void search_bike(ActionEvent event) throws SQLException {
        if(!textfield_searchbike.getText().isEmpty()) {
            tableviewbike1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            tableviewbike1.getColumns().clear();
            Search inst;
            inst = new Search();
            inst.search_defined(tableviewbike1, textfield_searchbike.getText());
            tableviewbike1.setVisible(true);
        }
        else{
            error_window("Chyba pri hladani bicykla");
        }

    }

    @FXML
    void search_allbikes(ActionEvent event){
            tableviewbike1.getColumns().clear();
            Search inst;
            inst = new Search();
            inst.search_allbikes(tableviewbike1);
            tableviewbike1.setVisible(true);
    }

    @FXML
    void search_accessories(ActionEvent event) throws SQLException {
        if(!textfield_searchaccessories.getText().isEmpty()) {
            tableviewaccessories1.getColumns().clear();
            Search inst;
            inst = new Search();
            inst.search_accessories(tableviewaccessories1, textfield_searchaccessories.getText());
            tableviewaccessories1.setVisible(true);
        }
        else{
            error_window("Chyba pri hladani prislusenstva");
        }

    }

    @FXML
    void search_objednavka(ActionEvent event) throws SQLException {
        int idobj = 0;
        if (!textfield_searchobjednavka.getText().isEmpty()) {
            try{
                idobj = Integer.parseInt(textfield_searchobjednavka.getText());
                tableviewobjednavka1.getColumns().clear();
                Search inst;
                inst = new Search();
                inst.search_objednavka(tableviewobjednavka1, Integer.valueOf(textfield_searchobjednavka.getText()));
                tableviewobjednavka1.setVisible(true);
            }catch(NumberFormatException e){
                error_window("Cislo objednavky nie je cislo.");

            }
        } else {
            error_window("Chyba pri hladani objednavky");
        }




    }

    @FXML
    void search_allobj(ActionEvent event) throws SQLException {
        tableviewobjednavka1.getColumns().clear();
        Search inst;
        inst = new Search();
        inst.search_allobjednavka(tableviewobjednavka1);
        tableviewobjednavka1.setVisible(true);
    }

   /* @FXML
    void serach_3top(ActionEvent event) throws SQLException {
        tableviewbike1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        Connection conn = null;
        PreparedStatement stmt = null;
        Properties connectionProps = new Properties();

        connectionProps.put("user", "root");
        connectionProps.put("password", "916626");


        String connectionString = "jdbc:mysql://localhost:3306/DBS_projekt";
        try {
            conn = DriverManager.getConnection(connectionString, connectionProps);
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {

            stmt.close();

        }
    }

    @FXML
    void search_3tail(ActionEvent event) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Properties connectionProps = new Properties();

        connectionProps.put("user", "root");
        connectionProps.put("password", "916626");


        String connectionString = "jdbc:mysql://localhost:3306/DBS_projekt";
    }*/


    //----------------------------UPDATE-----------------------------
    @FXML
    void update_product(ActionEvent event) throws SQLException {
        BikeTypeEntity id_typ = null;
        CenaEntity id_cena = null;

        Session session = OpenSession.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            if (!textfield_updateName.getText().isEmpty() && !textfield_updateID1.getText().isEmpty()) {
                BycikelEntity updatedBike = (BycikelEntity) session.get(BycikelEntity.class, Integer.parseInt(textfield_updateID1.getText()));
                updatedBike.setNazov(textfield_updateName.getText());
                session.update(updatedBike);
            }
            if (select_updatetype.getValue() != null && !textfield_updateID1.getText().isEmpty()) {
                Criteria criteria = session.createCriteria(BikeTypeEntity.class);
                criteria.add(Restrictions.eq("typ", select_updatetype.getValue().toString()));
                List typelist = criteria.list();

                for (Iterator iterator = typelist.iterator(); iterator.hasNext(); ) {
                    BikeTypeEntity mybt = (BikeTypeEntity) iterator.next();
                    id_typ = mybt;
                }
                BycikelEntity updatedBike = (BycikelEntity) session.get(BycikelEntity.class, Integer.parseInt(textfield_updateID1.getText()));
                updatedBike.setBikeTypeByIdT(id_typ);
                session.update(updatedBike);
            }
            if (select_updateprice.getValue() != null && !textfield_updateID1.getText().isEmpty()) {
                Criteria criteria = session.createCriteria(CenaEntity.class);
                criteria.add(Restrictions.eq("typ", select_updateprice.getValue()));
                List pricelist = criteria.list();

                for (Iterator iterator = pricelist.iterator(); iterator.hasNext(); ) {
                    CenaEntity myc = (CenaEntity) iterator.next();
                    id_cena = (CenaEntity) myc;
                }
                BycikelEntity updatedBike = (BycikelEntity) session.get(BycikelEntity.class, Integer.parseInt(textfield_updateID1.getText()));
                updatedBike.setCenaByIdC(id_cena);
                session.update(updatedBike);
            }
            tx.commit();

            tableviewbikeUPD.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            tableviewbikeUPD.getColumns().clear();
            Update_tableview inst;
            inst = new Update_tableview();
            inst.for_bike(tableviewbikeUPD);
            tableviewbikeUPD.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @FXML
    void update_price(ActionEvent event) throws SQLException {
        Session session = OpenSession.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            if (!textfield_updatePrice.getText().isEmpty() && !textfield_updateID2.getText().isEmpty()) {
                CenaEntity updatedcena = (CenaEntity) session.get(CenaEntity.class, Integer.parseInt(textfield_updateID2.getText()));
                updatedcena.setCena(Double.parseDouble(textfield_updatePrice.getText()));
            }
            tx.commit();

            tableviewpriceUPD.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            tableviewpriceUPD.getColumns().clear();
            Update_tableview inst;
            inst = new Update_tableview();
            inst.for_price(tableviewpriceUPD);

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @FXML
    void update_type(ActionEvent event) throws SQLException {
        Session session = OpenSession.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            if((!textfield_updateType.getText().isEmpty()) && (!textfield_updateID4.getText().isEmpty())) {
                BikeTypeEntity updatedtype = (BikeTypeEntity) session.get(BikeTypeEntity.class, Integer.parseInt(textfield_updateID4.getText()));
                updatedtype.setTyp(textfield_updateType.getText());
            }
            tx.commit();

            tableviewtypeUPD.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            tableviewtypeUPD.getColumns().clear();
            Update_tableview inst;
            inst = new Update_tableview();
            inst.for_bikeType(tableviewtypeUPD);

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    //----------------------------DELETE-----------------------------

    @FXML
    void delete_bike(ActionEvent ecent) throws SQLException {
        Session session = OpenSession.getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            if((!textfield_deleteID1.getText().isEmpty())) {
                BycikelEntity myb = (BycikelEntity)session.get(BycikelEntity.class, textfield_deleteID1.getText());
                session.delete(myb);
            } else {
                if (!textfield_deleteName.getText().isEmpty()) {
                    BycikelEntity myb = (BycikelEntity) session.createCriteria(BycikelEntity.class).add(Restrictions.eq("nazov", textfield_deleteName.getText()));
                    session.delete(myb);
                } else {
                    error_window("Chyba pri mazani bicykla");
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        tableviewbikeDEL.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableviewbikeDEL.getColumns().clear();
        Update_tableview inst;
        inst = new Update_tableview();
        inst.for_bike(tableviewbikeDEL);
    }

    @FXML
    void delete_accessories(ActionEvent ecent) throws SQLException {
        Session session = OpenSession.getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            if(!textfield_deleteID2.getText().isEmpty()) {
                AccessoriesEntity mya = (AccessoriesEntity)session.get(AccessoriesEntity.class, textfield_deleteID2.getText());
                session.delete(mya);
            } else {
                if (!textfield_deleteaccessories.getText().isEmpty()) {
                    AccessoriesEntity mya = (AccessoriesEntity) session.createCriteria(AccessoriesEntity.class).add(Restrictions.eq("nazov", textfield_deleteaccessories.getText()));
                    session.delete(mya);
                } else {
                    error_window("Chyba pri mazani prislusenstva");
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        tableviewaccessoriesDEL.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableviewaccessoriesDEL.getColumns().clear();
        Update_tableview inst;
        inst = new Update_tableview();
        inst.for_accessories(tableviewaccessoriesDEL);
    }

    @FXML
    void delete_biketype(ActionEvent ecent) throws SQLException {
        Session session = OpenSession.getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            if(!textfield_deleteID3.getText().isEmpty()) {
                BikeTypeEntity myb = (BikeTypeEntity)session.get(BikeTypeEntity.class, textfield_deleteID3.getText());
                session.delete(myb);
            } else {
                if (!textfield_deletebiketype.getText().isEmpty()) {
                    BikeTypeEntity myb = (BikeTypeEntity) session.createCriteria(BikeTypeEntity.class).add(Restrictions.eq("typ", textfield_deletebiketype.getText()));
                    session.delete(myb);
                } else {
                    error_window("Chyba pri mazani typu bicykla");
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        tableviewbiketypeDEL.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableviewbiketypeDEL.getColumns().clear();
        Update_tableview inst;
        inst = new Update_tableview();
        inst.for_bikeType(tableviewbiketypeDEL);
    }

    @FXML
    void delete_accessoriestype(ActionEvent ecent) throws SQLException {
        Session session = OpenSession.getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            if(!textfield_deleteID4.getText().isEmpty()) {
                AccessoriesTypeEntity mya = (AccessoriesTypeEntity)session.get(AccessoriesTypeEntity.class, textfield_deleteID4.getText());
                session.delete(mya);
            } else {
                if (!textfield_deleteaccessoriestype.getText().isEmpty()) {
                    AccessoriesTypeEntity mya = (AccessoriesTypeEntity) session.createCriteria(AccessoriesTypeEntity.class).add(Restrictions.eq("typ", textfield_deleteaccessoriestype.getText()));
                    session.delete(mya);
                } else {
                    error_window("Chyba pri mazani typu prislusenstva");
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        tableviewaccessoriestypeDEL.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableviewaccessoriestypeDEL.getColumns().clear();
        Update_tableview inst;
        inst = new Update_tableview();
        inst.for_bikeType(tableviewaccessoriestypeDEL);
    }

    @FXML
    void delete_price(ActionEvent ecent) throws SQLException {
        Session session = OpenSession.getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            if(!textfield_deleteID5.getText().isEmpty()) {
                CenaEntity mya = (CenaEntity)session.get(CenaEntity.class, textfield_deleteID5.getText());
                session.delete(mya);
            } else {
                if (!textfield_deleteprice.getText().isEmpty()) {
                    CenaEntity mya = (CenaEntity) session.createCriteria(CenaEntity.class).add(Restrictions.eq("typ", textfield_deleteprice.getText()));
                    session.delete(mya);
                } else {
                    error_window("Chyba pri mazani ceny");
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        tableviewpriceDEL.getColumns().clear();
        Update_tableview inst;
        inst = new Update_tableview();
        inst.for_price(tableviewpriceDEL);
    }


    //----------------------------REMOVE ITEM FROM TABLE-----------------------------

    @FXML
    void remove_bike(ActionEvent event) throws SQLException {
        TablePosition pos = (TablePosition) tableview_objednavka.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();

        Stlpce aktualne = tableview_objednavka.getSelectionModel().getSelectedItem();
        double aktcena = aktualne.getCena();
        total_price-=aktcena;
        total_items--;
        total_price_label.setText(String.valueOf(total_price));
        total_items_label.setText(String.valueOf(total_items));
        list_objbikes.remove(aktualne.getId());
        tableview_objednavka.getItems().remove(row);
    }

    @FXML
    void remove_accessories(ActionEvent event) throws SQLException {
        TablePosition pos = (TablePosition) tableview_objednavka.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();

        Stlpce aktualne = tableview_objednavka.getSelectionModel().getSelectedItem();
        double aktcena = aktualne.getCena();
        total_price-=aktcena;
        total_items--;
        total_price_label.setText(String.valueOf(total_price));
        total_items_label.setText(String.valueOf(total_items));
        list_objaccessories.remove(aktualne.getId());
        tableview_objednavka.getItems().remove(row);
    }

    //----------------------------STATISTIKA-----------------------------

    @FXML
    void statistika_top5(ActionEvent event) throws SQLException {
        tableviewstatistika.getColumns().clear();
        Statistiky inst;
        inst = new Statistiky();
        inst.statistika_top5(tableviewstatistika);
        tableviewstatistika.setVisible(true);
    }

    @FXML
    void statistika_top3products(ActionEvent event) throws SQLException {
        tableviewstatistika.getColumns().clear();
        Statistiky inst;
        inst = new Statistiky();
        inst.statistika_top3products(tableviewstatistika);
        tableviewstatistika.setVisible(true);
    }

    @FXML
    void statistika_defined(ActionEvent event) {
        if(!textfield_statistikabike.getText().isEmpty()) {
            tableviewstatistika.getColumns().clear();
            Statistiky inst;
            inst = new Statistiky();
            inst.statistika_defined(tableviewstatistika, textfield_statistikabike.getText());
            tableviewstatistika.setVisible(true);
        }
        else{
            error_window("Chyba pri zadani mena");
        }
    }

    //----------------------------FILL-----------------------------

    private void filcombo_cena(ComboBox comboBox_pom) throws SQLException {
        list_cena.clear();
        List allprices = null;
        Session session = OpenSession.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(CenaEntity.class).setProjection(Projections.property("cena"));
            list_cena.addAll(criteria.list());

            comboBox_pom.setItems(list_cena);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private void filcombo_bikeType(ComboBox comboBox_pom) throws SQLException {
        list_typ.clear();
        Session session = OpenSession.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(BikeTypeEntity.class).setProjection(Projections.property("typ"));
            list_typ.addAll(criteria.list());

            comboBox_pom.setItems(list_typ);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private void filcombo_accessoriesType(ComboBox comboBox_pom) throws SQLException {
        list_typ.clear();
        Session session = OpenSession.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(AccessoriesTypeEntity.class).setProjection(Projections.property("typ"));
            list_typ.addAll(criteria.list());

            comboBox_pom.setItems(list_typ);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private void filcombo_objednavka_bike(ComboBox comboBox_pom) throws SQLException {
        list_bikes.clear();
        Session session = OpenSession.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(BycikelEntity.class).setProjection(Projections.property("nazov"));
            list_bikes.addAll(criteria.list());


            comboBox_pom.setItems(list_bikes);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private void filcombo_objednavka_accessories(ComboBox comboBox_pom) throws SQLException {
        list_accessories.clear();
        Session session = OpenSession.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(AccessoriesEntity.class).setProjection(Projections.property("nazov"));
            list_accessories.addAll(criteria.list());

            comboBox_pom.setItems(list_accessories);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


    }

    private void error_window(String message){
        Label message_label = new Label(message);
        StackPane error_layout = new StackPane();
        error_layout.getChildren().add(message_label);
        Scene errorScene = new Scene(error_layout, 400, 150);

        Stage errorStage = new Stage();
        errorStage.setTitle("Chyba!!!");
        errorStage.setScene(errorScene);

        //Set position of second window, related to primary window.
        errorStage.setX(750);
        errorStage.setY(350);

        errorStage.show();
    }

    @FXML
    void add_newaccessories(){
        if(select_accessories_objednavka.getValue()!=null){
            List allaccessories = null;
            Session session = OpenSession.getSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                Criteria criteria = session.createCriteria(AccessoriesEntity.class);
                criteria.add(Restrictions.like("nazov", select_accessories_objednavka.getValue()));
                allaccessories = criteria.list();

                for (Iterator iterator = allaccessories.iterator(); iterator.hasNext(); ) {
                    AccessoriesEntity mya = (AccessoriesEntity) iterator.next();
                    items.add(new Stlpce(mya.getId(), mya.getNazov(), mya.getCenaByIdC().getCena(), mya.getAccessoriesTypeByIdT().getTyp()));
                    list_objaccessories.add(mya.getId());
                    total_price += mya.getCenaByIdC().getCena();
                    total_items++;
                }

                tableview_objednavka.setItems(items);
                total_items_label.setText(String.valueOf(total_items));
                total_price_label.setText(String.valueOf(total_price));

                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
            tableview_objednavka.setVisible(true);
        }
    }

    @FXML
    void add_newbike(){
        if(select_bike_objednavka.getValue()!=null){
            List allbikes = null;
            Session session = OpenSession.getSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                Criteria criteria = session.createCriteria(BycikelEntity.class);
                criteria.add(Restrictions.like("nazov", select_bike_objednavka.getValue()));
                allbikes = criteria.list();

                for (Iterator iterator = allbikes.iterator(); iterator.hasNext(); ) {
                    BycikelEntity myb = (BycikelEntity) iterator.next();
                    items.add(new Stlpce(myb.getIdB(), myb.getNazov(), myb.getCenaByIdC().getCena(), myb.getBikeTypeByIdT().getTyp()));
                    list_objbikes.add(myb.getIdB());
                    total_price += myb.getCenaByIdC().getCena();
                    total_items++;
                }

                tableview_objednavka.setItems(items);
                total_items_label.setText(String.valueOf(total_items));
                total_price_label.setText(String.valueOf(total_price));

                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
            tableview_objednavka.setVisible(true);
        }
    }

    private void set_items(ObjednavkaEntity novaObj)  throws SQLException{
        Session session = OpenSession.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            for(int i=0; i<list_objbikes.size();i++) {
                PolozkyEntity nova_polozka = new PolozkyEntity();
                nova_polozka.setIdProduct(list_objbikes.get(i));
                nova_polozka.setBike(1);
                nova_polozka.setAccessories(0);
                nova_polozka.setId_odbjednavkyByIdO(novaObj);
                session.save(nova_polozka);

            }
            for(int i=0; i<list_objaccessories.size();i++) {
                PolozkyEntity nova_polozka = new PolozkyEntity();
                nova_polozka.setIdProduct(list_objaccessories.get(i));
                nova_polozka.setBike(0);
                nova_polozka.setAccessories(1);
                nova_polozka.setId_odbjednavkyByIdO(novaObj);
                session.save(nova_polozka);

            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private void obj_window(){

        Label message_label = new Label("Objednanie prebehlo uspesne.");
        StackPane obj_layout = new StackPane();
        obj_layout.getChildren().add(message_label);


        Scene errorScene = new Scene(obj_layout, 400, 150);

        Stage errorStage = new Stage();
        errorStage.setTitle("Objednavka");
        errorStage.setScene(errorScene);

        //Set position of second window, related to primary window.
        errorStage.setX(750);
        errorStage.setY(350);

        errorStage.show();
    }



}
