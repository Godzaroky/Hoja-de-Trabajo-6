import java.io.*;
import java.util.*;

public class PokemonDataLoader {
    public static Map<String, Pokemon> loadPokemon() {
        Map<String, Pokemon> pokemonMap = new HashMap<>();
        String file = "C:\\UVG\\HDT-6\\archive.zip";
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 11) continue; // Validación de datos
                
                String nombre = data[0];
                String tipo1 = data[1];
                String tipo2 = data[2].equals("null") ? "" : data[2];
                int total = Integer.parseInt(data[3]);
                int hp = Integer.parseInt(data[4]);
                int ataque = Integer.parseInt(data[5]);
                int defensa = Integer.parseInt(data[6]);
                int spAtaque = Integer.parseInt(data[7]);
                int spDefensa = Integer.parseInt(data[8]);
                int velocidad = Integer.parseInt(data[9]);
                List<String> habilidades = Arrays.asList(data[10].split(";"));
                
                Pokemon pokemon = new Pokemon(nombre, tipo1, tipo2, total, hp, ataque, defensa, spAtaque, spDefensa, velocidad, habilidades);
                pokemonMap.put(nombre, pokemon);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return pokemonMap;
    }
}