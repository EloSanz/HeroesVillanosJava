package heroesVillanos;

import Excepciones.CaracteristicaNegativaException;

public class Heroe extends Personaje {
	public String getNombre(){
		return this.getNombrePersonaje();
	}

	@Override
	public String toString()
	{
		return String.format("\tHéroe: %-20s\t%-20s\tv = %.1f\tf = %.1f\td = %.1f\tr = %.1f",
            this.getNombrePersonaje(),
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
	}

	public boolean esHeroe() {
		return true;
	}

	public boolean esVillano() {
		return false;
	}

}
