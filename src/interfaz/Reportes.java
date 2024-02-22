package interfaz;

import java.util.Scanner;

public class Reportes {
    public static void reportes() {
        System.out.println("\nReportes.\n--------------------------------");
        Scanner scanner = new Scanner(System.in);
        String mensaje = "1) Personajes o ligas que vencen a un personaje por característica.\n" + 
                "2) Listado ordenado de personajes por múltiples características";

        int opcion = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 2, scanner);

        switch (opcion) {
            case 1:
                break;
            case 2:
                break;
        }
    }

}
