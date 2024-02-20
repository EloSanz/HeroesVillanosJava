package main;

import java.util.ArrayList;
import java.util.List;
import archivos.Archivo;
import heroesVillanos.*;

public class Main {
    public static List<Personaje> personajesGlobal = new ArrayList<>();
    public static List<Competidor> ligasGlobal = new ArrayList<>();
    public static List<String> nombresLigas = new ArrayList<>(); //estrategia elegida
   

    public static void main(String[] args) {
        testArchivoPersonajes();//carga personajes
        testArchivoLigas();//carga los nombres de las ligas
        cargarCompetidoresEnLigas();
        

        //interfaz.InterfazDeUsuario.menu();


        mostrarCompetidores(ligasGlobal);
        //mostrarCompetidor(ligasGlobal.get(3));
        //System.out.println(ligasGlobal.get(3));
    }
   
    public static void cargarCompetidoresEnLigas() {
        for (Competidor competidor : ligasGlobal) {
            if (competidor instanceof Liga) {
                Liga liga = (Liga) competidor;
                //nombresLigas.add(liga.getNombre());
                for (String nombreMiembro : liga.getMiembrosString()) {
                    int encontroPersonaje = 0;
                    for (Personaje personaje : personajesGlobal) {
                        if (nombreMiembro.equals(personaje.getNombrePersonaje())) {
                            liga.agregarMiembro(personaje);
                            encontroPersonaje = 1;
                            break; //porque no hay repetidos.
                        }
                    }//terminó, lo encuentra o no es un personaje.
                    if(encontroPersonaje == 0)
                    {
                        for (String nombreLiga : nombresLigas) {
                            if (nombreMiembro.equals(nombreLiga)) {
                                Liga subliga = encontrarLigaPorNombre(nombreLiga);
                                if (subliga != null) {//encontré una subliga (nunca debería fallar acá)
                                    liga.agregarMiembro(subliga);
                                    break;
                                }
                            }
                        }
                    }
                   
                }
            }
        }
    }

    public static Liga encontrarLigaPorNombre(String nombreLiga) {
        for (Competidor competidor : ligasGlobal) {
            if( nombreLiga.equals( competidor.getNombre() ) ){
                Liga liga = (Liga) competidor;
                return liga;
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

    public static void mostrarCompetidor2() {
            for (Competidor competidor : ligasGlobal) {
                competidor.mostrar();
            }   
        }
    

    public static void testArchivoPersonajes() {
        Archivo archivoPersonajes = new Archivo("personajes.in");
        personajesGlobal = archivoPersonajes.cargarPersonajes();

    }

    public static void testArchivoLigas() {
        Archivo archivoLigas = new Archivo("ligas.in");
        ligasGlobal = archivoLigas.cargarLigas(nombresLigas);
    }

    public static void mostrarListaPersonajes(List<Personaje> personajes) {
        System.out.println("Lista personajes:\n");
        for (Personaje personaje : personajes)
            System.out.println(personaje.getNombrePersonaje());

    }
}
