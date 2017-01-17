
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Clase para definir instancias lógicas del mundo
 */

public class Mundo {
	private JPanel panel; // Atributo del panel visual del juego
	static Mario Mario; // Atributo que contiene al Mario del juego
	private static long UltimaHora; //Atributo para saber la última hora de creación de los caparazones
	private Random numR = new Random(); // Nuevo generador de números random
	private JLabelTuberia t; //Atributo que contiene una etiqueta gráfica de una tubería
	public boolean movGoomba = false; // Atributo que guarda variable de movimiento para el goomba
	private int posInicialGoomba1Estatica; // Atributo que guarda la posición inicial del goomba
	private int posInicialGoomba2Estatica; // Atributo que guarda la segunda posición inicial del goomba
	private int contGoomba = 0; // Atributo contador del goomba
	private boolean margenError = false; // Atributo que guarda el margen de error que se puede producir
	public static boolean caidaGoomba = false; // Atributo que guarda si hay caida o no del goomba
	public int caidaGoombaNumero; // Atributo que guarda el número para la caida del goomba
	public static boolean perderVidaGoomba = false; // Atributo para saber si el goomba a muerto
	public static boolean ganarVidaSeta = false;// Atributo para saber si se suma vida
//	private int j; //Atributo que guardara una variable que usaremos para la creacion de monedas
	public boolean crearMiniMonedasBoolean = false;
	
	JLabelCaparazonVerde CV = new JLabelCaparazonVerde(); // Atributo Jlabel para caparazón verde
	JLabelTuberia Tuberia = new JLabelTuberia(); // Atributo Jlabel para tuberia
	JLabelBloque Bloque = new JLabelBloque(); // Atributo Jlabel para bloque
	JLabelBloqueA BloqueA = new JLabelBloqueA(); // Atributo Jlabel para bloque amarillo
	JLabelCaida Caida = new JLabelCaida(); // Atributo Jlabel para caida
	JLabelMoneda Moneda = new JLabelMoneda(); //Atributo Jlabel para monedass
	JLabelTuberiaGrande TuberiaGrande = new JLabelTuberiaGrande(); // Atributo jlabel para la tuberia grande
	JLabelGoomba Goomba = new JLabelGoomba(); // Atributo jlabel para el goomba
	JLabelSetaVida setaVida = new JLabelSetaVida(); // Atributo jlabel de la seta vida
	JLabelBloqueUsado bloqueUsado = new JLabelBloqueUsado(); // Atributo jlabel del bloque usado
	
	static ArrayList<Integer> aPosInicialGoomba = new ArrayList<Integer>(); // Array que guarda las posiciones iniciales de los goombas
	static ArrayList<Integer> aContGoomba = new ArrayList<Integer>(); // Array que guarda los contadores de los gombas
	static ArrayList<JLabelVida> aVida = new ArrayList(); // Array que guarda las vidas de Mario
	static ArrayList<JLabelBloque> aBloques = new ArrayList(); //Aray que guarda los bloques
	static ArrayList<JLabelBloqueA> aBloquesA = new ArrayList(); // Array que guarda los bloques amarillos
	static ArrayList<JLabelTuberia> aTuberias = new ArrayList(); // Array que guarda las tuberias
	static ArrayList<JLabelCaida> aCaida = new ArrayList(); // Array que guarda las caidas de Mario
	static ArrayList<JLabelTuberiaGrande> aTuberiaGrande = new ArrayList(); // Array que guarda las tuberias grandes
	static ArrayList<JLabelMoneda> aMonedas = new ArrayList(); // Array que guarda las monedas
	static ArrayList<JLabelMoneda> aMonedasReserva = new ArrayList();
	static ArrayList<JLabelMiniMoneda> aMiniMonedas = new ArrayList();
	static ArrayList<JLabelGoomba> aGoomba = new ArrayList(); // Array que guarda los goombas
	static ArrayList<JLabelCaparazonRojo> aCR = new ArrayList(); // Array que guarda los caparazones rojos
	static ArrayList<JLabelCaparazonVerde> aCV = new ArrayList(); // Array que guarda los caparazones verdes
	static ArrayList<JLabelSetaVida> aSetaVida = new ArrayList(); // Array que guarda las setas de vida
	static ArrayList<JLabelBloqueUsado> aBloquesUsados = new ArrayList(); // Array que guarda los bloques usados
	
