
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;



public class Mundo {
	private JPanel panel; // panel visual del juego
	static Mario Mario; // Mario del juego
	private static long UltimaHora; // Para saber la última hora de creación de
									// los caparazones verdes
	private JLabelTuberia t;
	private Random numR = new Random(); // Nuevo generador de números random
	
	
	// Variables de los Goombas
	public boolean movGoomba = false;
	private int posInicialGoomba1Estatica;
	private int posInicialGoomba2Estatica;
	private int contGoomba = 0;
	private boolean margenError = false;
	public static boolean caidaGoomba = false;
	public int caidaGoombaNumero;
	public static boolean perderVidaGoomba = false;
	private int j;
	static ArrayList<Integer> aPosInicialGoomba = new ArrayList<Integer>();
	static ArrayList<Integer> aContGoomba = new ArrayList<Integer>();
	JLabelCaparazonVerde CV = new JLabelCaparazonVerde(); // Nuevo Jlabel Para
															// capazaron
	JLabelTuberia Tuberia = new JLabelTuberia();
	JLabelBloque Bloque = new JLabelBloque();
	JLabelBloqueA BloqueA = new JLabelBloqueA();
	JLabelCaida Caida = new JLabelCaida();
	JLabelTuberiaGrande TuberiaGrande = new JLabelTuberiaGrande();
	JLabelGoomba Goomba = new JLabelGoomba();
	ArrayList<JLabelVida> aVida = new ArrayList();
	static ArrayList<JLabelBloque> aBloques = new ArrayList();
	static ArrayList<JLabelBloqueA> aBloquesA = new ArrayList();
	static ArrayList<JLabelTuberia> aTuberias = new ArrayList();
	static ArrayList<JLabelCaida> aCaida = new ArrayList();
	static ArrayList<JLabelTuberiaGrande> aTuberiaGrande = new ArrayList();
	static ArrayList<JLabelMoneda> aMonedas = new ArrayList();
	static ArrayList<JLabelGoomba> aGoomba = new ArrayList();
	ArrayList<JLabelCaparazonRojo>aCR=new ArrayList();

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
	 * Crea un nuevo Corazón que mostrará la vida y lo añade al panel visual
	 * 
	 */

	public void creaCorazon() {
		int cont = Mario.getVida();
		int x = 50;
		for (int i = 0; i < cont; i++) {
			JLabelVida Corazon = new JLabelVida();
			Corazon.setLocation(x, 50);
			panel.add(Corazon);
			panel.repaint();
			aVida.add(Corazon);
			x = x + 20;
		}

	}

