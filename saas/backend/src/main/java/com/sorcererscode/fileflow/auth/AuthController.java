package com.sorcererscode.fileflow.auth;

import com.sorcererscode.fileflow.auth.dtos.LoginResponse;
import com.sorcererscode.fileflow.auth.dtos.UserLogin;
import com.sorcererscode.fileflow.users.dtos.UserInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody UserLogin request)
            throws LoginException {
        LoginResponse response = authService.loginUser(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<LoginResponse> signup(@RequestBody UserInput request) {
        LoginResponse response = authService.registerUser(request);
        return ResponseEntity.ok(response);
    }

}
