package exceptions;
//clase para validar excepciones

public class PokemonException  extends Exception{

    public PokemonException(String name) {
        super("Pokemon no encontrado" +  name);
    }
}
