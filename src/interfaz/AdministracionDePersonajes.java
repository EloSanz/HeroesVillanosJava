package interfaz;
import java.util.Map;
import java.util.Scanner;
import Excepciones.CaracteristicaNegativaException;
import archivos.Archivo;
import heroesVillanos.*;

public class AdministracionDePersonajes {
    
    public static void administrador( Map<String,Competidor>  competidores) {
        Scanner scanner = new Scanner(System.in);
        String mensaje = "1) Carga desde archivo.\n" +
                "2) Creación de personaje.\n" +
                "3) Listado de personajes.\n" +
                "4) Guardar en archivo todos los personajes.\n" +
                "5) Volver al menú principal.";
    
        int opcion;
        do {
            System.out.println("\nAdministracion de Personajes.\n--------------------------------");
            opcion = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 5, scanner);
    
            switch (opcion) {
                case 1:
                    cargarDesdeArchivo(scanner, competidores);
                    break;
                case 2:
                    crearPersonaje(scanner, competidores);
                    break;
                case 3:
                    InterfazDeUsuario.mostrarPersonajes(competidores);
                    break;
                case 4:
                    InterfazDeUsuario.guardarEnArchivo(competidores, true);   
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    InterfazDeUsuario.menu();
                    break;
            }
        } while (opcion != 5);
    
        scanner.close();
    }
    public static void cargarDesdeArchivo(Scanner scanner, Map<String, Competidor> competidores)
    {
        System.out.println("Ingrese el nombre del archivo: ");
                    String path = scanner.next();
                    Archivo archivo = new Archivo(path);
                    if (archivo.cargarPersonajes(competidores))
                        System.out.println("Cargado: " + path);
                    else
                        System.out.println("Error al cargar el archivo " + path);
    }
    public static void crearPersonaje(Scanner scanner, Map<String, Competidor> competidores) {
        int tipo;
        do {
            System.out.println("Creación de Personaje");
            System.out.print("Tipo (1: Héroe, 2: Villano): ");
            tipo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
    
            if (tipo != 1 && tipo != 2) {
                System.out.println("Ingrese un tipo válido (1 para héroe, 2 para villano).");
            }
        } while (tipo != 1 && tipo != 2);
    
        System.out.print("Nombre Real: ");
        String nombreReal = scanner.nextLine();
    
        System.out.print("Nombre del Personaje: ");
        String nombrePersonaje = scanner.nextLine();
    
        System.out.print("Velocidad: ");
        int velocidad = scanner.nextInt();
    
        System.out.print("Fuerza: ");
        int fuerza = scanner.nextInt();
    
        System.out.print("Destreza: ");
        int destreza = scanner.nextInt();
    
        System.out.print("Resistencia: ");
        int resistencia = scanner.nextInt();
    
        if (tipo == 1) {
            try {
                competidores.put(nombrePersonaje, new Heroe(nombreReal, nombrePersonaje, velocidad, fuerza, destreza, resistencia));
            } catch (CaracteristicaNegativaException e) {
                System.out.println("Error al crear el héroe: " + e.getMessage());
            }
        } else if (tipo == 2) {
            try {
                competidores.put(nombrePersonaje, new Villano(nombreReal, nombrePersonaje, velocidad, fuerza, destreza, resistencia));
            } catch (CaracteristicaNegativaException e) {
                System.out.println("Error al crear el villano: " + e.getMessage());
            }
        }
    }
    
    
    
}
