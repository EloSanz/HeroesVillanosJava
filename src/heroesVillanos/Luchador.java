package heroesVillanos;

public interface Luchador {

		public boolean venceA(Luchador luchador, Caracteristica caracteristica);
		
		public boolean esHeroe(); //la liga pregunta por uno y ya sabe qué tipo de liga es:
		public boolean esVillano();												//(heroes ó villanos)
		
}