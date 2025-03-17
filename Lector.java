import java.io.*;
import java.util.*;

public class Lector {
    public static Map<String, Pokemon> cargarPokemonsDesdeCSV(String rutaArchivo) {
        Map<String, Pokemon> pokemonMap = new HashMap<>()();
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Omite los encabezados
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                
                if (datos.length < 10) continue; // Verificar que tenga suficientes columnas
                
                String name = datos[1].trim();
                String type1 = datos[2].trim();
                String type2 = datos[3].trim().isEmpty() ? "None" : datos[3].trim();
                int total = Integer.parseInt(datos[4].trim());
                int hp = Integer.parseInt(datos[5].trim());
                int attack = Integer.parseInt(datos[6].trim());
                int defense = Integer.parseInt(datos[7].trim());
                int spAttack = Integer.parseInt(datos[8].trim());
                int spDefense = Integer.parseInt(datos[9].trim());
                int speed = Integer.parseInt(datos[10].trim());
                
                List<String> abilities = new ArrayList<>();
                if (datos.length > 11) {
                    String[] abilitiesArray = datos[11].replace("[", "").replace("]", "").split(";");
                    for (String ability : abilitiesArray) {
                        abilities.add(ability.trim());
                    }
                }
                
                // Crear objeto Pokemon y agregarlo al mapa
                Pokemon pokemon = new Pokemon(name, type1, type2, total, hp, attack, defense, spAttack, spDefense, speed, abilities);
                pokemonMap.put(name, pokemon);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        
        return pokemonMap;
    }
}