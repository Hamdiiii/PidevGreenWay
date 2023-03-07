/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entites.Evaluation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import services.EvaluationService;
import java.io.IOException;
import java.util.Date;
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
import java.util.Properties;
import javafx.scene.control.Alert;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Transport;

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
    private TableView<Evaluation> tabEV;

    @FXML
    private TableColumn<Evaluation, String> comtv;
    @FXML
    private TableColumn<Evaluation, Integer> cltv;
    @FXML
    private TableColumn<Evaluation, Integer> rat;
    @FXML
    private Rating rating;

    @FXML
    private Label msg;
    @FXML
    private Button btn;
    @FXML
    private TextField recipientField;

    @FXML
    private Label emailMsg;
    @FXML
    private TextField pass;

//    private final String username = "sirine.rebai@esprit.tn";
//    private final String password = "siriner560";
//    private final String smtpHost = "smtp.gmail.com";
//    private final int smtpPort = 587;
    /**
     * Initializes the controller class.
     */
    private final ObservableList<Evaluation> data = FXCollections.observableArrayList();
    @FXML
    private Text rata;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comtv.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContenu()));
        rat.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getRating()));
        cltv.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId_personne()));
        tabEV.setItems(data);

        rating.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number old, Number newT) {
                msg.setText("Rating:" + newT);
            }

        });

    }

    @FXML
    void ajouterEv(ActionEvent event) throws MessagingException {
        String contenu = comment.getText();
        int ratingValue = (int) rating.getRating();
        int id_personne = Integer.parseInt(clientid.getText());
        Evaluation evaluation = new Evaluation(contenu, ratingValue, id_personne);
        EvaluationService service = new EvaluationService();
        service.ajouterEvaluation(evaluation);
        data.add(evaluation);
        clearFields();

//        String recipient = recipientField.getText();
//        sendEmail(recipient);
        String to = "daadsoufi01@gmail.com";
        String from = "sirinerebai1234@gmail.com";
        String host = "localhost";
        String port = "25";
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        final String email = "sirinerebai1234@gmail.com";//
       // final String password = "rpqfvaeulqwtgksd";
       final String password = "hdgbz";

        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.ssl.trust", "*");
        props.setProperty("mail.smtp.starttls.enable", "true");

        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(props,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(from));
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to, false));
        msg.setSubject("Demande de parrainage ");
        msg.setText("salem");
        msg.setSentDate(new Date());
        Transport.send(msg);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Demande de parrainage");
        alert.setHeaderText("Demande envoyée!");
        alert.showAndWait();
    }

//    private void sendEmail(String recipient) throws AddressException, MessagingException {
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.ssl.enable", "true");
//        props.put("mail.smtp.socketFactory.port", "587");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback", "false");
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("sirine.rebai@esprit.tn"));
//            message.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse("sirinerebai1234@gmail.com"));
//            Transport.send(message);
//
//        } catch (Exception ex) {
//            System.out.println("Error sending email: " + ex.getMessage());
//        }
//    }
    void clearFields() {
        comment.setText("");
        msg.setText(String.valueOf(0));
        clientid.setText("");
    }

    @FXML
    void suppEv(ActionEvent event
    ) {
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
    public void btnRetour(ActionEvent event
    ) {
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
