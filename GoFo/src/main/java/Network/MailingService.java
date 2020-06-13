/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

/**
 * MailingService does as its name implies, sends confirmation emails to newly
 * registered users to confirm their account
 *
 * @author ShawkyDev
 * @version 1.0
 * @since 12/6/2020
 */
import com.sun.tools.javac.Main;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailingService extends Thread {

    private String msg, title;
    private ArrayList<String> emails;
    
    
    ///the one and only instance :
    private static MailingService mailingService = null;

    @Override
    public void run() {
        try {

            for (String to : emails) {
                sendEmailTo(to, title, msg);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MailingService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static MailingService getInstance(){
        if(mailingService==null)
            mailingService = new MailingService();
        return mailingService;
    }

    public void SendMultipleMails(String title, String content, ArrayList<String> emails) {
        this.msg = content;
        this.title = title;
        this.emails=emails;
        run();
    

    
    }
    /**
     * This function takes the email address and title and message
     * and sends the email  
     * @param Email
     * @param title
     * @param msg 
     */
    public static void sendEmailTo(String Email, String title, String msg) {

        // Sender's email ID needs to be mentioned
        String from = "gofomailservice@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("gofomailservice@gmail.com", "GoFo12345678");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(Email));

            // Set Subject: header field
            message.setSubject("GoFo " + title);

            // Now set the actual message
            message.setText(msg);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }

}
