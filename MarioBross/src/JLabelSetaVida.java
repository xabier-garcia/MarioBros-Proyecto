import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelSetaVida extends JLabel {

	private static final long serialVersionUID = 10L; // Para serialización
	public static final int TAMANYO_SETAVIDA = 100; // píxels (igual ancho que largo)
	private static final boolean DIBUJAR_SETAVIDA = false; // Dibujado (paradepuración)del bounding circle de la moneda

	/**
	 * Construye y devuelve el JLabel de la moneda con su gráfico y tamaño
	 */
	
	public JLabelSetaVida() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/SetaVidaMarioSinFondo.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: mariobroscoin.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_SETAVIDA+10, TAMANYO_SETAVIDA+10);
	}

	/**
	 * Método para pintar la moneda
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
		g2.drawImage(img, 0, 0, TAMANYO_SETAVIDA, TAMANYO_SETAVIDA, null);
		
		if (DIBUJAR_SETAVIDA)
			g2.drawRect(0, 0, TAMANYO_SETAVIDA, TAMANYO_SETAVIDA);
	}

}
