/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Materiaux;
import java.util.List;

/**
 *
 * @author Sirine
 */
public interface InterfaceMateriaux {
    public int ajouterMateriaux(Materiaux m);
    public void modifierClient(int idMateriaux, Materiaux m);
    public boolean supprimerMateriaux(Materiaux m);
    public List<Materiaux> afficherMateriaux();
}
