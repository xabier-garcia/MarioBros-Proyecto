
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelBloqueA extends JLabel {
	private static final long serialVersionUID = 2L; // Para serializaci�n

	public static final int TAMANYO_BLOQUE = 100; // p�xels (igual ancho que
													// largo)

	private static final boolean DIBUJAR_RECTANGULO_BLOQUE = false; // Dibujado (paradepuraci�n)del bounding rectangle del bloque amarillo
	/**
	 * Construye y devuelve el JLabel del Bloque Amarillo con su gr�fico y tama�o
	 */

	public JLabelBloqueA() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/BloqueAmarilloMario.jpg").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: BloqueAmarilloMario.jpg no encontrado");
			e.printStackTrace();
		}
		setBounds(0, 0, TAMANYO_BLOQUE+1, TAMANYO_BLOQUE+1);

	}

	/**
	 * M�todo para pintar el componente del Bloque Amarillo
	 */

	@Override
	protected void paintComponent(Graphics g) {
		// super.paintComponent(g); // En este caso no nos sirve el pintado
		// normal de un JLabel
		Image img = ((ImageIcon) getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g; // El Graphics realmente es Graphics2D
		// Escalado m�s fino con estos 3 par�metros:
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Prepara rotaci�n (siguientes operaciones se rotar�n)
		// Dibujado de la imagen
		g2.drawImage(img, 0, 0, TAMANYO_BLOQUE, TAMANYO_BLOQUE, null);

		if (DIBUJAR_RECTANGULO_BLOQUE)
			g2.drawRect(0, 0, TAMANYO_BLOQUE, TAMANYO_BLOQUE);
	}

}
