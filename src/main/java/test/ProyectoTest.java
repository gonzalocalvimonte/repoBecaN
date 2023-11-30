package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import db.consultasDB;
import lector.ProcesaPartido;
import logica.Partido;
import logica.Persona;
import logica.Pronostico;
import logica.metodosUtilitarios;

class ProyectoTest {
	

	@Test
	void test1() {
		ArrayList<Partido> listaPartidos = consultasDB.consultaPartidos();
		System.out.println(listaPartidos);
		int result = metodosUtilitarios.cantRondas(listaPartidos);
		assertEquals(4,result);
	}
	
	@Test
	void test2() {
		ArrayList<Partido> listaPartidos = consultasDB.consultaPartidos();
		System.out.println(listaPartidos);
		int result = metodosUtilitarios.cantRondas(listaPartidos);
		assertEquals(3,result);
	}
	
	@Test
	void test3() {
		
	}

}
