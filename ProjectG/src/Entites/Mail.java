/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Sirine
 */
public class Mail {

    private static final String username = "sirine.rebai@esprit.tn";
    private static final String password = "siriner560";

    public void sendEmail(String recipient) {
        // Etape 1 : Création de la session
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); //Enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //Set TLS encryption enabled
        props.put("mail.smtp.host", "smtp.gmail.com");  //Set SMTP host
        props.put("mail.smtp.port", "587"); //Set smtp port
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            //Etape2:Creation de l'objet de message
            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("sirine.rebai@esprit.tn"));
//            message.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse("sirinerebai1234@gmail.com"));
             Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", "username", "password");
        System.out.println("Transport: "+transport.toString());
        transport.sendMessage(message, message.getAllRecipients());
        
            message.setSubject("Ekteb l'objet mtaa l mail ");
            message.setText("w lenna lcontenu ");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
