package com.sorcererscode.fileflow.auth.dtos;

import com.sorcererscode.fileflow.users.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String token;
    private UserDto user;
}
