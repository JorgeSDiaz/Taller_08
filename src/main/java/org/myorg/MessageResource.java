package org.myorg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.myorg.model.Message;
import org.myorg.service.MessageService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/message")
public class MessageResource {
    @Inject
    MessageService messageService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response lastMessages() {
        try {
            return Response.ok("{\"data\": " + new ObjectMapper().writeValueAsString(messageService.list()) + "}").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMessage(Message newMessage) {
        try {
            return Response.ok("{\"data\": " + new ObjectMapper().writeValueAsString(messageService.add(newMessage)) + "}").build();
        } catch (JsonProcessingException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        }
    }

}
