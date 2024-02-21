package heroesVillanos;

import Excepciones.CaracteristicaNegativaException;

public class Heroe extends Personaje {

	@Override
	public String toString()
	{
		return String.format("%15s: \t%-20s %-20s  \t%.1f\t%.1f\t%.1f\t%.1f",
			"Héroe",
            this.getNombre(),
            this.getNombreReal(),
            this.getVelocidad(),
            this.getFuerza(),
            this.getDestreza(),
            this.getResistencia());
	}
    public void mostrar(){
        System.out.println(this);
    }

	public Heroe(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia, int destreza)
			throws CaracteristicaNegativaException {
		super(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
		esLiga = false;
	}

	public boolean esHeroe() {
		return true;
	}

	public boolean esVillano() {
		return false;
	}

}
