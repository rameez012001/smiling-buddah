package com.smiling.buddah.controller;

import com.smiling.buddah.entity.User;
import com.smiling.buddah.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController{
    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    ResponseEntity<String> createUser(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }

    @PostMapping("/{username}/follow")
    ResponseEntity<?> followUser(@PathVariable String username){
        return userService.followUser(getCurrentUser(),username);
    }

    @PostMapping("/{username}/ufollow")
    ResponseEntity<?> unFollowUser(@PathVariable String username){
        return userService.unFollowUser(getCurrentUser(),username);
    }

    @GetMapping("/{username}/followers")
    public ResponseEntity<Set<String>> getFollowers(@PathVariable String username) {
        return userService.followers(username);
    }

    @GetMapping("/{username}/followings")
    public ResponseEntity<Set<String>> getFollowings(@PathVariable String username) {
        return userService.followings(username);
    }

}
