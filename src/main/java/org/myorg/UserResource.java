package org.myorg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.myorg.model.User;
import org.myorg.persistence.UserServiceException;
import org.myorg.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/user")
public class UserResource {
    @Inject
    UserService userService;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() throws JsonProcessingException {
        return Response.ok("{\"data\": " + new ObjectMapper().writeValueAsString(userService.list()) + "}").build();
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User newUser) throws JsonProcessingException {
        return Response.ok("{\"data\": " + new ObjectMapper().writeValueAsString(userService.add(newUser)) + "}").build();
    }

    @POST
    @Path("/log-in")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logIn(User user) {
        try {
            return Response.ok("{\"data\": " + new ObjectMapper().writeValueAsString(userService.check(user)) + "}").build();
        } catch (UserServiceException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        } catch (JsonProcessingException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        }
    }
}
