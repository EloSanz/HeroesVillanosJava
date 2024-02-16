package heroesVillanos;

public abstract class Personaje {
    private String nombreReal;
    private String nombrePersonaje;
    private int velocidad;
    private int fuerza;
    private int resistencia;
    private int destreza;

    public Personaje(String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia, int destreza) {
    	this.nombreReal = nombreReal;
    	this.nombrePersonaje = nombrePersonaje;
        setVelocidad(velocidad);
        setFuerza(fuerza);
        setResistencia(resistencia);
        setDestreza(destreza);
    }
    public Personaje()
    {
    	
    }
    public boolean venceA(Personaje otro, Caracteristica caracteristica) {
        switch (caracteristica) {
            case VELOCIDAD:
                return this.velocidad > otro.velocidad;
            case FUERZA:
                return this.fuerza > otro.fuerza;
            case RESISTENCIA:
                return this.resistencia > otro.resistencia;
            case DESTREZA:
                return this.destreza > otro.destreza;
            default:
            	throw new IllegalArgumentException("Característica inexistente: " + caracteristica);
        }
    }

    
    public void setVelocidad(int velocidad) {
        if (velocidad < 0) {
            throw new IllegalArgumentException("La velocidad no puede ser negativa");
        }
        this.velocidad = velocidad;
    }

    public void setFuerza(int fuerza) {
        if (fuerza < 0) {
            throw new IllegalArgumentException("La fuerza no puede ser negativa");
        }
        this.fuerza = fuerza;
    }

    public void setResistencia(int resistencia) {
        if (resistencia < 0) {
            throw new IllegalArgumentException("La resistencia no puede ser negativa");
        }
        this.resistencia = resistencia;
    }

    public void setDestreza(int destreza) {
        if (destreza < 0) {
            throw new IllegalArgumentException("La destreza no puede ser negativa");
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
}