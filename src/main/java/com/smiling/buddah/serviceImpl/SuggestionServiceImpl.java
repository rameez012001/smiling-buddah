package com.smiling.buddah.serviceImpl;

import com.smiling.buddah.entity.User;
import com.smiling.buddah.service.SuggestionService;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SuggestionServiceImpl implements SuggestionService {
    @Override
    public ResponseEntity<?> suggestUserByMutuals(User currentUser) {
        Set<User> alreadyFollowing = currentUser.getFollowings();
        Map<User, Long> mutualCountMap = currentUser.getFollowings().stream()
                .flatMap(friend -> friend.getFollowings().stream())
                .filter(suggested -> !suggested.equals(currentUser))
                .filter(suggested -> !alreadyFollowing.contains(suggested))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return ResponseEntity.ok(mutualCountMap.entrySet().stream()
                .sorted(Map.Entry.<User, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet()));
    }
}
