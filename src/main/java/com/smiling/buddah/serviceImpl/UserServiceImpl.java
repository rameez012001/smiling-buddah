package com.smiling.buddah.serviceImpl;

import com.smiling.buddah.entity.User;
import com.smiling.buddah.repository.UserRepository;
import com.smiling.buddah.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        userRepository.save(user);
    }

    @Override
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public User getCurrentUser(String username) {
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("user not found"));
    }

    @Override
    public ResponseEntity<String> followUser(User currentUser, String username) {
        User target = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        if (target.equals(currentUser)) {
            return ResponseEntity.badRequest().body("You can't follow yourself.");
        }

        target.getFollowers().add(currentUser);
        userRepository.save(target);
        return ResponseEntity.ok("Followed " + username);
    }

    @Override
    public ResponseEntity<String> unFollowUser(User currentUser, String username) {
        User target = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        if (target.equals(currentUser)) {
            return ResponseEntity.badRequest().body("You can't follow yourself.");
        }

        target.getFollowers().remove(currentUser);
        userRepository.save(target);
        return ResponseEntity.ok("UnFollowed " + username);
    }

    @Override
    public ResponseEntity<Set<String>> followings(String username) {
        User target = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Set<String> followingNames = target.getFollowings().stream()
                .map(User::getUsername)
                .collect(Collectors.toSet());

        return ResponseEntity.ok(followingNames);
    }

    @Override
    public ResponseEntity<Set<String>> followers(String username) {
        User target = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Set<String> followerNames = target.getFollowers().stream()
                .map(User::getUsername)
                .collect(Collectors.toSet());

        return ResponseEntity.ok(followerNames);
    }


}
