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
public class FeedbackService {

    @Value("${spring.mail.to}")
    String TO;

    @Value("${spring.mail.from}")
    String From;

    @Value("${spring.mail.name}")
    String Name;

    @Value("${spring.mail.subject}")
    String Subject;

    @Value("#{'${spring.mail.to}'.split(',')}")
    public List<String> myList;

    public  EmailCfg emailCfg;
    @Autowired
    public FeedbackService(EmailCfg emailCfg)
    {
        this.emailCfg=emailCfg;
    }

    @Autowired
   private Configuration config;



    public void sendFeedback(Map<String, Object> model ) throws AddressException {

        InternetAddress[] recipientAddress = new InternetAddress[myList.size()];


        int counter = 0;
        for (String recipient : myList) {
            recipientAddress[counter] = new InternetAddress(recipient.trim());
            counter++;
        }


        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", this.emailCfg.getPort());
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.auth", "true");
        //props.put("mail.debug", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
        Transport transport=null;
        try {
            Template t = config.getTemplate("email-body.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

            // Taking static data for testing but should be dynamically
            msg.setFrom(new InternetAddress(From,Name));
           // msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
           // msg.addRecipients(Message.RecipientType.CC, String.valueOf(myList));
            msg.setRecipients(Message.RecipientType.TO, recipientAddress);
            msg.setSubject(Subject);
            msg.setContent(html,"text/html");



            transport = session.getTransport();
            transport.connect(this.emailCfg.getHost(), this.emailCfg.getUsername(), this.emailCfg.getPassword());
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
