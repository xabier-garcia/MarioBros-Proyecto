
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelBloque extends JLabel {
	private static final long serialVersionUID = 1L; // Para serialización
	
	public static final int TAMANYO_BLOQUE = 100; // píxels (igual ancho que largo)
	
	public static final int ARISTA_RECTANGULO_BLOQUE = 99; // Radio en píxels del bounding circle del Mario(para choques)
	
	private static final boolean DIBUJAR_RECTANGULO_BLOQUE = true; // Dibujado (paradepuración)del bounding circle de choque de Mario
	
	

	/**
	 * Construye y devuelve el JLabel del Bloque con su gráfico y tamaño
	 */
	
	public JLabelBloque() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/BloqueMario.jpg").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Mario.png no encontrado");
			e.printStackTrace();
		}
		setBounds(0, 0, TAMANYO_BLOQUE, TAMANYO_BLOQUE);

	}
	
	/**
	 * Método para pintar el componente de Mario
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
		g2.drawImage(img, 0, 0, TAMANYO_BLOQUE, TAMANYO_BLOQUE, null);
		
		if (DIBUJAR_RECTANGULO_BLOQUE)
			g2.drawRect(0,0,ARISTA_RECTANGULO_BLOQUE,ARISTA_RECTANGULO_BLOQUE);	
			}

}
