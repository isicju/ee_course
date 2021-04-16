package com.eecourse.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
public class SimpleRestApi {
    @GET
    public Response getMsg() {
        return Response.status(200).entity("{}").build();
    }
}
