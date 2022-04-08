/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppinggui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contains all the method to access data like insert, update, delete, create
 * table
 *
 * @author Chenduo Ouyang 19091093
 */
public class DataAccess {

    private final String InsertOrderSQL = "INSERT INTO ORDERHEAD (ORDERID, ORDERDATE, CUSTOMERNAME, ADDRESS, EMAIL) VALUES (?, ?, ?, ? ,?) ";
    private final String InsertOrderlnSQL = "INSERT INTO ORDERLINE (ORDERLINEID, ORDERID, PRODUCTID, QUANTITY, SIZE, COLOR, PRICE) VALUES (?, ?, ?, ?, ? ,? ,?) ";
    private final String InsertProductSQL = "INSERT INTO PRODUCT (ID, NAME, PRICE, CATEGORY, SIZE, COLOR) VALUES (?, ?, ?, ?, ?, ?) ";
    private final String DeleteProductSQL = "DELETE FROM PRODUCT WHERE ID = ?";
    private final String ProductByCatSQL = "SELECT * FROM PRODUCT WHERE CATEGORY = ?";
    private final String ProductByIdSQL = "SELECT * FROM PRODUCT WHERE ID = ?";
    private final String DeleteOrderSQL = "DELETE FROM ORDERHEAD WHERE ORDERID = ?";
    private final String DeleteAllOrderlnSQL = "DELETE FROM ORDERLINE WHERE ORDERID = ?";

    /**
     * Delete the order and all their lines
     * @param Id
     * @return 
     */
    public int deleteOrder(int Id) {
        Connection conn;
        DBManager db = new DBManager();
        conn = db.getConnection();
        try {
            PreparedStatement statement = conn.prepareStatement(DeleteOrderSQL);
            statement.setInt(1, Id);
            statement.executeUpdate();
            statement = conn.prepareStatement(DeleteAllOrderlnSQL);
            statement.setInt(1, Id);
            return statement.executeUpdate();
            

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnections();
        }
        return -1;
    }
   
