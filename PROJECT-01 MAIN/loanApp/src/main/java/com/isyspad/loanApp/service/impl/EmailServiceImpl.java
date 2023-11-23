package com.isyspad.loanApp.service.impl;

import com.isyspad.loanApp.service.EmailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Scheduled(cron = "${cron.expression.value}")                        // Schedule daily at 8:00 AM - "0 0 8 * * ?")
    //@Scheduled(fixedDelay=5000)
    public void sendScheduledEmail() {
        String to = "kabalilogeshp25@gmail.com";
        String subject = "Test Email by Lokki";
        String Message = "<html xmlns='http://www.w3.org/1999/xhtml'>\n" +
                "<head>\n" +
                "<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/>\n" +
                "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "<title>My demo email</title>\n" +
                "</head>\n" +
                " <body>\n" +
                "<table width='100%' border='0' align='center' cellpadding='0' cellspacing='0'>\n" +
                "\n" +
                "<tbody><tr> <td align='center'>\n" +
                "                <table class='col-600' width='600' border='0' align='center' cellpadding='0' cellspacing='0'>\n" +
                "                <tbody><tr> \n" +
                "<td align-'center' valign='top' bgcolor=\"#ffc40c\" style=\"background-size: cover; background-position: top; height: '400' '='\">\n" +
                "<table class=\"col-600\" width=\"600\" height=\"400\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "<tbody><tr><td height=\"40\"></td></tr>\n" +
                "<tr><td align=\"center\" style=\"line-height: 0px;\"><p>Happy to welcome you Mr.Suresh.!</p><br><br>\n" +
                "<i class=\"fa fa-envelope\" style=\"font-size:48px;color:red\"></i></td></tr>\n" +
                "\n" +
                "<tr><td align=\"center\" style=\"font-family: 'Raleway', sans-serif; font-size: 17px; color: #ffffff; line-height:150px; font-weight: bold; letter-spacing:5px;\">\n" +
                "<h1>E-MAIL SCHEDULING</h1> \n" +
                "</td></tr>\n" +
                "<tr>\n" +
                "<td align=\"center\" style=\"font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif; font-size: 15px; color: #ffffff; line-height: 20px; font-weight: 100; \">\n" +
                "<p style=\"color: darkslategray;\">Hai Mr.Suresh.. <br> Here i am submitting demo E-mail <br> With Time Scheduling, as per your guidelines<br>Thank You..! </p>\n" +
                "</td>\n" +
                "</tr></tbody>\n" +
                "</table>\n" +
                "</td>\n" +
                "\n" +
                "   </tr></tbody></table></td></tr></tbody></table></tr></body></html>";

        sendHtmlEmail(to, subject, Message);
    }

    public void sendHtmlEmail(String to, String subject, String Message) {
        MimeMessagePreparator preparator = mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(Message, true);
        };

        mailSender.send(preparator);
    }
}
