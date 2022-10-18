package com.smallAPI.smallAPI.h2.controller;

import com.smallAPI.smallAPI.h2.services.MockUserGenerateSevice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mockusers")
public class MockUserController {

    private MockUserGenerateSevice mockUserGenerateSevice;

    public MockUserController(MockUserGenerateSevice mockUserGenerateSevice) {
        this.mockUserGenerateSevice = mockUserGenerateSevice;
    }

    @GetMapping("/generate")
    public void generateDummyUsers() {
        mockUserGenerateSevice.generateAccounts();
    }


}
