package com.risorlet.portalscopebackend.user;

public class Mapper {

    public static User toUser (UserDto userDto) {
        return new User(
            userDto.getId(),
            userDto.getFirstName(),
            userDto.getLastName(),
            userDto.getEmail(),
            userDto.getPassword(),
            userDto.getIsAdmin()
        );
    }

    public static UserDto toUserDto (User user) {
        return new UserDto(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getPassword(),
            user.getIsAdmin()
        );
    }
}
