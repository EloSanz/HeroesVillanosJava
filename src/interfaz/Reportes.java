package interfaz;

import heroesVillanos.Caracteristica;
import heroesVillanos.Competidor;
import heroesVillanos.CompetidorComparator;
//import heroesVillanos.Personaje;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Excepciones.CaracteristicaInexistenteException;

public class Reportes {
    public static void reportes(Map<String, Competidor> competidores) {
        System.out.println("\nReportes.\n--------------------------------");
        Scanner scanner = new Scanner(System.in);
        String mensaje = "1) Personajes o ligas que vencen a un personaje por característica.\n" +
                "2) Listado ordenado de personajes por múltiples características\n" + 
                "3) Volver al menu principal\n";

        int opcion;
		do {
			opcion = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 4, scanner);
            scanner.nextLine(); // limpio el buffer
			switch (opcion) {
		    case 1:
		        reportePersonajesQueVencen(competidores, scanner);
		        break;
		    case 2:
		        reportePersonajesOrdenados(competidores, scanner);
		        break;
		    case 3:
                System.out.println("Volviendo al menú principal...");
                InterfazDeUsuario.menu();
                break;
			}			
		}while (opcion != 3);     
    }

    private static void reportePersonajesQueVencen(Map<String, Competidor> competidores, Scanner scanner) {
        System.out.println("Ingrese el nombre del personaje: ");
        String nombrePersonaje = scanner.nextLine();

        Competidor personaje = competidores.get(nombrePersonaje);
        if (personaje != null) {
            System.out.println("Ingrese la característica para la cual desea encontrar los personajes que vencen a " + nombrePersonaje + ": ");
            String nombreCaracteristica = scanner.nextLine();
            try {
                Caracteristica caracteristica = Caracteristica.valueOf(nombreCaracteristica.toUpperCase());
                System.out.println("Personajes o ligas que vencen a " + nombrePersonaje + " en " + caracteristica + ": " + personaje.getCaracteristica(caracteristica));

                Map<String, Competidor> mapaVencedores = new LinkedHashMap<>();
                for (Competidor competidor : competidores.values()){
                    if (competidor.esGanador(personaje, caracteristica, false) == 1) {
                        mapaVencedores.put(competidor.getNombre(), competidor);
                    }
                }
                InterfazDeUsuario.mostrarPersonajes(mapaVencedores);
            } catch (IllegalArgumentException e) {
                System.out.println("La característica ingresada no es válida.");
            } catch (CaracteristicaInexistenteException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("El personaje ingresado no existe.");
        }
    }

    private static void reportePersonajesOrdenados(Map<String, Competidor> competidores, Scanner scanner) {
        String mensaje = "Ingrese el número de características por las que desea ordenar: ";
        int numCaracteristicas = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 4, scanner);
        scanner.nextLine(); // Consumir el salto de línea

        Caracteristica[] caracteristicas = new Caracteristica[numCaracteristicas];
        System.out.println("Caracteristicas por las cuales ordenar: \nVELOCIDAD\nFUERZA\nDESTREZA\nRESISTENCIA");
        for (int i = 0; i < numCaracteristicas; i++) {
            System.out.println("Ingrese la característica #" + (i + 1) + ": ");
            String nombreCaracteristica = scanner.nextLine();
            caracteristicas[i] = Caracteristica.valueOf(nombreCaracteristica.toUpperCase());
        }

        // Ordenar los personajes según las características seleccionadas
        Map<String, Competidor> mapaOrdenado = new LinkedHashMap<>();
        List<Map.Entry<String, Competidor>> listaOrdenada = new ArrayList<>(competidores.entrySet());
        CompetidorComparator comparator = new CompetidorComparator(caracteristicas);
        Collections.sort(listaOrdenada, comparator);

        // Llenar el mapa ordenado con los elementos ordenados
        for (Map.Entry<String, Competidor> entry : listaOrdenada) {
            mapaOrdenado.put(entry.getKey(), entry.getValue());
        }

        // Imprimir el mapa ordenado de personajes
        System.out.println("Listado ordenado de personajes por múltiples características:");
        InterfazDeUsuario.mostrarPersonajes(mapaOrdenado);
    }

}
