import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelMoneda extends JLabel {

	private static final long serialVersionUID = 1L; // Para serializaci�n

	public static final int TAMANYO_COIN = 80; // p�xels (igual ancho que largo)

	public static final int RADIO_ESFERA_COIN = 38; // Radio en p�xels del
													// bounding circle del
													// caparaz�n (para choques)

	private static final boolean DIBUJAR_ESFERA_COIN = false; // Dibujado
																// (paradepuraci�n)del
																// bounding
																// circle de
																// choque de
																// Mario

	private long hora = System.currentTimeMillis(); // Para saber la hora, lo
													// utilizaremos para la
													// creaci�n de caparazones

	public long getHora() {
		return hora;
	}

	public JLabelMoneda() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/mariobroscoin.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: mariobroscoin.png no encontrado");
			e.printStackTrace();
		}
		setBounds(0, 0, TAMANYO_COIN, TAMANYO_COIN);
	}

	/**
	 * M�todo para pintar el caparaz�n
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
		g2.drawImage(img, 0, 0, TAMANYO_COIN, TAMANYO_COIN, null);
		if (DIBUJAR_ESFERA_COIN)
			g2.drawOval(TAMANYO_COIN / 2 - RADIO_ESFERA_COIN, TAMANYO_COIN / 2 - RADIO_ESFERA_COIN,
					RADIO_ESFERA_COIN * 2, RADIO_ESFERA_COIN * 2);
	}

}
