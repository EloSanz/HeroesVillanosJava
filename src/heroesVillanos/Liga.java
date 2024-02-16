package heroesVillanos;

import java.util.ArrayList;
import java.util.List;

public class Liga implements Luchador {
    private String nombre;
    private List<Luchador> miembros; //tanto Personajes como Ligas
    
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

    @Override
    public boolean venceA(Luchador luchador, Caracteristica caracteristica) {
    	//implementar
        //System.out.println(luchador. + " contra " + competidor.getNombrePersonaje());
    	
        return true;
    }

    

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public boolean esHeroe() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esVillano() {
		// TODO Auto-generated method stub
		return false;
	}
}
