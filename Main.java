/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.greenWay.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Sirine
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
      try{
        Parent root =FXMLLoader.load(getClass().getResource("/presentation/LoginFXML.fxml"));
        Scene scene= new Scene (root);
       stage.setScene(scene) ;
       //stage.setResizable(false);
       stage.show();
        
    }catch (Exception ex){
          System.out.println(ex.getMessage());
    }
    
    }
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        launch(args);
   }
    
}