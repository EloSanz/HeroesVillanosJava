package main;
import java.util.List;

import Excepciones.CaracteristicaNegativaException;
import archivos.Archivo;
import heroesVillanos.*;

public class Main {

    public static void main(String[] args) {
            
    try {
        Personaje villano = new Villano("Juan", "Juan el malvado", 300, 400,400, 450);
        //Personaje spiderman = new Heroe("Peter", "Spiderman", 300, 300, 300, 550);
        Personaje venom = new Villano("Fulanito", "Venom", 300, 400, 400, 300);

        Liga villanosSpiderman = new Liga("Villanos de Spiderman");
        villanosSpiderman.agregarMiembro(villano);
        villanosSpiderman.agregarMiembro(venom);
        //villanosSpiderman.agregarMiembro(spiderman);
        //System.out.println(villanosSpiderman.getVelocidad());
    
    } catch (CaracteristicaNegativaException e) {
        e.printStackTrace();
    }

    testArchivo();
    

    }

    public static void testArchivo()
{
    Archivo archivo = new Archivo("personajes.in");

        List <Heroe> heroes = archivo.cargarHeroes();
        List <Personaje> personajes = archivo.cargarPersonajes();


        System.out.println("Lista personajes Entera:\n");
        for(Personaje personaje : personajes)
        {
            System.out.println(personaje.getNombrePersonaje());
        }

        System.out.println("\nLista Heroes Entera:\n");
        for (Heroe heroe : heroes) {
            System.out.println(heroe.getNombrePersonaje());
        }
}

}
