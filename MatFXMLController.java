
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import Entites.Materiaux;
import Services.MateriauxService;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sirine
 */
public class MatFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @FXML
    private ComboBox<String> combo1;

    @FXML
    private ChoiceBox<String> combo2;

    @FXML
    private TableView<Materiaux> tableview;

    @FXML
    private TableColumn<Materiaux, String> Tp;

    @FXML
    private TableColumn<Materiaux, String> tr;

    @FXML
    private TableColumn<Materiaux, String> dv;

    @FXML
    private TableColumn<Materiaux, String> cu;

    @FXML
    private TextField ttt;

    @FXML
    private Button ajbtn;

    @FXML
    private Button modifbtn;

    @FXML
    private Button supbtn;
    @FXML
    private Button calcul;
    @FXML
    private DatePicker date;
    @FXML
    private TextField result;
    @FXML
    private Button tauxc;
    @FXML
    private TextField recy;

    @FXML
    private TextField mater;
    @FXML
    private ImageView image;
    @FXML
    private Text type;
    @FXML
    private Text taux;
    @FXML
    private Text duree;
    @FXML
    private Text condition;
     @FXML
    private Button ici;
    private final ObservableList<Materiaux> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo1.getItems().addAll("M??tal", "Plastique", "verre", "coton");
        combo2.getItems().addAll("Usage unique", "r??utilisable");
        Tp.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));
        tr.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTaux_recyclage()));
        dv.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDuree_vie()));
        cu.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCondition_utilisation()));
        tableview.setItems(data);

        String imagePath = "/presentation/image.png";
        Image image = new Image(imagePath);

        this.image.setImage(image);

    }

    @FXML
    private void handleAjouter() throws SQLException {
        String type = combo1.getValue();
        String condition_utilisation = combo2.getValue();
        String duree_vie = result.getText();
        String taux_recyclage = recy.getText();
        if (type == null || taux_recyclage == null || duree_vie.isEmpty() || condition_utilisation == null || condition_utilisation.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("Tous les champs doivent ??tre remplis");
            alert.showAndWait();
        } else {
            Materiaux materiaux = new Materiaux(type, taux_recyclage, duree_vie, condition_utilisation);
            MateriauxService service = new MateriauxService();
            service.ajouterMateriaux(materiaux);
            data.add(materiaux);
            clearFields();
        }
    }

    private void clearFields() {
        combo1.getSelectionModel().clearSelection();
        combo2.getSelectionModel().clearSelection();
        result.setText("");
        mater.setText("");
    }
@FXML
private void handleYoutube() throws URISyntaxException {
    String url = "https://www.youtube.com/watch?v=cP7r6BLVdnI&t=39s"; // Remplacez xxxxxxx par l'ID de la vid??o YouTube
    try {
        Desktop.getDesktop().browse(new URI(url));
    } catch (IOException | URISyntaxException e) {
        e.printStackTrace();
    }
}
    @FXML
    private void handlecalcul(ActionEvent event) throws IOException {
        // R??cup??ration des valeurs entr??es par l'utilisateur
        String typeDechet = combo1.getValue();
        int poids = Integer.parseInt(mater.getText());

        // Calcul du poids recycl?? et du poids non recycl??
        MateriauxService service = new MateriauxService();
        double[] poidsRecycleEtNonRecycle = service.calculerPoidsRecycleEtNonRecycle(typeDechet, poids);
        double poidsRecycle = poidsRecycleEtNonRecycle[0];
        double poidsNonRecycle = poidsRecycleEtNonRecycle[1];
        ttt.setText(String.format("Poids recycl?? : %.2f kg", poidsRecycle));
        recy.setText(String.format("Poids non recycl?? : %.2f kg", poidsNonRecycle));
        // Passer les valeurs de poids recycl?? et de poids non recycl?? ?? l'interface suivante
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../presentation/ChartFXML.fxml"));
        Parent root = loader.load();
        ChartFXMLController suivantController = loader.getController();
        // suivantController.initData(poidsRecycle, poidsNonRecycle);
        suivantController.setData(poidsRecycle, poidsNonRecycle);

        // Afficher l'interface suivante
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // Fermer l'interface actuelle
        // ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void handleSupprimer() {
        // R??cup??rer l'objet s??lectionn?? dans la table
        Materiaux materiauxASupprimer = tableview.getSelectionModel().getSelectedItem();

        if (materiauxASupprimer != null) {
            MateriauxService service = new MateriauxService();
            // Appeler la m??thode supprimerMateriaux pour supprimer l'objet de la base de donn??es
            boolean success = service.supprimerMateriaux(materiauxASupprimer);

            if (success) {
                // Si la suppression a r??ussi, supprimer l'objet de la table affich??e dans l'interface graphique
                tableview.getItems().remove(materiauxASupprimer);
                System.out.println("La suppression du Materiaux est effectu??e");
            } else {
                System.out.println("Echec de suppression");
            }
        }
    }

    @FXML
    private void calculerDureeVie(ActionEvent event) {
        LocalDate dateAjout = date.getValue();
        if (dateAjout == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez s??lectionner une date d'ajout !");
            alert.showAndWait();
            return;
        }

        String type = combo1.getValue();
        if (type == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez s??lectionner un type de d??chet !");
            alert.showAndWait();
            return;
        }

        LocalDate dateFin = null;
        if (type.equals("Plastique")) {
            dateFin = dateAjout.plusDays(365);
        } else if (type.equals("Verre")) {
            dateFin = dateAjout.plusYears(15);
        } else if (type.equals("M??tal")) {
            dateFin = dateAjout.plusYears(20);
        } else if (type.equals("Coton")) {
            dateFin = dateAjout.plusDays(200);
        }

        if (dateFin != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            result.setText("jusqu au " + dateFin.format(formatter));
        }
    }

    @FXML
    private void handleModifier() {
        Materiaux selectedMateriaux = tableview.getSelectionModel().getSelectedItem();
        if (selectedMateriaux != null) {
            String type = combo1.getValue();
            MateriauxService service = new MateriauxService();
            String taux = ttt.getText();
            String duree = result.getText();
            String condition = combo2.getValue();
            selectedMateriaux.setType(type);
            selectedMateriaux.setTaux_recyclage(taux);
            selectedMateriaux.setDuree_vie(duree);
            selectedMateriaux.setCondition_utilisation(condition);

            try {
                service.modifierMateriaux(selectedMateriaux.getIdMateriaux(), selectedMateriaux);
                tableview.refresh(); // rafra??chir la tableview
                System.out.println("Materiaux modifi?? avec succ??s!");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
