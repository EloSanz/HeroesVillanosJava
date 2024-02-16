package heroesVillanos;

public class Villano extends Personaje{

	public Villano(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia,
			int destreza) {
		super(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza);
	}

	public Villano() {
		
	}

	@Override
	public boolean venceA(Luchador luchador, Caracteristica caracteristica) {
		throw new UnsupportedOperationException("Unimplemented method 'venceA'");
	}

	@Override
	public boolean esHeroe() {
		return true;
	}

	@Override
	public boolean esVillano() {
		return true;
	}
	

}
