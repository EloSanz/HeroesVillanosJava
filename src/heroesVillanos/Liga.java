package heroesVillanos;

import java.util.ArrayList;
import java.util.List;

public class Liga extends Competidor {
    private String nombre;
    private List<Competidor> miembros; //tanto Personajes como Ligas
    
    /* Supongamos que tenemos la liga: "Amigos de Spiderman"
    * 
    * 
    */
    
    public Liga(String nombre) {
        this.setNombre(nombre);
        this.miembros = new ArrayList<>();
    }
    
    public void agregarMiembro(Personaje miembroNuevo) {
        miembros.add(miembroNuevo);
    }

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    public double getVelocidad() {  // CADA VEZ QUE SE LLAMA A ESTE METODO, SE CALCULA NUEVAMENTE EL PROMEDIO
        double velocidades = 0;
        for (Competidor competidor : miembros) {
            velocidades += competidor.getVelocidad();
        }
        
        return (velocidades / miembros.size());
    }

	public double getFuerza() {  // CADA VEZ QUE SE LLAMA A ESTE METODO, SE CALCULA NUEVAMENTE EL PROMEDIO
        double fuerzas = 0;
        for (Competidor competidor : miembros) {
            fuerzas += competidor.getFuerza();
        }
        
        return (fuerzas / miembros.size());
    }

	public double getResistencia() {  // CADA VEZ QUE SE LLAMA A ESTE METODO, SE CALCULA NUEVAMENTE EL PROMEDIO
        double resistencias = 0;
        for (Competidor competidor : miembros) {
            resistencias += competidor.getResistencia();
        }
        
        return (resistencias / miembros.size());
    }

	public double getDestreza() {  // CADA VEZ QUE SE LLAMA A ESTE METODO, SE CALCULA NUEVAMENTE EL PROMEDIO
        double destrezas = 0;
        for (Competidor competidor : miembros) {
            destrezas += competidor.getDestreza();
        }
        
        return (destrezas / miembros.size());
    }

}
