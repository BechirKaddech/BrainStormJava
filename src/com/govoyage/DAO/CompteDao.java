/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.DAO;


import com.govoyage.ENTITIES.Compte;
import com.govoyage.IDAO.CompteIDAO;
import com.govoyage.UTIL.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fadoua
 */
public class CompteDao implements CompteIDAO {
    
      Connection cnx;

    public CompteDao() {
        cnx = MyConnection.getInstance();

    }
      @Override
    public Compte veriflogin(String username, String password) {
        Compte role=null;
        String requete = "select * from fos_user where username=? And password=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
             ResultSet rs = ps.executeQuery();
            ps.setString(1, username);
            ps.setString(2, password);
            while (rs.next()) {
                role.setNom(rs.getString("nom"));
                role.setPrenom(rs.getString("prenom"));
                role.setUsername(rs.getString("username"));
                role.setPassword(rs.getString("password"));
                
            }
            return role ;
           
        } catch (SQLException ex) {
            System.out.println("erreur " + ex.getMessage());
          return null;
        
            
}
         
}

    @Override
    public String veriflogin2(String username, String password) {
         String role="";
        String requete = "select roles from fos_user where username=? And password=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                role=resultat.getString(1);
                
            }
            return role ;
           
        } catch (SQLException ex) {
            System.out.println("erreur " + ex.getMessage());
          return null;
        }
    }

    @Override
    public Compte getCompte(String username, String password) {
        Compte f = new Compte();
        
     String requete = "select * from fos_user where username=? And password=?";
     try {
     PreparedStatement st = cnx.prepareStatement(requete);
     st.setString(1, username);
     st.setString(2, password);
     ResultSet rs = st.executeQuery();
     while (rs.next()) {   
     f.setId(rs.getInt(1));
     f.setEmail(rs.getString(4));
     f.setNom(rs.getString(18));
     f.setPrenom(rs.getString(19));
     f.setUsername(rs.getString(2));
     f.setPassword(rs.getString(8));
         return f;       
     }
     }  catch (SQLException ex) {
            System.out.println("erreur " + ex.getMessage());
          return null;
        }
     return f;
    }

    @Override
    public void modifierCompte(Compte c, int id) {
         String req= "update fos_user set nom=?,prenom=?,username=?,password=?,email=? where id="+ id;
         
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            
            st.setString(1, c.getNom());
            st.setString(2, c.getPrenom());
            st.setString(3, c.getUsername());
            st.setString(5, c.getEmail());
            st.setString(4, c.getPassword());
            
           
            
            st.executeUpdate();
            System.out.println("Modification GOOD");
        } catch (SQLException ex) {
            System.out.println("Erreur Modification");
        }
    }

    @Override
    public void supprimerCompte(int id) {
        String req = "DELETE FROM fos_user WHERE id=" + id;

        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Suppression effectuée");
        } catch (SQLException ex) {
            System.err.println("Erreur de la Suppression");
        }
    }

  
}