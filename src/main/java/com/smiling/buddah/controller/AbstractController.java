package com.smiling.buddah.controller;

import com.smiling.buddah.entity.User;
import com.smiling.buddah.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public class AbstractController {
    @Autowired
    private UserService userService;

    protected User getCurrentUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.getCurrentUser(username);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
