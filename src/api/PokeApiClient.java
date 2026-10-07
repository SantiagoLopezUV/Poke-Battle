package api;

import exceptions.PokemonException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PokeApiClient {

    private static final String url = "https://pokeapi.co/api/v2/pokemon/"; //Llamar la url, en un atributo inmutable
    private static HttpClient client;

    public PokeApiClient(){
        this.client = HttpClient.newHttpClient();
    }

    public static String fetchJson(String pokemonName) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + pokemonName))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString()); //peticion que convierte la respuesta a string

        //se ejecuta primero, si no encuentra nada devuelve la excepcion
        if (response.statusCode() == 404) {
            throw new PokemonException.NotFound(pokemonName);
        }
        if (response.statusCode() != 200) { //si cualquier otro diferente de 200 se interrumpe
            throw new PokemonException.ApiError(response.statusCode());
        }
        //si no se cumple lo anterior, devuelve el JSON
        return response.body(); // JSON como String
    }
}

