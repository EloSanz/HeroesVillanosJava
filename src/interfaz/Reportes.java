package interfaz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Excepciones.CaracteristicaInexistenteException;
import heroesVillanos.Caracteristica;
import heroesVillanos.Competidor;

public class Reportes {
    public static void reportes(Map<String, Competidor> competidores) {
        System.out.println("\nReportes.\n--------------------------------");
        Scanner scanner = new Scanner(System.in);
        String mensaje = "1) Personajes o ligas que vencen a un personaje por característica.\n" +
                "2) Listado ordenado de personajes por múltiples características";

        int opcion = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 2, scanner);

        switch (opcion) {
            case 1:
                reportePersonajesQueVencen(competidores);
                break;
            case 2:
                reportePersonajesOrdenados(competidores);
                break;
        }
    }

    private static void reportePersonajesQueVencen(Map<String, Competidor> competidores) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el nombre del personaje: ");
            String nombrePersonaje = scanner.nextLine();

            Competidor personaje = competidores.get(nombrePersonaje);
            if (personaje != null) {
                System.out.println("Personajes o ligas que vencen a " + nombrePersonaje + " por característica:");

                for (Competidor competidor : competidores.values()) {
                    if (!competidor.getNombre().equals(nombrePersonaje)) {
                        try {
                            if (competidor.esGanador(personaje, Caracteristica.VELOCIDAD) ||
                                    competidor.esGanador(personaje, Caracteristica.FUERZA) ||
                                    competidor.esGanador(personaje, Caracteristica.RESISTENCIA) ||
                                    competidor.esGanador(personaje, Caracteristica.DESTREZA)) {
                                System.out.println("- " + competidor.getNombre());
                            }
                        } catch (CaracteristicaInexistenteException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                }
            } else {
                System.out.println("El personaje ingresado no existe.");
            }
        }
    }

    private static void reportePersonajesOrdenados(Map<String, Competidor> competidores) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de características por las que desea ordenar: ");
        int numCaracteristicas = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Caracteristica[] caracteristicas = new Caracteristica[numCaracteristicas];
        for (int i = 0; i < numCaracteristicas; i++) {
            System.out.println("Ingrese la característica #" + (i + 1) + ": ");
            String nombreCaracteristica = scanner.nextLine();
            caracteristicas[i] = Caracteristica.valueOf(nombreCaracteristica.toUpperCase());
        }

        // Ordenar los personajes según las características seleccionadas
        List<Competidor> listaOrdenada = new ArrayList<>(competidores.values());
        Collections.sort(listaOrdenada, new Comparator<Competidor>() {
            @Override
            public int compare(Competidor c1, Competidor c2) {
                for (Caracteristica caracteristica : caracteristicas) {
                    double valorC1 = c1.getCaracteristica(caracteristica);
                    double valorC2 = c2.getCaracteristica(caracteristica);
                    if (valorC1 != valorC2) {
                        return Double.compare(valorC1, valorC2);
                    }
                }
                // Si los personajes tienen las mismas características, se ordenan por nombre
                return c1.getNombre().compareTo(c2.getNombre());
            }
        });

        // Imprimir la lista ordenada de personajes
        System.out.println("Listado ordenado de personajes por múltiples características:");
        for (Competidor personaje : listaOrdenada) {
            System.out.println("- " + personaje.getNombre());
        }

        scanner.close();
    }
}