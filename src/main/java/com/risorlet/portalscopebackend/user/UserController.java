package com.risorlet.portalscopebackend.user;

import java.util.*;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import lombok.*;


@AllArgsConstructor
@RestController
@RequestMapping("/portalscope/users")
public class UserController {

    private UserRepository userRepository; // dependency injection by constructor
    private BCryptPasswordEncoder encoder;

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        
        String encodedPasssord = encoder.encode(user.getPassword());
        user.setPassword(encodedPasssord);
        User newUser = userRepository.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<User> validateUser(@RequestBody UserDto userdto) {
        User user = userRepository.findByEmail(userdto.getEmail())
                            .orElseThrow(() -> new UserNotFoundException(userdto.getEmail()));
        
        String passwordEntered = userdto.getPassword();
        if(!encoder.matches(passwordEntered, user.getPassword())) {
            throw new PasswordMismatchException();
        }
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        User requestedUser = userRepository.findById(userId)
                                .orElseThrow(() -> new UserNotFoundException(userId.toString()));
        return ResponseEntity.ok(requestedUser);
    }

    @CrossOrigin
    @GetMapping("auth/{userEmail}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String userEmail) {
        User requestedUser = userRepository.findByEmail(userEmail)
                                .orElseThrow(() -> new UserNotFoundException(userEmail));
        return ResponseEntity.ok(requestedUser);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User updatedUser) {

        User user = userRepository.save(updatedUser);
        return ResponseEntity.ok(user);
    }

    @CrossOrigin
    @DeleteMapping("{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer userId) {
        User deletedUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId.toString()));
        userRepository.deleteById(userId);
        return ResponseEntity.ok(deletedUser);
    }
}
