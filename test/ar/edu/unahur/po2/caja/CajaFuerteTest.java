package ar.edu.unahur.po2.caja;

import static org.junit.Assert.*;

import org.junit.Test;

public class CajaFuerteTest {

	@Test
	public void queAlCrearSeCreaAbierta() {
		CajaFuerte caja = new CajaFuerte();
		assertEquals(true,caja.estaAbierta());
	}
	
	/* Se deben ELIMINAR ya que son deficientes o se deben refactorizar
	 @Test 
	public void queCuandoLaCierroEstaCerrada() {
		CajaFuerte caja = new CajaFuerte();
		caja.cerrar();
		assertEquals(false,caja.estaAbierta());
	}
	
	@Test 
	public void queAlAbrirSeAbra() {
		CajaFuerte caja = new CajaFuerte();
		caja.cerrar();
		caja.abrir();
		assertEquals(true,caja.estaAbierta());
	}
	 */

	@Test
	public void queAlCerrarlaEstaCerrada() {
		CajaFuerte caja = new CajaFuerte();
		caja.cerrar(1234);
		assertEquals(false,caja.estaAbierta());
	}
	
	@Test
	public void queAlAbrirSeAbra() {
		CajaFuerte caja = new CajaFuerte();
		caja.cerrar(1234);
		caja.abrir(1234);
		assertEquals(true,caja.estaAbierta());
	}
	
	@Test
	public void queAlCerrarConClaveEstaCerrada() {
		CajaFuerte caja = new CajaFuerte();
		caja.cerrar(1234);		
		assertEquals(false,caja.estaAbierta());
	}
	
	@Test
	public void queAlAbrirConClaveDeCierreSeAbra() {
		CajaFuerte caja = new CajaFuerte();
		caja.cerrar(1234);
		caja.abrir(1234);
		assertEquals(true,caja.estaAbierta());
	}
	
	@Test
	public void queNoSePuedaCerrarSiYaEstaCerrada() {
		CajaFuerte caja = new CajaFuerte();
		caja.cerrar(1234);
		caja.cerrar(4321);
		caja.abrir(4321);
		assertEquals(false,caja.estaAbierta());
	}
	
	@Test
	public void queAlAbrirConClaveIncorrectaNoSeAbra() {
		CajaFuerte caja = new CajaFuerte();
		caja.cerrar(1234);
		caja.abrir(4321);
		assertEquals(false,caja.estaAbierta());
	}
	
	@Test
	public void queSeBloqueaDespuesDe3IntentosFallidos() {
		CajaFuerte caja = new CajaFuerte();
		caja.cerrar(1234);		
		caja.abrir(4321);
		caja.abrir(4321);
		caja.abrir(4321);
		assertEquals(true,caja.estaBloqueada());
	}	
	
	@Test
	public void queLuegoDeAperturaExitosaSeReseteanLosIntentosFallidos() {
		CajaFuerte caja = new CajaFuerte();
		caja.cerrar(1234);		
		caja.abrir(4321);
		caja.abrir(4321);
		caja.abrir(1234);
		caja.cerrar(2345);
		caja.abrir(1234);
		assertEquals(false,caja.estaBloqueada());
	}
	
	@Test
	public void queNoSePuedaAbrirSiEstaBloqueda() {
		CajaFuerte caja = new CajaFuerte();
		caja.cerrar(1234);		
		caja.abrir(4321);
		caja.abrir(4321);
		caja.abrir(4321);		
		assertEquals(true,caja.estaBloqueada());
		caja.abrir(1234);
		assertEquals(false,caja.estaAbierta());
		assertEquals(true,caja.estaBloqueada());		
	}		
}
