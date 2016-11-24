
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;


public class Mundo {
	private JPanel panel; // panel visual del juego
	Mario Mario; // Mario del juego
	private static long UltimaHora; // Para saber la �ltima hora de creaci�n de
									// los caparazones verdes
	private Random numR = new Random();
	ArrayList<JLabelCaparazonRojo>aCR=new ArrayList();
	JLabelCaparazonVerde CV = new JLabelCaparazonVerde();

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
	 * Crea un Mario nuevo y lo a�ade al mundo y al panel visual
	 * 
	 * @param posX
	 *            Posici�n X de pixel del nuevo Mario
	 * @param posY
	 *            Posici�n Y de p�xel del nuevo Mario
	 */
	public void creaMario(int posX, int posY) {
		// Crear y a�adir el Mario a la ventana
		Mario = new Mario();
		Mario.setPosicion(posX, posY);
		panel.add(Mario.getGrafico()); // A�ade al panel visual
		Mario.getGrafico().repaint(); // Refresca el dibujado de Mario
	}

	/**
	 * Si han pasado m�s de 1,2 segundos desde la �ltima, * crea un caparazon nuevo
	 * nuevo en una posici�n aleatoria y la a�ade al mundo y al panel visual
	 */

	public void creaCV() {

		if (System.currentTimeMillis() - UltimaHora > 12000) {
			CV.setLocation(numR.nextInt(panel.getWidth() - CV.TAMANYO_CV), this.panel.getHeight() - 1080);
			panel.add(CV);
			CV.repaint();
			
			UltimaHora = System.currentTimeMillis();
		}

	}
	
	//M�todo para mover caparaz�n verde
	
	public void moverCV(){
		CV.move(CV.getX(),CV.getY()+10);
	}
	
	/**
	 * Si han pasado m�s de 1 segundos desde la �ltima, * crea una estrella
	 * nueva en una posici�n aleatoria y la a�ade al mundo y al panel visual
	 */

	public void creaCR() {

		if (System.currentTimeMillis() - UltimaHora > 10000) {
			JLabelCaparazonRojo CR = new JLabelCaparazonRojo();
			CR.setLocation(numR.nextInt(panel.getWidth() - CV.TAMANYO_CV), this.panel.getHeight() - 120);
			panel.add(CR);
			CR.repaint();
			aCR.add(CR);
			UltimaHora = System.currentTimeMillis();
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
