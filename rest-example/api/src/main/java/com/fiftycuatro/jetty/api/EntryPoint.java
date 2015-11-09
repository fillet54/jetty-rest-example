package com.fiftycuatro.jetty.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/entry")
public interface EntryPoint {
   @GET
   @Path("test")
   @Produces(MediaType.APPLICATION_JSON)
   public SampleDTO test(); 
}
