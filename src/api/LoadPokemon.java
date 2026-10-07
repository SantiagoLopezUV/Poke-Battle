package api;

import model.Pokemon;
import org.json.JSONObject;

public class LoadPokemon {

    private LoadPokemon() { }

    public static Pokemon load(String name) throws Exception {
        String jsonBody = PokeApiClient.fetchJson(name);
        JSONObject json = new JSONObject(jsonBody);

        Pokemon pokemon = new Pokemon();
        pokemon.setId(json.getInt("id"));
        pokemon.setName(json.getString("name"));
        pokemon.setUrlSprite(json.getJSONObject("sprites").getString("front_default"));

        PokeApiParser.parseType(json, pokemon);
        PokeApiParser.parseStats(json, pokemon);

        return pokemon;
    }
}