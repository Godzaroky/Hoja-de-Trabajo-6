import java.io.*;
import java.util.*;

public class Lector {
     
    public static Map<String, Pokemon> cargarPokemonsDesdeCSV(String rutaArchivo) {
        Map<String, Pokemon> pokemonMap = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Omitir la primera línea (encabezados)
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                
                if (datos.length < 10) continue; // Verificar que tenga suficientes columnas
                
                String nombre = datos[1].trim();
                String tipo1 = datos[2].trim();
                String tipo2 = datos[3].trim().isEmpty() ? "None" : datos[3].trim();
                int total = Integer.parseInt(datos[4].trim());
                int hp = Integer.parseInt(datos[5].trim());
                int ataque = Integer.parseInt(datos[6].trim());
                int defensa = Integer.parseInt(datos[7].trim());
                int spAtaque = Integer.parseInt(datos[8].trim());
                int spDefensa = Integer.parseInt(datos[9].trim());
                int velocidad = Integer.parseInt(datos[10].trim());
                
                // La columna de habilidades no es consistente, así que debemos manejarla
                List<String> habilidades = new ArrayList<>();
                if (datos.length > 11) {
                    String[] habilidadesArray = datos[11].replace("[", "").replace("]", "").split(";");
                    for (String ability : habilidadesArray) {
                        habilidades.add(ability.trim());
                    }
                }
                
                // Crear objeto Pokemon y agregarlo al mapa
                Pokemon pokemon = new Pokemon(nombre, tipo1, tipo2, total, hp, ataque, defensa, spAtaque, spDefensa, velocidad, habilidades);
                pokemonMap.put(nombre, pokemon);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        
        return pokemonMap;
    }
}