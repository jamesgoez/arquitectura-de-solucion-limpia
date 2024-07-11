package co.base.project.usecase.mail.services;

import co.base.project.usecase.notification.save.dto.SaveNotificationInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendHtmlEmail(SaveNotificationInputDTO notificationInputDTO) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        message.setFrom(new InternetAddress("jamesgoez23@gmail.com"));
        message.setRecipients(MimeMessage.RecipientType.TO, notificationInputDTO.getBuyerEmail().orElse(""));
        message.setSubject("Novadades en tu pedido");

        String htmlContent = "<p>Hola! Tenemos programada la entrega de tu paquete para ma\u00f1ana, en la direcci\u00f3n de " +
                "entrega esperamos un d\u00eda con <strong>".concat(notificationInputDTO.getForecastDescription()).concat("</strong> y por esta raz\u00f3n " +
                        "es posible que tengamos retrasos. Haremos todo a nuestro alcance para cumplir con tu " +
                        "entrega.</p>");
        message.setContent(htmlContent, "text/html; charset=utf-8");

        mailSender.send(message);
    }
}
