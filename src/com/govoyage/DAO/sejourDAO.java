/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.DAO;



import com.govoyage.ENTITIES.sejour;
import com.govoyage.IDAO.IsejourDAO;
import com.govoyage.UTIL.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Saidi
 */
public class sejourDAO implements IsejourDAO{
     private Connection cnx;

    public sejourDAO() {
        cnx=MyConnection.getInstance();
    }
     

 public void add(sejour p) {
        String req = "insert into sejour (dateDepart,dateArrive,prix,Hotel_id,Ville_id) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
   
            ps.setDate(1, (Date) p.getDateDepart());
            ps.setDate(2, (Date) p.getDateArrive());
            ps.setDouble(3, p.getPrix());
            ps.setInt(4,p.getHotel().getId());
            ps.setInt(5, p.getVille().getId());
           
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(sejourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

 
    public boolean updateSejour(sejour se) {
        String query = "UPDATE sejour SET  dateDepart=? ,dateArrive=? , prix=?,Hotel_id=?,Ville_id=? WHERE id=?";
        
         try {
            PreparedStatement pSt = cnx.prepareStatement(query);
            pSt.setDate(1, (Date) se.getDateDepart());
            pSt.setDate(2, (Date) se.getDateArrive());
            pSt.setDouble(3, se.getPrix());
            pSt.setInt(4, se.getHotel().getId());
            pSt.setInt(5, se.getVille().getId());
            pSt.setInt(6, se.getId());
           

             System.out.println("ùùùùùù");
         
           
            
            pSt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("echec de la modification!!!");
            return false;
        }        
    
    }
//
//    @Override
//    public void deleteSejour(int id) {
//         String requete = "DELETE FROM sejour WHERE id=? ";
//        try {
//            PreparedStatement ps = cnx.prepareStatement(requete);
//            ps.setInt(1, id);
//            ps.executeUpdate();
//            System.out.println("Sejour supprimée");
//        } catch (SQLException ex) {
//            System.out.println("erreur lors de la suppression " + ex.getMessage());
//        }        
//     
//    }
//
  
    public ArrayList<sejour> displayAllsejour() {
        ArrayList<sejour> listesejour = new ArrayList<>();

        String requete = "select * from sejour";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                sejour se = new sejour();
                se.setId(resultat.getInt(1));
                se.setDateDepart(resultat.getDate(2));
                se.setDateArrive(resultat.getDate(3));
                se.setPrix(resultat.getDouble(4));
                HotelDAO hotelDAO =new HotelDAO();
                se.setHotel(hotelDAO.findhotelById(resultat.getInt(5)));
                villeDAO villeDAO= new villeDAO();

                se.setVille(villeDAO.findvilleById(resultat.getInt(6)));
               
                

                listesejour.add(se);
                
       for(sejour elem: listesejour)
       {
       	 System.out.println (elem);
       }
            }
            return listesejour;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de la liste des sejour " + ex.getMessage());
            return null;
        }        
    
    }

//    @Override
    public sejour findsejourById(int id) {
        sejour se = new sejour();
        String requete = "select * from sejour where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                se.setDateDepart(resultat.getDate(2));
                se.setDateArrive(resultat.getDate(3));
                se.setPrix(resultat.getDouble(4));
                HotelDAO hotelDAO =new HotelDAO();
                se.setHotel(hotelDAO.findhotelById(resultat.getInt(5)));
                villeDAO VilleDAO= new villeDAO();
                se.setVille(VilleDAO.findvilleById(resultat.getInt(6)));
                
            }
            return se;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du sejour " + ex.getMessage());
            return null;
        }
    }
//
    public sejour findsejourBynom(Date dateDepart ) {
         sejour se = new sejour();
        String requete = "select * from sejour where dateDepart=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setDate(2, dateDepart);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                se.setDateDepart(resultat.getDate(2));
                se.setDateArrive(resultat.getDate(3));
                 se.setPrix(resultat.getDouble(4));
               
            }
            return se;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du sejour " + ex.getMessage());
            return null;
        }
    }
//    
//     public sejour findPostByTitre(String titre) {
//        sejour post= new sejour();
//        String requete = "select * from sejour where nomVille=?";
//        try {
//            PreparedStatement ps = cnx.prepareStatement(requete);
//            ps.setString(1, titre);
//            ResultSet resultat = ps.executeQuery();
//            while (resultat.next()) {
//                post.setId(resultat.getInt(1));
//                post.setNomVille(resultat.getString(2));
//                 post.setNomHotel(resultat.getString(3));
//                 post.setPrix(resultat.getDouble(4));
//            }
//            return post;
//
//        } catch (SQLException ex) {
//            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
//            return null;
//        }
//    }
//     
      public void deleteSejour(int id) {
        String requete = "delete from sejour where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Sejour supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
        
    }

    @Override
    public int count() {
        String query = "select count(*) as nbrVilles from sejour ;";
        int nombre = 0;
        try{
            PreparedStatement prep = cnx.prepareStatement(query);
            ResultSet result = prep.executeQuery();
            while(result.next())
            {
                nombre = result.getInt("nbrVilles");
            }
        } catch (SQLException ex) {
            return nombre;
        }
        return nombre;
    }


    
}
