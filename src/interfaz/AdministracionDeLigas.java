package interfaz;

import java.util.Scanner;
import java.util.Set;

import archivos.Archivo;
import heroesVillanos.Competidor;
import heroesVillanos.Liga;

public class AdministracionDeLigas {
    
    public static void administrador(Set<Competidor> competidores) {
        Scanner scanner = new Scanner(System.in);
        String mensaje = "1) Carga desde archivo.\n" +
                "2) Creación de liga.\n " +
                "3) Listado de ligas.\n" +
                "4) Guardar en archivo todas las ligas.";
    int opcion;
        do {
            System.out.println("\nAdministracion de Ligas.\n--------------------------------");
            opcion = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 5, scanner);
    
            switch (opcion) {
                case 1:
                    System.out.println("Cargando Ligas.\nIngrese el nombre del archivo: ");
                    String path = scanner.next();
                    Archivo archivo = new Archivo(path);
                    archivo.cargarLigas(competidores);
                    System.out.println("Cargado: " + path);
                    break;
                case 2:
                    crearLiga(scanner, competidores);
                    break;
                case 3:
                    InterfazDeUsuario.mostrarLigas(competidores);
                    break;
                case 4:
                    InterfazDeUsuario.guardarEnArchivo(competidores, false);
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    InterfazDeUsuario.menu();
                    break;
            }
        } while (opcion != 5);
    
        scanner.close();
    }
    
    
    public static void crearLiga(Scanner scanner, Set<Competidor> competidores) {
        System.out.println("Creación de Liga");
        System.out.print("Ingrese Nombre de la Liga: ");
        String nombreLiga = scanner.nextLine();
        Liga liga = new Liga(nombreLiga);
        String nombreBuscado;
        do {
            System.out.print("Ingrese el nombre de un competidor para agregar a la liga (o 'fin' para terminar): ");
            nombreBuscado = scanner.nextLine();
            for (Competidor competidor : competidores) {
                if (competidor.getNombre().equals(nombreBuscado)) {
                    liga.agregarMiembro(competidor);
                    break;
                }
            }
            if (!nombreBuscado.equals("fin")) {
                System.out.println("No se encontró ningún personaje con ese nombre.");
            }
        } while (!nombreBuscado.equals("fin"));

        competidores.add(liga);
        System.out.println("Liga creada exitosamente.");
    }

}
