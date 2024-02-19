package main;

import java.util.ArrayList;
import java.util.List;
import archivos.Archivo;
import heroesVillanos.*;

public class Main {
    public static List<Personaje> personajes = new ArrayList<>();
    public static List<Competidor> ligasGlobal = new ArrayList<>();
    public static List<String> nombresLigas = new ArrayList<>(); //estrategia elegida
    public static void main(String[] args) {
        testArchivoPersonajes();
        testArchivoLigas();
        cargarCompetidoresEnLigas();
        
        if(ligasGlobal.get(3) instanceof Liga)
            {
                Liga ligaEncontrada = (Liga) ligasGlobal.get(3);
                System.out.println("Mostrando " + ligaEncontrada.getNombre());
                mostrarCompetidor(ligaEncontrada);
            }
    }
    public static void cargarCompetidoresEnLigas() {
        for (Competidor competidor : ligasGlobal) {
            if (competidor instanceof Liga) {
                Liga liga = (Liga) competidor;
                nombresLigas.add(liga.getNombre());
                for (String nombreMiembro : liga.getMiembrosString()) {
                    for (Personaje personaje : personajes) {
                        if (nombreMiembro.equals(personaje.getNombrePersonaje())) {
                            liga.agregarMiembro(personaje);
                            break; //porque no hay repetidos.
                        }
                    }
                    for (String nombreLiga : nombresLigas) {
                        if (nombreMiembro.equals(nombreLiga)) {
                            Liga subliga = encontrarLigaPorNombre(nombreLiga);
                            if (subliga != null) {//encontré una subliga
                                liga.agregarMiembro(subliga);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static Liga encontrarLigaPorNombre(String nombreLiga) {
        for (Competidor competidor : ligasGlobal) {
            if (competidor instanceof Liga) {
                Liga liga = (Liga) competidor;
                if (nombreLiga.equals(liga.getNombre())) {
                    return liga;
                }
            }
        }
        return null;
    }

    public static void mostrarCompetidores(List<Competidor> competidores) {
        for (Competidor competidor : competidores) {
            if (competidor instanceof Liga) {
                Liga liga = (Liga) competidor;//necesito para el getCompetidores().
                liga.mostrar();
                mostrarCompetidores(liga.getCompetidores());
            } else { //es personaje
                competidor.mostrar();
            }
        }
    }
    public static void mostrarCompetidor(Competidor competidor) {
            if (competidor instanceof Liga) {
                Liga liga = (Liga) competidor;//necesito para el getCompetidores().
                liga.mostrar();
                mostrarCompetidores(liga.getCompetidores());
            } else { //es personaje
                competidor.mostrar();
            }
        }
    

    public static void testArchivoPersonajes() {
        Archivo archivoPersonajes = new Archivo("personajes.in");
        personajes = archivoPersonajes.cargarPersonajes();

    }

    public static void testArchivoLigas() {
        Archivo archivoLigas = new Archivo("ligas.in");
        ligasGlobal = archivoLigas.cargarLigas();
    }

    public static void mostrarListaPersonajes(List<Personaje> personajes) {
        System.out.println("Lista personajes:\n");
        for (Personaje personaje : personajes)
            System.out.println(personaje.getNombrePersonaje());

    }
}
