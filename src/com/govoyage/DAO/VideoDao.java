/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.DAO;

import com.govoyage.ENTITIES.VideoM;
import com.govoyage.IDAO.IvideoDao;
import com.govoyage.UTIL.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class VideoDao implements IvideoDao{
       private Connection cnx;

    public VideoDao() {
        cnx = MyConnection.getInstance();
    }


    public void addVideo(VideoM p) {
        String req = "insert into video (updated_at,name,path) values (?,?,?)";
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
    
      public void removeVideoById(int id_v) {
        String requete = "delete from video where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id_v);
            ps.executeUpdate();
            System.out.println("Video supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    
    
}
