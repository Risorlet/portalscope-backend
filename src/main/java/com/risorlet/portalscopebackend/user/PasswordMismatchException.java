package com.risorlet.portalscopebackend.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class PasswordMismatchException extends RuntimeException{
    PasswordMismatchException() {
        super("Incorrect password Entered!");
    }
}
