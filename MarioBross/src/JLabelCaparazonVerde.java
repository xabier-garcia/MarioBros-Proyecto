import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelCaparazonVerde extends JLabel {
	
private static final long serialVersionUID = 6L; // Para serialización
	
	public static final int TAMANYO_CV = 80; // píxels (igual ancho que largo)
	
	public static final int RADIO_ESFERA_CV= 38; // Radio en píxels del bounding circle del caparazón (para choques)
	
	private static final boolean DIBUJAR_ESFERA_CV = false; // Dibujado (paradepuración)del bounding circle del caparazón verde
	
	private long hora=System.currentTimeMillis(); // Para saber la hora, lo utilizaremos para la creación de caparazones

	/**
	 * Getter de la hora
	 * @return atributo de hora
	 */
	
	public long getHora() {
		return hora;
	}

	/**
	 * Construye y devuelve el JLabel del caparazon verde con su gráfico y tamaño
	 */
	
	public JLabelCaparazonVerde() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/CV.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: CV.png no encontrado");
			e.printStackTrace();
		}
		setBounds(0, 0, TAMANYO_CV, TAMANYO_CV);
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
		g2.drawImage(img, 0, 0, TAMANYO_CV, TAMANYO_CV, null);
		if (DIBUJAR_ESFERA_CV)
			g2.drawOval(TAMANYO_CV / 2 - RADIO_ESFERA_CV, TAMANYO_CV / 2 - RADIO_ESFERA_CV, RADIO_ESFERA_CV * 2,
					RADIO_ESFERA_CV * 2);
	}

}
