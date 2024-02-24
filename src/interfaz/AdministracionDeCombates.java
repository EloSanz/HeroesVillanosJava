package interfaz;

import java.util.Map;
import java.util.Scanner;

import heroesVillanos.Competidor;
import heroesVillanos.Personaje;

public class AdministracionDeCombates {
    public static void realizacionDeCombates(Map<String, Competidor> competidores) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRealizacion de Combates.\n--------------------------------");

        String mensaje = "1) Combate entre personajes.\n" +
                "2) Combate entre ligas.\n" +
                "3) Combate entre personaje y liga.\n";

        int opcion = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 3, scanner);

        switch (opcion) {
            case 1:
                combatePersonajeXPersonaje(scanner,competidores);
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    private static void combatePersonajeXPersonaje(Scanner scanner, Map<String, Competidor> competidores) {
        System.out.println("Combate entre Personajes");
        Personaje personaje1, personaje2 = null;
        
        personaje1 = getPersonaje(scanner, competidores, 1);
        System.out.println(personaje1.getNombre() + " Seleccionado. Pulse para avanzar");
        do
        {
            personaje2 = getPersonaje(scanner, competidores, 2);
            if(personaje1 == personaje2)
            {
                System.out.println("No se puede combatir contra si mismo. Ingrese otro personaje...\nPulse para avanzar");

            }
        }while(personaje1 == personaje2);
        
    int op = InterfazDeUsuario.obtenerOpcion("Ingrese categoría a competir: " + 
                                            "Velocidad: 1\n"+
                                            "Fuerza: 2\n"+
                                            "Destreza: 3\n"+
                                            "Resistencia: 4\n", 1, 4, scanner);
        System.out.println(op);
        System.out.println(personaje1 +" contra " + personaje2);
    

    }
    private static Personaje getPersonaje(Scanner scanner, Map<String, Competidor> competidores, int numeroPersonaje) {
        scanner.nextLine();//limpio el buffer
        while (true) {
            System.out.print("Seleccione el personaje " + numeroPersonaje + ": ");
            String nombrePersonaje = scanner.nextLine().trim(); // Leer y limpiar la línea de entrada
            System.out.println("Buscando a " + nombrePersonaje);
            
            Competidor competidor = competidores.get(nombrePersonaje);
            if (competidor == null) {
                System.out.println("No existe un personaje con ese nombre. Por favor, ingrese otro nombre.");
            } else if (competidor.getEsLiga()) {
                System.out.println(nombrePersonaje + " es una liga. Ingrese otro nombre.");
            } else {
                return (Personaje) competidor;
            }
        }
    }




}
