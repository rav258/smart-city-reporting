package com.smartcity.reporting.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CurrentUserResponse {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Set<String> roles;

    public CurrentUserResponse(Long id, String email, String firstName, String lastName, Set<String> roles) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }

}
