/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Sirine
 */
import Entites.Materiaux;
import Services.MateriauxService;
import entites.Evaluation;
import services.EvaluationService;
import java.sql.SQLException;

public class main {

    /**
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        MateriauxService m1 = new MateriauxService();
        Materiaux m = new Materiaux("zaz", "3", "mm", "poo");
        Materiaux m2 = new Materiaux("doop", "6", "mm", "poo");
        Materiaux m3 = new Materiaux("sirine", "89", "mm", "poo");

        //Client c2 = new Client(date1);
        //m1.modifierMateriaux(1,m);
       // m1.ajouterMateriaux(m3);
//        m1.ajouterMateriaux(m2);

       // m1.supprimerMateriaux(m3);
       // System.out.println(m1.afficherMateriaux());
       Materiaux m9 = new Materiaux();
    m9.setType("Plastique");
    m9.setTaux_recyclage("50%");
    m9.setDuree_vie("365");
    m9.setCondition_utilisation("Usage unique");
    m1.ajouterMateriaux(m9);
    
    
//EVALUATION        
        EvaluationService ev = new EvaluationService();
        Evaluation e = new Evaluation("lll", 10,3);
        Evaluation e2 = new Evaluation("mmm", 10,3);
       // ev.ajouterEvaluation(e);
       // ev.modifierEvaluation(3,e);
        //ev.supprimerEvaluation(7);
     System.out.println( ev.afficherEvaluation());
        System.out.println("***");
    }
}
