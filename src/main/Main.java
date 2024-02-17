package main;

import java.util.ArrayList;
import java.util.List;

import Excepciones.CaracteristicaNegativaException;
import archivos.Archivo;
import heroesVillanos.*;

public class Main {

    public static void main(String[] args) {

        try {
            Personaje villano = new Villano("Juan", "Juan el malvado", 300, 400, 400, 450);
            // Personaje spiderman = new Heroe("Peter", "Spiderman", 300, 300, 300, 550);
            Personaje venom = new Villano("Fulanito", "Venom", 300, 400, 400, 300);

            Liga villanosSpiderman = new Liga("Villanos de Spiderman");
            villanosSpiderman.agregarMiembro(villano);
            villanosSpiderman.agregarMiembro(venom);
            // villanosSpiderman.agregarMiembro(spiderman);
            // System.out.println(villanosSpiderman.getVelocidad());

        } catch (CaracteristicaNegativaException e) {
            e.printStackTrace();
        }

        testArchivoPersonajes();
        testArchivoLigas();
    }

    public static void testArchivoPersonajes() {
        Archivo archivoPersonajes = new Archivo("personajes.in");
        List<Personaje> personajes = archivoPersonajes.cargarPersonajes();
        personajes.sort(Personaje.VELOCIDAD); //test Ordenamiento
        mostrarListaPersonajes(personajes);
   
        List<Heroe> heroes = new ArrayList<>();
        List<Villano> villanos = new ArrayList<>();

        for (Personaje personaje : personajes) {
            if (personaje.esHeroe())
                heroes.add((Heroe) personaje);
            else
                villanos.add((Villano) personaje);
        }
      
     
    }
    public static void testArchivoLigas(){
        Archivo archivoLigas = new Archivo("ligas.in");
        List<Liga> ligas = archivoLigas.cargarLigas();
        mostrarListaLigas(ligas);
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

    }
    public static void mostrarListaLigas(List<Liga> ligas)
    {
        System.out.println("\nLigas: \n");
        for (Liga liga : ligas) {
            System.out.println(liga.getNombre() + ": " + liga.getMiembrosString());
        }
    }
    public static void mostrarListaPersonajes(List<Personaje> personajes)
    {
        System.out.println("Lista personajes:\n");
        for(Personaje personaje : personajes)
             System.out.println(personaje.getNombrePersonaje());

    }
}
