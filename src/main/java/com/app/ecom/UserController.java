package com.app.ecom;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

   private final UserService userService;

    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        return userService.fetchAllUsers();
    }


    @PostMapping("/api/users")
    public String  createUser(@RequestBody User user){
        userService.addUser(user);
        return "User added successfully";
    }
}
