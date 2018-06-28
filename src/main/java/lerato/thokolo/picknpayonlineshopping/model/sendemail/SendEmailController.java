/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.sendemail;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MANDELACOMP2
 */
@RestController
@RequestMapping("/email")
public class SendEmailController {
    
    @Autowired
    private EmailService emailService;
    
    @RequestMapping(value = "/send-email", method = RequestMethod.POST)
    public SendEmail sendEmail(@RequestBody SendEmail sendEmail) throws MessagingException{
    
        return this.emailService.sendEmail(sendEmail);
    }
    
}
