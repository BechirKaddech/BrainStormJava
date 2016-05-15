package com.govoyage.DAO;

import com.govoyage.ENTITIES.vol;
import com.govoyage.IDAO.IvilleDAO;
import com.govoyage.IDAO.IvolDAO;
import com.govoyage.UTIL.MyConnection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ashref
 */
public class volDAO implements IvolDAO {

    private Connection cnx;

    public volDAO() {
        cnx = MyConnection.getInstance();
    }

    @Override
    public boolean insertvol(vol vl) {
        String query = "INSERT INTO vol(nomCompagnie,dateDepart,dateArrivee, nomAeroport, note, nvote, prixVol, villeDepart_id, villeArrivee_id) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pSt = cnx.prepareStatement(query);
            pSt.setString(1, vl.getNomCompagnie());

            pSt.setInt(8, vl.getVilleDepart().getId());
            pSt.setInt(9, vl.getVilleArrivee().getId());
            pSt.setDate(2, (Date) vl.getDateDepart());
            pSt.setDate(3, (Date) vl.getDateArrivee());

            pSt.setString(4, vl.getNomAeroport());
            pSt.setFloat(5, vl.getNote());
            pSt.setFloat(6, vl.getNvote());
            pSt.setFloat(7, vl.getPrixVol());
            pSt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println("vol non ajouté!");
            return false;
        }

    }

    //modifier circuit
    @Override
    public boolean updatevol(vol vl) {
        String query = "UPDATE vol SET nomCompagnie=?   ,dateDepart=? ,dateArrivee=? ,nomAeroport=? ,note=? ,nvote=? ,prixVol=? ,villeDepart_id=? ,villeArrivee_id=?  WHERE id=? ";

        try {
            PreparedStatement pSt = cnx.prepareStatement(query);
            pSt.setString(1, vl.getNomCompagnie());

            
           
            pSt.setDate(2, (Date) vl.getDateDepart());
            pSt.setDate(3, (Date) vl.getDateArrivee());
           // pSt.setString(4, vl.getDateDepart());
            // pSt.setString(5, vl.getDateArrivee());
            pSt.setString(4, vl.getNomAeroport());
          
            pSt.setFloat(5, vl.getNote());
            pSt.setFloat(6, vl.getNvote());
            pSt.setFloat(7, vl.getPrixVol());
            pSt.setInt(8, vl.getVilleDepart().getId());
             pSt.setInt(9, vl.getVilleArrivee().getId());
               pSt.setInt(10, vl.getId());
            pSt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println("vol non modifié!");
            return false;
        }
    }

    @Override
    public void deletevol(int id) {
        String requete = "DELETE FROM vol WHERE id=? ";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("vol supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public ArrayList<vol> displayAllvol() {
        ArrayList<vol> listevol = new ArrayList<>();

        String requete = "select * from vol";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IvilleDAO villedao = new villeDAO();

            while (resultat.next()) {
                vol vl = new vol();
                vl.setId(resultat.getInt(1));
                vl.setNomCompagnie(resultat.getString(2));
                vl.setDateDepart(resultat.getDate(3));
                vl.setDateArrivee(resultat.getDate(4));
                vl.setVilleDepart(villedao.findvilleById(resultat.getInt(8)));
                vl.setVilleArrivee(villedao.findvilleById(resultat.getInt(9)));
   
                vl.setPrixVol( resultat.getFloat(7));
              

                listevol.add(vl);

                for (vol elem : listevol) {
                    System.out.println(elem);
                }
            }
            return listevol;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de la liste des sejour " + ex.getMessage());
            return null;
        }
    }

    @Override
    public vol findvolById(int id) {
        vol vl = new vol();
        String requete = "select * from vol where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);

            ResultSet resultat = ps.executeQuery();
            IvilleDAO villedao = new villeDAO();
            while (resultat.next()) {
                vl.setId(resultat.getInt(1));
                vl.setNomCompagnie(resultat.getString(2));
                vl.setVilleDepart(villedao.findvilleById(resultat.getInt(9)));

                vl.setVilleArrivee(villedao.findvilleById(resultat.getInt(10)));
                vl.setDateDepart(resultat.getDate(3));
                vl.setDateArrivee(resultat.getDate(4));
                vl.setNomAeroport(resultat.getString(5));
            }
            return vl;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du vol " + ex.getMessage());
            return null;
        }
    }

    @Override
    public vol findvolByvilledep(String villeDepart) {
        vol vl = new vol();
        String requete = "select * from vol where villeDepart_id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, villeDepart);
            ResultSet resultat = ps.executeQuery();
            IvilleDAO villedao = new villeDAO();
            while (resultat.next()) {
                vl.setNomCompagnie(resultat.getString(2));
                vl.setVilleDepart(villedao.findvilleById(resultat.getInt(3)));
                vl.setVilleArrivee(villedao.findvilleById(resultat.getInt(4)));

                vl.setDateDepart(resultat.getDate(5));
                vl.setDateArrivee(resultat.getDate(6));
                vl.setNomAeroport(resultat.getString(7));
            }
            return vl;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du vol " + ex.getMessage());
            return null;
        }
    }




    @Override
    public int count() {
        String query = "select count(*) as nbrVilles from vol ;";
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
