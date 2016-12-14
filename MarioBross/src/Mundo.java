import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;





public class Mundo {
	private JPanel panel; // panel visual del juego
	Mario Mario; // Mario del juego
	private static long UltimaHora; // Para saber la última hora de creación de
									// los caparazones verdes
	private JLabelTuberia t;
	private Random numR = new Random(); //Nuevo generador de números random
	JLabelCaparazonVerde CV = new JLabelCaparazonVerde(); //Nuevo Jlabel Para capazaron
	JLabelTuberia Tuberia = new JLabelTuberia();
	JLabelBloque Bloque = new JLabelBloque();
	JLabelBloqueA BloqueA = new JLabelBloqueA();
	JLabelCaida Caida = new JLabelCaida();
	JLabelVida Corazon = new JLabelVida();
	JLabelTuberiaGrande TuberiaGrande = new JLabelTuberiaGrande();
	ArrayList<JLabelBloque> aBloques = new ArrayList();
	ArrayList<JLabelBloqueA> aBloquesA = new ArrayList();
	ArrayList<JLabelTuberia> aTuberias = new ArrayList();
	ArrayList<JLabelCaida> aCaida = new ArrayList();
	ArrayList<JLabelTuberiaGrande> aTuberiaGrande = new ArrayList();

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
	
	public void creaCorazon(){
		Corazon= new JLabelVida();
		Corazon.setLocation(50,50);
		panel.add(Corazon);
		
		
	}
	
