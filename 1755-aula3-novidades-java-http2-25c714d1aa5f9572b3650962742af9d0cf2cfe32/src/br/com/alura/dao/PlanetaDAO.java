package br.com.alura.dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class PlanetaDAO {

    public void listar() throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        var uri = new URI("https://www.google.com");
        var request = HttpRequest.newBuilder().uri(uri).build();

        httpClient.sendAsync(request, BodyHandlers.ofString())
                .whenComplete((response, error) -> System.out.println(response.body()));
    }
}
