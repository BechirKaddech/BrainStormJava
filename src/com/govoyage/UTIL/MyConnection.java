
package com.govoyage.UTIL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyConnection {
    
    private static Connection cnx;
    private String url="jdbc:mysql://localhost:3306/versionfinale";
    private String user="root";
    private String pwd="";
    
    private MyConnection() {
        try {
            cnx=DriverManager.getConnection(url, user, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur"+ex.getMessage());
        }
    }
    
   public static Connection getInstance()
   {if (cnx==null) new MyConnection();
   return cnx;
   }
  
    
}