	/**
	 * Crea un nuevo Bloque y lo añade al panel visual
	 */

	
	public void creaBloque(){
		Bloque = new JLabelBloque();
		Bloque.setLocation(1220, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1020, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(2020, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(2120, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(2220, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(3220, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(3320, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(3420, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(3520, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(3620, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(4920, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(5020, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(5120, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(5220, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(6320, 900);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(6320, 800);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(7920, 900);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(8020, 900);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(8020, 800);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(9120, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(9320, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(9520, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(9720, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(9920, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(10120, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(10320, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(9320, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(9420, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(9520, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(9620, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(9820, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(9920, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(10020, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(10120, 320);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(12200, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(12200, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(13920, 999);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(14020, 999);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(14120, 999);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		// Primer cuadrado de bloques
		Bloque= new JLabelBloque();
		Bloque.setLocation(14920, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(14920, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(14920, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(15020, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(15120, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(15220, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(15320, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(15320, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(15320, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//Segundo cuadrado de bloques
		Bloque= new JLabelBloque();
		Bloque.setLocation(16220, 999);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(16220, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(16220, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(16220, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(16320, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(16420, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(16520, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(16520, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(16520, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(16520, 999);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(17620, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(17820, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//Piramide de bloques final
		// -- fila 1
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(18720, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(18820, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(18920, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19020, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19120, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19220, 899);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		// -- fila 2
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(18820, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(18920, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19020, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19120, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19220, 799);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		// -- fila 3
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(18920, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19020, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19120, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19220, 699);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		// -- fila 4
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19020, 599);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19120, 599);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19220, 599);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		// -- fila 5
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19120, 499);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19220, 499);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		// -- fila 6
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(19220, 399);
		panel.add(Bloque);
		aBloques.add(Bloque);	
	}
	
	public void crearCaida(){
		
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
	public void creaBloqueA(){
		
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
//	/**
//	 * Crea una tubería y la añade al panel visual
//	 */

	public void crearTuberia(){
		
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
	
	public void crearTuberiaGrande(){
		
		TuberiaGrande = new JLabelTuberiaGrande();
		TuberiaGrande.setLocation(12020, 550);
		panel.add(TuberiaGrande);
		aTuberiaGrande.add(TuberiaGrande);
	
	}
	
	

	
	/**
	 * Si han pasado más de 1,2 segundos desde la última, * crea un caparazon nuevo
	 * nuevo en una posición aleatoria y la añade al mundo y al panel visual
	 */

	public void creaCV() {

		if (System.currentTimeMillis() - UltimaHora > 12000) {
			CV.setLocation(numR.nextInt(panel.getWidth() - CV.TAMANYO_CV), this.panel.getHeight() - 1080);
			panel.add(CV);
			CV.repaint();
			
			UltimaHora = System.currentTimeMillis();
		}

	}
	
	//Método para mover caparazón verde
	
	public void moverCV(){
		CV.move(CV.getX(),CV.getY()+10);
	}
	

	
	//Método para mover Bloque Izquierda
	
	public void moverObjetoI(){
		for(int i=0;i<aBloques.size();i++){
			aBloques.get(i).move(aBloques.get(i).getX()-20, (aBloques.get(i).getY()));
		}
	for(int a=0;a<aBloquesA.size();a++){
			aBloquesA.get(a).move(aBloquesA.get(a).getX()-20, (aBloquesA.get(a).getY()));
		}
		for(int e=0;e<aTuberias.size();e++){
			aTuberias.get(e).move(aTuberias.get(e).getX()-20, (aTuberias.get(e).getY()));
		}
		for(int o=0;o<aCaida.size();o++){
			aCaida.get(o).move(aCaida.get(o).getX()-20, (aCaida.get(o).getY()));
			}
		for(int u=0;u<aTuberiaGrande.size();u++){
			aTuberiaGrande.get(u).move(aTuberiaGrande.get(u).getX()-20, (aTuberiaGrande.get(u).getY()));
			}
	}
	
	//Método para mover Bloque Derecha
	
		public void moverObjetoD(){
			for(int i=0;i<aBloques.size();i++){
				aBloques.get(i).move(aBloques.get(i).getX()+20, (aBloques.get(i).getY()));
				}
			for(int a=0;a<aBloquesA.size();a++){
				aBloquesA.get(a).move(aBloquesA.get(a).getX()+20, (aBloquesA.get(a).getY()));
				}
			for(int e=0;e<aTuberias.size();e++){
				aTuberias.get(e).move(aTuberias.get(e).getX()+20, (aTuberias.get(e).getY()));
				}
			for(int o=0;o<aCaida.size();o++){
				aCaida.get(o).move(aCaida.get(o).getX()+20, (aCaida.get(o).getY()));
				}
			for(int u=0;u<aTuberiaGrande.size();u++){
				aTuberiaGrande.get(u).move(aTuberiaGrande.get(u).getX()+20, (aTuberiaGrande.get(u).getY()));
				}
		}

	// Método para fijar la caida

	public boolean caida() {
		for (int i = 0; i < aCaida.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aCaida.get(i).getBounds())) {
				Mario.setCaida(true);
				return true;
			}
		}
		return false;

	}
		//Método para la intersección del choque horizontal

	public boolean interseccion() {

		for (int i = 0; i < aTuberias.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aTuberias.get(i).getBounds())) {
				return true;
			}
		}
		for (int j = 0; j < aBloques.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aBloques.get(j).getBounds())) {
				return true;
			}
		}
		for (int k = 0; k < aTuberiaGrande.size(); k++) {
			if (Mario.getGrafico().getBounds().intersects(aTuberiaGrande.get(k).getBounds())) {
				return true;
			}
		}
		for (int l = 0; l < aBloquesA.size(); l++) {
			if (Mario.getGrafico().getBounds().intersects(aBloquesA.get(l).getBounds())) {
				return true;
			}
		}

		return false;
	}
	
	// Método para que Mario se quede en los objetos

	public void apoyo() {

		for (int i = 0; i < aTuberias.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aTuberias.get(i).getBounds())
					&& Mario.getPosY() <= aTuberias.get(i).getY()) {
				Mario.gravedad = Mario.gravedad - 20;
				Mario.setPosY(Mario.gravedad);
			}
		}

		for (int i = 0; i < aBloques.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aBloques.get(i).getBounds())
					&& Mario.getPosY() <= aBloques.get(i).getY() - 100) {
				Mario.gravedad = Mario.gravedad - 20;
				Mario.setPosY(Mario.gravedad);
			}
		}

		for (int k = 0; k < aTuberiaGrande.size(); k++) {
			if (Mario.getGrafico().getBounds().intersects(aTuberiaGrande.get(k).getBounds())
					&& Mario.getPosY() <= aTuberiaGrande.get(k).getY()) {
				Mario.gravedad = Mario.gravedad - 20;
				Mario.setPosY(Mario.gravedad);
			}
		}

		for (int l = 0; l < aBloquesA.size(); l++) {
			if (Mario.getGrafico().getBounds().intersects(aBloquesA.get(l).getBounds())
					&& Mario.getPosY() <= aBloquesA.get(l).getY() - 100) {
				Mario.gravedad = Mario.gravedad - 20;
				Mario.setPosY(Mario.gravedad);
			}
		}

	}
	
	//Método para saber si hay un choque con un cv
	
	public boolean choque(){
		if(Mario.getGrafico().getBounds().intersects(CV.getBounds())){
			panel.remove(CV);
			panel.repaint();
			return true;
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