	/**
	 * Construye un mundo de juego
	 * 
	 * @param panel
	 *            Panel visual del juego
	 */
	public Mundo(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * Crea un Mario nuevo y lo añade al mundo y al panel visual
	 * 
	 * @param posX
	 *            Posición X de pixel del nuevo Mario
	 * @param posY
	 *            Posición Y de píxel del nuevo Mario
	 */
	
	public void creaMario(int posX, int posY) {
		// Crear y añadir el Mario a la ventana
		Mario = new Mario();
		Mario.setPosicion(posX, posY);
		panel.add(Mario.getGrafico()); // Añade al panel visual
		Mario.getGrafico().repaint(); // Refresca el dibujado de Mario

	}
	
	/**
	 * Método que crea una nueva seta de vida y lo añade al panel visual
	 * 
	 */
	
	public void crearSetaVida(){
		setaVida = new JLabelSetaVida();
		setaVida.setLocation(1120, 660);
		panel.add(setaVida);
		aSetaVida.add(setaVida);
		
		setaVida = new JLabelSetaVida();
		setaVida.setLocation(6320, 320);
		panel.add(setaVida);
		aSetaVida.add(setaVida);
		
		setaVida = new JLabelSetaVida();
		setaVida.setLocation(9720, 320);
		panel.add(setaVida);
		aSetaVida.add(setaVida);
		

		setaVida = new JLabelSetaVida();
		setaVida.setLocation(17700, 660);
		panel.add(setaVida);
		aSetaVida.add(setaVida);
	}
	
	/**
	 * Método que realiza la salida de una setavida desde dentro de un bloque
	 * @return si hay una salida
	 * 
	 */
	
	public void SaleSetaVida() {
		for (int i = 0; i < aSetaVida.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aSetaVida.get(i).getBounds())
					&& Mario.getPosY() < 860 && Mario.getPosY()>aBloquesA.get(i).getY()) {
				if(aSetaVida.get(i) != null){
					JLabelSetaVida setaVida = aSetaVida.get(i);
					setaVida.move(setaVida.getX(), setaVida.getY() - 105);	
					}
			}
		}
	}
	
	/**
	 * Método que cambia de bloque amarillo por el usado
	 */
	public void cambioBloqueAmarilloBloqueUsado(){
		for(int i = 0; i<aBloquesA.size(); i++){
			if(Mario.getGrafico().getBounds().intersects(aBloquesA.get(i).getBounds()) 
					&& Mario.getPosY()>aBloquesA.get(i).getY() && Mario.getPosY() < 860 ){
				aBloquesA.get(i).setVisible(false);
				bloqueUsado = new JLabelBloqueUsado();
				bloqueUsado.setLocation(aBloquesA.get(i).getX(), aBloquesA.get(i).getY());
				panel.add(bloqueUsado);
				aBloquesUsados.add(bloqueUsado);
			}
		}
	}
	
	/**
	 * Método que cambia de bloque normal por el usado
	 */
	public void cambioBloqueNormalBloqueUsado(){
		for(int i = 0; i<aBloquesA.size(); i++){
			if(Mario.getGrafico().getBounds().intersects(aBloquesA.get(i).getBounds()) 
					&& Mario.getPosY()>aBloquesA.get(i).getY() && Mario.getPosY() < 860 ){
				aBloquesA.get(i).setBackground(Color.black);
				aBloquesA.get(i).setOpaque(true);
			}
		}
	}
	
