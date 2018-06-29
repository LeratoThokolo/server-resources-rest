/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.sendemail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author MANDELACOMP2
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public SendEmail sendEmail(SendEmail sendEmail) {

        
        try {

            MimeMessage message = this.javaMailSender.createMimeMessage();
            message.setFrom(new InternetAddress("leratongoakothokolo@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendEmail.getTo_email()));
            message.setSubject(sendEmail.getSubject());

            BodyPart bodyPart = new MimeBodyPart();
            bodyPart.setText(sendEmail.getBody());

            Multipart multipart = new MimeMultipart();

            multipart.addBodyPart(bodyPart);

            bodyPart = new MimeBodyPart();
            DataSource dataSource = new FileDataSource(sendEmail.getFile());
            bodyPart.setDataHandler(new DataHandler(dataSource));
            bodyPart.setFileName(String.valueOf(sendEmail.getFile()));
            multipart.addBodyPart(bodyPart);

            message.setContent(multipart);
            this.javaMailSender.send(message);

        } catch (MessagingException e) {

            throw new RuntimeException(e);
        }

        return sendEmail;
    }
}
