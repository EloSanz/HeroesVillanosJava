package main;

import Excepciones.CaracteristicaNegativaException;
import heroesVillanos.*;

public class Main {

    public static void main(String[] args) {
            
    try {
        Personaje villano = new Villano("Juan", "Juan el malvado", -10, 10,10, 10);
        Personaje spiderman = new Heroe("Peter", "Spiderman", 350, 300, 300, 550);
        Personaje venom = new Villano("Fulanito", "Venom", 300, 400, 400, 300);
    } catch (CaracteristicaNegativaException e) {
        e.printStackTrace();
    }

    //Liga villanosSpiderman = new Liga("Villanos de Spiderman");

    //villanosSpiderman.agregarMiembro(venom);

    //boolean resultado = villanosSpiderman.venceA(spiderman, Caracteristica.FUERZA);

    //System.out.println("Resultado de la comparación: " + resultado);

    System.out.println("mbbbbbbbbbbb");

    }
}
