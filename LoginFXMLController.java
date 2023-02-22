/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.greenWay.presentation;

import Entites.Client;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Sirine
 */
public class LoginFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private TableView<Client> tableview;
    @FXML
    private TableColumn<Client, Date> DateCreation;

    @FXML
    private TableColumn<Client, Integer> ID;
       @FXML
    private Button ajouterbtn;

    @FXML
    private ImageView image;
    javafx.scene.image.Image google=new javafx.scene.image.Image("/presentation/image.png");
   @FXML
    void AfficherImage(ActionEvent event) {
        image.setImage(google);
    }
    
   

    java.sql.Date date1 = java.sql.Date.valueOf("2024-07-02");
  ObservableList<Client> list = FXCollections.observableArrayList(
       
        new Client(1,date1)   
  );
  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    ID.setCellValueFactory (new PropertyValueFactory<Client,Integer>("id"));
    DateCreation.setCellValueFactory (new PropertyValueFactory<Client,Date>("DateCreation"));
    
    tableview.setItems(list);
    
}
}