	/**
	 * Elimina corazon
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
	
	public void creaMoneda(){

		JLabelMoneda moneda = new JLabelMoneda();
		moneda.setLocation(1220, 660);
		panel.add(moneda);
		aMonedas.add(moneda);
		
		moneda = new JLabelMoneda();
		moneda.setLocation(1020, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(2020, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(2120, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(2220, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(3220, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(3320, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(3420, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(3520, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(3620, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(4920, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(5020, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(5120, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(5220, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(6320, 900);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(6320, 800);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(7920, 900);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(8020, 900);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(8020, 800);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(9120, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(9320, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(9520, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(9720, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(9920, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(10120, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(10320, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(9320, 320);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(9420, 320);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(9520, 320);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(9620, 320);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(9820, 320);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(9920, 320);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(10020, 320);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(10120, 320);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(12200, 899);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(12200, 799);
		panel.add(moneda);
		aMonedas.add(moneda);
		
		//Triangulo de monedas 1
		moneda = new JLabelMoneda();
		moneda.setLocation(12910, 899);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(13010, 799);
		panel.add(moneda);
		aMonedas.add(moneda);
		
		moneda = new JLabelMoneda();
		moneda.setLocation(13010, 899);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(13110, 699);
		panel.add(moneda);
		aMonedas.add(moneda);
		
		moneda = new JLabelMoneda();
		moneda.setLocation(13110, 799);
		panel.add(moneda);
		aMonedas.add(moneda);
		
		moneda = new JLabelMoneda();
		moneda.setLocation(13110, 899);
		panel.add(moneda);
		aMonedas.add(moneda);
		
		moneda = new JLabelMoneda();
		moneda.setLocation(13210, 799);
		panel.add(moneda);
		aMonedas.add(moneda);
		
		moneda = new JLabelMoneda();
		moneda.setLocation(13210, 899);
		panel.add(moneda);
		aMonedas.add(moneda);
		
		moneda = new JLabelMoneda();
		moneda.setLocation(13310, 899);
		panel.add(moneda);
		aMonedas.add(moneda);

		// Primer cuadrado de monedas
		moneda = new JLabelMoneda();
		moneda.setLocation(14920, 899);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(14920, 799);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(14920, 699);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(15020, 699);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(15120, 699);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(15220, 699);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(15320, 699);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(15320, 799);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(15320, 899);
		panel.add(moneda);
		aMonedas.add(moneda);

		// Segundo cuadrado de monedas
		moneda = new JLabelMoneda();
		moneda.setLocation(16220, 999);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(16220, 899);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(16220, 799);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(16220, 699);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(16320, 699);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(16420, 699);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(16520, 699);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(16520, 799);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(16520, 899);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(16520, 999);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(17620, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(17820, 660);
		panel.add(moneda);
		aMonedas.add(moneda);

		// Piramide de monedas final
		// -- fila 1

		moneda = new JLabelMoneda();
		moneda.setLocation(18720, 899);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(18820, 899);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(18920, 899);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(19020, 899);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(19120, 899);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(19220, 899);
		panel.add(moneda);
		aMonedas.add(moneda);

		// -- fila 2

		moneda = new JLabelMoneda();
		moneda.setLocation(18820, 799);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(18920, 799);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(19020, 799);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(19120, 799);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(19220, 799);
		panel.add(moneda);
		aMonedas.add(moneda);

		// -- fila 3

		moneda = new JLabelMoneda();
		moneda.setLocation(18920, 699);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(19020, 699);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(19120, 699);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(19220, 699);
		panel.add(moneda);
		aMonedas.add(moneda);

		// -- fila 4

		moneda = new JLabelMoneda();
		moneda.setLocation(19020, 599);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(19120, 599);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(19220, 599);
		panel.add(moneda);
		aMonedas.add(moneda);

		// -- fila 5

		moneda = new JLabelMoneda();
		moneda.setLocation(19120, 499);
		panel.add(moneda);
		aMonedas.add(moneda);

		moneda = new JLabelMoneda();
		moneda.setLocation(19220, 499);
		panel.add(moneda);
		aMonedas.add(moneda);

		// -- fila 6

		moneda = new JLabelMoneda();
		moneda.setLocation(19220, 399);
		panel.add(moneda);
		aMonedas.add(moneda);
	}

	public boolean SaleMoneda() {
		for (int i = 0; i < aBloques.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aBloques.get(i).getBounds())
					&& Mario.getPosY() > aBloques.get(i).getY() && Mario.getPosY() < 860) {
					if(aMonedas.get(i)!=null){
					JLabelMoneda moneda = aMonedas.get(i);
					moneda.move(moneda.getX(), moneda.getY() - 100);
					j = i;
					return true;}
				
			}
		}
		return false;
	}
	
	// TODO
	public void eliminaMoneda() {
		JLabelMoneda moneda = aMonedas.get(j);
		panel.remove(moneda);
		aMonedas.set(j, null);
		Mario.setMonedas(Mario.getMonedas() + 1);
		System.out.println(Mario.getMonedas());
		panel.repaint();
	}

	// Creacion de los goombas
	public void crearGoomba(){
		Goomba = new JLabelGoomba();
		Goomba.setLocation(7200,894);
		panel.add(Goomba);
		aGoomba.add(Goomba);
		
//		aPosInicialGoomba.add(aGoomba.get(0).getX());
//		posInicialGoomba1Estatica =  aGoomba.get(0).getX();
		
		Goomba= new JLabelGoomba();
		Goomba.setLocation(14300,894);
		panel.add(Goomba);
		aGoomba.add(Goomba);
		
//		aPosInicialGoomba.add(aGoomba.get(1).getX());
//		posInicialGoomba2Estatica =  aGoomba.get(1).getX();
		
		aContGoomba.add(0);
		aContGoomba.add(0);
	}
	
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
	
	public void moverGoombaD(){
		for(int i = 0; i<aGoomba.size(); i++){
//			aPosInicialGoomba.set(i, aPosInicialGoomba.get(i)+10);
			aContGoomba.set(i, aContGoomba.get(i) + 1);
//			if(aPosInicialGoomba.get(i).intValue() <= posInicialGoomba1Estatica + 580 || aPosInicialGoomba.get(i).intValue() <= posInicialGoomba2Estatica + 580  ){ //7800
			if(!Mundo.interseccionGoombas() || !margenError){
			aGoomba.get(i).move(aGoomba.get(i).getX() + 10, (aGoomba.get(i).getY()));
				if(aContGoomba.get(i) == 8){
					aGoomba.get(i).cambiarImgGoomba();
					aContGoomba.set(i,0);
					margenError = true;
				}
			}
			else{
				movGoomba = true;
				for(int e = 0; e<aContGoomba.size(); e++){
				aContGoomba.set(e,0);
				}
			}
		}
	}
	
	public void moverGoombaI(){
		for(int i = 0; i<aGoomba.size(); i++){
//			aPosInicialGoomba.set(i, aPosInicialGoomba.get(i)-10);
			aContGoomba.set(i, aContGoomba.get(i) + 1);
//			if(aPosInicialGoomba.get(i).intValue() >= posInicialGoomba1Estatica - 760 || aPosInicialGoomba.get(i).intValue() >= posInicialGoomba2Estatica - 760){ //6440
			if(!Mundo.interseccionGoombas() || margenError){
			aGoomba.get(i).move(aGoomba.get(i).getX() - 10, (aGoomba.get(i).getY()));
			if(aContGoomba.get(i) == 8){
				aGoomba.get(i).cambiarImgGoomba();
				aContGoomba.set(i,0);
				margenError = false;
			}
			}
			else{
				movGoomba = false;
				for(int e = 0; e<aContGoomba.size(); e++){
					aContGoomba.set(e,0);
				}
			}
		}
	
	}
	
	public void interaccionGoomba(){
		for (int i = 0; i < aGoomba.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aGoomba.get(i).getBounds())){
				if( Mario.getGrafico().getBounds().getMaxY()== 910){// 910 es mas o menos la posicion máxima de los goombas
					caidaGoombaNumero = i;
					caidaGoomba = true;
				}
				else{
					perderVidaGoomba = true;
				}
			}		
		}
	}
	
	public static void caidaDeLosGoombas(int i){
		perderVidaGoomba = false;
		aGoomba.get(i).setLocation(aGoomba.get(i).getX(), aGoomba.get(i).getY()+20);
		if(aGoomba.get(i).getY() >= 1100){
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
		
		//Triangulo de bloques 1
		Bloque = new JLabelBloque();
		Bloque.setLocation(12910, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(13010, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(13010, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(13110, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(13110, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(13110, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(13210, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(13210, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(13310, 899);
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
		Bloque.setLocation(16220, 999);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16220, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16220, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16220, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16320, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16420, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16520, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16520, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16520, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(16520, 999);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(17620, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(17820, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// Piramide de bloques final
		// -- fila 1

		Bloque = new JLabelBloque();
		Bloque.setLocation(18720, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(18820, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(18920, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19020, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19120, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19220, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// -- fila 2

		Bloque = new JLabelBloque();
		Bloque.setLocation(18820, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(18920, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19020, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19120, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19220, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// -- fila 3

		Bloque = new JLabelBloque();
		Bloque.setLocation(18920, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19020, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19120, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19220, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// -- fila 4

		Bloque = new JLabelBloque();
		Bloque.setLocation(19020, 599);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19120, 599);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19220, 599);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// -- fila 5

		Bloque = new JLabelBloque();
		Bloque.setLocation(19120, 499);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(19220, 499);
		panel.add(Bloque);
		aBloques.add(Bloque);

		// -- fila 6

		Bloque = new JLabelBloque();
		Bloque.setLocation(19220, 399);
		panel.add(Bloque);
		aBloques.add(Bloque);
	}

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
		Caida.setLocation(15620, 998);
		panel.add(Caida);
		aCaida.add(Caida);

		Caida = new JLabelCaida();
		Caida.setLocation(16300, 998);
		panel.add(Caida);
		aCaida.add(Caida);

	}

	/**
	 * Crea un nuevo Bloque Amarillo y lo añade al panel visual
	 */
	public void creaBloqueA() {

		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(3420, 320);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

		BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(1120, 660);
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
		BloqueA.setLocation(17720, 660);
		panel.add(BloqueA);
		aBloquesA.add(BloqueA);

	}

