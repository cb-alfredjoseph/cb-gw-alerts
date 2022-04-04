package com.chargebee.cbgwalerts.email;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Service
public class EmailService {

    @Value("${spring.mail.to}")
    String to;

    @Value("${spring.mail.from}")
    String from;

    @Value("${spring.mail.name}")
    String name;

    @Value("${spring.mail.subject}")
    String subject;

    @Value("#{'${spring.mail.to}'.split(',')}")
    public List<String> recipients;

    public EmailConfiguration emailConfiguration;
    @Autowired
    public EmailService(EmailConfiguration emailConfiguration)
    {
        this.emailConfiguration=emailConfiguration;
    }

    @Autowired
    private Configuration config;



    public void sendEmail(Map<String, Object> model ) throws AddressException {

        InternetAddress[] recipientAddress = new InternetAddress[recipients.size()];


        int counter = 0;
        for (String recipient : recipients) {
            recipientAddress[counter] = new InternetAddress(recipient.trim());
            counter++;
        }


        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", this.emailConfiguration.getPort());
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
        Transport transport=null;
        try {
            Template template = config.getTemplate("email-body.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            msg.setFrom(new InternetAddress(from,name));
            msg.setRecipients(Message.RecipientType.TO, recipientAddress);
            msg.setSubject(subject);
            msg.setContent(html,"text/html");



            transport = session.getTransport();
            transport.connect(this.emailConfiguration.getHost(), this.emailConfiguration.getUsername(), this.emailConfiguration.getPassword());
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
            transport.close();

        } catch (MessagingException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("The email was not sent");
            System.out.println("Error message: "+e.getMessage());
        }

    }
}
