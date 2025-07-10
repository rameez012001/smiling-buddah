package com.smiling.buddah.service;

import com.smiling.buddah.entity.User;
import org.springframework.http.ResponseEntity;

public interface SuggestionService {
    ResponseEntity<?> suggestUserByMutuals(User currentUser);
}
