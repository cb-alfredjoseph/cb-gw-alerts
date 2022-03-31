package com.chargebee.cbgwalerts.email;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;

@Service
public class FeedbackService {
    String TO="siddhantchourasia99@gmail.com";
    String Name="Rohit";
    String From="siddhant.chourasia@chargebee.com";
    String Subject="Email Working";
    public  EmailCfg emailCfg;
    @Autowired
    public FeedbackService(EmailCfg emailCfg)
    {
        this.emailCfg=emailCfg;
    }


    @Autowired
   private Configuration config;



    public void sendFeedback(Map<String, Object> model ) {

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
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
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
