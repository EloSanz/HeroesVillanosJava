package heroesVillanos;

import Excepciones.CaracteristicaNegativaException;

public class Villano extends Personaje{

	public Villano(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia, int destreza) throws CaracteristicaNegativaException{
		super(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
	}

	public boolean esHeroe() {
		return false;
	}

	public boolean esVillano() {
		return true;
	}
}
