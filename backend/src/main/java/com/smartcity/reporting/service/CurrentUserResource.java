package com.smartcity.reporting.service;

import com.smartcity.reporting.security.dto.CurrentUserResponse;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/auth")
@Produces(MediaType.APPLICATION_JSON)
public class CurrentUserResource {

    @Inject
    CurrentUserService currentUserService;

    @GET
    @Path("/me")
    @RolesAllowed({"CITIZEN", "ADMIN", "WORKER", "MODERATOR"})
    public CurrentUserResponse me() {
        return currentUserService.getCurrentUser();
    }
}
