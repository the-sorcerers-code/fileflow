package com.sorcererscode.fileflow.users;

import com.sorcererscode.fileflow.users.dtos.UserInput;

import java.util.Optional;

public interface UserService {

    User create(UserInput input);

    Optional<User> findUserByEmail(String email);

    User get(long id);
}
