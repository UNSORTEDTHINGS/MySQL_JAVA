package database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Database {

    private final Map<String, Product> DATA;

    public Database() {
        DATA = new HashMap<>();
    }

    private Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Authentication.URL, Authentication.USER_NAME, Authentication.PASSWORD);
            if (connection != null) {
                System.out.println("Connected to the database " + Authentication.DATABASE_NAME);
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        return connection;
    }

    public Map<String, Product> getDATA() {
        return DATA;
    }

    public void loadData() {
        ResultSet rs;
        try {
            Statement load = connect().createStatement();
            rs = load.executeQuery(Quarries.SELECT.GET_STATEMENT());
            while (rs.next())
                DATA.put(rs.getString(2), new Product(rs.getString(1), rs.getString(2),
                        rs.getDouble(3), rs.getDouble(4), rs.getInt(5)));

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("LOAD DATA IS DONE");
    }

    public void addToDB(Product product) {
        if(!exist(product.getName())) {
            try {
                PreparedStatement insert = connect().prepareStatement(Quarries.INSERT.GET_STATEMENT());
                insert.setString(1, product.getSku());
                insert.setString(2, product.getName());
                insert.setDouble(3, product.getOriginal_price());
                insert.setDouble(4, product.getSell_price());
                insert.setInt(5, product.getQty());
                DATA.put(product.getName(), product);
                insert.executeUpdate();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        else {
            System.out.println("Record : "+product.getName() + " - Already There");
        }
    }

    public Product findRecord(String name) {
        return DATA.get(name);
    }

    public void removeRecord(String name) {
        try {
            PreparedStatement delete = connect().prepareStatement(Quarries.DELETE.GET_STATEMENT());
            delete.setString(1, name);
            delete.executeUpdate();
            DATA.remove(name);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    private boolean exist(String name){
        for (String s:DATA.keySet()) {
            if(s.equalsIgnoreCase(name)){
              return true;
            }
        }
        return false;
    }

}
