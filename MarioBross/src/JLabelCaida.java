import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelCaida extends JLabel {
	private static final long serialVersionUID = 4L; // Para serializaci�n

	public static final int TAMANYO_LARGO = 320; // p�xels (igual ancho que
													// largo)
	
	public static final int TAMANYO_ANCHO = 100; 

	private static final boolean DIBUJAR_RECTANGULO_CAIDA = false; // Dibujado(paradepuraci�n) del bounding rectangle de la caida
																

	/**
	 * Construye y devuelve el JLabel de la caida con su gr�fico y tama�o
	 */

	public JLabelCaida() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/CaidaMario.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: CaidaMario.png no encontrado");
			e.printStackTrace();
		}
		setBounds(0, 0, TAMANYO_LARGO, TAMANYO_ANCHO);

	}

	/**
	 * M�todo para pintar el componente de la caida
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
		g2.drawImage(img, 0, 0, TAMANYO_LARGO, TAMANYO_ANCHO, null);

		if (DIBUJAR_RECTANGULO_CAIDA)
			g2.drawRect(0, 0, TAMANYO_LARGO , TAMANYO_ANCHO);
	}

}

