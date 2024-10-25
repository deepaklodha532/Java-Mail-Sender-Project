package com.learn.javamailsender;

import com.learn.javamailsender.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailService emailService ;
    @Test
    void emailSendTest(){
        System.out.println("sending email ");
        emailService.sendEmail("deepaklodha432@gmail.com", "Email from spring boot " , "This email  is send using email  services ");
    }


    @Test
    void sendHtmlInEmail(){
        String htmlContent= "" +"<h3 style='color:blue; border:1px solid red;'> Welcome To Learn  Code  with durgesh </h1>"+"";
        emailService.sendEmailWithHtml("deepaklodha432@gmail.com" , "Email  form  spring boot ",htmlContent);
    }

    @Test
    void  sendEmailWithFile(){
        emailService.sendEmailWithFile("deepaklodha432@gmail.com","Email with file", "This email contains  file",new File("D:\\Gallery\\my gallery\\Screenshot_20240423_133340.jpg"));
    }


}
