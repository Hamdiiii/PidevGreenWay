import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import entites.categorie;
import entites.produit;
import entites.Personne;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.*;
import java.util.List;
import services.categorieservice;
import services.produitservice;
import services.PersonneService;
public class Main {
 
  
    public static void main (String []args) throws IOException{
       
        
       categorie c = new categorie("xxx");
        Personne pe = new Personne("hamdi.malek@esprit.tn","xxx","malek","hamdi",95055677,"monastir",1,1,1,1,1);
        PersonneService PersonneService = new PersonneService();
        categorie c1 = new categorie("sirinee");

        categorieservice categorieservice = new categorieservice();
         produitservice produitservice = new produitservice();
         
        produit p = new produit(1,"fedup","hamdi","aa",1,1,1,1,1);
        produitservice.ajouterproduit(p);
         categorieservice.ajoutercategorie(c);
         categorieservice.ajoutercategorie(c1);
         categorieservice.modifiercategorie(c);
         produitservice.supprimerproduit(p);
         
  //System.out.println( categorieservice.ajoutercategorie(c));
       // System.out.println(categorieservice.affichercategorie());
       //System.out.println(categorieservice.modifiercategorie(c));
        
      
       System.out.println(categorieservice.supprimercategorie(c));
       //int resultat = categorieservice.ajoutercategorie(c);
       int resultat = produitservice.ajouterproduit(p);
       if(resultat == 1){
           System.out.println("ajout produit reussi");
       }else{
           System.out.println("echec ajout");
       }System.out.println(produitservice.afficherproduit());
        List<produit> listPro = produitservice.afficherproduit();
        for(produit pp : listPro){
           System.out.println(pp.toString());
       } 
       int res = categorieservice.ajoutercategorie(c);
       if(res == 1){
           System.out.println("ajout categorie reussi");
       }else{
           System.out.println("echec ajout");
       }
       System.out.println(categorieservice.affichercategorie());

       //List<Personne> listPer = PersonneService.afficherPersonnes();
      
    //  listPro.stream().forEach(aa -> System.out.println(aa));
              // System.out.println(produitservice.afficherproduit());

   /* LocalDateTime myDateObj = LocalDateTime.now();  
    System.out.println("Before formatting: " + date);  
    DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); */
      
}
    
}
