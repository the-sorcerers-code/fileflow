package com.sorcererscode.fileflow.common.services;

import com.sorcererscode.fileflow.users.User;
import com.sorcererscode.fileflow.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public @NonNull Optional<String> getCurrentAuditor() {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        User currentUser = userRepository.findByEmail(currentUserEmail).orElse(null);

        String userFullName = currentUser != null ?
                String.format("%s %s", currentUser.getFirstName(), currentUser.getLastName()) :
                "Unknown User";

        return Optional.of(userFullName);
    }
}
