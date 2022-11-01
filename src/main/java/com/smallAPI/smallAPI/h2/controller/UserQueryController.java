package com.smallAPI.smallAPI.h2.controller;

import com.smallAPI.smallAPI.h2.models.User;
import com.smallAPI.smallAPI.h2.services.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("users")
public class UserQueryController {

    @Autowired
    private Environment environment;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Value("${allowed}")
    public String allowed;

    private final UserQueryService userQueryService;

    public UserQueryController(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    public void fireRefreshEvent() {
        eventPublisher.publishEvent(new RefreshEvent(this, "RefreshEvent", "Refreshing scope"));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "userId") Long userId) {
        this.fireRefreshEvent();
        Boolean allowed = Boolean.parseBoolean(environment.getProperty("allowed"));
        System.out.println(allowed);
        Optional<User> userOpt = userQueryService.getUserById(userId);
        if (userOpt.isPresent() && allowed) {
            return new ResponseEntity<>(userOpt.get(), HttpStatus.OK);
        } else
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> userData) {
        System.out.println(userData);
        return new ResponseEntity<>(userQueryService.createUser(userData), HttpStatus.OK);
    }

}
