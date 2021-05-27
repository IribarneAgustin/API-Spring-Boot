package com.alkemy.api.email;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.*;
import java.io.IOException;
import com.alkemy.api.models.UserModel;

public class Mailer {

    private static final String API_KEY = "";
    private static final String SENDER_EMAIL = "";

    public Mailer(){}

    
    public void sendEmail(UserModel user) {

        Email from = new Email(SENDER_EMAIL);
        String subject = "ALKEMY API";
        Email to = new Email(user.getEmail());
        Content content = new Content("text/plain", "Gracias por registrarse en Alkemy API");
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid(API_KEY);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
