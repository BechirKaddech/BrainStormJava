/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.DAO;


import com.govoyage.ENTITIES.Hotel;
import com.govoyage.IDAO.HotelIDAO;
import com.govoyage.UTIL.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fadoua
 */
public class HotelDAO implements HotelIDAO  {
     Connection cnx;
     
     public HotelDAO () {
    
    cnx=MyConnection.getInstance();
    
    
}

    @Override
    public void AjouterHotel(Hotel h) {
         String query ="INSERT INTO hotel (nomHotel , Description ,Categorie,Disponibilite,latitude,longitude ,Ville_id) VALUES (?,?,?,?,?,?,?)";
         try {
             PreparedStatement pSt = cnx.prepareStatement(query);
            pSt.setString(1, h.getNomHotel());
            pSt.setString(2, h.getDescription());
            pSt.setString(3, h.getCategorie());
            pSt.setString(4, h.getDisponibilite());
            pSt.setDouble(5, h.getLatitude());
            pSt.setDouble(6, h.getLongitude());
            pSt.setInt(7, h.getVille_id());
             pSt.executeUpdate();
            
            
         } catch (SQLException ex) {
              System.out.println("problème d'ajout"+ex);
         }
    }

    @Override
    public boolean ModifierHotel(Hotel h) {
         String query = "UPDATE hotel SET nomHotel=? , Description=? , Categorie=? , Disponibilite=? where id=?";
         try {
            PreparedStatement pSt = cnx.prepareStatement(query);
            pSt.setString(1, h.getNomHotel());
            pSt.setString(2, h.getDescription());
            pSt.setString(3, h.getCategorie());
            pSt.setString(4, h.getDisponibilite());
            pSt.setInt(5, h.getId());
            pSt.executeUpdate();
            
            return true;
         } catch (SQLException ex) {
            System.out.println("pas de modification ");
             return false;
         }

    }

    @Override
    public void SupprimerHotel(int id) {
         String requete = "DELETE FROM hotel WHERE id=?";
         try {
             PreparedStatement ps = cnx.prepareStatement(requete);
              ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Hotel supprimé");
         } catch (SQLException ex) {
            System.out.println("Hotel non supprimé");
         }
           
    }

    @Override
    public Hotel ChercherHotel(int id) {
        Hotel h = new Hotel();
        String requete = "select * from hotel where id=?";
         try {
             PreparedStatement ps = cnx.prepareStatement(requete);
              ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            return h;
         } catch (SQLException ex) {
             System.out.println("erreur l'hotel est introuvable " + ex.getMessage());
            return null;
         }


        
    }

    @Override
    public List<Hotel> AfficherHotel() {
        List<Hotel> list = new ArrayList<>();
         String requete = "select * from hotel";
         try {
             Statement statement = cnx.createStatement();
             ResultSet resultat = statement.executeQuery(requete);
             while (resultat.next()) {  
                 Hotel h = new Hotel();
                 h.setNomHotel(resultat.getString("nomHotel"));
                 h.setDescription(resultat.getString("Description"));
                 h.setCategorie(resultat.getString("Categorie"));
                 h.setDisponibilite(resultat.getString("Disponibilite"));
                 h.setId(resultat.getInt("id"));
                list.add(h);
             }} 
         catch (SQLException ex) {
             Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
         }

           return list;
    }

    @Override
    public List<Hotel> ChercherHotel2(String nom) {
        List<Hotel> list = new ArrayList<>();
         String requete = "select * from hotel where upper(nomHotel) like upper('%"+nom+"%')";
         try {
             PreparedStatement ps = cnx.prepareStatement(requete);
             //ps.setString(1, nom);
             ResultSet resultat = ps.executeQuery();
             while (resultat.next()) {  
                 Hotel h = new Hotel();
                 h.setNomHotel(resultat.getString("nomHotel"));
                 h.setDescription(resultat.getString("Description"));
                 h.setCategorie(resultat.getString("Categorie"));
                 h.setDisponibilite(resultat.getString("Disponibilite"));
                 h.setId(resultat.getInt("id"));
                list.add(h);
             }} 
         catch (SQLException ex) {
             Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
         }

           return list;
    }

    @Override
    public ArrayList<Hotel> displayAllhotel() {
  
               ArrayList<Hotel> listehotel = new ArrayList<>();

        String requete = "select * from hotel";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Hotel ho = new Hotel();
                ho.setId(resultat.getInt(1));
                ho.setNomHotel(resultat.getString(2));
                 listehotel.add(ho);


            }      
                
       for(Hotel elem: listehotel)
       {
       	 System.out.println (elem);
       }
            
            return listehotel;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de la liste des sejour " + ex.getMessage());
            return null;
        }  
    }

    @Override
    public Hotel findhotelById(int id) {
      
        Hotel ho = new Hotel();
        String requete = "select * from hotel where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                ho.setId(resultat.getInt(1));
                ho.setNomHotel(resultat.getString(2));
                ho.setDescription(resultat.getString(3));
                ho.setCategorie(resultat.getString(4));
                ho.setDisponibilite(resultat.getString(5));
                
            }
            return ho;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du sejour " + ex.getMessage());
            return null;
        }    
    }

    @Override
    public int count(){
        String query = "select count(*) as nbrVilles from hotel ;";
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
