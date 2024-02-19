package heroesVillanos;

import Excepciones.CaracteristicaInexistenteException;

public abstract class Competidor {

    public abstract double getVelocidad();

    public abstract double getFuerza();

    public abstract double getResistencia();

    public abstract double getDestreza();

    public abstract void mostrar();

    public boolean venceA(Competidor competidor, Caracteristica caracteristica, int contador) throws CaracteristicaInexistenteException {
        if(contador > 3) {
            return false;
        } else {
            switch (caracteristica) {
                case VELOCIDAD:
                    if(this.getVelocidad() == competidor.getVelocidad()) {
                        return venceA(competidor, Caracteristica.FUERZA, contador++);
                    } else {
                        return this.getVelocidad() > competidor.getVelocidad();
                    }
                case FUERZA:
                    if(this.getFuerza() == competidor.getFuerza()) {
                        return venceA(competidor, Caracteristica.RESISTENCIA, contador++);
                    } else {
                        return this.getFuerza() > competidor.getFuerza();
                    }
                case RESISTENCIA:
                    if(this.getResistencia() == competidor.getResistencia()) {
                        return venceA(competidor, Caracteristica.DESTREZA, contador++);
                    } else {
                        return this.getResistencia() > competidor.getResistencia();
                    }
                case DESTREZA:
                    if(this.getDestreza() == competidor.getDestreza()) {
                        return venceA(competidor, Caracteristica.VELOCIDAD, contador++);
                    } else {
                        return this.getDestreza() > competidor.getDestreza();
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

}