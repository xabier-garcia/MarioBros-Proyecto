import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PruebasTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_Constructor_y_Sets_Mario() {
		Mario mario = new Mario();
		mario.setNombre("Mario");
		mario.setMonedas(0);
		mario.setVida(3);
		mario.setCaida(false);
		mario.setCont(false);
		mario.setSalto(false);
		assertEquals("Mario", mario.getNombre());
		assertEquals(0, mario.getMonedas());
		assertEquals(3, mario.getVida());
		assertEquals(false, mario.isCaida());
		assertEquals(false, mario.isCont());
		assertEquals(false, mario.isSalto());
	}
	
	@Test
	public void test_Choque_CV_y_Choque_CR(){
		Ventana ventana = new Ventana();
		Mundo mundo = new Mundo(ventana.pPrincipal);
		assertEquals(false,mundo.choqueCR());
		assertEquals(false,mundo.choqueCV());
	}

	@Test(expected = NullPointerException.class)
	public void test_Elimina_Vida() {
		Mario mario = new Mario();
		mario.setVida(1);
		Ventana ventana = new Ventana();
		Mundo mundo = new Mundo(ventana.pPrincipal);
		mundo.creaMoneda();
		mundo.creaCorazon();
		mundo.eliminaCorazon();
	}
	
	@Test(expected=NullPointerException.class)
	public void test_Elimina_Moneda(){
		Ventana ventana = new Ventana();
		Mundo mundo = new Mundo(ventana.pPrincipal);
		mundo.creaMoneda();
		mundo.eliminaMoneda(0);	
	}
	
	@Test
	public void test_interseccion_Goombas(){
		Ventana ventana = new Ventana();
		Mundo mundo = new Mundo(ventana.pPrincipal);
		mundo.crearGoomba();
		assertEquals(false,mundo.interseccionGoombas());
	}
	
	@Test
	public void test_moverGoombas(){
		Ventana ventana = new Ventana();
		Mundo mundo = new Mundo(ventana.pPrincipal);
		mundo.moverGoombaI();
		mundo.moverGoombaD();
	}	
}
