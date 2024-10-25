package com.learn.javamailsender.services;

import java.io.File;
import java.io.InputStream;

public interface EmailService {

    //send email  to single person
    void sendEmail(String to  , String subject, String message) ;

    //send email  to multiple person
    void sendEmail(String  []to ,  String subject,  String message);

    //void sendEmailWithHtml
    void sendEmailWithHtml(String to  ,  String subject, String htmlContent);


    //void  send email  with file
    void sendEmailWithFile(String to , String subject, String message , File file ) ;


    //void  send
//    void sendEmailWithFile(String to , String subject, String message , InputStream is ) ;



}
