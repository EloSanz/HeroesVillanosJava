package main;
import heroesVillanos.*;

public class Main { // TESTINGGGGGGG

	public static void main(String[] args) {
		
	Personaje villano = new Villano("Juan", "Juan el malvado", -10,10,10,10);
	
        Personaje spiderman = new Heroe("Peter", "Spiderman",	 350, 	300, 300, 550);
        Personaje venom = new Villano("Fulanito", "Venom",		 300, 	400, 400, 300);

        //Liga villanosSpiderman = new Liga("Villanos de Spiderman");
       
        //villanosSpiderman.agregarMiembro(venom);

        //boolean resultado = villanosSpiderman.venceA(spiderman, Caracteristica.FUERZA);
        
        //System.out.println("Resultado de la comparación: " + resultado);

        System.out.println("Esto deberia funcionar.");
	
	}
}
