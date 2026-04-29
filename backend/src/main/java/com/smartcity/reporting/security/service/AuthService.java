package com.smartcity.reporting.security.service;

import com.smartcity.reporting.security.dto.AuthResponse;
import com.smartcity.reporting.security.dto.LoginRequest;
import com.smartcity.reporting.security.dto.RegisterRequest;
import com.smartcity.reporting.user.entity.Role;
import com.smartcity.reporting.user.entity.User;
import com.smartcity.reporting.user.repository.RoleRepository;
import com.smartcity.reporting.user.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class AuthService {

    @Inject
    UserRepository userRepository;

    @Inject
    RoleRepository roleRepository;

    @Transactional
    public void register(RegisterRequest request) {
        String email = request.getEmail().trim().toLowerCase();

        if (userRepository.existsByEmail(email)) {
            throw new WebApplicationException("Email is already in use", Response.Status.CONFLICT);
        }

        Role citizenRole = roleRepository.findByName("CITIZEN")
                .orElseThrow(() -> new WebApplicationException("Default role CITIZEN not found", Response.Status.INTERNAL_SERVER_ERROR));

        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(BcryptUtil.bcryptHash(request.getPassword()));
        user.setFirstName(request.getFirstName().trim());
        user.setLastName(request.getLastName().trim());
        user.setActive(true);
        user.addRole(citizenRole);

        userRepository.persist(user);
    }

    public AuthResponse login(LoginRequest request) {
        String email = request.getEmail().trim().toLowerCase();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new WebApplicationException("Invalid email or password", Response.Status.UNAUTHORIZED));

        if (Boolean.FALSE.equals(user.getActive())) {
            throw new WebApplicationException("User account is inactive", Response.Status.FORBIDDEN);
        }

        boolean passwordMatches = BcryptUtil.matches(request.getPassword(), user.getPasswordHash());
        if (!passwordMatches) {
            throw new WebApplicationException("Invalid email or password", Response.Status.UNAUTHORIZED);
        }

        Set<String> roles = user.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        String token = Jwt.issuer("smart-city-reporting")
                .upn(user.getEmail())
                .subject(String.valueOf(user.getId()))
                .groups(roles)
                .expiresIn(Duration.ofHours(12))
                .sign();

        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}
