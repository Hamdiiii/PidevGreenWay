
package presentation;

import Entites.Materiaux;
import Services.MateriauxService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Sirine
 */



public class DetailController implements Initializable {

    @FXML
    private Label txttype;

    @FXML
    private Label txtpoids;

    @FXML
    private Label txtduree;

    @FXML
    private Label conditiontxt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            MateriauxService m = new MateriauxService();
            List<Materiaux> list = m.afficherMateriaux();

            // Assuming that the list has at least one Materiaux object
            if (!list.isEmpty()) {
                Materiaux ms = list.get(0);
                setMateriaux(ms);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setMateriaux(Materiaux m) {
        String type = m.getType();
        String poids = m.getTaux_recyclage();
        String duree = m.getDuree_vie();
        String desc =m.getCondition_utilisation();
        txttype.setText(type);
        txtpoids.setText(poids);
        txtduree.setText(duree);
        conditiontxt.setText(desc);
    }
}

