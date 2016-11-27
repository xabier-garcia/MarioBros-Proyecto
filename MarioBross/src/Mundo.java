import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;




public class Mundo {
	private JPanel panel; // panel visual del juego
	Mario Mario; // Mario del juego
	private static long UltimaHora; // Para saber la última hora de creación de
									// los caparazones verdes
	
	private Random numR = new Random(); //Nuevo generador de números random
	JLabelCaparazonVerde CV = new JLabelCaparazonVerde(); //Nuevo Jlabel Para capazaron
	ArrayList<JLabelBloque> aBloques = new ArrayList();
	ArrayList<JLabelBloqueA> aBloquesA = new ArrayList();
	ArrayList<JLabelTuberia> aTuberias = new ArrayList();

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
	
	//TODO
	
	/**
	 * Crea un nuevo Bloque y lo añade al panel visual
	 */

	
	public void creaBloque(){
		JLabelBloque Bloque = new JLabelBloque();
		Bloque.setLocation(1220, 660);
		panel.add(Bloque);
		Bloque.repaint();
		aBloques.add(Bloque);
		JLabelBloque Bloque2 = new JLabelBloque();
		Bloque2.setLocation(1020, 660);
		panel.add(Bloque2);
		Bloque2.repaint();
		aBloques.add(Bloque2);
		JLabelBloque Bloque3= new JLabelBloque();
		Bloque3.setLocation(2020, 660);
		panel.add(Bloque3);
		Bloque3.repaint();
		aBloques.add(Bloque3);
		JLabelBloque Bloque4= new JLabelBloque();
		Bloque4.setLocation(2120, 660);
		panel.add(Bloque4);
		Bloque4.repaint();
		aBloques.add(Bloque4);
		JLabelBloque Bloque5= new JLabelBloque();
		Bloque5.setLocation(2220, 660);
		panel.add(Bloque5);
		Bloque5.repaint();
		aBloques.add(Bloque5);
		
	}
	
	//TODO
	
	/**
	 * Crea un nuevo Bloque Amarillo y lo añade al panel visual
	 */
	public void creaBloqueA(){
		JLabelBloqueA BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(1120, 660);
		panel.add(BloqueA);
		BloqueA.repaint();	
		aBloquesA.add(BloqueA);
	}
	
//	//TODO
//	
//	/**
//	 * Crea una tubería y la añade al panel visual
//	 */

	public void creaTuberia(){
		JLabelTuberia Tuberia = new JLabelTuberia();
		Tuberia.setLocation(1820, 650);
		panel.add(Tuberia);
		Tuberia.repaint();	
		aTuberias.add(Tuberia);
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
	

	//TODO
	
	//Método para mover Bloque Izquierda
	
	public void moverBloqueI(){
		for(int i=0;i<aBloques.size();i++){
			aBloques.get(i).move(aBloques.get(i).getX()-20, (aBloques.get(i).getY()));
			}
		for(int a=0;a<aBloquesA.size();a++){
			aBloquesA.get(a).move(aBloquesA.get(a).getX()-20, (aBloquesA.get(a).getY()));
			}
		for(int e=0;e<aBloquesA.size();e++){
			aTuberias.get(e).move(aTuberias.get(e).getX()-20, (aTuberias.get(e).getY()));
			}
	}
	
	//TODO
	
	//Método para mover Bloque Derecha
	
		public void moverBloqueD(){
			for(int i=0;i<aBloques.size();i++){
				aBloques.get(i).move(aBloques.get(i).getX()+20, (aBloques.get(i).getY()));
				}
			for(int a=0;a<aBloquesA.size();a++){
				aBloquesA.get(a).move(aBloquesA.get(a).getX()+20, (aBloquesA.get(a).getY()));
				}
			for(int e=0;e<aBloquesA.size();e++){
				aTuberias.get(e).move(aTuberias.get(e).getX()+20, (aTuberias.get(e).getY()));
				}
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