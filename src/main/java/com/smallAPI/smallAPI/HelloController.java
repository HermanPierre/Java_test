package com.smallAPI.smallAPI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${allowed}")
    private String configValue;

    @GetMapping("/")
    public String index() {
        return "Hello from Pierre ! :)";
    }
}
