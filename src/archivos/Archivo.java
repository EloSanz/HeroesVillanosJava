package archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import Excepciones.CaracteristicaNegativaException;
import heroesVillanos.Heroe;
import heroesVillanos.Liga;
import heroesVillanos.Personaje;
import heroesVillanos.Villano;

public class Archivo {
    private String nombreArchivo;
    public Archivo(String nombreArchivo)
    {
        this.nombreArchivo = nombreArchivo;
    }
    public List<Personaje> cargarPersonajes() {

        List<Personaje> personajes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", "); //lee linea por linea

                if (partes.length == 7) { //si la linea es correcta
                    String tipo = partes[0];
                    String nombreReal = partes[1];
                    String nombrePersonaje = partes[2];
                    int velocidad = Integer.parseInt(partes[3]);
                    int fuerza = Integer.parseInt(partes[4]);
                    int resistencia = Integer.parseInt(partes[5]);
                    int destreza = Integer.parseInt(partes[6]);
                    if ("Héroe".equals(tipo)) {
                        try {
                            personajes.add(new Heroe(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza));
                        } catch (CaracteristicaNegativaException e) {
                            e.printStackTrace();
                        }
                    } else if ("Villano".equals(tipo)) {
                        try {
                            personajes.add(new Villano(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza));
                        } catch (CaracteristicaNegativaException e) {
                            e.printStackTrace();
                        }
                    }
                }//else es Incorrecta, podríamos hacer un archivo de erorres.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personajes;
    }

    public List<Liga> cargarLigas() 
    {
        List <Liga> ligas = new ArrayList<>();

     
        try(BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while( (linea = bf.readLine()) != null)
            {
                String[] partes = linea.split(", ");
                String nombreLiga = partes[0];
                int cantidadDeMiembros = partes.length;
                Set<String> miembros = new HashSet<>();
                for(int i = 1; i < cantidadDeMiembros; i++)
                {
                    miembros.add(partes[i]);
                }
                ligas.add(new Liga(nombreLiga, miembros));
            }
        }catch(Exception e)
        {   
            e.getMessage();
        }
    return ligas;
    }

}
