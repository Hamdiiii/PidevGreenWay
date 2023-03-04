/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entites.Materiaux;
import java.util.List;
import java.sql.*;
import outils.My_connection;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Sirine
 */
public class MateriauxService {

    Connection x = My_connection.getInstance().getCnx();

    public int ajouterMateriaux(Materiaux m) {
        int id = -1;
        try {
            String req1 = " INSERT INTO `materiaux`(`type`, `taux_recyclage`, `duree_vie`, `condition_utilisation`) VALUES ('" + m.getType() + "','" + m.getTaux_recyclage() + "','" + m.getDuree_vie() + "','" + m.getCondition_utilisation() + "')";
            Statement st = x.createStatement();
            id = st.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public double[] calculerPoidsRecycleEtNonRecycle(String typeDechet, int poids) {
        double[] poidsRecycleEtNonRecycle = new double[2];

        // Calcul du taux de recyclage
        double tauxRecyclage = TauxRecyclage(typeDechet);

        // Calcul du poids recyclé et du poids non recyclé
        double poidsRecycle = poids * tauxRecyclage;
        double poidsNonRecycle = poids * (1 - tauxRecyclage);

        poidsRecycleEtNonRecycle[0] = poidsRecycle;
        poidsRecycleEtNonRecycle[1] = poidsNonRecycle;

        return poidsRecycleEtNonRecycle;
    }

    public int calculerDureeVieRestante(Materiaux materiaux, LocalDate dateAjout) {
        // Calculer la durée de vie restante en fonction de la date d'ajout et de la durée de vie prévue
        LocalDate dateExpiration = dateAjout.plusDays(Integer.parseInt(materiaux.getDuree_vie()));
        long joursRestants = ChronoUnit.DAYS.between(LocalDate.now(), dateExpiration);

        // Retourner le nombre de jours restants avant expiration
        return (int) joursRestants;
    }

    public double TauxRecyclage(String type) {
        double taux = 0.0;
        if (type.equals("Plastique")) {
            taux = 0.9;
        } else if (type.equals("Verre")) {
            taux = 0.8;
        } else if (type.equals("Métal")) {
            taux = 0.7;
        } else if (type.equals("coton")) {
            taux = 0.3;
        }
        return taux;
    }

    public void modifierMateriaux(int idMateriaux, Materiaux m) throws SQLException {
        String update = "UPDATE `materiaux` set type =?, taux_recyclage=? ,duree_vie=?, condition_utilisation=? where idMateriaux = ?";

        try {
            PreparedStatement st = x.prepareStatement(update);
            st.setString(1, m.getType());
            st.setString(2, m.getTaux_recyclage());
            st.setString(3, m.getDuree_vie());
            st.setString(4, m.getCondition_utilisation());
            st.setInt(5, idMateriaux);
            st.executeUpdate();
            System.out.println("client modifie avec succée!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public boolean supprimerMateriaux(Materiaux m) {
        try {
            String req = " DELETE FROM materiaux WHERE type =? AND taux_recyclage=? AND duree_vie=? AND condition_utilisation=? ";
            PreparedStatement st = x.prepareStatement(req);
            st.setString(1, m.getType());
            st.setString(2, m.getTaux_recyclage());
            st.setString(3, m.getDuree_vie());
            st.setString(4, m.getCondition_utilisation());
            st.executeUpdate();
            System.out.println("La supression du Materiaux est effectuée");
            return true;
        } catch (SQLException ex) {
            System.out.println("Echec de supression");
        }
        return false;
    }

    public List<Materiaux> afficherMateriaux() throws SQLException {
        List<Materiaux> list = new ArrayList<>();

        String req = "Select * from Materiaux";
        PreparedStatement ps = x.prepareStatement(req);
        ResultSet rst = ps.executeQuery();
        while (rst.next()) {
            Materiaux m1 = new Materiaux();
            m1.setType(rst.getString("Type"));
            m1.setTaux_recyclage(rst.getString("Taux_recyclage"));
            m1.setDuree_vie(rst.getString("Duree_vie"));
            m1.setCondition_utilisation(rst.getString("Condition_utilisation"));
//            m1.setDateCreation(rst.get("dateCreation"));
//            m1.setIdClient(rst.getInt("idClient"));
            list.add(m1);
        }
        return list;
    }
}
