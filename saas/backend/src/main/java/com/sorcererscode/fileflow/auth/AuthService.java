package com.sorcererscode.fileflow.auth;

import com.sorcererscode.fileflow.auth.dtos.LoginResponse;
import com.sorcererscode.fileflow.auth.dtos.UserLogin;
import com.sorcererscode.fileflow.users.dtos.UserInput;

import javax.security.auth.login.LoginException;

public interface AuthService {
    LoginResponse loginUser(UserLogin input) throws LoginException;
    LoginResponse registerUser(UserInput input);
}
