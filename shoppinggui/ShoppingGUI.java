/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppinggui;

import guiView.HomeFrame;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Chenduo Ouyang 19091093
 */
public class ShoppingGUI {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // test db connection first
        DBManager   db  = new DBManager() ;
        Connection conn = db.getConnection() ;
        if( conn == null ){
            JOptionPane.showMessageDialog(null, "Cannot connect to the database. Please try again later.\n"
                    + "It might be due to you are arleady running this application.");
            System.exit(-1); 
        }
        db.closeConnections();
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
        IKeyManager keyman =  new dbKeyManager() ;
        OrderController oc = new OrderController(keyman) ;
        IController controller = new ShopController(oc) ;
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               HomeFrame hf = new HomeFrame( controller );
               controller.setHomeView(hf);
               oc.getOrder().addObserver(hf);
               hf.setLocation(200, 200);
               hf.setSize(800, 630);
               hf.setVisible(true);
            }
        });        
    }
    
}
