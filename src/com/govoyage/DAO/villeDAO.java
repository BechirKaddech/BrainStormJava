/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.DAO;


import com.govoyage.ENTITIES.ImageM;
import com.govoyage.ENTITIES.Post;
import com.govoyage.ENTITIES.ville;
import com.govoyage.IDAO.IvilleDAO;
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
 * @author sirine
 */
public class villeDAO implements IvilleDAO {
     private Connection cnx;

    public villeDAO() {
       cnx=MyConnection.getInstance();
    }
     
      

    @Override
    public boolean insertVille(ville v) {
    String query ="INSERT INTO ville (nom, pays,latitude, longitude, description, type, langue) "
                 + "VALUES (?,?,?,?,?,?,?)"; 
  
    
         try {
            PreparedStatement pSt = cnx.prepareStatement(query);
            pSt.setString(1,v.getNom());
            
            pSt.setString(2,v.getPays());
            pSt.setDouble(3,v.getLatitude());
            pSt.setDouble(4,v.getLongitude());
            pSt.setString(5,v.getDescription());
            pSt.setString(6,v.getType());
            pSt.setString(7,v.getLangue());

            
            pSt.executeUpdate();
            System.out.println("ville ajouté----");
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ville non ajouté!");
            return false;
        }   
     
    }

