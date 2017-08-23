package com.lvdveekens.examples;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ExampleClient {

    public static void main(String[] args) {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8081/api/example");

        String response = webResource.type("application/json").get(String.class);
        System.out.println(response);
    }
}
