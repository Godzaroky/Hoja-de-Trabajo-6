import java.util.*;

public class PokemonManager {
    private Map<String, Pokemon> pokemonMap;
    private Map<String, Pokemon> coleccionUsuario;

    public PokemonManager(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
        this.coleccionUsuario = new HashMap<>(); // Se puede cambiar la implementación
    }

    public void agregarPokemon(String nombre) {
        if (!pokemonMap.containsKey(nombre)) {
            System.out.println("Error: Pokémon no encontrado en la base de datos.");
            return;
        }
        if (coleccionUsuario.containsKey(nombre)) {
            System.out.println("Este Pokémon ya está en tu colección.");
        } else {
            coleccionUsuario.put(nombre, pokemonMap.get(nombre));
            System.out.println(nombre + " agregado a tu colección.");
        }
    }

    public void mostrarPokemon(String nombre) {
        if (pokemonMap.containsKey(nombre)) {
            System.out.println(pokemonMap.get(nombre));
        } else {
            System.out.println("Pokémon no encontrado.");
        }
    }

    public void mostrarColeccionOrdenadaPorTipo() {
        coleccionUsuario.values().stream()
            .sorted(Comparator.comparing(Pokemon::getTipo1))
            .forEach(System.out::println);
    }

    public void mostrarTodosOrdenadosPorTipo() {
        pokemonMap.values().stream()
            .sorted(Comparator.comparing(Pokemon::getTipo1))
            .forEach(System.out::println);
    }

    public void buscarPorHabilidad(String habilidad) {
        pokemonMap.values().stream()
            .filter(p -> p.getHabilidades().contains(habilidad))
            .forEach(System.out::println);
    }

    public Map<String, Pokemon> getColeccionUsuario() {
        return coleccionUsuario;
    }
}