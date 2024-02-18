package heroesVillanos;

import Excepciones.CaracteristicaInexistenteException;

public abstract class Competidor {

    public abstract double getVelocidad();

    public abstract double getFuerza();

    public abstract double getResistencia();

    public abstract double getDestreza();

    public boolean venceA(Competidor competidor, Caracteristica caracteristica)
            throws CaracteristicaInexistenteException {
        switch (caracteristica) {
            case VELOCIDAD:
                return this.getVelocidad() > competidor.getVelocidad();
            case FUERZA:
                return this.getFuerza() > competidor.getFuerza();
            case RESISTENCIA:
                return this.getResistencia() > competidor.getResistencia();
            case DESTREZA:
                return this.getDestreza() > competidor.getDestreza();
            default:
                throw new CaracteristicaInexistenteException("Característica inexistente: " + caracteristica);
        }
    }

    public abstract boolean esHeroe();

    public abstract boolean esVillano();

}