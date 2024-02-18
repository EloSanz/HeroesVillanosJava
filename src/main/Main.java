package main;

import java.util.ArrayList;
import java.util.List;
import archivos.Archivo;
import heroesVillanos.*;


    
    public class Main {
    public static List<Personaje> personajes = new ArrayList<>();
    public static List<Competidor> ligas = new ArrayList<>();

    public static void main(String[] args) {
        testArchivoPersonajes();
        testArchivoLigas();
        cargarCompetidoresEnLigas();
        mostrarListaLigas(ligas);
    }

    public static void cargarCompetidoresEnLigas() {
        for (Competidor competidor : ligas) {
            if (competidor instanceof Liga) {
                Liga liga = (Liga) competidor;
                for (String nombreMiembro : liga.getMiembrosString()) {
                    for (Personaje personaje : personajes) {
                        if (nombreMiembro.equals(personaje.getNombrePersonaje())) {
                            liga.agregarMiembro(personaje);
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void mostrarListaLigas(List<Competidor> competidores) {
        for (Competidor competidor : competidores) {
            if (competidor instanceof Liga) {
                Liga liga = (Liga) competidor;
                mostrarLiga(liga);
                mostrarListaLigas(liga.getCompetidores());
            } else if (competidor instanceof Personaje) {
                Personaje personaje = (Personaje) competidor;
                System.out.println("  Personaje: " + personaje.getNombrePersonaje());
            }
        }
    }
    public static void mostrarLiga(Liga liga)
    {
        System.out.println("Liga: " + liga.getNombre());
    }

    public static void testArchivoPersonajes() {
        Archivo archivoPersonajes = new Archivo("personajes.in");
        personajes = archivoPersonajes.cargarPersonajes();

    }
    public static void testArchivoLigas(){
        Archivo archivoLigas = new Archivo("ligas.in");
        ligas = archivoLigas.cargarLigas();
        //mostrarListaLigas(ligas);
        
        /*    
        System.out.println("\n");
        Liga ligaPrimera = ligas.get(0);
        ligaPrimera.agregarMiembrosString(ligaPrimera.getMiembrosString());//agrega la lista de miembros

        ligaPrimera.agregarMiembro(ligas.get(1));//agrega otra subliga
        System.out.println("Liga primera: " + ligaPrimera.getNombre() + ligaPrimera.getMiembrosString());
        
        
        System.out.println("se agrega la liga: " + ligas.get(1).getNombre());
        System.out.println("se agrega " + ligas.get(1).getMiembrosString());

        ligaPrimera.agregarMiembrosString(ligas.get(1).getMiembrosString());//agregamos los demas miembros

        System.out.println("\nLiga actualizada: " + ligaPrimera.getNombre());
        System.out.println("Miembros: " + ligaPrimera.getMiembrosString()) ; 
        */
    }

    public static void mostrarListaPersonajes(List<Personaje> personajes)
    {
        System.out.println("Lista personajes:\n");
        for(Personaje personaje : personajes)
             System.out.println(personaje.getNombrePersonaje());

    }
}
