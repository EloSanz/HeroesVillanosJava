package heroesVillanos;

public class Heroe extends Personaje{

	public Heroe(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia, int destreza) {
		super(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
		
	}

	public boolean venceA(Luchador luchador, Caracteristica caracteristica) {
		//implementar
		return false;
	}

	@Override
	public boolean esHeroe() {

		return true;
	}
	@Override
	public boolean esVillano() {
		return false;
	}

	
}
