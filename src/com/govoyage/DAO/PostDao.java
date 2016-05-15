/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.DAO;

import com.govoyage.ENTITIES.Post;
import com.govoyage.ENTITIES.User;
import com.govoyage.IDAO.IPostDao;
import com.govoyage.UTIL.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.DateTimeAtCompleted;

/**
 *
 * @author user
 */
public class PostDao implements IPostDao {

    private Connection cnx;

    public PostDao() {
        cnx = MyConnection.getInstance();
    }

    @Override
    public void addPost(Post p) {
        String req = "insert into poste (Titre,Contenu,date_published,user) values (?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
   
            ps.setString(1, p.getTitre());
            ps.setString(2, p.getContenu());
          ps.setTimestamp(3, java.sql.Timestamp.from(java.time.Instant.now()));
ps.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setString(4, p.getUser());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Post> displayAllPosts() {
        ArrayList<Post> listePost = new ArrayList<Post>();

        String requete = "select * from poste";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Post h = new Post();
                h.setId(resultat.getInt(1));
                h.setImage_id(resultat.getInt(2));
                h.setV_id(resultat.getInt(3));
                h.setTitre(resultat.getString(4));
                h.setContenu(resultat.getString(5));
                h.setDate_published(resultat.getTimestamp(6));
                

                listePost.add(h);
            }
            return listePost;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des pays " + ex.getMessage());
            return null;
        }
    }
    
    
        public ArrayList<Post> displayAllPostsByTitle() {
        ArrayList<Post> listePost = new ArrayList<Post>();

        String requete = "select * from poste order by Titre ASC  ";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Post h = new Post();
                h.setId(resultat.getInt(1));
                h.setImage_id(resultat.getInt(2));
                h.setV_id(resultat.getInt(3));
                h.setTitre(resultat.getString(4));
                h.setContenu(resultat.getString(5));
                h.setDate_published(resultat.getTimestamp(6));
                

                listePost.add(h);
            }
            return listePost;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des pays " + ex.getMessage());
            return null;
        }
    }
 public ArrayList<Post> displayAllPostsByDate() {
        ArrayList<Post> listePost = new ArrayList<Post>();
      

        String requete = "select * from poste order by Date_published DESC  ";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
       

            while (resultat.next()) {
                Post h = new Post();
                h.setId(resultat.getInt(1));
                h.setImage_id(resultat.getInt(2));
                h.setV_id(resultat.getInt(3));
                h.setTitre(resultat.getString(4));
                h.setContenu(resultat.getString(5));
                h.setDate_published(resultat.getTimestamp(6));
                

                listePost.add(h);
            }
            return listePost;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des pays " + ex.getMessage());
            return null;
        }
    }


    
        public int findPostByid(String titre) {
        Post post= new Post();
            int c = 0;
        String requete = "select id from poste where titre=?";
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
        
        
        
        
        
                public int findPostImage(String titre) {
        Post post= new Post();
            int c = 0;
        String requete = "select image_id from poste where titre=?";
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
                
            public String SelectImage(Integer image_id) {
        Post post= new Post();
            String p = "";
        String requete = "select path from image where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, image_id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
          
                      p=  (resultat.getString(1));
              
            }
            return p;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return p;
        }
    }
            
                     public int findPostVideo(String titre) {
        Post post= new Post();
            int c = 0;
        String requete = "select v_id from poste where titre=?";
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
            
            
              public String SelectVideo(Integer v_id) {
        Post post= new Post();
            String p = "";
        String requete = "select path from video where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, v_id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
          
                      p=  (resultat.getString(1));
              
            }
            return p;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return p;
        }
    }
            
            
        
        
        
        
        
        
        
        
    
    
    
    
    public Post findPostByTitre(String titre) {
        Post h= new Post();
        String requete = "select * from poste where titre=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, titre);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                         h.setId(resultat.getInt(1));
                h.setImage_id(resultat.getInt(2));
                h.setV_id(resultat.getInt(3));
                h.setTitre(resultat.getString(4));
                h.setContenu(resultat.getString(5));
                h.setDate_published(resultat.getTimestamp(6));
                h.setUser(resultat.getString(7));
            }
            return h;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
    
        public void removePostById(int id) {
        String requete = "delete from poste where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Depot supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
        
         public String findPostUser(String titre) {
        Post post= new Post();
          String u="";
        String requete = "select user from poste where titre=?";
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
