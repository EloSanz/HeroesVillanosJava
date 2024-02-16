package heroesVillanos;

import Excepciones.CaracteristicaNegativaException;

public class Heroe extends Personaje{

	public Heroe(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia, int destreza) throws CaracteristicaNegativaException{
		super(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
	}

	public boolean esHeroe() {
		return true;
	}

	public boolean esVillano() {
		return false;
	}

	
}
