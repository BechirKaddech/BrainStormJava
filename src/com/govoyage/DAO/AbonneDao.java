/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.DAO;


import com.govoyage.ENTITIES.Abonne;
import com.govoyage.IDAO.AbonneIDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.govoyage.UTIL.MyConnection;
import java.sql.Connection;

/**
 *
 * @author Fadoua
 */
public class AbonneDao implements AbonneIDAO {
     Connection cnx;
    public AbonneDao(){
        
    cnx = MyConnection.getInstance();
}
    public void insertAbonne(Abonne c) {
        String req = "INSERT INTO fos_user (username,nom,prenom,email,password,enabled,username_canonical, email_canonical,salt, locked, expired, roles, credentials_expired,etat )VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            
            st.setString(1, c.getUsername());
            st.setString(2, c.getNom());
            st.setString(3, c.getPrenom());
            st.setString(4, c.getEmail());
            st.setString(5, c.getPassword());
            st.setInt(6,1);
            st.setString(7, "gfff");
            st.setString(8, "gf");
            st.setString(9, "gff");
            st.setInt(10,0);
            st.setInt(11,0);
            st.setString(12, "a:1:{i:0;s:11:\"ROLE_ABONNE\";"); 
            st.setInt(13,0);
            st.setString(14, "valide");
   
            st.executeUpdate();
            System.out.println("Ajout Effectuée");
        } catch (SQLException ex) {
            System.err.println("Erreur d'Ajout"+ex);
        }
    }

      public void deleteAbonne(Abonne c) {
        String req = "DELETE FROM fos_user WHERE id=" + c.getId();

        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Suppression effectuée");
        } catch (SQLException ex) {
            System.err.println("Erreur de la Suppression");
        }

    }
    public List<Abonne> AfficherAbonne(int id) {
        List<Abonne> maListe = new ArrayList<>();
        String req = "SELECT * FROM fos_user where id="+id;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Abonne c = new Abonne();

                c.setId(rs.getInt(1));
                c.setNom(rs.getString(2));
                c.setPrenom(rs.getString(3));
                c.setPassword(rs.getString(5));
                c.setEmail(rs.getString(6));
                //c.setUrl(rs.getString(8));
                c.setEtat(rs.getString(9));
                maListe.add(c);
            }
            return maListe;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Abonne> displayAllAbonne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void modifierAbonne(Abonne a,int id){
            
         String req= "update fos_user set nom=?,prenom=?,username=?,password=?,email=? where id="+ id;
         
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            
            st.setString(1, a.getNom());
            st.setString(2, a.getPrenom());
            st.setString(3, a.getUsername());
            st.setString(5, a.getEmail());
            st.setString(4, a.getPassword());
            
           
            
            st.executeUpdate();
            System.out.println("Modification GOOD");
        } catch (SQLException ex) {
            System.out.println("Erreur Modification");
        }
         
         
     }
    public Abonne getAbonneEnCours(String username, String password) {
        
     Abonne Abonne = new Abonne();
        
     String requete = "select * from fos_user where username=? And password=?";
     try {
     Statement st = cnx.createStatement();
     ResultSet rs = st.executeQuery(requete);
     while (rs.next()) {   
     Abonne f = new Abonne();
     f.setId(Integer.parseInt(rs.getString("id")));
     f.setEmail(rs.getString("email"));
     f.setNom(rs.getString("nom"));
     f.setPrenom(rs.getString("prenom"));
     f.setUsername(rs.getString("username"));
     f.setPassword(rs.getString("password"));
                
     }
     } catch (Exception e) {
     }
     return Abonne;
     }
    
    

       
         
     
    
}
