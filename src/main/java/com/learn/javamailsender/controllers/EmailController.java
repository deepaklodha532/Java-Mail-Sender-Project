package com.learn.javamailsender.controllers;

import com.learn.javamailsender.helper.CustomResponse;
import com.learn.javamailsender.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class EmailController {


    @Autowired
    private EmailService emailService;
    //send email
    @PostMapping("/send")
    public ResponseEntity<?> sendEmailInhtml( @RequestBody  EmailRequest request) {
        emailService.sendEmailWithHtml(request.getTo(), request.getSubject(), request.getMessage());
        return new ResponseEntity<>(CustomResponse.builder().message("Email send successfully !!").httpStatus(HttpStatus.OK).success(true), HttpStatus.OK ) ;
    }

//    @PostMapping("/send-with-file")
//    public ResponseEntity<CustomResponse> sendWithFile(@RequestBody EmailRequest request , @RequestParam MultipartFile file) throws IOException {
//         emailService.sendEmailWithFile(request.getTo() ,request.getSubject(),request.getMessage(), file.getInputStream());
//    }
}
