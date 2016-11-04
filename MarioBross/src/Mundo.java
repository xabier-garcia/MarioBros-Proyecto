
import java.util.ArrayList;

import javax.swing.JPanel;

public class Mundo {
	private JPanel panel; // panel visual del juego
	Mario Mario; // Coche del juego

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
		// Crear y añadir el coche a la ventana
		Mario = new Mario();
		Mario.setPosicion(posX, posY);
		panel.add(Mario.getGrafico()); // Añade al panel visual
		Mario.getGrafico().repaint(); // Refresca el dibujado de Mario
	}

	/**
	 * Devuelve el Mario del mundo
	 * 
	 * @return Mario en el mundo. Si no lo hay, devuelve null
	 */
	public Mario getMario() {
		return Mario;
	}
	
	/**
	 * Calcula si hay choque en horizontal con los límites del mundo
	 * 
	 * @return true si hay choque horizontal, false si no lo hay
	 */
	public boolean hayChoqueHorizontal(Mario Mario) {
		return (Mario.getPosX() < JLabelMario.RADIO_ESFERA_MARIO - JLabelMario.TAMANYO_MARIO / 2
				|| Mario.getPosX() > panel.getWidth() - JLabelMario.TAMANYO_MARIO / 2 - JLabelMario.RADIO_ESFERA_MARIO);
	}

	/**
	 * Realiza un rebote en horizontal del objeto de juego indicado
	 * 
	 * @param coche
	 *            Objeto que rebota en horizontal
	 */
	public void rebotaHorizontal(Mario mario) {
		// System.out.println( "Choca X");
		double dir = Mario.getPosX();
		dir = 180 - dir; // Rebote espejo sobre OY (complementario de 180)
		if (dir < 0)
			dir = 360 + dir; // Corrección para mantenerlo en [0,360)
		Mario.setPosX(dir);
	}

}
