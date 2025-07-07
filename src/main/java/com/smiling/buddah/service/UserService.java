package com.smiling.buddah.service;

import com.smiling.buddah.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void createUser(User user);
    ResponseEntity<List<User>> getAllUser();
}