//	/**
//	 * Método que devuelve el bloque que toca mario
//	 */
//	public int devolverBloqueA(){
//		for(int i = 0; i<aBloquesA.size();i++){
//			if(Mario.getGrafico().getBounds().intersects(aBloquesA.get(i).getBounds())){
//				return i;
//			}
//		}
//		return -1;
//	}
//	
	
	public void eliminarSetaVida() {
		for(int k = 0; k<aSetaVida.size();k++){
		if(Mario.getGrafico().getBounds().intersects(aSetaVida.get(k).getBounds())){
		JLabelSetaVida setaVida = aSetaVida.get(k);
		panel.remove(setaVida);
		setaVida.move(setaVida.getX(), setaVida.getY() - 1000);
		panel.repaint();
		ganarVidaSeta = true;
		}
		}
	}

	
	/**
	 * Método que crea un nuevo Corazón que mostrará la vida y lo añade al panel visual
	 * 
	 */

	public void creaCorazon() {
		int cont = Mario.getVida();
		int x = 35;
		for (int i = 0; i < cont; i++) {
			JLabelVida Corazon = new JLabelVida();
			Corazon.setLocation(x, 25);
			panel.add(Corazon);
			panel.repaint();
			aVida.add(Corazon);
			x = x + 30;
		}

	}
	
	/**
	 * Método que crea una nueva mini moneda para saber cuantas hay
	 * 
	 */
	public void creaMiniMoneda() {
		int cont = Mario.getMonedas();
		int x = 35;
		for (int i = 0; i < cont; i++) {
			JLabelMiniMoneda Moneda = new JLabelMiniMoneda();
			Moneda.setLocation(x, 65);
			panel.add(Moneda);
			panel.repaint();
			aMiniMonedas.add(Moneda);
			x = x + 30;
		}

	}

	/**
	 * Método que elimina un corazon del panel visual cuando Mario pierde una vida
	 * 
	 */

	public void eliminaCorazon() {
		int i = this.aVida.size() - 1;
		while (i >= 0) {
			JLabelVida Corazon = aVida.get(i);
			if (Mario.getVida() < aVida.size()) {
				panel.remove(Corazon);
				panel.repaint();
				aVida.remove(Corazon);

			}
			--i;
		}

	}
	
	/**
	 * Crea una nueva moneda y la añade al panel visual bajo los bloques
	 * 
	 */

	public void creaMoneda() {

		Moneda = new JLabelMoneda();
		Moneda.setLocation(1220, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(1020, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(2020, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(2120, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(2220, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(3220, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(3320, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(3420, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(3520, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(3620, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(4920, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(5020, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(5120, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(5220, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(9120, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(9320, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(9520, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(9720, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(9920, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(10120, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(10320, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(9320, 320);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(9420, 320);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(9520, 320);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(9620, 320);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(9820, 320);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(9920, 320);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(10020, 320);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(10120, 320);
		panel.add(Moneda);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(17600, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);

		Moneda = new JLabelMoneda();
		Moneda.setLocation(17800, 660);
		panel.add(Moneda);
		aMonedas.add(Moneda);
	}

	/**
	 * Método que realiza la salida de una moneda desde dentro de un bloque
	 * @return si hay una salida
	 * 
	 */
	
	public void SaleMoneda() {
		for (int i = 0; i < aMonedas.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aMonedas.get(i).getBounds())
					&& Mario.getPosY() > aMonedas.get(i).getY() && Mario.getPosY() < 860) {
				if (aMonedas.get(i) != null) {
					JLabelMoneda moneda = aMonedas.get(i);
					moneda.move(moneda.getX(), moneda.getY() - 100);
					aMonedasReserva.add(moneda);
					}
			}
		}
	}
	
	public void elevarMoneda(){
		for(int i = 0; i<aMonedasReserva.size(); i++){
			aMonedasReserva.get(i).move(aMonedasReserva.get(i).getX(), aMonedasReserva.get(i).getY() - 2);
			if(aMonedasReserva.get(i).getY()== 0){
				eliminaMoneda(i);
			}
		}
	}

	/**
	 * Método que elimina la moneda que ha salido
	 * 
	 */
	
	public void eliminaMoneda(int j) {
		JLabelMoneda moneda = aMonedas.get(j);
		moneda.setVisible(false);
		panel.remove(moneda);
		panel.repaint();
		Mario.setMonedas(Mario.getMonedas()+1);
		crearMiniMonedasBoolean = true;
		
	}

	/**
	 * Método para la creación de los goombas, los añadirá al panel visual
	 * 
	 */
	
	public void crearGoomba() {
		Goomba = new JLabelGoomba();
		Goomba.setLocation(7200, 894);
		panel.add(Goomba);
		aGoomba.add(Goomba);

		// aPosInicialGoomba.add(aGoomba.get(0).getX());
		// posInicialGoomba1Estatica = aGoomba.get(0).getX();

		Goomba = new JLabelGoomba();
		Goomba.setLocation(14300, 894);
		panel.add(Goomba);
		aGoomba.add(Goomba);

		// aPosInicialGoomba.add(aGoomba.get(1).getX());
		// posInicialGoomba2Estatica = aGoomba.get(1).getX();

		aContGoomba.add(0);
		aContGoomba.add(0);
	}
	
	/**
	 * Método que calcula si hay alguna intersección con los goombas
	 * @return verdadero si hay una interseccion
	 * 
	 */

	public static boolean interseccionGoombas() {
		for (int n = 0; n < aGoomba.size(); n++) {
			for (int i = 0; i < aTuberias.size(); i++) {
				if (aGoomba.get(n).getBounds().intersects(aTuberias.get(i).getBounds())) {
					return true;
				}
			}
			for (int j = 0; j < aBloques.size(); j++) {
				if (aGoomba.get(n).getBounds().intersects(aBloques.get(j).getBounds())) {
					return true;
				}
			}
			for (int k = 0; k < aTuberiaGrande.size(); k++) {
				if (aGoomba.get(n).getBounds().intersects(aTuberiaGrande.get(k).getBounds())) {
					return true;
				}
			}
			for (int l = 0; l < aBloquesA.size(); l++) {
				if (aGoomba.get(n).getBounds().intersects(aBloquesA.get(l).getBounds())) {
					return true;
				}
			}

			for (int m = 0; m < aCaida.size(); m++) {
				if (aGoomba.get(n).getBounds().intersects(aCaida.get(m).getBounds())) {
					return true;
				}
			}
		}

		return false;
	}
	
	/**
	 * Método que mueve el goomba hacia la derecha
	 * 
	 */

	public void moverGoombaD() {
		for (int i = 0; i < aGoomba.size(); i++) {
			// aPosInicialGoomba.set(i, aPosInicialGoomba.get(i)+10);
			aContGoomba.set(i, aContGoomba.get(i) + 1);
			// if(aPosInicialGoomba.get(i).intValue() <=
			// posInicialGoomba1Estatica + 580 ||
			// aPosInicialGoomba.get(i).intValue() <= posInicialGoomba2Estatica
			// + 580 ){ //7800
			if (!Mundo.interseccionGoombas() || !margenError) {
				aGoomba.get(i).move(aGoomba.get(i).getX() + 10, (aGoomba.get(i).getY()));
				if (aContGoomba.get(i) == 8) {
					aGoomba.get(i).cambiarImgGoomba();
					aContGoomba.set(i, 0);
					margenError = true;
				}
			} else {
				movGoomba = true;
				for (int e = 0; e < aContGoomba.size(); e++) {
					aContGoomba.set(e, 0);
				}
			}
		}
	}
	
	/**
	 * Método que mueve el goomba hacia la izquierda
	 * 
	 */

	public void moverGoombaI() {
		for (int i = 0; i < aGoomba.size(); i++) {
			// aPosInicialGoomba.set(i, aPosInicialGoomba.get(i)-10);
			aContGoomba.set(i, aContGoomba.get(i) + 1);
			// if(aPosInicialGoomba.get(i).intValue() >=
			// posInicialGoomba1Estatica - 760 ||
			// aPosInicialGoomba.get(i).intValue() >= posInicialGoomba2Estatica
			// - 760){ //6440
			if (!Mundo.interseccionGoombas() || margenError) {
				aGoomba.get(i).move(aGoomba.get(i).getX() - 10, (aGoomba.get(i).getY()));
				if (aContGoomba.get(i) == 8) {
					aGoomba.get(i).cambiarImgGoomba();
					aContGoomba.set(i, 0);
					margenError = false;
				}
			} else {
				movGoomba = false;
				for (int e = 0; e < aContGoomba.size(); e++) {
					aContGoomba.set(e, 0);
				}
			}
		}

	}
	
	/**
	 * Método que calcula si hay interacción con el goomba
	 * 
	 */

	public void interaccionGoomba() {
		for (int i = 0; i < aGoomba.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aGoomba.get(i).getBounds())) {
				if (Mario.getGrafico().getBounds().getMaxY() == 910) {// 910 es más o menos la posición máxima de los goombas
					caidaGoombaNumero = i;
					caidaGoomba = true;
				} else {
					perderVidaGoomba = true;
				}
			}
		}
	}

	/**
	 * Método que calcula si el goomba cae, se realizará una caida tras perder una vida
	 * 
	 */
	
	public static void caidaDeLosGoombas(int i) {
		perderVidaGoomba = false;
		aGoomba.get(i).setLocation(aGoomba.get(i).getX(), aGoomba.get(i).getY() + 20);
		if (aGoomba.get(i).getY() >= 1100) {
			caidaGoomba = false;
			aGoomba.get(i).setVisible(false);
		}

	}

	/**
	 * Crea un nuevo Bloque y lo añade al panel visual
	 */

	public void creaBloque() {
		Bloque = new JLabelBloque();
		Bloque.setLocation(1220, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(1020, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(2020, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(2120, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(2220, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(3220, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(3320, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(3420, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(3520, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(3620, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(4920, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(5020, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(5120, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(5220, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(6320, 900);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(6320, 800);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(7920, 900);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(8020, 900);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(8020, 800);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(9120, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(9320, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(9520, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(9720, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(9920, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(10120, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(10320, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(9320, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(9420, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(9520, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(9620, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(9820, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(9920, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(10020, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(10120, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(12200, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(12200, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// Triangulo de bloques 1
		Bloque = new JLabelBloque();
		Bloque.setLocation(13000, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(13100, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(13100, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(13200, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(13200, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(13200, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(13300, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(13300, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(13400, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// Primer cuadrado de bloques
		Bloque = new JLabelBloque();
		Bloque.setLocation(14920, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(14920, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(14920, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(15020, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(15120, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(15220, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(15320, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(15320, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(15320, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// Segundo cuadrado de bloques
		Bloque = new JLabelBloque();
		Bloque.setLocation(16200, 999);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16200, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16200, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16200, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16300, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16400, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16500, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16500, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16500, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16500, 999);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(17600, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(17800, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// Piramide de bloques final
		// -- fila 1

		Bloque = new JLabelBloque();
		Bloque.setLocation(18910, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19010, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19110, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19210, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19310, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19410, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// -- fila 2

		Bloque = new JLabelBloque();
		Bloque.setLocation(19010, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19110, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19210, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19310, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19410, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// -- fila 3

		Bloque = new JLabelBloque();
		Bloque.setLocation(19110, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19210, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19310, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19410, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// -- fila 4

		Bloque = new JLabelBloque();
		Bloque.setLocation(19210, 599);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19310, 599);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19410, 599);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// -- fila 5

		Bloque = new JLabelBloque();
		Bloque.setLocation(19310, 499);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19410, 499);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// -- fila 6

		Bloque = new JLabelBloque();
		Bloque.setLocation(19410, 399);
		panel.add(Bloque);
		aBloques.add(Bloque);
	}
	
	/**
	 * Método que crea las caidas y las añade al panel visual
	 * 
	 */

	public void crearCaida() {

		Caida = new JLabelCaida();
		Caida.setLocation(2005, 999);
		panel.add(Caida);
		aCaida.add(Caida);

		Caida = new JLabelCaida();
		Caida.setLocation(4980, 999);
		panel.add(Caida);
		aCaida.add(Caida);

		Caida = new JLabelCaida();
		Caida.setLocation(15520, 998);
		panel.add(Caida);
		aCaida.add(Caida);

		Caida = new JLabelCaida();
		Caida.setLocation(16280, 998);
		panel.add(Caida);
		aCaida.add(Caida);

	}

	/**
	 * Crea un nuevo Bloque Amarillo y lo añade al panel visual
	 */
	
	public void creaBloqueA() {
		

		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(1120, 660);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(3420, 320);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(6320, 320);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(9220, 660);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(9420, 660);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(9620, 660);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(9820, 660);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(10020, 660);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(10220, 660);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(9720, 320);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(12060, 200);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

		// Primer cuadrado de bloques
		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(15120, 320);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(17700, 660);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

	}

	/**
	 * Método que crea las tuberias pequeñas y las añade al panel visual
	 * 
	 */

	public void crearTuberia() {

		Tuberia.setLocation(1820, 650);
		panel.add(Tuberia);
		aTuberias.add(Tuberia);

		Tuberia = new JLabelTuberia();
		Tuberia.setLocation(8110, 650);
		panel.add(Tuberia);
		aTuberias.add(Tuberia);

		Tuberia = new JLabelTuberia();
		Tuberia.setLocation(11835, 650);
		panel.add(Tuberia);
		aTuberias.add(Tuberia);

		Tuberia = new JLabelTuberia();
		Tuberia.setLocation(17900, 650);
		panel.add(Tuberia);
		aTuberias.add(Tuberia);
	}

	/**
	 * Método que crea las tuberias grandes y las añade al panel visual
	 * 
	 */
	
	public void crearTuberiaGrande() {

		TuberiaGrande = new JLabelTuberiaGrande();
		TuberiaGrande.setLocation(12020, 550);
		panel.add(TuberiaGrande);
		aTuberiaGrande.add(TuberiaGrande);

	}

	/**
	 * Si han pasado más de 1,2 segundos desde la última, * crea un caparazon
	 * nuevo nuevo en una posición aleatoria y la añade al mundo y al panel
	 * visual
	 */

	public void creaCV() {

		if (System.currentTimeMillis() - UltimaHora > 12000) {
			JLabelCaparazonVerde CV = new JLabelCaparazonVerde();
			CV.setLocation(numR.nextInt(panel.getWidth() - CV.TAMANYO_CV), this.panel.getHeight() - 1080);
			panel.add(CV);
			CV.repaint();
			aCV.add(CV);
			UltimaHora = System.currentTimeMillis();
		}

	}

	/**
	 * Si han pasado más de 1,2 segundos desde la última, * crea un caparazon
	 * nuevo nuevo en una posición aleatoria y la añade al mundo y al panel
	 * visual
	 */

	public void creaCR() {

		if (System.currentTimeMillis() - UltimaHora > 12000) {
			JLabelCaparazonRojo CR = new JLabelCaparazonRojo();
			CR.setLocation(panel.getWidth() - CV.TAMANYO_CV, this.panel.getHeight() - 105);
			panel.add(CR);
			CR.repaint();
			aCR.add(CR);
			UltimaHora = System.currentTimeMillis();
		}

	}

	/**
	 * Método que mueve el caparazón verde
	 * 
	 */

	public void moverCV() {
		for (int i = 0; i < aCV.size(); i++) {
			aCV.get(i).move(aCV.get(i).getX(), aCV.get(i).getY() + 10);
			if (aCV.get(i).getY() >= 950) {
				panel.remove(aCV.get(i));
				panel.repaint();
				aCV.remove(aCV.get(i));
			}
		}

	}

	/**
	 * Método que mueve el caparazón rojo hacia la izquierda
	 * 
	 */

	public void moverCR() {
		for (int i = 0; i < aCR.size(); i++) {
			aCR.get(i).move(aCR.get(i).getX() - 10, aCR.get(i).getY());
		}
	}

	/**
	 * Método que mueve el caparazón rojo hacia la  derecha
	 * 
	 */

	public void moverCR2() {
		for (int i = 0; i < aCR.size(); i++) {
			aCR.get(i).move(aCR.get(i).getX() + 20, aCR.get(i).getY());
		}
	}

	/**
	 * Método que mueve los bloques, los bloques amarillos, las tuberias pequeñas y grandes, los goombas y las monedas
	 * hacia la izquierda
	 * 
	 */

	public void moverObjetoI() {
		for (int i = 0; i < aBloques.size(); i++) {
			aBloques.get(i).move(aBloques.get(i).getX() - 20, (aBloques.get(i).getY()));
		}
		for (int a = 0; a < aBloquesA.size(); a++) {
			aBloquesA.get(a).move(aBloquesA.get(a).getX() - 20, (aBloquesA.get(a).getY()));
		}
		for (int e = 0; e < aTuberias.size(); e++) {
			aTuberias.get(e).move(aTuberias.get(e).getX() - 20, (aTuberias.get(e).getY()));
		}
		for (int o = 0; o < aCaida.size(); o++) {
			aCaida.get(o).move(aCaida.get(o).getX() - 20, (aCaida.get(o).getY()));
		}
		for (int u = 0; u < aTuberiaGrande.size(); u++) {
			aTuberiaGrande.get(u).move(aTuberiaGrande.get(u).getX() - 20, (aTuberiaGrande.get(u).getY()));
		}
		for (int v = 0; v < aGoomba.size(); v++) {
			aGoomba.get(v).move(aGoomba.get(v).getX() - 20, (aGoomba.get(v).getY()));
		}
		for (int j = 0; j < aMonedas.size(); j++) {
			if (aMonedas.get(j) != null) {
				aMonedas.get(j).move(aMonedas.get(j).getX() - 20, (aMonedas.get(j).getY()));
			}
		}
		for (int l = 0; l < aSetaVida.size(); l++) {
			if(aSetaVida.get(l) != null){
				aSetaVida.get(l).move(aSetaVida.get(l).getX() - 20, (aSetaVida.get(l).getY()));
			}
		}

		for (int k = 0; k < aCV.size(); k++) {
			if (!aCV.isEmpty() && aCV.get(k) != null) {
				aCV.get(k).move(aCV.get(k).getX() - 20, (aCV.get(k).getY()));
			}
		}
		
		for (int ñ = 0; ñ < aBloquesUsados.size(); ñ++) {
			aBloquesUsados.get(ñ).move(aBloquesUsados.get(ñ).getX() - 20, (aBloquesUsados.get(ñ).getY()));
		}
	}
	
	/**
	 * Método que mueve los bloques, los bloques amarillos, las tuberias pequeñas y grandes, los goombas y las monedas
	 * hacia la derecha
	 * 
	 */
	
	public void moverObjetoD() {
		for (int i = 0; i < aBloques.size(); i++) {
			aBloques.get(i).move(aBloques.get(i).getX() + 20, (aBloques.get(i).getY()));
		}
		for (int a = 0; a < aBloquesA.size(); a++) {
			aBloquesA.get(a).move(aBloquesA.get(a).getX() + 20, (aBloquesA.get(a).getY()));
		}
		for (int e = 0; e < aTuberias.size(); e++) {
			aTuberias.get(e).move(aTuberias.get(e).getX() + 20, (aTuberias.get(e).getY()));
		}
		for (int o = 0; o < aCaida.size(); o++) {
			aCaida.get(o).move(aCaida.get(o).getX() + 20, (aCaida.get(o).getY()));
		}
		for (int u = 0; u < aTuberiaGrande.size(); u++) {
			aTuberiaGrande.get(u).move(aTuberiaGrande.get(u).getX() + 20, (aTuberiaGrande.get(u).getY()));
		}
		for (int v = 0; v < aGoomba.size(); v++) {
			aGoomba.get(v).move(aGoomba.get(v).getX() + 20, (aGoomba.get(v).getY()));
		}
		for (int j = 0; j < aMonedas.size(); j++) {
			if (aMonedas.get(j) != null) {
				aMonedas.get(j).move(aMonedas.get(j).getX() + 20, (aMonedas.get(j).getY()));
			}
		}
		for (int l = 0; l < aSetaVida.size(); l++) {
			if(aSetaVida.get(l) != null){
				aSetaVida.get(l).move(aSetaVida.get(l).getX() + 20, (aSetaVida.get(l).getY()));
			}
		}

		for (int k = 0; k < aCV.size(); k++) {
			if (!aCV.isEmpty() && aCV.get(k) != null) {
				aCV.get(k).move(aCV.get(k).getX() + 20, (aCV.get(k).getY()));
			}
		}
		
		for (int ñ = 0; ñ < aBloquesUsados.size(); ñ++) {
			aBloquesUsados.get(ñ).move(aBloquesUsados.get(ñ).getX() + 20, (aBloquesUsados.get(ñ).getY()));
		}
	}

	/**
	 * Método que fija la caida
	 * @return si hay o no caida
	 * 
	 */

	public static boolean caida() {
		for (int i = 0; i < aCaida.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aCaida.get(i).getBounds())) {
				Mario.setCaida(true);
				return true;
			}
		}
		return false;

	}
	
	/**
	 * Método para la interseccion del choque horizontal
	 * @return si hay o no interseccion
	 * 
	 */

	public boolean interseccion() {

		for (int i = 0; i < aTuberias.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aTuberias.get(i).getBounds())
					&& !Mario.getGrafico().EsEspejo()) {
				return true;
			}
		}
		for (int j = 0; j < aBloques.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aBloques.get(j).getBounds())
					&& !Mario.getGrafico().EsEspejo()) {
				return true;
			}
		}
		for (int k = 0; k < aTuberiaGrande.size(); k++) {
			if (Mario.getGrafico().getBounds().intersects(aTuberiaGrande.get(k).getBounds())
					&& !Mario.getGrafico().EsEspejo()) {
				return true;
			}
		}
		for (int l = 0; l < aBloquesA.size(); l++) {
			if (Mario.getGrafico().getBounds().intersects(aBloquesA.get(l).getBounds())
					&& !Mario.getGrafico().EsEspejo()) {
				return true;
			}
		}

		return false;
	}
	
	/**
	 * Método para la segunda interseccion del choque horizontal
	 * @return si hay o no interseccion
	 * 
	 */
	
	public boolean interseccion2() {

		for (int i = 0; i < aTuberias.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aTuberias.get(i).getBounds())
					&& Mario.getGrafico().EsEspejo()) {
				return true;
			}
		}
		for (int j = 0; j < aBloques.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aBloques.get(j).getBounds())
					&& Mario.getGrafico().EsEspejo()) {
				return true;
			}
		}
		for (int k = 0; k < aTuberiaGrande.size(); k++) {
			if (Mario.getGrafico().getBounds().intersects(aTuberiaGrande.get(k).getBounds())
					&& Mario.getGrafico().EsEspejo()) {
				return true;
			}
		}
		for (int l = 0; l < aBloquesA.size(); l++) {
			if (Mario.getGrafico().getBounds().intersects(aBloquesA.get(l).getBounds())
					&& Mario.getGrafico().EsEspejo()) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Método para la interseccion del caparazon rojo
	 * @return si hay o no interseccion
	 * 
	 */
	public boolean interseccionCR() {

		for (int n = 0; n < aCR.size(); n++) {
			for (int i = 0; i < aTuberias.size(); i++) {
				if (aCR.get(n).getBounds().intersects(aTuberias.get(i).getBounds())) {
					return true;
				}
			}
			for (int j = 0; j < aBloques.size(); j++) {
				if (aCR.get(n).getBounds().intersects(aBloques.get(j).getBounds())) {
					return true;
				}
			}
			for (int k = 0; k < aTuberiaGrande.size(); k++) {
				if (aCR.get(n).getBounds().intersects(aTuberiaGrande.get(k).getBounds())) {
					return true;
				}
			}
			for (int l = 0; l < aBloquesA.size(); l++) {
				if (aCR.get(n).getBounds().intersects(aBloquesA.get(l).getBounds())) {
					return true;
				}
			}

			for (int m = 0; m < aCaida.size(); m++) {
				if (aCR.get(n).getBounds().intersects(aCaida.get(m).getBounds())) {
					return true;
				}
			}
		}

		return false;

	}
	
	/**
	 * Método que elimina caparazón rojo
	 * 
	 */

	public void eliminarCR() {
		int i = this.aCR.size() - 1;
		while (i >= 0) {
			JLabelCaparazonRojo CR = aCR.get(i);
			if (interseccionCR()) {
				panel.remove(CR);
				panel.repaint();
				aCR.remove(CR);

			}
			--i;
		}
	}
	
	/**
	 * Método de apoyo para que mario se quede sobre los objetos
	 * @return si hay o no apoyo
	 * 
	 */

	public static boolean apoyo() {

		for (int i = 0; i < aTuberias.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aTuberias.get(i).getBounds())
					&& Mario.getPosY() <= aTuberias.get(i).getY()) {
				Mario.gravedad = Mario.gravedad - 20;
				Mario.setPosY(Mario.gravedad);
				return true;
			}
		}

		for (int i = 0; i < aBloques.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aBloques.get(i).getBounds())
					&& Mario.getPosY() <= aBloques.get(i).getY() - 100) {
				Mario.gravedad = Mario.gravedad - 20;
				Mario.setPosY(Mario.gravedad);
				return true;
			}
		}

		for (int k = 0; k < aTuberiaGrande.size(); k++) {
			if (Mario.getGrafico().getBounds().intersects(aTuberiaGrande.get(k).getBounds())
					&& Mario.getPosY() <= aTuberiaGrande.get(k).getY()) {
				Mario.gravedad = Mario.gravedad - 20;
				Mario.setPosY(Mario.gravedad);
				return true;
			}
		}

		for (int l = 0; l < aBloquesA.size(); l++) {
			if (Mario.getGrafico().getBounds().intersects(aBloquesA.get(l).getBounds())
					&& Mario.getPosY() <= aBloquesA.get(l).getY() - 100) {
				Mario.gravedad = Mario.gravedad - 20;
				Mario.setPosY(Mario.gravedad);
				return true;
			}
		}
		return false;

	}

	/**
	 * Método para saber si hay un choque vertical con algunos de los objetos del mundo
	 * @return si hay o no choque vertical cn dicho objeto
	 * 
	 */
	
	public boolean choqueV() {
		for (int i = 0; i < aBloques.size(); i++) {

			if (Mario.getGrafico().getBounds().intersects(aBloques.get(i).getBounds())
					&& Mario.getPosY() > aBloques.get(i).getY() && Mario.getPosY() < 860) {
				Mario.gravedad = Mario.getGravedad() + 20;
				Mario.setSalto(false);
				Mario.setCaida(true);
				return true;
			}
		}

		for (int i = 0; i < aBloquesA.size(); i++) {

			if (Mario.getGrafico().getBounds().intersects(aBloquesA.get(i).getBounds())
					&& Mario.getPosY() > aBloquesA.get(i).getY() && Mario.getPosY() < 860) {
				Mario.gravedad = Mario.getGravedad() + 20;
				Mario.setSalto(false);
				Mario.setCaida(true);
				return true;
			}
		}
		return false;
	}

	/**
	 * Método para saber si hay un choque con un caparazon verde
	 * 
	 * @return si hay o no choque con dicho objeto
	 * 
	 */

	public boolean choqueCV() {
		if (!aCV.isEmpty()) {
			for (int i = 0; i < aCV.size(); i++) {
				JLabelCaparazonVerde CV = aCV.get(i);
				if (Mario.getGrafico().getBounds().intersects(aCV.get(i).getBounds())) {
					panel.remove(CV);
					aCV.remove(CV);
					panel.repaint();
					return true;
				}
			}
		}
		return false;

	}
	
	/**
	 * Método para saber si hay un choque con un caparazon rojo
	 * @return si hay o no choque con dicho objeto
	 * 
	 */
	
	public boolean choqueCR() {
		if (!aCR.isEmpty()) {
			for (int i = 0; i < aCR.size(); i++) {
				JLabelCaparazonRojo CR = aCR.get(i);
				if (Mario.getGrafico().getBounds().intersects(aCR.get(i).getBounds())) {
					panel.remove(CR);
					aCR.remove(CR);
					panel.repaint();
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * Devuelve el Mario del mundo
	 * 
	 * @return Mario en el mundo. Si no lo hay, devuelve null
	 */
	
	public Mario getMario() {
		return Mario;
	}

}