import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de mapa a utilizar (hash, tree, linked):");
        String mapType = scanner.nextLine();
        PokemonManager manager = new PokemonManager(mapType);
        
        Map<String, Pokemon> allPokemon = PokemonDataLoader.loadPokemon(); // Carga los datos desde un archivo
        
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar un Pokémon a la colección");
            System.out.println("2. Mostrar los datos de un Pokémon");
            System.out.println("3. Mostrar colección ordenada por tipo1");
            System.out.println("4. Mostrar todos los Pokémon ordenados por tipo1");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon a agregar: ");
                    String nombre = scanner.nextLine();
                    if (allPokemon.containsKey(nombre)) {
                        System.out.println(manager.addPokemon(allPokemon.get(nombre)));
                    } else {
                        System.out.println("Error: El Pokémon no existe en los datos.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String buscarNombre = scanner.nextLine();
                    System.out.println(manager.getPokemon(buscarNombre));
                    break;
                case 3:
                    System.out.println("Pokémon en la colección ordenados por tipo1:");
                    for (Pokemon p : manager.getPokemonSortedByType()) {
                        System.out.println(p.getNombre() + " - " + p.getTipo1());
                    }
                    break;
                case 4:
                    System.out.println("Todos los Pokémon ordenados por tipo1:");
                    List<Pokemon> sortedList = new ArrayList<>(allPokemon.values());
                    sortedList.sort(Comparator.comparing(Pokemon::getTipo1));
                    for (Pokemon p : sortedList) {
                        System.out.println(p.getNombre() + " - " + p.getTipo1());
                    }
                    break;
                case 5:
                    System.out.print("Ingrese la habilidad a buscar: ");
                    String habilidad = scanner.nextLine();
                    System.out.println("Pokémon con la habilidad " + habilidad + ":");
                    for (Pokemon p : allPokemon.values()) {
                        if (p.getHabilidades().contains(habilidad)) {
                            System.out.println(p.getNombre());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}