package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.Properties;

public class Update_tableview {


    public void for_bike(TableView tableview1){
        Connection conn = null;
        PreparedStatement stmt = null;
        Properties connectionProps = new Properties();

        connectionProps.put("user", "root");
        connectionProps.put("password", "916626");


        String connectionString = "jdbc:mysql://localhost:3306/DBS_projekt";
        try {
            conn = DriverManager.getConnection(connectionString, connectionProps);
            stmt = conn.prepareStatement("SELECT * FROM bycikel JOIN cena ON cena.id = bycikel.id_c JOIN  bike_type ON bike_type.id_t = bycikel.id_t");
            ResultSet rs = stmt.executeQuery();
            ObservableList<Stlpce> stlpce_data = FXCollections.observableArrayList();
            stlpce_data.clear();
            while(rs.next()){
                stlpce_data.addAll(FXCollections.observableArrayList( new Stlpce(rs.getInt("id_b"),rs.getString("nazov"),rs.getDouble("cena"),rs.getString("typ"))));
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

            TableColumn stl_cena = new TableColumn("Cena");
            stl_cena.setMinWidth(100);
            stl_cena.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Double>("cena"));

            tableview1.setItems(stlpce_data);
            tableview1.getColumns().addAll(stl_id,stl_nazov, stl_typ, stl_cena);


        }catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void for_price(TableView tableview1){
        Connection conn = null;
        PreparedStatement stmt = null;
        Properties connectionProps = new Properties();

        connectionProps.put("user", "root");
        connectionProps.put("password", "916626");


        String connectionString = "jdbc:mysql://localhost:3306/DBS_projekt";
        try {
            conn = DriverManager.getConnection(connectionString, connectionProps);
            stmt = conn.prepareStatement("SELECT * FROM cena");
            ResultSet rs = stmt.executeQuery();
            ObservableList<Stlpce> stlpce_data = FXCollections.observableArrayList();
            stlpce_data.clear();
            while(rs.next()){
                stlpce_data.addAll(FXCollections.observableArrayList( new Stlpce(rs.getInt("id"),rs.getDouble("cena"))));
            }

            TableColumn stl_id = new TableColumn("ID");
            stl_id.setMinWidth(30);
            stl_id.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Integer>("id"));

            TableColumn stl_cena = new TableColumn("Cena");
            stl_cena.setMinWidth(100);
            stl_cena.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Double>("cena"));

            tableview1.setItems(stlpce_data);
            tableview1.getColumns().addAll(stl_id, stl_cena);
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void for_bikeType(TableView tableview1){
        Connection conn = null;
        PreparedStatement stmt = null;
        Properties connectionProps = new Properties();

        connectionProps.put("user", "root");
        connectionProps.put("password", "916626");


        String connectionString = "jdbc:mysql://localhost:3306/DBS_projekt";
        try {
            conn = DriverManager.getConnection(connectionString, connectionProps);
            stmt = conn.prepareStatement("SELECT * FROM bike_type");
            ResultSet rs = stmt.executeQuery();
            ObservableList<Stlpce> stlpce_data = FXCollections.observableArrayList();
            stlpce_data.clear();
            while(rs.next()){
                stlpce_data.addAll(FXCollections.observableArrayList( new Stlpce(rs.getInt("id_t"),rs.getString("typ"))));
            }

            TableColumn stl_id = new TableColumn("ID");
            stl_id.setMinWidth(30);
            stl_id.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Integer>("id"));

            TableColumn stl_typ = new TableColumn("Typ");
            stl_typ.setMinWidth(100);
            stl_typ.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, String>("typ"));


            tableview1.setItems(stlpce_data);
            tableview1.getColumns().addAll(stl_id, stl_typ);
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void for_accessoriesType(TableView tableview1){
        Connection conn = null;
        PreparedStatement stmt = null;
        Properties connectionProps = new Properties();

        connectionProps.put("user", "root");
        connectionProps.put("password", "916626");


        String connectionString = "jdbc:mysql://localhost:3306/DBS_projekt";
        try {
            conn = DriverManager.getConnection(connectionString, connectionProps);
            stmt = conn.prepareStatement("SELECT * FROM accessories_type");
            ResultSet rs = stmt.executeQuery();
            ObservableList<Stlpce> stlpce_data = FXCollections.observableArrayList();
            stlpce_data.clear();
            while(rs.next()){
                stlpce_data.addAll(FXCollections.observableArrayList( new Stlpce(rs.getInt("id"),rs.getString("typ"))));
            }

            TableColumn stl_id = new TableColumn("ID");
            stl_id.setMinWidth(30);
            stl_id.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Integer>("id"));

            TableColumn stl_typ = new TableColumn("Typ");
            stl_typ.setMinWidth(100);
            stl_typ.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, String>("typ"));


            tableview1.setItems(stlpce_data);
            tableview1.getColumns().addAll(stl_id, stl_typ);
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void for_accessories(TableView tableview1){
        Connection conn = null;
        PreparedStatement stmt = null;
        Properties connectionProps = new Properties();

        connectionProps.put("user", "root");
        connectionProps.put("password", "916626");


        String connectionString = "jdbc:mysql://localhost:3306/DBS_projekt";
        try {
            conn = DriverManager.getConnection(connectionString, connectionProps);
            stmt = conn.prepareStatement("SELECT * FROM accessories JOIN accessories_type ON accessories_type.id = accessories.id_t JOIN cena ON cena.id = accessories.id_c");
            ResultSet rs = stmt.executeQuery();
            ObservableList<Stlpce> stlpce_data = FXCollections.observableArrayList();
            stlpce_data.clear();
            while(rs.next()){
                stlpce_data.addAll(FXCollections.observableArrayList( new Stlpce(rs.getInt("id"),rs.getString("typ"))));
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

            TableColumn stl_cena = new TableColumn("Cena");
            stl_cena.setMinWidth(100);
            stl_cena.setCellValueFactory(
                    new PropertyValueFactory<Stlpce, Double>("cena"));


            tableview1.setItems(stlpce_data);
            tableview1.getColumns().addAll(stl_id, stl_nazov, stl_typ, stl_cena);
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void add_bike(TableView tableview1, String combonazov){
        Connection conn = null;
        PreparedStatement stmt = null;
        Properties connectionProps = new Properties();

        connectionProps.put("user", "root");
        connectionProps.put("password", "916626");


        String connectionString = "jdbc:mysql://localhost:3306/DBS_projekt";
        try{
            conn = DriverManager.getConnection(connectionString, connectionProps);
            stmt = conn.prepareStatement("SELECT id_b,nazov,typ,cena FROM bycikel JOIN cena ON cena.id = bycikel.id_c JOIN  bike_type ON bike_type.id_t = bycikel.id_t WHERE nazov=?");
            stmt.setString(1, combonazov);
            ResultSet rs = stmt.executeQuery();
            ObservableList stlpce_data = FXCollections.observableArrayList();
            while(rs.next()){
                stlpce_data.add(FXCollections.observableArrayList(new Stlpce(rs.getInt("id_b"), rs.getString("nazov"), rs.getDouble("cena"), rs.getString("typ"))));
            }



            tableview1.setItems(stlpce_data);

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void objednavka_table(TableView tableview1){
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

        TableColumn stl_cena = new TableColumn("Cena");
        stl_cena.setMinWidth(100);
        stl_cena.setCellValueFactory(
                new PropertyValueFactory<Stlpce, Double>("cena"));

        // tableview1.setItems(stlpce_data);
        tableview1.getColumns().addAll(stl_id, stl_nazov, stl_typ, stl_cena);

    }
}
