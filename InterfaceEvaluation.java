/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entites.Evaluation;
import java.util.List;

/**
 *
 * @author Sirine
 */
public interface InterfaceEvaluation {
     public void ajouterEvaluation(Evaluation e);

    public void modifierEvaluation(int idEvaluation, Evaluation e);

    public void supprimerEvaluation(Evaluation e);

    public List<Evaluation> afficherEvaluation();

}
