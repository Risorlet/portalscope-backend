package com.risorlet.portalscopebackend.user;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserPasswordEncoder {

    @Bean
    public BCryptPasswordEncoder bcpe () {
        return new BCryptPasswordEncoder();
    }
}
