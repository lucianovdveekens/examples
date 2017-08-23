package com.lvdveekens.examples;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ExampleClient {

    public static void main(String[] args) {
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8081/api/example");

        ClientResponse clientResponse = webResource.type("application/json").get(ClientResponse.class);
        System.out.println(clientResponse);
        String entity = clientResponse.getEntity(String.class);
        System.out.println(entity);
    }
}
