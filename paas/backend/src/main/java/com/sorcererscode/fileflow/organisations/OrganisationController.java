package com.sorcererscode.fileflow.organisations;

import com.sorcererscode.fileflow.organisations.dtos.OrganisationInput;
import com.sorcererscode.fileflow.organisations.dtos.OrganisationResponse;
import com.sorcererscode.fileflow.organisations.services.OrganisationService;
import com.sorcererscode.fileflow.users.User;
import com.sorcererscode.fileflow.users.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/organisations")
public class OrganisationController {

    @Autowired
    private OrganisationService organisationService;

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<OrganisationResponse> createOrganisation(@RequestBody OrganisationInput input)
            throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated())
        {
            throw new Exception("Incorrect authentication details");
        }

        String username = authentication.getName();
        Optional<User> user = userService.findUserByEmail(username);

        if (user.isEmpty()) {
            throw new Exception("Incorrect authentication details");
        }

        OrganisationResponse response = organisationService.create(input, user.get());
        return ResponseEntity.ok(response);
    }

    @GetMapping("user-organisations")
    public ResponseEntity<List<OrganisationResponse>> getUserOrganisations(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) throws Exception {

        if (page < 1 || limit < 1) {
            throw new IllegalArgumentException("Page or limit should be greater than 0");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated())
        {
            throw new Exception("Incorrect authentication details");
        }

        String username = authentication.getName();
        Optional<User> user = userService.findUserByEmail(username);

        if (user.isEmpty()) {
            throw new Exception("Incorrect authentication details");
        }
        List<OrganisationResponse> userOrganisations = organisationService.getUserOrganisations(user.get(), page, limit);
        return ResponseEntity.of(Optional.ofNullable(userOrganisations));
    }


    @GetMapping("{id}")
    public ResponseEntity<OrganisationResponse> getOrganisationById(
            @PathVariable("id") long id
    ) {
        OrganisationResponse response = organisationService.get(id);
        return ResponseEntity.ok(response);
    }

}
