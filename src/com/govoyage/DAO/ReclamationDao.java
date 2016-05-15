/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.DAO;

import com.govoyage.ENTITIES.Post;
import com.govoyage.ENTITIES.Reclamation;
import com.govoyage.UTIL.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ReclamationDao {
       private Connection cnx;

    public ReclamationDao() {
        cnx = MyConnection.getInstance();
    }
        public void addReclamation(Reclamation p) {
        String req = "insert into reclamation (Titre,Contenu,date_published,etat) values (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
   
            ps.setString(1, p.getTitre());
            ps.setString(2, p.getContenu());
          ps.setTimestamp(3, java.sql.Timestamp.from(java.time.Instant.now()));
ps.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
ps.setString(4, "Non Validé");
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
         public ArrayList<Reclamation> displayAllReclamation() {
        ArrayList<Reclamation> listeReclamation = new ArrayList<Reclamation>();

        String requete = "select * from reclamation";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Reclamation h = new Reclamation();
                h.setId(resultat.getInt(1));
                h.setTitre(resultat.getString(2));
                h.setContenu(resultat.getString(3));
                h.setDate_published(resultat.getTimestamp(4));
                h.setEtat(resultat.getString(5));

                listeReclamation.add(h);
            }
            return listeReclamation;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des pays " + ex.getMessage());
            return null;
        }
    }

         
            public Reclamation findReclamtionByTitre(String titre) {
        Reclamation h= new Reclamation();
        String requete = "select * from reclamation where Titre=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, titre);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                         h.setId(resultat.getInt(1));
              
                h.setTitre(resultat.getString(2));
                h.setContenu(resultat.getString(3));
                h.setDate_published(resultat.getTimestamp(4));
                h.setEtat(resultat.getString(5));
            }
            return h;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
            
             public int findReclamationByid(String titre) {
       
            int c = 0;
        String requete = "select id from reclamation where Titre=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, titre);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
          
                      c=  (resultat.getInt(1));
              
            }
            return c;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return 0;
        }
    }
             
               public void ValiderRec(int id) {
        String req = "UPDATE  reclamation SET etat=? where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
   
         
ps.setString(1, "Validé");
  ps.setInt(2, id);
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
               
                   public void removeReclamationId(int id) {
        String requete = "delete from reclamation  where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Reclamation supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
                      public void EnCoursRec(int id) {
        String req = "UPDATE  reclamation SET etat=? where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
   
         
ps.setString(1, "En cours");
  ps.setInt(2, id);
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
}
