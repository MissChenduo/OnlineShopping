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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chenduo Ouyang 19091093
 */
public class dbKeyManager implements IKeyManager {

    public dbKeyManager() {
        dbKeyManager.intialiseTable() ;
    }

    @Override
    public int getNextId() {
        try {
            Integer nextid ;
            DBManager db = new DBManager();
            Connection conn = db.getConnection();
            Statement statement;
            
            ResultSet rs ;
            String QuerySql = "SELECT NEXTID FROM NEXTID";
            statement = conn.createStatement();
            rs = statement.executeQuery(QuerySql);
            rs.next();
            nextid = rs.getInt(1);
            String updateSql = "UPDATE NEXTID SET NEXTID = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateSql);
            pstmt.setInt(1, (nextid + 1) );
            pstmt.executeUpdate() ;
            
            rs.close();
            db.closeConnections();
            return nextid;
        } catch (SQLException ex) {
            Logger.getLogger(dbKeyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    /**
     * Static method to initialize a key table
     */
    public static void intialiseTable()  {
        try {
            DBManager db = new DBManager();
            Connection conn = db.getConnection();
            if (conn == null) {
                System.out.println("Cannot get connection from db");
                return;
            }
            if (!db.isTableExist("NEXTID")) {
                // Create NextID Table to the database
                Statement statement;
                String createSql = "CREATE TABLE NEXTID ( NEXTID INT NOT NULL)";
                String insertSql = "INSERT INTO NEXTID VALUES (1000)";
                statement = conn.createStatement();
                statement.executeUpdate(createSql);
                statement.executeUpdate(insertSql);
                db.closeConnections();
            } else {
                System.out.println("NextId table exists!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbKeyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
