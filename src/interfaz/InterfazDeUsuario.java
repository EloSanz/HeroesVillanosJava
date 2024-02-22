package interfaz;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import heroesVillanos.Competidor;
import heroesVillanos.Liga;

public class InterfazDeUsuario {


    public static void menu() {
         Set<Competidor> competidores = new HashSet<Competidor>();

        System.out.println("Heroes y Villanos: El Videojuego.\n--------------------------------");


        String mensaje = "1) Administracion de Personajes.\n" +
                "2) Administracion de Ligas.\n" +
                "3) Realizacion de Combates.\n" +
                "4) Reportes.\n" +
                "5) Salir.";
        Scanner sc = new Scanner(System.in);
        int opcion = InterfazDeUsuario.obtenerOpcion(mensaje, 1, 5, sc); 

        switch (opcion) {
            case 1: 
                AdministracionDePersonajes.administrador(competidores);
                break;
            case 2: 
                AdministracionDeLigas.administrador(competidores);
                break;
            case 3: 
                AdministracionDeCombates.realizacionDeCombates();
                break;
            case 4: 
                Reportes.reportes();
                break;
            case 5: 
                System.out.println("Gracias por jugar.");
                System.exit(0);
                break;
        }
        sc.close();
    }

    public static int obtenerOpcion(String mensaje, int min, int max, Scanner scanner) {

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

        //scanner.close();

        return opcion;
    }


    public static void mostrarCompetidor(Competidor competidor)
    {
        _mostrarCompetidor(competidor, false);
    }
    public static void _mostrarCompetidor(Competidor competidor, boolean subliga) {
        
        if (competidor.esLiga) {
            Liga liga = (Liga) competidor;
            List<Competidor> competidores = liga.getCompetidores();
            if (subliga)
                System.out.print("\tSubliga: ");
            System.out.println(liga);
            for (Competidor c : competidores) {
                _mostrarCompetidor(c,true);
            }
        } else {
            System.out.println(competidor);
        }
    }
   
    public static void mostrarPersonajes(Set<Competidor> competidores) {
        System.out.println("Lista personajes:\n");
        System.out.println(
                "\tHeroe/Villano Nombre Personaje       Nombre Real           Velocidad  Fuerza  Destreza  Resistencia");
        for (Competidor competidor : competidores) {
            if (!competidor.esLiga) {
                System.out.println(competidor);
            }
        }
    }
    public static void mostrarLigas(Set<Competidor> competidores) {
        System.out.println("\nLigas:");
        for (Competidor competidor : competidores) {
            if (competidor.esLiga) {
                mostrarCompetidor(competidor);
            }
        }
    }
   

    public static void guardarEnArchivo(Set<Competidor> competidores, boolean personaje) {
        String nombreArchivo = personaje ? "personajesOut.txt" : "ligasNuevas.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Competidor competidor : competidores) {
                if (personaje && !competidor.esLiga) {
                    writer.write(competidor.toString());
                    writer.newLine();
                } else if (!personaje && competidor.esLiga) {
                    writer.write(competidor.toString());
                    writer.newLine();
                }
            }
            System.out.println(personaje ? "Personajes guardados en el archivo 'personajesOut.txt'" : "Ligas guardadas en el archivo 'ligasNuevas.txt'");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }
   

}