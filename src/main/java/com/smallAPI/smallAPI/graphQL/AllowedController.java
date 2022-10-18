package com.smallAPI.smallAPI.graphQL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllowedController {

    @Value("${allowed}")
    public Boolean allowed;

    @QueryMapping
    public Boolean getAllowed() {
        return allowed;
    }
}
