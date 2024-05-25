package com.sorcererscode.fileflow.config;

import com.sorcererscode.fileflow.users.Role;
import com.sorcererscode.fileflow.users.User;
import com.sorcererscode.fileflow.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataSeeding {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {

            if (userRepository.count() == 0) {
                User admin = new User();
                admin.setFirstName("System");
                admin.setLastName("Administrator");
                admin.setEmail("admin@fileflow.org");
                admin.setPassword(passwordEncoder.encode("secretpassword123"));
                admin.setActive(true);
                admin.setRole(Role.ROLE_ADMIN);

                userRepository.save(admin);
            }

        };
    }
}
