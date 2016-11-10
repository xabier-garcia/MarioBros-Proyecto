import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelCaparazonRojo extends JLabel{
private static final long serialVersionUID = 1L; // Para serialización
	
	public static final int TAMANYO_CR = 65; // píxels (igual ancho que largo)
	
	public static final int RADIO_ESFERA_CR= 40; // Radio en píxels del bounding circle del caparazón (para choques)
	
	private static final boolean DIBUJAR_ESFERA_CR = false; // Dibujado (paradepuración)del bounding circle de choque de Mario
	
	
	public JLabelCaparazonRojo() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/CR.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: CR.png no encontrado");
			e.printStackTrace();
		}
		setBounds(0, 0, TAMANYO_CR, TAMANYO_CR);
	}

	/**
	 * Método para pintar el caparazón
	 */

	@Override
	protected void paintComponent(Graphics g) {
		// super.paintComponent(g); // En este caso no nos sirve el pintado
		// normal de un JLabel
		Image img = ((ImageIcon) getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g; // El Graphics realmente es Graphics2D
		// Escalado más fino con estos 3 parámetros:
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Prepara rotación (siguientes operaciones se rotarán)
		// Dibujado de la imagen
		g2.drawImage(img, 0, 0, TAMANYO_CR, TAMANYO_CR, null);
		if (DIBUJAR_ESFERA_CR)
			g2.drawOval(TAMANYO_CR / 2 - RADIO_ESFERA_CR, TAMANYO_CR / 2 - RADIO_ESFERA_CR, RADIO_ESFERA_CR * 2,
					RADIO_ESFERA_CR * 2);
	}


}
