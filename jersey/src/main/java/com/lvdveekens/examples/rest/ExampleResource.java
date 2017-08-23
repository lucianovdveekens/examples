package com.lvdveekens.examples.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/example")
public class ExampleResource {

    @GET
    public String getSomething() {
        return "Hello there!";
    }
}
