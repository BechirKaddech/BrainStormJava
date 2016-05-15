/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.DAO;

import com.govoyage.UTIL.MyConnection;
import com.govoyage.ENTITIES.ImageM;
import com.govoyage.ENTITIES.Post;
import com.govoyage.IDAO.IimageDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ImageDao implements IimageDao{
       private Connection cnx;

    public ImageDao() {
        cnx = MyConnection.getInstance();
    }


    public void addImage(ImageM p) {
        String req = "insert into image (updated_at,name,path) values (?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
             ps.setTimestamp(1, java.sql.Timestamp.from(java.time.Instant.now()));
ps.setTimestamp(1, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            ps.setString(2, p.getName());
            ps.setString(3, p.getPath());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void ajouterMedia2(ImageM p, Post C) {
   

               // Ajout Commentaire
     
        String queryComment = "insert into poste (Titre,Contenu, image_id,v_id,date_published,user) values (?,?,(select id from image ORDER BY id DESC LIMIT 1),(select id from video ORDER BY id DESC LIMIT 1),?,?)";
        
        try{
              PreparedStatement ps2 = cnx.prepareStatement(queryComment);
            ps2.setString(1, C.getTitre());
               ps2.setString(2, C.getContenu());
                     ps2.setTimestamp(3, java.sql.Timestamp.from(java.time.Instant.now()));
ps2.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
ps2.setString(4, C.getUser());
        
            ps2.executeUpdate();
     
        }catch (SQLException exception) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, exception);
        }   
  
    }
     
          public void removeImageById(int id) {
        String requete = "delete from image where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Image supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    
}
