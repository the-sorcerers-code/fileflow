package com.sorcererscode.fileflow.auth;

import com.sorcererscode.fileflow.auth.dtos.LoginResponse;
import com.sorcererscode.fileflow.auth.dtos.LoginInput;
import com.sorcererscode.fileflow.users.dtos.UserInput;

import javax.security.auth.login.LoginException;

public interface AuthService {
    LoginResponse loginUser(LoginInput input) throws LoginException;
    LoginResponse registerUser(UserInput input);
}
