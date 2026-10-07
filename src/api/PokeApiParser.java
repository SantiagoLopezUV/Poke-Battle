package api;

import model.Pokemon;
import org.json.JSONArray;
import org.json.JSONObject;

public class PokeApiParser {

    private PokeApiParser() { } //evita que se creen objetos nuevos

    // tipos
    public static void parseType(JSONObject json, Pokemon pokemon)
    {
        JSONArray types = json.getJSONArray("types");
        String primaryType = types.getJSONObject(0)
                .getJSONObject("type")
                .getString("name");
        pokemon.setType(primaryType);
    }

    // stats pokemon
    public static void parseStats(JSONObject json, Pokemon pokemon)
    {
        JSONArray stats = json.getJSONArray("stats");

        for (int i = 0; i < stats.length(); i++)
        {
            JSONObject entry = stats.getJSONObject(i);
            String statName = entry.getJSONObject("stat").getString("name");
            int baseStat = entry.getInt("base_stat");

            switch (statName)
            {
                case "hp" ->
                {
                    pokemon.setHp(baseStat);
                    pokemon.setCurrentHp(baseStat); // el hp total del pokemon
                }
                case "attack" -> pokemon.setAttack(baseStat);
                case "defense" -> pokemon.setDefense(baseStat);
                case "speed" -> pokemon.setSpeed(baseStat);
            }
        }
    }
}