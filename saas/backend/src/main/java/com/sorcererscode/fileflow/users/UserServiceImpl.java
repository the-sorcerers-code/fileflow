package com.sorcererscode.fileflow.users;

import com.sorcererscode.fileflow.users.dtos.UserInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User create(UserInput input) {
        User user = mapper.map(input, User.class);
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
