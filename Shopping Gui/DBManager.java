/*
 * The programs are designed for PDC paper
 */
package shoppinggui;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ChenDuo Ouyang 19091093
 */
public final class DBManager {

    private static final String USER_NAME = "pdc"; //your DB username
    private static final String PASSWORD = "pdc"; //your DB password
    private static final String URL = "jdbc:derby:ShopDB; create=true";  //url of the DB host

    Connection conn;

    /**
     *
     */
    public DBManager() {
        establishConnection();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        DBManager dbManager = new DBManager();
        System.out.println(dbManager.getConnection());
    }

    /**
     *
     * @return
     */
    public Connection getConnection() {
        return this.conn;
    }

    //Establish connection

    /**
     *
     */
    public void establishConnection() {
        try {
            //Establish a connection to Database
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     *
     * @param sql
     * @return
     */
    public ResultSet queryDB(String sql) {

        if( sql.isEmpty())
            return null;
        
        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSet;
    }

    /**
     *
     * @param sql
     */
    public void updateDB(String sql) {

        if( sql.isEmpty())
            return ;
        
        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param sTablename
     * @return
     * @throws SQLException
     */
    public boolean isTableExist(String sTablename) throws SQLException {
        if (conn != null) {
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, sTablename.toUpperCase(), null);
            if (rs.next()) {
                System.out.println(sTablename + " exists.");
                return true;
            } else {
                System.out.println(sTablename + " does not exist.");
                return false;
            }
        }
        return false;
    }

}
