package com.sorcererscode.fileflow.users.dtos;

import lombok.Data;

@Data
public class UserInput {
    private String email;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
}
