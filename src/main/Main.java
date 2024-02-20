package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import archivos.Archivo;
import heroesVillanos.*;
import Excepciones.*;
public class Main {
    public static Set<Personaje> personajesGlobal = new HashSet<Personaje>();
    public static List<Competidor> ligasGlobal = new ArrayList<>();
    public static List<String> nombresLigas = new ArrayList<>(); //estrategia elegida
   

    public static void main(String[] args) {
        cargarPersonajesEnMemoria("personajes.in");//carga personajes
        cargarNombreLigas_y_ListaMiembros("ligas.in");//carga los nombres de las ligas
        try {
            cargarCompetidoresEnLigas();
        } catch (LigaInexistente e) {
            e.printStackTrace();
        }
        

        //interfaz.InterfazDeUsuario.menu();

        //personajesGlobal.sort(null);

        //mostrarListaPersonajes(personajesGlobal);
        Liga ligaAux = (Liga)ligasGlobal.get(3);
        mostrarListaPersonajes(ligaAux.getPersonajes());
        //System.out.println(ligasGlobal.get(3));
    }
   
    public static void cargarCompetidoresEnLigas() throws LigaInexistente{
        for (Competidor competidor : ligasGlobal) {
                if(nombresLigas.contains(competidor.getNombre()))//Si el competidor es una liga
                    {
                        Liga liga = (Liga) competidor;
                        for (String nombreMiembro : liga.getMiembrosString()) {
                        int encontroMiembro = 0;
                        for (Personaje personaje : personajesGlobal) {
                            if (nombreMiembro.equals(personaje.getNombrePersonaje())) {
                                liga.getPersonajes().add(personaje);
                                liga.agregarMiembro(personaje); //redundande pero util
                                encontroMiembro = 1;
                                break; //porque no hay repetidos.
                            }
                        }//terminó, lo encuentra o no es un personaje.
                        if(encontroMiembro == 0)
                        {
                            for (String nombreLiga : nombresLigas) {
                                if (nombreMiembro.equals(nombreLiga)) {
                                    Liga subliga = encontrarLigaPorNombre(nombreLiga);
                                    liga.agregarMiembro(subliga);
                                    liga.getPersonajes().addAll(subliga.getPersonajes());
                                    encontroMiembro = 1;
                                    break;//porque no hay repetidos.
                                }
                            }
                        }
                        if(encontroMiembro == 0)
                        {
                            throw new LigaInexistente("No existe la liga: " + nombreMiembro);
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

                mostrarListaPersonajes(liga.getPersonajes());
                
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
    
    public static void cargarPersonajesEnMemoria(String Path) {
        Archivo archivoPersonajes = new Archivo(Path);
        personajesGlobal = archivoPersonajes.cargarPersonajes();

    }

    public static void cargarNombreLigas_y_ListaMiembros(String Path) {
        Archivo archivoLigas = new Archivo(Path);
        ligasGlobal = archivoLigas.cargarLigas(nombresLigas);
    }

    public static void mostrarListaPersonajes(Set<Personaje> personajes) {
        System.out.println("Lista personajes:\n");
        System.out.println("Nombre Personaje Nombre Real  \t Velocidad Fuerza Destreza Resistencia");

        for (Personaje personaje : personajes)
            System.out.println(personaje);

    }

}
