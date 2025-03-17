import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PokemonManager {
    private Map<String, Pokemon> pokemonCollection;

    public PokemonManager(String mapType) {
        this.pokemonCollection = PokemonMapFactory.createMap(mapType);
    }

    public String addPokemon(Pokemon pokemon) {
        if (pokemonCollection.containsKey(pokemon.getNombre())) {
            return "El Pokémon " + pokemon.getNombre() + " ya está en la colección.";
        }
        pokemonCollection.put(pokemon.getNombre(), pokemon);
        return "Pokémon " + pokemon.getNombre() + " agregado correctamente.";
    }

    public String getPokemon(String name) {
        if (pokemonCollection.containsKey(name)) {
            return pokemonCollection.get(name).toString();
        }
        return "Pokémon no encontrado.";
    }

    public List<Pokemon> getPokemonSortedByType() {
        List<Pokemon> sortedList = new ArrayList<>(pokemonCollection.values());
        sortedList.sort((p1, p2) -> p1.getTipo1().compareTo(p2.getTipo1()));
        return sortedList;
    }

    public void displayCollection() {
        if (pokemonCollection.isEmpty()) {
            System.out.println("No hay Pokémon en la colección.");
            return;
        }
        for (Pokemon p : pokemonCollection.values()) {
            System.out.println(p);
        }
    }
}