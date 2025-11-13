/**CONTROLLER CLASS CONTROLS THE HTTP REQUESTS**/
package com.capstoneproject.musicplatform.controller;

import com.capstoneproject.musicplatform.model.Artist;
import com.capstoneproject.musicplatform.model.User;
import com.capstoneproject.musicplatform.service.UserService;
import org.springframework.http.ResponseEntity;       //For http requests
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController         //Indicate RESTapi controller
@RequestMapping("api/users")       //Endpoint path
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {     //Dependency injection
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }


    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username){     //Path variable passes URL username to getUser method
        Optional<User> user = userService.findByUserName(username);      //Search by username
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());   //Return 200 or 404
    }
}
