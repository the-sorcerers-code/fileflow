package com.sorcererscode.fileflow.auth;

import com.sorcererscode.fileflow.auth.dtos.LoginResponse;
import com.sorcererscode.fileflow.auth.dtos.UserLogin;
import com.sorcererscode.fileflow.security.JwtService;
import com.sorcererscode.fileflow.users.User;
import com.sorcererscode.fileflow.users.UserService;
import com.sorcererscode.fileflow.users.dtos.UserDto;
import com.sorcererscode.fileflow.users.dtos.UserInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Override
    public LoginResponse loginUser(UserLogin input) throws LoginException {
        authenticateUser(input.getEmail(), input.getPassword());

        User user = userService.findUserByEmail(input.getEmail())
                .orElseThrow(() -> new LoginException("Invalid credentials."));

        String jwtToken = jwtService.generateJwtToken(user);
        return LoginResponse.builder()
                .token(jwtToken)
                .user(modelMapper.map(user, UserDto.class))
                .build();
    }

    @Override
    public LoginResponse registerUser(UserInput input) {
        User user = userService.create(input);
        String jwtToken = jwtService.generateJwtToken(user);
        return LoginResponse.builder()
                .token(jwtToken)
                .user(modelMapper.map(user, UserDto.class))
                .build();
    }

    private void authenticateUser(String username, String password) throws LoginException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            username,
                            password
                    )
            );
        }catch (BadCredentialsException ex) {
            throw new LoginException("Incorrect username or password");
        } catch (DisabledException ex) {
            throw new LoginException("Your account has been disabled. Please contact the system administrator.");
        }
    }
}
