/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.DAO;


import com.govoyage.ENTITIES.Abonne;
import com.govoyage.IDAO.AdminIDAO;
import com.govoyage.UTIL.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

/**
 *
 * @author Fadoua
 */
public class AdminDao implements AdminIDAO {
     Connection cnx ;

    public AdminDao() {
    cnx= MyConnection.getInstance();
    }
   
    
public Abonne findAbonneByID(int id) {
        String req = "SELECT * from admin WHERE id=" + id;
        Abonne a = null;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                a = new Abonne();
                a.setId(rs.getInt(1));
                a.setNom(rs.getString(2));
                a.setPrenom(rs.getString(3));
                a.setUsername(rs.getString(4));
                a.setPassword(rs.getString(5));
                a.setEmail(rs.getString(6));

            }

        } catch (SQLException ex) {
            System.err.println("erreur de recherche");
        }

        return a;

    }
 public Abonne findAbonneByEmail(String Email) {
        String req = "SELECT * from fos_user WHERE upper(email) = upper(?)";
        Abonne a = null;
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, Email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a = new Abonne();
                a.setId(rs.getInt(1));
                a.setNom(rs.getString(2));
                a.setPrenom(rs.getString(3));
                a.setUsername(rs.getString(4));
                a.setPassword(rs.getString(5));
                a.setEmail(rs.getString(6));
              
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return a;

    
}
}
