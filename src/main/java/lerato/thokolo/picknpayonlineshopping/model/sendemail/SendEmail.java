/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.sendemail;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author MANDELACOMP2
 */
public class SendEmail {

    private String to_email;
    private String subject;
    private String body;
    private File file;

    public SendEmail() {

    }

    public SendEmail(String to_email, String subject, String body, File file) {
        this.file = new File("C:/Users/MANDELACOMP2/AndroidStudioProjects/DrawerActivityWithFragments/receipt.txt");
        this.to_email = to_email;
        this.subject = subject;
        this.body = body;
        this.file = file;
    }

    public SendEmail(String json) throws IOException {

        SendEmail e = new ObjectMapper().readValue(json, SendEmail.class);
        this.to_email = e.to_email;
        this.subject = e.subject;
        this.body = e.body;
        this.file = e.file;

    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getTo_email() {
        return to_email;
    }

    public void setTo_email(String to_email) {
        this.to_email = to_email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
