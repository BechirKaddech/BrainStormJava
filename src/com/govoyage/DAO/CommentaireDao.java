/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.DAO;

import com.govoyage.ENTITIES.Commentaire;
import com.govoyage.ENTITIES.Post;
import com.govoyage.IDAO.ICommentDao;
import com.govoyage.UTIL.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author user
 */
public class CommentaireDao implements ICommentDao{
        private Connection cnx;

    public CommentaireDao() {
        cnx = MyConnection.getInstance();
    }
      public ArrayList<Commentaire> findPostById(Integer Poste_id) {
        
         ArrayList<Commentaire> listeCommentaire = new ArrayList<Commentaire>();
        String requete = "select * from commentaire where Poste_id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, Poste_id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Commentaire commentaire= new Commentaire();
                commentaire.setId(resultat.getInt(1));
              
                 commentaire.setBody(resultat.getString(2));
              
                       commentaire.setDate_p(resultat.getTimestamp(3));
                           commentaire.setPoste_id(resultat.getInt(4));
                               commentaire.setUser(resultat.getString(5));
                 listeCommentaire.add(commentaire);
            }
            return listeCommentaire;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
       public void addPost(Commentaire p) {
        String req = "insert into commentaire (Body,date_p,poste_id,user) values (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
       ps.setString(1, p.getBody());
                 ps.setTimestamp(2, java.sql.Timestamp.from(java.time.Instant.now()));
ps.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setInt(3, p.getPoste_id());
            ps.setString(4, p.getUser());
        
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
               public void removeCommentById(int id) {
        String requete = "delete from commentaire where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Commentaire supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
                   public void updateDepot(Commentaire depot,int id) {
        String requete = "update commentaire set Body=? where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, depot.getBody());
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
                   
                      public int findCommentByid(String Body) {
      
            int c = 0;
        String requete = "select id from commentaire where Body=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1,Body );
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
                      
         public String findCommentUser(String titre) {
        Post post= new Post();
          String u="";
        String requete = "select user from commentaire where Body=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, titre);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
          
                      u=  (resultat.getString(1));
              
            }
            return u;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return u;
        }
    }
    
    
}
