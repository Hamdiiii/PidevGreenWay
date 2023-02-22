/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Base.MyConnection;
import Entite.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rayen
 */
public class UserService implements InterfaceUser{

      Connection cnx;

    public UserService() {
        cnx = MyConnection.getInstance().getCnx();
    }

    
      @Override
    public int ajouterUser(User p) {
         try {
            String sql = "insert into personne(email,motdepasse,nom,prenom,telephone,adresse,id_fournisseur ,id_personne,id_livreur, id_admin,id_client)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, p.getEmail());
            ste.setString(2, p.getMotdepasse());
            ste.setString(3, p.getNom());
            ste.setString(4, p.getPrenom());
            ste.setString(5, p.getTelephone());
            ste.setString(6, p.getAdresse());
            ste.setInt(7, p.getId_fournisser());
            ste.setInt(8, p.getId_personne());
            ste.setInt(9, p.getId_livreur());
            ste.setInt(10, p.getId_admin());
            ste.setInt(11, p.getId_client());
            ste.executeUpdate();
            System.out.println("user ajoute");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          return 0;
    }

      @Override
    public boolean modifierUser(String nom,User p) {
        String sql = "update  set personne email=?,motdepasse=?,nom=?,Prenom=?,telephone=?,adresse=?,id_fournisser=?,id_personne=?,id_livreur=?,id_admin=?,id_client=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, p.getEmail());
            ste.setString(2, p.getMotdepasse());
            ste.setString(3, p.getNom());
            ste.setString(4, p.getPrenom());
            ste.setString(5, p.getTelephone());
            ste.setString(6, p.getAdresse());
            ste.setInt(7, p.getId_fournisser());
            ste.setInt(8, p.getId_personne());
            ste.setInt(9, p.getId_livreur());
            ste.setInt(10, p.getId_admin());
            ste.setInt(11, p.getId_client());
            System.out.println("success");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          return false;
    
    }
 
         @Override
          public boolean supprimerUser(User p) {
         String sql = "delete from personne  where id_personne=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, p.getId_personne());
            ste.executeUpdate();
            System.out.println("supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return true;
        }   
          return false;
          
          }
         
              
            



      @Override
      public List<User> afficherUser() {

 List<User> User = new ArrayList<>();
        try {
            String sql = "select email,motdepasse,nom,prenom,telephone,adresse,id_fournisseur ,id_personne,id_livreur, id_admin,id_client from personne";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

                User p = new User(s.getString(1),s.getString(2),s.getString(3),s.getString(4),s.getString(5),s.getString(6),s.getInt(7),s.getInt(8),s.getInt(9),s.getInt(10),s.getInt(11));
                User.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return User;
    }
    
}
   
