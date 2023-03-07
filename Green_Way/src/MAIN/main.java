/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;

import Entites.Client;
import Entites.Evaluation;
import Services.ClientService;
import Services.EvaluationService;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Sirine
 */
public class main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws SQLException {
        java.sql.Date date = java.sql.Date.valueOf("2021-06-09");
        java.sql.Date date1 = java.sql.Date.valueOf("2024-07-02");

//CLIENT
        ClientService cl = new ClientService();
        Client c = new Client(date);
        Client c2 = new Client(date1);
        // cl.modifierClient(11,c);
        cl.ajouterClient(c2);
        //cl.supprimerClient(11);
        // System.out.println(cl.afficherClient());
        
//EVALUATION        
        EvaluationService ev = new EvaluationService();
        Evaluation e = new Evaluation("lll", 10);
        Evaluation e2 = new Evaluation("mmm", 10);
       // ev.ajouterEvaluation(e);
       // ev.modifierEvaluation(3,e);
        //ev.supprimerEvaluation(7);
     System.out.println( ev.afficherEvaluation());
        System.out.println("***");

    }

}
