package interfaz;

import java.util.Map;
import java.util.Scanner;

import Excepciones.CaracteristicaInexistenteException;
import heroesVillanos.Caracteristica;
import heroesVillanos.Competidor;
import heroesVillanos.Liga;
import heroesVillanos.Personaje;

public class AdministracionDeCombates {
    public static void realizacionDeCombates(Map<String, Competidor> competidores) { ///acá se cambio lo que se recibe por parametro. Para tener los competidores que estan en memoria
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRealizacion de Combates.\n--------------------------------");

        String mensaje = "1) Combate entre personajes.\n" +
                "2) Combate entre ligas.\n" +
                "3) Combate entre personaje y liga.\n" +
                "4) Volver al menu principal";

        int opcion;
        do {
            System.out.println("\nRealizacion de combates.\n--------------------------------");
			opcion = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 4, scanner);
			switch (opcion) {
		    case 1:
		    	combateEntrePersonajes(competidores);
		        break;
		    case 2:
		    	combateEntreLigas(competidores);
		        break;
		    case 3:
		    	combatePersonajeYLiga(competidores);
		        break;
		    case 4:
                System.out.println("Volviendo al menú principal...");
                InterfazDeUsuario.menu();
                break;
			}
        }while (opcion != 4);
		        
    }
    
    private static void combatePersonajeYLiga(Map<String, Competidor> competidores) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCombate entre Personaje y Liga.\n--------------------------------");

        System.out.print("Ingrese el nombre del personaje: ");
        String nombrePersonaje = scanner.nextLine();

        System.out.print("Ingrese el nombre de la liga: ");
        String nombreLiga = scanner.nextLine();

        // Obtener el personaje y la liga del mapa de competidores
        Competidor personaje = competidores.get(nombrePersonaje);
        Competidor liga = competidores.get(nombreLiga);

        // Realizar el combate entre el personaje y la liga
        if (personaje != null && liga != null && !personaje.getEsLiga() && liga.getEsLiga()) {
            try {
                // Comenzar el desempate con la característica de velocidad
                Caracteristica caracteristicaActual = Caracteristica.VELOCIDAD;

                boolean ganaPersonaje = personaje.esGanador(liga, caracteristicaActual);
                boolean ganaLiga = liga.esGanador(personaje, caracteristicaActual);

                // Realizar el desempate hasta que haya un ganador o sea empate
                while (ganaPersonaje == ganaLiga) {
                    // Cambiar a la siguiente característica según el orden establecido
                    caracteristicaActual = obtenerSiguienteCaracteristica(caracteristicaActual);

                    ganaPersonaje = personaje.esGanador(liga, caracteristicaActual);
                    ganaLiga = liga.esGanador(personaje, caracteristicaActual);
                }

                // Determinar el ganador basado en el desempate
                if (ganaPersonaje) {
                    System.out.println(nombrePersonaje + " gana el combate.");
                } else if (ganaLiga) {
                    System.out.println(nombreLiga + " gana el combate.");
                } else {
                    System.out.println("El combate termina en empate.");
                }
            } catch (CaracteristicaInexistenteException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("El personaje o la liga no existen o no corresponden al tipo correcto.");
        }
    }
    
    private static void combateEntreLigas(Map<String, Competidor> competidores) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCombate entre Ligas.\n--------------------------------");

        System.out.print("Ingrese el nombre de la primera liga: ");
        String nombreLiga1 = scanner.nextLine();

        System.out.print("Ingrese el nombre de la segunda liga: ");
        String nombreLiga2 = scanner.nextLine();

        // Obtener las ligas del mapa de competidores
        Competidor liga1 = competidores.get(nombreLiga1);
        Competidor liga2 = competidores.get(nombreLiga2);

        // Realizar el combate entre las ligas
        if (liga1 != null && liga2 != null && liga1.getEsLiga() && liga2.getEsLiga()) {
            try {
                // Comenzar el desempate con la característica de velocidad
                Caracteristica caracteristicaActual = Caracteristica.VELOCIDAD;

                boolean ganaLiga1 = liga1.esGanador(liga2, caracteristicaActual);
                boolean ganaLiga2 = liga2.esGanador(liga1, caracteristicaActual);

                // Realizar el desempate hasta que haya un ganador o sea empate
                while (ganaLiga1 == ganaLiga2) {
                    // Cambiar a la siguiente característica según el orden establecido
                    caracteristicaActual = obtenerSiguienteCaracteristica(caracteristicaActual);

                    ganaLiga1 = liga1.esGanador(liga2, caracteristicaActual);
                    ganaLiga2 = liga2.esGanador(liga1, caracteristicaActual);
                }

                // Determinar el ganador basado en el desempate
                if (ganaLiga1) {
                    System.out.println(nombreLiga1 + " gana el combate.");
                } else if (ganaLiga2) {
                    System.out.println(nombreLiga2 + " gana el combate.");
                } else {
                    System.out.println("El combate termina en empate.");
                }
            } catch (CaracteristicaInexistenteException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Uno o ambos competidores no son ligas válidas.");
        }
    }
    
    private static void combateEntrePersonajes(Map<String, Competidor> competidores) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCombate entre Personajes.\n--------------------------------");

        System.out.print("Ingrese el nombre del primer personaje: ");
        String nombrePersonaje1 = scanner.nextLine();

        System.out.print("Ingrese el nombre del segundo personaje: ");
        String nombrePersonaje2 = scanner.nextLine();

        // Obtener los competidores del mapa de competidores
        Competidor competidor1 = competidores.get(nombrePersonaje1);
        Competidor competidor2 = competidores.get(nombrePersonaje2);

        // Realizar el combate entre los personajes
        if (competidor1 != null && competidor2 != null || !competidor1.equals(competidor2)) {
            try {
                // Comenzar el desempate con la característica de velocidad
                Caracteristica caracteristicaActual = Caracteristica.VELOCIDAD;

                boolean ganaCompetidor1 = competidor1.esGanador(competidor2, caracteristicaActual);
                boolean ganaCompetidor2 = competidor2.esGanador(competidor1, caracteristicaActual);

                // Realizar el desempate hasta que haya un ganador o sea empate
                while (ganaCompetidor1 == ganaCompetidor2) {
                    // Cambiar a la siguiente característica según el orden establecido
                    caracteristicaActual = obtenerSiguienteCaracteristica(caracteristicaActual);

                    ganaCompetidor1 = competidor1.esGanador(competidor2, caracteristicaActual);
                    ganaCompetidor2 = competidor2.esGanador(competidor1, caracteristicaActual);
                }

                // Determinar el ganador basado en el desempate
                if (ganaCompetidor1) {
                    System.out.println(nombrePersonaje1 + " gana el combate.");
                } else if (ganaCompetidor2) {
                    System.out.println(nombrePersonaje2 + " gana el combate.");
                } else {
                    System.out.println("El combate termina en empate.");
                }
            } catch (CaracteristicaInexistenteException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Uno o ambos personajes no existen.");
        }
    }


    private static Caracteristica obtenerSiguienteCaracteristica(Caracteristica caracteristicaActual) {
        // Determinar la siguiente característica en el orden establecido
        switch (caracteristicaActual) {
            case VELOCIDAD:
                return Caracteristica.FUERZA;
            case FUERZA:
                return Caracteristica.RESISTENCIA;
            case RESISTENCIA:
                return Caracteristica.DESTREZA;
            case DESTREZA:
                return Caracteristica.VELOCIDAD;
            default:
                // Esto no debería ocurrir, pero en caso de error, se vuelve a velocidad
                return Caracteristica.VELOCIDAD;
        }
    }
}