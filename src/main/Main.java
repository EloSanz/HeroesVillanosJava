package main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import archivos.Archivo;
import heroesVillanos.*;

public class Main {
    public static Set<Competidor> competidores = new HashSet<Competidor>();

    public static void main(String[] args) {
        cargarPersonajesEnMemoria("personajes.in");// carga personajes
        cargarLigas_y_Miembros("ligas.in");

        String ligaBuscada = "DC";
        for (Competidor competidor : competidores) {
            if(ligaBuscada.equals(competidor.getNombre()))
                {
                    System.out.println("Mostrando: " + competidor.getNombre());
                    mostrarCompetidor(competidor);
                    break;
                }
        }
        //mostrarPersonajes(competidores);
        //mostrarLigas(competidores);
    }

    public static void cargarPersonajesEnMemoria(String Path) {
        Archivo archivoPersonajes = new Archivo(Path);
        archivoPersonajes.cargarPersonajes(competidores);
    }
    public static void cargarLigas_y_Miembros(String Path) {
        Archivo archivoLigas = new Archivo(Path);
        archivoLigas.cargarLigas(competidores);
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
                System.out.println(competidor);
            }
        }
    }
}
