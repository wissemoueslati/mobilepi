/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Admin
 */
public class mailer {
    
 public mailer() {
    }
      
    
    public static void sendll(String to, String sub,String msg, final String user, final String pass,int Code) 
    {
        
           Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(user, pass);
            }
        });

        try 
        {
           // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(to));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject("Commentaire ajouter");

         // This mail has 2 part, the BODY and the embedded image
         MimeMultipart multipart = new MimeMultipart("related");

         // first part (the html)
         BodyPart messageBodyPart = new MimeBodyPart();
         String htmlText = "<h1 style='color: Red'>commentaire ajouter :  </h1><h4></h4>";
         messageBodyPart.setContent(htmlText, "text/html");
         // add it
         multipart.addBodyPart(messageBodyPart);

//         // second part (the image)
//         messageBodyPart = new MimeBodyPart();
//         DataSource fds = new FileDataSource(
//            "C:\\Users\\Karim\\Desktop\\Valhalla\\3.jpg");
//
//         messageBodyPart.setDataHandler(new DataHandler(fds));
//         messageBodyPart.setHeader("Content-ID", "<image>");
//
//         // add image to the multipart
//         multipart.addBodyPart(messageBodyPart);

         // put everything together
         message.setContent(multipart);
         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");
           
            
         
            
        } catch (MessagingException e) 
        {
            System.out.println(e);
        }
   

        /*    try
        {
        Properties props = new Properties();
        
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.transport.portocol", "smtp");
        props.put("mail.smtps.auth", "true");
        
        
        Session session = Session.getInstance(props,null);
        
        // Create a default MimeMessage object.
        Message message = new MimeMessage(session);
        
        // Set From: header field of the header.
        message.setFrom(new InternetAddress(to));
        
        // Set To: header field of the header.
        message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(to));
        
        // Set Subject: header field
        message.setSubject("Activation de compte");
        SMTPTransport st=(SMTPTransport)session.getTransport("smtps");
        st.connect("smtp.gmail.com", 587, "azizhammami621@gmail.com","181JMT1043");
        st.sendMessage(message, message.getAllRecipients());
        
        // This mail has 2 part, the BODY and the embedded image
        
        
        // first part (the html)
        SMTPTransport.send(message);
        
        System.out.println("Sent message successfully....");
        
        
        
        
        } catch (MessagingException e)
        {
        System.out.println(e);
        }*/
    }
}

