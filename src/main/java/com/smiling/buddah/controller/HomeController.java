package com.smiling.buddah.controller;

import com.smiling.buddah.entity.User;
import com.smiling.buddah.service.SuggestionService;
import com.smiling.buddah.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/home")
public class HomeController extends AbstractController{

    @Autowired
    private SuggestionService service;
    @GetMapping
    public ResponseEntity<List<User>> getHomePage(@ModelAttribute Model model){
        return getUserService().getAllUser();
    }

    @GetMapping("/suggestions")
    public ResponseEntity<Set<User>> suggestUsers(){
        User currentUser = getCurrentUser();
        service.suggestUserByMutuals(currentUser);
    }
}