package service;

import java.io.IOException;
import java.net.InetAddress;
import model.ModelMessage;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServiceMail {

    public ModelMessage sendMain(String toEmail, String code) {
        ModelMessage ms = new ModelMessage(false, "");
        System.out.println("toEmail: " + toEmail);

    System.out.println("code nay io aka,azy am Email ato iny ly spin tia : " + code);
        // Remplacez les valeurs suivantes par votre adresse e-mail Gmail et votre mot de passe
        String username = "jwicheer14344@gmail.com";
        String password = "rxkc vkvk nzzg qhya";
                String from = "OpenData@gmail.com";

        // Configurez les propriétés pour la session SMTP
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            if (!isInternetAvailable()) {
                ms.setMessage("Aucune connexion Internet disponible.");
                return ms;
            }
            if (code != null) {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username)); // Utilisez votre adresse e-mail Gmail comme expéditeur
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
                message.setSubject("Code de vérification");
                message.setText(code);
                Transport.send(message);
                ms.setSuccess(true);
//                ms.setMessage("Code is null." + code);
            } else {
                ms.setMessage("Le code est nul.");
            }
        } catch (MessagingException e) {
            if (e.getMessage().equals("Adresses invalides")) {
                ms.setMessage("Adresse e-mail invalide");
            } else {
                ms.setMessage("Erreur");
                e.printStackTrace(); // Affichez l'erreur complète pour le débogage
            }
        }
        return ms;
    }

    private boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("www.google.com");
            return !ipAddr.equals("");
        } catch (IOException e) {
            return false;
        }
    }
}
