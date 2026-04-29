package com.smartcity.reporting.service;

import com.smartcity.reporting.security.dto.CurrentUserResponse;
import com.smartcity.reporting.user.entity.User;
import com.smartcity.reporting.user.repository.UserRepository;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class CurrentUserService {

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    UserRepository userRepository;

    public CurrentUserResponse getCurrentUser() {
        String email = securityIdentity.getPrincipal().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new WebApplicationException("Authenticated user not found", Response.Status.NOT_FOUND));

        return new CurrentUserResponse(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                securityIdentity.getRoles()
        );
    }
}
