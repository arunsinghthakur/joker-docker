package com.joker.api;

import com.joker.domain.User;
import com.joker.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserAPI {

    UserService userService;

    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(User user) {
        userService.save(user);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public User getUser(@PathParam("id") Long userId) {
        return userService.getUser(userId);
    }

    @POST
    @Path("/createtable")
    public void createUserTable() {
        userService.createUserTable();
    }
}
