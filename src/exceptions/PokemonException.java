package exceptions;
//clase para validar excepciones

public class PokemonException extends Exception {

    //  recibe cualquier mensaje
    public PokemonException(String message) {
        super(message);
    }

    // Subclase para cuando un pokemon no existe
    public static class NotFound extends PokemonException {
        public NotFound(String name) {
            super("Pokémon " + name + " no encontrado.");
        }
    }

    // Subclase para errores de servidor o red
    public static class ApiError extends PokemonException {
        public ApiError(int statusCode) {
            super("Error en el servidor de PokeAPI. Código HTTP: " + statusCode);
        }
    }

    // Subclase para cuando no se ingresa texto o se deja el placeholder
    public static class InvalidName extends PokemonException {
        public InvalidName() {
            super("Por favor, ingresa el nombre de un Pokémon.");
        }
    }
}
