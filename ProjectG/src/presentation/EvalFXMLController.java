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
    private Rating rating;

    @FXML
    private Label msg;
    @FXML
    private Button btn;
    @FXML
    private TextField recipientField;

    private final String username = "sirine.rebai@esprit.tn";
    private final String password = "siriner560";

    /**
     * Initializes the controller class.
     */
    private final ObservableList<Evaluation> data = FXCollections.observableArrayList();
    @FXML
    private Text rata;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        rating.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number old, Number newT) {
                msg.setText("Rating:" + newT);
            }

        });

    }

    private String lastRecipientEmail = "";

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
        // Récupérer l'adresse e-mail du destinataire
        String recipientEmail = recipientField.getText();

        // Envoyer l'e-mail automatiquement à l'adresse e-mail précédente
        if (!lastRecipientEmail.isEmpty()) {
            sendEmail(recipientEmail, lastRecipientEmail);
        }

        // Sauvegarder l'adresse e-mail du destinataire actuel pour une utilisation future
        lastRecipientEmail = recipientEmail;
    }

    // Fonction d'envoi de l'e-mail
    private void sendEmail(String recipientEmail, String lastRecipientEmail) {
        final String username = "sirinerebai1234@gmail.com"; // votre adresse e-mail
        final String password = "20136558"; // votre mot de passe

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(lastRecipientEmail));
            message.setSubject("Email");
            message.setText("Bonjour,\n\nMerci pour votre evaluation.");

            Transport.send(message);

            System.out.println("L'e-mail a été envoyé avec succès.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    void clearFields() {
        comment.setText("");
        msg.setText(String.valueOf(0));
        clientid.setText("");
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
