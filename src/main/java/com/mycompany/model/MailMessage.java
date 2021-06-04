package com.mycompany.model;


import com.mycompany.controller.MailController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailMessage {

    private String subject;
    private String text;
    private String email;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void sendMessage(Properties properties) throws MessagingException {

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("muzcinka594@gmail.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress((this.getEmail())));
        message.setSubject(this.getSubject());
        message.setText(this.getText());

        Transport tr = mailSession.getTransport();
        tr.connect(null, "tywBBUkmu657HUb7rcbC7w");
        tr.sendMessage(message, message.getAllRecipients());
        tr.close();

    }
}
