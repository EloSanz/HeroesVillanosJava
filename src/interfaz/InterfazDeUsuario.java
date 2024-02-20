package interfaz;

import java.util.Scanner;

public class InterfazDeUsuario {
    public static void menu() {
        System.out.println("Heroes y Villanos: El Videojuego.\n--------------------------------");

        String mensaje = "1) Administracion de Personajes.\n" +
                "2) Administracion de Ligas.\n" +
                "3) Realizacion de Combates.\n" +
                "4) Reportes.\n" +
                "5) Salir.";

        int opcion = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 5); 

        switch (opcion) {
            case 1: 
                InterfazDeUsuario.administracionDePersonajes();
                break;
            case 2: 
                InterfazDeUsuario.administracionDeLigas();
                break;
            case 3: 
                InterfazDeUsuario.realizacionDeCombates();
                break;
            case 4: 
                InterfazDeUsuario.reportes();
                break;
            case 5: 
                System.out.println("Gracias por jugar.");
                System.exit(0);
                break;
        }
    }

    public static int obtenerOpcion(String mensaje, int min, int max) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        int opcion = 0;

        System.out.println(mensaje);
        
        do {
            System.out.print("Opcion: ");
            if(scanner.hasNextInt()){
                opcion = scanner.nextInt();
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
        } while(opcion > max || opcion < min);

        scanner.close();

        return opcion;
    }

    public static void administracionDePersonajes() {
        System.out.println("\nAdministracion de Personajes.\n--------------------------------");

        String mensaje = "1) Carga desde archivo.\n" +
                "2) Creación de personaje.\n " +
                "3) Listado de personajes.\n" +
                "4) Guardar en archivo todos los personajes.";

        int opcion = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 4);

        switch (opcion) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
    
    public static void administracionDeLigas() {
        System.out.println("\nAdministracion de Ligas.\n--------------------------------");

        String mensaje = "1) Carga desde archivo.\n" +
                "2) Creación de liga.\n " +
                "3) Listado de ligas.\n" +
                "4) Guardar en archivo todas las ligas.";

        int opcion = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 4);

        switch (opcion) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    public static void realizacionDeCombates() {
        System.out.println("\nRealizacion de Combates.\n--------------------------------");

        String mensaje = "1) Combate entre personajes.\n" +
                "2) Combate entre ligas.\n " +
                "3) Combate entre personaje y liga.\n";

        int opcion = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 3);

        switch (opcion) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    public static void reportes() {
        System.out.println("\nReportes.\n--------------------------------");

        String mensaje = "1) Personajes o ligas que vencen a un personaje por característica.\n" + 
                "2) Listado ordenado de personajes por múltiples características";

        int opcion = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 2);

        switch (opcion) {
            case 1:
                break;
            case 2:
                break;
        }
    }
}