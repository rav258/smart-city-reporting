package com.smartcity.reporting.admin.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/admin/reports")
@Produces(MediaType.APPLICATION_JSON)
public class AdminReportResource {

    @GET
    @RolesAllowed("ADMIN")
    public String getAllReports() {
        return "Only admin can access this";
    }
}
