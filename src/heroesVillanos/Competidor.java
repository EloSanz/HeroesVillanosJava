package heroesVillanos;

import Excepciones.CaracteristicaInexistenteException;

public abstract class Competidor {
    protected String nombre;
    protected boolean esLiga;

    @Override
    public abstract String toString();

    public abstract double getCaracteristica(Caracteristica caracteristica);

    public abstract double calcularValorTotalCaracteristica(Caracteristica caracteristica);

    public abstract int contarCompetidores();

    public String getNombre() {
        return this.nombre;
    }

    public boolean getEsLiga() {
        return this.esLiga;
    }

    public boolean venceA(Competidor competidor, Caracteristica caracteristica, int contador)
            throws CaracteristicaInexistenteException {
        if (contador > 3) {
            return false;
        } else {
            switch (caracteristica) {
                case VELOCIDAD:
                    if (this.getCaracteristica(Caracteristica.VELOCIDAD) == competidor.getCaracteristica(Caracteristica.VELOCIDAD)) {
                        return venceA(competidor, Caracteristica.FUERZA, contador + 1);
                    } else {
                        return this.getCaracteristica(Caracteristica.VELOCIDAD) > competidor.getCaracteristica(Caracteristica.VELOCIDAD);
                    }
                case FUERZA:
                    if (this.getCaracteristica(Caracteristica.FUERZA) == competidor.getCaracteristica(Caracteristica.FUERZA)) {
                        return venceA(competidor, Caracteristica.RESISTENCIA, contador + 1);
                    } else {
                        return this.getCaracteristica(Caracteristica.FUERZA) > competidor.getCaracteristica(Caracteristica.FUERZA);
                    }
                case RESISTENCIA:
                    if (this.getCaracteristica(Caracteristica.RESISTENCIA) == competidor.getCaracteristica(Caracteristica.RESISTENCIA)) {
                        return venceA(competidor, Caracteristica.DESTREZA, contador + 1);
                    } else {
                        return this.getCaracteristica(Caracteristica.RESISTENCIA) > competidor.getCaracteristica(Caracteristica.RESISTENCIA);
                    }
                case DESTREZA:
                    if (this.getCaracteristica(Caracteristica.DESTREZA) == competidor.getCaracteristica(Caracteristica.DESTREZA)) {
                        return venceA(competidor, Caracteristica.VELOCIDAD, contador + 1);
                    } else {
                        return this.getCaracteristica(Caracteristica.DESTREZA) > competidor.getCaracteristica(Caracteristica.DESTREZA);
                    }
                default:
                    throw new CaracteristicaInexistenteException("Característica inexistente: " + caracteristica);
            }
        }
    }

    public boolean esGanador(Competidor competidor, Caracteristica caracteristica) throws CaracteristicaInexistenteException { // FUNCION ENVOLTORIO
        int contador = 0;
        return venceA(competidor, caracteristica, contador);
    }

    public abstract boolean esHeroe();

    public abstract boolean esVillano();

    public abstract boolean contieneA(String string);
}