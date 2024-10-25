package com.learn.javamailsender.services.impl;

import com.learn.javamailsender.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {


    Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    public EmailServiceImpl(JavaMailSender javaMailSender) {

        this.mailSender = javaMailSender;
    }

    private JavaMailSender mailSender ;

    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage  = new SimpleMailMessage() ;

        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom("deepaklodha532@gmail.com");
        mailSender.send(simpleMailMessage);
        logger.info("Email  has been sent .. ");
    }

    @Override
    public void sendEmail(String[] to, String subject, String message ) {
        SimpleMailMessage simpleMailMessage  = new SimpleMailMessage() ;

        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom("deepaklodha532@gmail.com");
        mailSender.send(simpleMailMessage);
        logger.info("Email  has been sent .. ");
     }

    @Override
    public void sendEmailWithHtml(String to, String subject, String htmlContent) {
        MimeMessage simpleMailMessage =  mailSender.createMimeMessage() ;
        try{
            MimeMessageHelper helper = new MimeMessageHelper(simpleMailMessage,true,"UTF-8") ;
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom("deepaklodha532@gmail.com");
            helper.setText(htmlContent, true);
            logger.info("sent the mail    ");
            mailSender.send(simpleMailMessage);


        }catch (MessagingException e){
           throw  new RuntimeException(e) ;
        }


    }

    @Override
    public void sendEmailWithFile(String to, String subject, String message, File file) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try{
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true) ;
            helper.setFrom("deepaklodha432@gmail.com" );
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(message);
            FileSystemResource fileSystemResource = new FileSystemResource(file);
            helper.addAttachment(fileSystemResource.getFilename(), file);
            mailSender.send(mimeMessage);
            logger.info("Email  send  success");

        }
        catch (MessagingException e){
            throw  new RuntimeException(e) ;
        }
    }

//    @Override
//    public void sendEmailWithFile(String to, String subject, String message, InputStream is) {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//
//        try{
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true) ;
//            helper.setFrom("deepaklodha432@gmail.com" );
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.setText(message);
//            FileSystemResource fileSystemResource =  new FileSystemResource(is) ;
//            mailSender.send(mimeMessage);
//            logger.info("Email  send  success");
//
//        }
//        catch (MessagingException e){
//            throw  new RuntimeException(e) ;
//        }
//    }
}