    /**
     * get Product by Id
     * @param id
     * @return 
     */
    public Product getProductById(Integer id) {
        Product product = null;
        Connection conn;
        DBManager db = new DBManager();
        conn = db.getConnection();
        ResultSet rs = null;
        try {

            PreparedStatement statement = conn.prepareStatement(ProductByIdSQL);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                product = ProductFactory.loadProduct(rs);
            }

            return product;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null)
                try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
            db.closeConnections();
        }
        return null;
    }

    /**
     *
     * @param cat
     * @return
     */
    public ArrayList<Product> getProductsByCategory(Category cat) {
        ArrayList<Product> products = new ArrayList<Product>();
        Connection conn;
        DBManager db = new DBManager();
        conn = db.getConnection();
        ResultSet rs = null;
        try {

            PreparedStatement statement = conn.prepareStatement(ProductByCatSQL);
            statement.setString(1, cat.toString());
            rs = statement.executeQuery();
            while (rs.next()) {
                Product p = ProductFactory.loadProduct(rs);
                products.add(p);
            }

            return products;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null)
                try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
            db.closeConnections();
        }
        return null;
    }

    /**
     * record count
     *
     * @param tableName
     * @return
     */
    public int recordCount(String tableName) {

        String sql = "SELECT COUNT(*) FROM " + tableName;

        DBManager db = new DBManager();
        ResultSet rs = db.queryDB(sql);
        try {
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null)
                try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
            db.closeConnections();
        }
        return -1;
    }

    /**
     *
     */
    public void createOrderLineTable() {
        Connection conn;
        DBManager db = new DBManager();
        conn = db.getConnection();
        try {
            if (!db.isTableExist("ORDERLINE")) {
                Statement statement;
                String createSql = "CREATE TABLE ORDERLINE ( ORDERLINEID INTEGER not NULL, "
                        + "ORDERID INTEGER, "
                        + "PRODUCTID INTEGER, "
                        + "QUANTITY INTEGER, "
                        + "COLOR VARCHAR(20), "
                        + "SIZE VARCHAR(10), "
                        + "PRICE Numeric(6,2) ,"
                        + "PRIMARY KEY (ORDERLINEID) )";
                statement = conn.createStatement();
                statement.executeUpdate(createSql);

            } else {
                System.out.println("ORDERLINE Table already exists");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnections();
        }
    }

    /**
     * Create order Table if that doesn't exist
     */
    public void createOrderTable() {
        Connection conn;
        DBManager db = new DBManager();
        conn = db.getConnection();
        try {
            if (!db.isTableExist("ORDERHEAD")) {
                Statement statement;
                String createSql = "CREATE TABLE ORDERHEAD ( ORDERID INTEGER not NULL, "
                        + "ORDERDATE DATE, "
                        + "CUSTOMERNAME VARCHAR(100), "
                        + "ADDRESS VARCHAR(100), "
                        + "EMAIL VARCHAR(100), "
                        + "PRIMARY KEY (ORDERID))";
                statement = conn.createStatement();
                statement.executeUpdate(createSql);

            } else {
                System.out.println("Order Head Table already exists");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnections();
        }
    }

    /**
     * Create Product Table if it doesn't exists
     */
    public void createProductTable() {
        Connection conn;
        DBManager db = new DBManager();
        conn = db.getConnection();
        try {
            if (!db.isTableExist("PRODUCT")) {
                Statement statement;
                String createSql = "CREATE TABLE PRODUCT ( ID INTEGER not NULL, "
                        + "Name VARCHAR(250), "
                        + "Price Numeric(6,2), "
                        + "Category VARCHAR(10), "
                        + "Size VARCHAR(250), "
                        + "COLOR VARCHAR(250), "
                        + "PRIMARY KEY (ID) )";
                statement = conn.createStatement();
                statement.executeUpdate(createSql);

            } else {
                System.out.println("Product Table already exists");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnections();
        }
    }

    /**
     * Delete Product by id
     *
     * @param Id
     * @return
     */
    public int deleteProduct(int Id) {
        Connection conn;
        DBManager db = new DBManager();
        conn = db.getConnection();
        try {
            PreparedStatement statement = conn.prepareStatement(DeleteProductSQL);
            statement.setInt(1, Id);
            return statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnections();
        }
        return -1;
    }

    /**
     * Insert product into the Product Table
     *
     * @param product
     * @return
     */
    public int insertProduct(Product product) {
        Connection conn;
        DBManager db = new DBManager();
        conn = db.getConnection();
        try {
            PreparedStatement statement = conn.prepareStatement(InsertProductSQL);
            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getCategory().toString());

            if (product instanceof Clothing) {
                Clothing clothing = (Clothing) product;
                statement.setString(5, clothing.getSizes().toString());
                statement.setString(6, clothing.getColors().toString());
            } else {
                statement.setString(5, "");
                statement.setString(6, "");
            }
            return statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnections();
        }
        return -1;
    }

    /**
     * Insert OrderItem to database
     *
     * @param orderItem
     * @return
     */
    public int insertOrderItem(OrderItem orderItem) {
        Connection conn;
        DBManager db = new DBManager();
        conn = db.getConnection();
        try {
            PreparedStatement statement = conn.prepareStatement(InsertOrderlnSQL);
            statement.setInt(1, orderItem.getId());
            statement.setInt(2, orderItem.getOrderId());
            statement.setInt(3, orderItem.getProduct().getId());
            statement.setInt(4, orderItem.getQty());
            Product product = orderItem.getProduct();
            if (product instanceof Clothing) {
                statement.setString(5, orderItem.getSize());
                statement.setString(6, orderItem.getColor());
            } else {
                statement.setString(5, "");
                statement.setString(6, "");
            }
            statement.setDouble(7, product.getPrice());

            return statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnections();
        }
        return -1;
    }

    /**
     * Insert order to database
     *
     * @param order
     * @return
     */
    public int insertOrder(Order order) {
        Connection conn;
        DBManager db = new DBManager();
        conn = db.getConnection();
        try {
            PreparedStatement statement = conn.prepareStatement(InsertOrderSQL);
            statement.setInt(1, order.getOrderId());
            statement.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
            statement.setString(3, order.getCustomerName());
            statement.setString(4, order.getAddress());
            statement.setString(5, order.getEmail());
            return statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnections();
        }
        return -1;
    }

}    