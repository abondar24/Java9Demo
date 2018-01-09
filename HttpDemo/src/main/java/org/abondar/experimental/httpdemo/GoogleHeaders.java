package org.abondar.experimental.httpdemo;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GoogleHeaders {

    public static void main(String[] args) {
        try {
            URI google = new URI("http://www.google.com");
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder(google)
                    .method("HEAD", HttpRequest.noBody())
                    .build();

            HttpResponse<?> response = client.send(request,HttpResponse.BodyHandler.discard(null));

            System.out.printf("Response code: %d\n",response.statusCode());

            System.out.println("Headers: ");
            response.headers()
                    .map()
                    .entrySet()
                    .forEach(System.out::println);
        } catch (URISyntaxException | InterruptedException | IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
