/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import Entites.Evaluation;
import Entites.Materiaux;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import Services.EvaluationService;
import java.io.IOException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author Sirine
 */
public class EvalFXMLController implements Initializable {

    @FXML
    private TextArea comment;

    @FXML
    private Text comnt;

    @FXML
    private Text client;

    @FXML
    private TextField clientid;
    @FXML
    private Button ajoutev;

    @FXML
    private Button suppev;

    @FXML
    private Button modifev;
    @FXML
    private TableView<Evaluation> tabEV;

    @FXML
    private TableColumn<Evaluation, String> comtv;
    @FXML
    private TableColumn<Evaluation, Integer> cltv;
        @FXML
    private Rating rating;

    @FXML
    private Label msg;


    @FXML
    void modifEv(ActionEvent event) {

    }

   @FXML
void suppEv(ActionEvent event) {
    // Obtenez l'évaluation sélectionnée dans la TableView
    Evaluation selectedEvaluation = tabEV.getSelectionModel().getSelectedItem();
    if (selectedEvaluation != null) {
        // Supprimez l'évaluation sélectionnée de la base de données
        EvaluationService service = new EvaluationService();
        boolean success = service.supprimerEvaluation(selectedEvaluation.getIdEvaluation());
        if (success) {
            // Obtenez la liste actuelle d'évaluations à partir de la TableView
            ObservableList<Evaluation> evaluations = tabEV.getItems();
            // Supprimez l'évaluation sélectionnée de la liste
            evaluations.remove(selectedEvaluation);
            // Réinitialiser la TableView avec la liste mise à jour
            tabEV.setItems(evaluations);
        } else {
            // Traitement des erreurs si la suppression d'évaluation a échoué
        }
    } else {
        // Aucune évaluation n'est sélectionnée dans la TableView
    }
}
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
        private final ObservableList<Evaluation> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comtv.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContenu()));
        cltv.setCellValueFactory(cellData -> new SimpleObjectProperty<>(Integer.valueOf(cellData.getValue().getIdClient())));
                tabEV.setItems(data);
                
       rating.ratingProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number old, Number newT) {
            msg.setText("Rating:"+newT);
            }
       
       
       });

    }

    @FXML
    void ajouterEv(ActionEvent event) {
           Evaluation e = new Evaluation(comment.getText(), Integer.parseInt(clientid.getText()));
    EvaluationService service = new EvaluationService();
    int id = service.ajouterEvaluation(e);
    if (id != -1) { // Vérifier que l'ajout s'est bien déroulé
        // Ajouter la nouvelle évaluation à la liste liée à la TableView
        ObservableList<Evaluation> listeEvaluations = tabEV.getItems();
        listeEvaluations.add(e);
    }
}

    @FXML
    public void btnRetour(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../presentation/MatFXML.fxml"));
            Parent root = loader.load();
            Scene newScene = new Scene(root);

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
