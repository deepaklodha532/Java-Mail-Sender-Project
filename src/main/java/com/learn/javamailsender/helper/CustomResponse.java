package com.learn.javamailsender.helper;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class CustomResponse {
    private String message;
    private HttpStatus httpStatus ;
    private boolean success = false;
}
