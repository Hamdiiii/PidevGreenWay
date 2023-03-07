/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entites.Client;
import java.util.List;
/**
 *
 * @author Sirine
 */
public interface InterfaceClient {

    public void ajouterClient(Client c);

    public void modifierClient(int idClient ,Client c);

    public void supprimerClient(Client c);

    public List<Client> afficherClient();


    
}
