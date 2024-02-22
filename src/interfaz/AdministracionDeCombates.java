package interfaz;

import java.util.Scanner;

public class AdministracionDeCombates {
    public static void realizacionDeCombates() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRealizacion de Combates.\n--------------------------------");

        String mensaje = "1) Combate entre personajes.\n" +
                "2) Combate entre ligas.\n " +
                "3) Combate entre personaje y liga.\n";

        int opcion = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 3, scanner);

        switch (opcion) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
