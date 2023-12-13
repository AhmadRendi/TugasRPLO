package com.example.tugasrplo.controller;

import com.example.tugasrplo.dto.request.LoginUserDto;
import com.example.tugasrplo.service.impl.ServiceUserImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    private ServiceUserImpl user;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginUserDto loginUserDto){
        return ResponseEntity.ok(user.loginUser(loginUserDto));
    }
}