    @Override
    public void deleteVille(int id) {
        String requete = "DELETE FROM ville WHERE id=? ";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("ville supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }  
    }

    @Override
    public boolean updateVille(ville v) {

    String query = "UPDATE ville SET nom=? ,pays=? ,latitude=? ,longitude=? ,description=? ,type=? ,langue=?  WHERE id=? ";
        
         try {
            PreparedStatement pSt = cnx.prepareStatement(query);
            pSt.setString(1,v.getNom());
            
            pSt.setString(2,v.getPays());
            pSt.setDouble(3,v.getLatitude());
            pSt.setDouble(4,v.getLongitude());
            pSt.setString(5,v.getDescription());
            pSt.setString(6,v.getType());
            pSt.setString(7,v.getLangue());
            pSt.setDouble(8,v.getId()); 
            
            pSt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("echec de la modification!!!");
            return false;
        }        
    }

    @Override
    public ArrayList<ville> displayAllvilles() {
        ArrayList<ville> listeville = new ArrayList<>();

        String requete = "select * from ville";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                ville v = new ville();
              
            
                v.setId(resultat.getInt(1));
                 v.setImage_id(resultat.getInt(2));
               v.setNom(resultat.getString(3));
               v.setPays(resultat.getString(4));
                v.setLatitude(resultat.getInt(5));
                
                v.setLongitude(resultat.getInt(6));
               v.setDescription(resultat.getString(7));
                v.setType(resultat.getString(8));
               v.setLangue(resultat.getString(9));
               

                listeville.add(v);
        /*        
       for(circuit elem: listecircuit)
       {
       	 System.out.println (elem);
       }*/
            }
            return listeville;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de la liste  " + ex.getMessage());
            return null;
        }  
    
    
    }

    @Override
    public ville findvilleById(int idd) {

    ville v = new ville();
        String requete = "select * from ville where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, idd);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
            
                v.setId(resultat.getInt(1));
                v.setImage_id(resultat.getInt(2));
                v.setNom(resultat.getString(3));
                v.setPays(resultat.getString(4));
                v.setLatitude(resultat.getInt(5));
                
                v.setLongitude(resultat.getInt(6));
                v.setDescription(resultat.getString(7));
                v.setType(resultat.getString(8));
                v.setLangue(resultat.getString(9));
            }
            return v;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du ville " + ex.getMessage());
            return null;
        }
    
    
    }

    @Override
    public ville findvilleBynom(String n) {
        
            ville v = new ville();
        String requete = "select * from ville where nom=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, n);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                v.setId(resultat.getInt(1));
                v.setNom(resultat.getString(3));
                v.setPays(resultat.getString(4));
                v.setLatitude(resultat.getInt(5));
                
                v.setLongitude(resultat.getInt(6));
                v.setDescription(resultat.getString(7));
                v.setType(resultat.getString(8));
                v.setLangue(resultat.getString(9));
            }
            return v;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche " + ex.getMessage());
            return null;
        }
    }

    @Override
    public int countVilles() {
        String query = "select count(*) as nbrVilles from ville ;";
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

    @Override
    public int countPaysTunisie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countPays(String p) {
 {
        {
        String requete = "select count(*) from ville where pays=?";
        int count=0;
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, p);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                count = resultat.getInt(1);
            }
            return count;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des Users " + ex.getMessage());
            return 0;
        }  
    }
    

    
    
    
    }

 
    }

    @Override
    public int countLangue(String p)      {
 {
        {
        String requete = "select count(*) from ville where langue=?";
        int count=0;
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, p);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                count = resultat.getInt(1);
            }
            return count;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des Users " + ex.getMessage());
            return 0;
        }  
    }
    

    
    
    
    }

 
    }

    @Override
    public List<ville> AfficherVille() {
               List<ville> list = new ArrayList<>();
         String requete = "select * from ville";
         try {
             Statement statement = cnx.createStatement();
             ResultSet resultat = statement.executeQuery(requete);
             while (resultat.next()) {  
                 ville h = new ville();
                 h.setNom(resultat.getString(3));
                list.add(h);
             }} 
         catch (SQLException ex) {
             Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
         }

           return list; 
    }

    @Override
    public int returnid(String s) {
               List<ville> list = new ArrayList<>();
        int i=0;
         String requete = "select * from ville where nom=?";
         try {
             PreparedStatement statement = cnx.prepareStatement(requete);
             statement.setString(1, s);
             ResultSet resultat = statement.executeQuery();
             while (resultat.next()) {  
                 i = resultat.getInt(1);
             }} 
         catch (SQLException ex) {
             Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
         }

           return i; }

    @Override
    public ArrayList<ville> displayAllvilless() {

                ArrayList<ville> listeville = new ArrayList<>();

        String requete = "select * from ville";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                ville v = new ville();
                v.setId(resultat.getInt(1));
                v.setNom(resultat.getString(3));
                 listeville.add(v);


            }      
                
       for(ville elem: listeville)
       {
       	 System.out.println (elem);
       }
            
            return listeville;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de la liste des sejour " + ex.getMessage());
            return null;
        }  
    }

    @Override
    public ville findvilleByIdss(int id) {
        ville vi = new ville();
        String requete = "select * from ville where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                vi.setId(resultat.getInt(1));
                vi.setNom(resultat.getString(3));
                
            }
            return vi;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du sejour " + ex.getMessage());
            return null;
        }    
    }

    @Override
    public int findVilleImage(int id) {
        ville v= new ville();
            int c = 0;
        String requete = "select image_id from ville where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
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
           

    @Override
    public String SelectImage(Integer image_id){
        ville ville= new ville();
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

    @Override
    public void ajoutervilleimage(ImageM p, ville v) {
      
         
        String queryComment = "INSERT INTO ville (image_id,nom, pays,latitude, longitude, description, type, langue) values ((select id from image ORDER BY id DESC LIMIT 1),?,?,?,?,?,?,?)";
        
        try{
              PreparedStatement pSt = cnx.prepareStatement(queryComment); 
         pSt.setString(1,v.getNom());
            
            pSt.setString(2,v.getPays());
            pSt.setDouble(3,v.getLatitude());
            pSt.setDouble(4,v.getLongitude());
            pSt.setString(5,v.getDescription());
            pSt.setString(6,v.getType());
            pSt.setString(7,v.getLangue());
        
            pSt.executeUpdate();
     
        }catch (SQLException exception) {
            Logger.getLogger(PostDao.class.getName()).log(Level.SEVERE, null, exception);
        }  
    
    }


   


    }
    
 

    

