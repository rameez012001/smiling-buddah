package com.smiling.buddah.service;

import com.smiling.buddah.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UserService {
    void createUser(User user);
    ResponseEntity<List<User>> getAllUser();
    User getCurrentUser(String username);
    ResponseEntity<String> followUser(User currentUser,String username);
    ResponseEntity<String> unFollowUser(User currentUser,String username);
    ResponseEntity<Set<String>> followings(String username);
    ResponseEntity<Set<String>> followers(String username);
}