	//
	//
	// /**
	// * Crea una tubería y la añade al panel visual
	// */

	public void crearTuberia() {

		Tuberia.setLocation(1820, 650);
		panel.add(Tuberia);
		aTuberias.add(Tuberia);

		Tuberia = new JLabelTuberia();
		Tuberia.setLocation(8110, 650);
		panel.add(Tuberia);
		aTuberias.add(Tuberia);

		Tuberia = new JLabelTuberia();
		Tuberia.setLocation(11820, 650);
		panel.add(Tuberia);
		aTuberias.add(Tuberia);

		Tuberia = new JLabelTuberia();
		Tuberia.setLocation(17920, 650);
		panel.add(Tuberia);
		aTuberias.add(Tuberia);
	}

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
			CV.setLocation(numR.nextInt(panel.getWidth() - CV.TAMANYO_CV), this.panel.getHeight() - 1080);
			panel.add(CV);
			CV.repaint();

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
			CR.setLocation(panel.getWidth() - CV.TAMANYO_CV, this.panel.getHeight() - 125);
			panel.add(CR);
			CR.repaint();
			aCR.add(CR);
			UltimaHora = System.currentTimeMillis();
		}

	}

	// Método para mover caparazón verde

	public void moverCV() {
		CV.move(CV.getX(), CV.getY() + 10);
	}
	

	// Método para mover caparazón rojo

	public void moverCR() {
		for(int i=0; i<aCR.size();i++){
			aCR.get(i).move(aCR.get(i).getX()-10, aCR.get(i).getY());
		}
	}
	
	// Método para mover caparazón rojo

		public void moverCR2() {
			for(int i=0; i<aCR.size();i++){
				aCR.get(i).move(aCR.get(i).getX()+20, aCR.get(i).getY());
			}
		}

	// Método para mover Bloque Izquierda

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
		for (int j=0; j<aMonedas.size();j++){
			if(aMonedas.get(j)!=null){
			aMonedas.get(j).move(aMonedas.get(j).getX()-20, (aMonedas.get(j).getY()));}
		}
	}
	//TODO
	// Método para mover Bloque Derecha

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
		for (int j=0; j<aMonedas.size();j++){
			if(aMonedas.get(j)!=null){
			aMonedas.get(j).move(aMonedas.get(j).getX()+20, (aMonedas.get(j).getY()));
		}
		}
	}

	// Método para fijar la caida

	public static boolean caida() {
		for (int i = 0; i < aCaida.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aCaida.get(i).getBounds())) {
				Mario.setCaida(true);
				return true;
			}
		}
		return false;

	}
	// Método para la intersección del choque horizontal

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
	
	
	public void eliminarCR(){
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
	// Método para que Mario se quede en los objetos

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

	// Método para saber si hay un choque con un cv

	public boolean choque() {
		if (Mario.getGrafico().getBounds().intersects(CV.getBounds())) {
			panel.remove(CV);
			panel.repaint();
			return true;
		}
		return false;

	}

	// Método para saber si hay un choque con un cr
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