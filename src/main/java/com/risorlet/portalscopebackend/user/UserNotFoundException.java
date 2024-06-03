package com.risorlet.portalscopebackend.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    
    UserNotFoundException(String credential) {
        super("The user with {" + credential + "} doesn't exist!");
    }
}
