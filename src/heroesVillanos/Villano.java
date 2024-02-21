package heroesVillanos;

import Excepciones.CaracteristicaNegativaException;

public class Villano extends Personaje {

	@Override
	public String toString()
	{
		return String.format("%15s: \t%-20s %-20s  \t%.1f\t%.1f\t%.1f\t%.1f",
            "Villano",
			this.getNombre(),
            this.getNombreReal(),
            this.getVelocidad(),
            this.getFuerza(),
            this.getDestreza(),
            this.getResistencia());
	}

	public Villano(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia, int destreza)
			throws CaracteristicaNegativaException {
		super(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
	}

	public boolean esHeroe() {
		return false;
	}

	public boolean esVillano() {
		return true;
	}
}
