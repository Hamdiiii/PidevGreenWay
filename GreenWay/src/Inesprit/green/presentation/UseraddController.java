/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inesprit.green.presentation;

import Base.MyConnection;
import Entite.User;
import Service.UserService;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author rayen
 */
public class UseraddController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection cnx = null;
     Statement ste = null;
     User  rcd = new User ();}
   
      private boolean namevalide(){
      Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(namein.getText());
        if(m.find() && m.group().equals(namein.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez entrer un type validé !");
                alert.showAndWait();
           
            return false;            
        }
     }
//                private boolean cityvalide(){
//      Pattern p = Pattern.compile("[a-zA-Z ]+");
//        Matcher m = p.matcher(city.getText());
//        if(m.find() && m.group().equals(city.getText())){
//            return true;
//        }else{
//                Alert alert = new Alert(Alert.AlertType.WARNING);
//                alert.setTitle("Type validé !");
//                alert.setHeaderText(null);
//                alert.setContentText("Veuillez entrer un type validé !");
//                alert.showAndWait();
//           
//            return false;            
//        }
//                }
                                private boolean phonevalide(){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(phonein.getText());
        if(m.find() && m.group().equals(phonein.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Type validé !");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez entrer un type validé !");
                alert.showAndWait();
           
            return false;            
        }
                }
//                            private boolean zipvalide(){
//        Pattern p = Pattern.compile("[0-9]+");
//        Matcher m = p.matcher(zip_code.getText());
//        if(m.find() && m.group().equals(zip_code.getText())){
//            return true;
//        }else{
//                Alert alert = new Alert(Alert.AlertType.WARNING);
//                alert.setTitle("Type validé !");
//                alert.setHeaderText(null);
//                alert.setContentText("Veuillez entrer un type validé !");
//                alert.showAndWait();
//           
//            return false;            
//        }
//        }
        ///////////////////////////////////////////////////
    
@FXML
    private TextField namein;

    @FXML
    private TextField passwordin;

    @FXML
    private TextField phonein;

    @FXML
    private TextField emailin;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button suprimer;

    @FXML
    private TableView<User> user_liste;

    @FXML
    private TableColumn<User,String > user_name;

    @FXML
    private TableColumn<User, String> user_email;
    @FXML
    private TableColumn<User, Integer> user_id;
    @FXML
    private TableColumn<User, String> user_phone;

    @FXML
    void ajoututilisateur(ActionEvent event) {
 UserService it = new UserService();
        if(namevalide()&&phonevalide()){
        
        String var1=namein.getText();
        String var2=passwordin.getText();
         String var3 =phonein.getText();
        String var4=emailin.getText();
      

       User i =new User();
        
      i.setNom(var1);
      i.setMotdepasse(var2);
      i.setTelephone(var3);
      i.setEmail(var4);
   
      it.ajouterUser(i);
      affiche();
       
      namein.clear();
      passwordin.clear();
      phonein.clear();
      emailin.clear();
        }
    }

    @FXML
    void deleteutilisateur(ActionEvent event) {
   UserService  it = new  UserService ();
           User i= new User();   
              i= user_liste.getSelectionModel().getSelectedItem();
              it.supprimerUser(i);
              affiche();
    }

    @FXML
    void updateutilisateur(ActionEvent event) {
 UserService it = new UserService();
        if(namevalide()&&phonevalide()){
        
           String var1=namein.getText();

        String var3=phonein.getText();
        String var4=emailin.getText();
      

       User i =new User();
        
      i.setNom(var1);
      i.setTelephone(var3);
      i.setEmail(var4);
      
   
      it.modifierUser(var1,i);
      //affiche();
       
      namein.clear();
      passwordin.clear();
      phonein.clear();
      emailin.clear();
        }
    }
   // fonction pour afficher les donnees dans un tableau 
public void affiche() {
    try {
        Statement stmt = MyConnection.getInstance().getCnx().createStatement();

        ResultSet rs = stmt.executeQuery("SELECT email,motdepasse,nom,prenom,telephone,adresse,id_fournisseur ,id_personne,id_livreur, id_admin,id_client FROM personne");

        ObservableList<User> list = FXCollections.observableArrayList();

        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");

            String email = rs.getString("email");
            String phone = rs.getString("phone");

            User user = new User(id, username, email, phone);
            list.add(user);
        }
System.out.println("Number of rows in list: " + list.size());

     user_id.setCellValueFactory(new PropertyValueFactory<>("id"));
user_name.setCellValueFactory(new PropertyValueFactory<>("username"));
user_email.setCellValueFactory(new PropertyValueFactory<>("email"));
user_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        user_liste.setItems(list);

    } catch (SQLException e) {
        e.printStackTrace();//
    }
}

@FXML
    void getuser(MouseEvent event) {
        int index = user_liste.getSelectionModel().getSelectedIndex();
   if (index <= -1) {
        return;
   }
    UserService it=new UserService();
    namein.setText(user_name.getCellData(index));
    emailin.setText(user_email.getCellData(index));
    phonein.setText(user_phone.getCellData(index));

    }

       
}

    
    

