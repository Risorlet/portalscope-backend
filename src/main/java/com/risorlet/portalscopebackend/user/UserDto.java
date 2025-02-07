package com.risorlet.portalscopebackend.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String password = "";
    private Boolean isAdmin = false;
}
