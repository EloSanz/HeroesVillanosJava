package archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.nio.charset.StandardCharsets; // para que lea caracteres especiales

import Excepciones.CaracteristicaNegativaException;
import heroesVillanos.Competidor;
import heroesVillanos.Heroe;
import heroesVillanos.Liga;
import heroesVillanos.Villano;

public class Archivo {
    private String nombreArchivo;

    public Archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void cargarPersonajes(Set<Competidor> personajes) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo, StandardCharsets.UTF_8))) { // UTF-8 para que lea caracteres especiales
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", "); // lee linea por linea

                if (partes.length == 7) { // si la linea es correcta
                    String tipo = partes[0];
                    String nombreReal = partes[1];
                    String nombrePersonaje = partes[2];
                    int velocidad = Integer.parseInt(partes[3]);
                    int fuerza = Integer.parseInt(partes[4]);
                    int resistencia = Integer.parseInt(partes[5]);
                    int destreza = Integer.parseInt(partes[6]);
                    if ("Héroe".equals(tipo)) {
                        try {
                            personajes.add(
                                    new Heroe(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza));
                        } catch (CaracteristicaNegativaException e) {
                            e.printStackTrace();
                        }
                    } else if ("Villano".equals(tipo)) {
                        try {
                            personajes.add(
                                    new Villano(nombreReal, nombrePersonaje, velocidad, fuerza, resistencia, destreza));
                        } catch (CaracteristicaNegativaException e) {
                            e.printStackTrace();
                        }
                    }
                } // else es Incorrecta, podríamos hacer un archivo de erorres.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarLigas(Set<Competidor> competidores) {
        try (BufferedReader bf = new BufferedReader(new FileReader(nombreArchivo, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] partes = linea.split(", ");
                Liga liga = new Liga(partes [0]);
                for(int i = 1; i < partes.length; i++)//cargo miembros.
                {
                    String miembroBuscado = partes[i];
                    for (Competidor competidor : competidores) {
                        if(miembroBuscado.equals(competidor.getNombre()))
                            {
                                liga.agregarMiembro(competidor);
                                break; //no hay competidores con el mismo nombre.
                            }
                    }
                }
                competidores.add(liga);                
            }            
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
