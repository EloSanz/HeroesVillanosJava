package heroesVillanos;

import java.util.Comparator;

import Excepciones.CaracteristicaNegativaException;

public abstract class Personaje extends Competidor {
    private String nombreReal;
    private String nombrePersonaje;

    private int velocidad;
    private int fuerza;
    private int resistencia;
    private int destreza;

    public Personaje(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia,
            int destreza) throws CaracteristicaNegativaException {
        this.nombreReal = nombreReal;
        this.nombrePersonaje = nombrePersonaje;

        setVelocidad(velocidad);
        setFuerza(fuerza);
        setResistencia(resistencia);
        setDestreza(destreza);
    }

    public void setVelocidad(int velocidad) throws CaracteristicaNegativaException {
        if (velocidad < 0) {
            throw new CaracteristicaNegativaException("La velocidad no puede ser negativa");
        }
        this.velocidad = velocidad;
    }

    public void setFuerza(int fuerza) throws CaracteristicaNegativaException {
        if (fuerza < 0) {
            throw new CaracteristicaNegativaException("La fuerza no puede ser negativa");
        }
        this.fuerza = fuerza;
    }

    public void setResistencia(int resistencia) throws CaracteristicaNegativaException {
        if (resistencia < 0) {
            throw new CaracteristicaNegativaException("La resistencia no puede ser negativa");
        }
        this.resistencia = resistencia;
    }

    public void setDestreza(int destreza) throws CaracteristicaNegativaException {
        if (destreza < 0) {
            throw new CaracteristicaNegativaException("La destreza no puede ser negativa");
        }
        this.destreza = destreza;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public double getVelocidad() {
        return this.velocidad;
    }

    public double getFuerza() {
        return this.fuerza;
    }

    public double getResistencia() {
        return this.resistencia;
    }

    public double getDestreza() {
        return this.destreza;
    }

    // COMPARADORES
    public static final Comparator<Personaje> VELOCIDAD = Comparator.comparingDouble(Personaje::getVelocidad);
    public static final Comparator<Personaje> FUERZA = Comparator.comparingDouble(Personaje::getFuerza);
    public static final Comparator<Personaje> RESISTENCIA = Comparator.comparingDouble(Personaje::getResistencia);
    public static final Comparator<Personaje> DESTREZA = Comparator.comparingDouble(Personaje::getDestreza);

}