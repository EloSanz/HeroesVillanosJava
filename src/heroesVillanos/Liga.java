package heroesVillanos;

import java.util.ArrayList;
import java.util.List;

public class Liga extends Competidor {
    private List<Competidor> competidores; // tanto Personajes como Ligas
    private boolean esHomogenea = true;
    private boolean esLigaDeHeroes = true;
    //
    public Liga(String nombre) {
        esLiga = true;
        this.setNombre(nombre);
        this.competidores = new ArrayList<>();
    }

    @Override
	public String toString()
	{
		return "Liga: " + this.nombre;
	}


    public void agregarMiembro(Competidor miembroNuevo) { // YA NO ES BOOLEAN YA QUE NO HAY RESTRICCIONES PARA LAS LIGAS
                                                          // MIXTAS
        if (competidores.isEmpty()) {
            if (this.esLigaDeHeroes != false && miembroNuevo.esVillano()) {
                this.esLigaDeHeroes = false;
            }
        } else {
            if (esLigaDeHeroes && miembroNuevo.esVillano()) {
                this.esLigaDeHeroes = false;
                this.esHomogenea = false;
            } else if (!esLigaDeHeroes && esHomogenea && miembroNuevo.esHeroe()) {
                this.esHomogenea = false;
            }
        }
        competidores.add(miembroNuevo);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVelocidad() { // CADA VEZ QUE SE LLAMA A ESTE METODO, SE CALCULA NUEVAMENTE EL PROMEDIO
        double velocidades = 0;
        for (Competidor competidor : competidores) {
            velocidades += competidor.getVelocidad();
        }
        if (this.esHomogenea)
            return (velocidades / competidores.size()) * 1.10;// bonus

        return (velocidades / competidores.size());
    }

    public double getFuerza() { // CADA VEZ QUE SE LLAMA A ESTE METODO, SE CALCULA NUEVAMENTE EL PROMEDIO
        double fuerzas = 0;
        for (Competidor competidor : competidores) {
            fuerzas += competidor.getFuerza();
        }
        if (this.esHomogenea)
            return (fuerzas / competidores.size()) * 1.10;// bonus
        return (fuerzas / competidores.size());
    }

    public double getResistencia() { // CADA VEZ QUE SE LLAMA A ESTE METODO, SE CALCULA NUEVAMENTE EL PROMEDIO
        double resistencias = 0;
        for (Competidor competidor : competidores) {
            resistencias += competidor.getResistencia();
        }
        if (this.esHomogenea)
            return (resistencias / competidores.size()) * 1.10;// bonus
        return (resistencias / competidores.size());
    }

    public double getDestreza() { // CADA VEZ QUE SE LLAMA A ESTE METODO, SE CALCULA NUEVAMENTE EL PROMEDIO
        double destrezas = 0;
        for (Competidor competidor : competidores) {
            destrezas += competidor.getDestreza();
        }
        if (this.esHomogenea)
            return (destrezas / competidores.size()) * 1.10;// bonus
        return (destrezas / competidores.size());
    }

    @Override
    public boolean esHeroe() {
        return this.esLigaDeHeroes;
    }

    @Override
    public boolean esVillano() {
        return (!esLigaDeHeroes && esHomogenea) ? true : false;
    }


    public List<Competidor> getCompetidores() {
        return this.competidores;
    }

}
