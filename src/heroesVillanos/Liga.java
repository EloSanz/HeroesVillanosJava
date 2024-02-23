package heroesVillanos;

import java.util.HashMap;
import java.util.Map;

public class Liga extends Competidor {
    private Map<String, Competidor> competidores; // tanto Personajes como Ligas
    private boolean esHomogenea = true;
    private boolean esLigaDeHeroes = true;
    //
    public Liga(String nombre) {
        this.esLiga = true;
        this.setNombre(nombre);
        this.competidores = new HashMap<>();//compoite implementado
    }

    @Override
	public String toString()
	{
		return "Liga: " + this.nombre;
	}

    public void agregarMiembro(Competidor miembroNuevo) {
        competidores.put(miembroNuevo.getNombre(), miembroNuevo); // Agregar el miembro al HashMap
        // Actualizar los indicadores de la liga
        if (competidores.isEmpty()) {
            esLigaDeHeroes = !miembroNuevo.esVillano();
        } else {
            if (esLigaDeHeroes && miembroNuevo.esVillano()) {
                esLigaDeHeroes = false;
                esHomogenea = false;
            } else if (!esLigaDeHeroes && esHomogenea && miembroNuevo.esHeroe()) {
                esHomogenea = false;
            }
        }
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getVelocidad() {
        double velocidades = 0;
        for (Competidor competidor : competidores.values()) { // Iterar sobre los valores del HashMap
            velocidades += competidor.getVelocidad();
        }
        if (this.esHomogenea) {
            return (velocidades / competidores.size()) * 1.10; // bonus
        }
        return (velocidades / competidores.size());
    }
    
    public double getFuerza() {
        double fuerzas = 0;
        for (Competidor competidor : competidores.values()) { // Iterar sobre los valores del HashMap
            fuerzas += competidor.getFuerza();
        }
        if (this.esHomogenea) {
            return (fuerzas / competidores.size()) * 1.10; // bonus
        }
        return (fuerzas / competidores.size());
    }
    
    public double getResistencia() {
        double resistencias = 0;
        for (Competidor competidor : competidores.values()) { // Iterar sobre los valores del HashMap
            resistencias += competidor.getResistencia();
        }
        if (this.esHomogenea) {
            return (resistencias / competidores.size()) * 1.10; // bonus
        }
        return (resistencias / competidores.size());
    }
    
    public double getDestreza() {
        double destrezas = 0;
        for (Competidor competidor : competidores.values()) { // Iterar sobre los valores del HashMap
            destrezas += competidor.getDestreza();
        }
        if (this.esHomogenea) {
            return (destrezas / competidores.size()) * 1.10; // bonus
        }
        return (destrezas / competidores.size());
    }
    
    @Override
    public boolean esHeroe() {
        return this.esLigaDeHeroes;
    }
    
    @Override
    public boolean esVillano() {
        return (!esLigaDeHeroes && esHomogenea); 
    }
    
    
    public boolean contieneA(String nombre) {

        return competidores.containsKey(nombre); // Utilizar containsKey para verificar si la clave existe en el HashMap
    }

    public boolean contieneA(Competidor other) {
    if (competidores.containsKey(other.getNombre())) {
        return true;
    } else {
        for (Competidor competidor : competidores.values()) {
            if (competidor.getEsLiga()) {
                Liga liga = (Liga) competidor;
                if (liga.contieneA(other)) {
                    return true;
                }
            }
        }
    }
    return false;
}
    public Map<String, Competidor> getCompetidores() {
        return this.competidores; 
    }

    public void quitarMiembro(Competidor miembro) {
       this.competidores.remove(miembro.getNombre());
    }

}
