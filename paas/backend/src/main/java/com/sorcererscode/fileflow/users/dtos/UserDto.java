package com.sorcererscode.fileflow.users.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private Boolean active;
}
