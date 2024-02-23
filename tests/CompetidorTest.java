package tests;
import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import heroesVillanos.Caracteristica;
import heroesVillanos.Competidor;
import heroesVillanos.Heroe;
import heroesVillanos.Villano;
import Excepciones.CaracteristicaNegativaException;
import Excepciones.CaracteristicaInexistenteException;

public class CompetidorTest {

	@Test
	public void caracteristicaNegativaExceptionTest () throws  CaracteristicaNegativaException{

		assertThrows(
				CaracteristicaNegativaException.class, 
				()->{new Heroe("Clark Kent", "Superman", -500, 300, 210, 160);},
				"Expected dothing() to throw, but it didn't");
	}
	
	
	@Test
	public void esGanadorTestVelocidad(){
		try {
		Competidor p1 = new Villano("Arthur Fleck", "El Guasón", 200, 210, 220, 205);
		Competidor p2 = new Heroe("Barry Allen", "Flash", 500, 250, 240, 400);
		assertTrue(p2.esGanador(p1, Caracteristica.VELOCIDAD));

		}catch(CaracteristicaNegativaException  e) {
		}
		catch(CaracteristicaInexistenteException e) {
		}
	}
	
	@Test
	public void esGanadorTestFuerza() {
		try {
		Competidor p1 = new Heroe("Steve Rogers", "Captain America", 300, 350, 400, 350);
		Competidor p2 = new Heroe("Tony Stark", "Iron Man", 400, 400, 400, 350);
		assertTrue(p2.esGanador(p1, Caracteristica.FUERZA));
	}catch(CaracteristicaNegativaException  e) {
		
	}catch(CaracteristicaInexistenteException e) {
		
	}
	}
	@Test
	public void esGanadorTestResistencia() {
		try {
			Competidor p1 = new Villano("Victor Fries", "Mr. Freeze",320, 280, 350, 300);
			Competidor p2 = new Villano("Selina Kyle", "Catwoman", 280, 300, 250, 350);
			assertTrue(p1.esGanador(p2, Caracteristica.RESISTENCIA));
		}catch(CaracteristicaNegativaException  e) {
			
		}catch(CaracteristicaInexistenteException e) {
			
		}
	}
	
	@Test
	public void esGanadorTestDestreza() {
		try {
			Competidor p1 = new Heroe("Norman Osborn", "Green Goblin", 300, 250, 300, 550);
			Competidor p2 = new Villano("Peter Parker", "Spider-Man", 350, 300, 300, 350);
			assertTrue(p1.esGanador(p2, Caracteristica.DESTREZA));
		}catch(CaracteristicaNegativaException  e) {
			
		}catch(CaracteristicaInexistenteException e) {
			
		}
	}
	@Test
	public void esGanadorTestEmpate() {
		try {
			Competidor p1 = new Heroe("Lucas Diaz", "Pepe patea traseros", 300, 250, 100, 500);
			Competidor p2 = new Villano("Alejandro Perez", "Pana Rabbit", 300, 250, 100, 500);
			assertTrue(!p1.esGanador(p2, Caracteristica.VELOCIDAD) && !p2.esGanador(p1, Caracteristica.VELOCIDAD));
		}catch(CaracteristicaNegativaException  e) {
			
		}catch(CaracteristicaInexistenteException e) {
			
		}

	}
}
