
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelMario extends JLabel {
	private static final long serialVersionUID = 1L; // Para serialización
	public static final int TAMANYO_MARIO = 150; // píxels (igual ancho que
													// algo)
	public static final int RADIO_ESFERA_MARIO = 70; // Radio en píxels del
														// bounding circle del
														// Mario(para choques)
	private static final boolean DIBUJAR_ESFERA_MARIO = false; // Dibujado (para
	private boolean Espejo=false;															// depuración)
																// del bounding
																// circle de
																// choque del
																// Mario

	/**
	 * Construye y devuelve el JLabel del Mario con su gráfico y tamaño
	 */
	public JLabelMario() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/MarioB.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Mario.png no encontrado");
			e.printStackTrace();
		}
		setBounds(0, 0, TAMANYO_MARIO, TAMANYO_MARIO);

	}

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
		g2.drawImage(img, 0, 0, TAMANYO_MARIO, TAMANYO_MARIO, null);
		if (DIBUJAR_ESFERA_MARIO)
			g2.drawOval(TAMANYO_MARIO / 2 - RADIO_ESFERA_MARIO, TAMANYO_MARIO / 2 - RADIO_ESFERA_MARIO,
					RADIO_ESFERA_MARIO * 2, RADIO_ESFERA_MARIO * 2);
	}

	public void setComponentOrientationEspejo() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/MarioBEspejo.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: MarioEspejo.png no encontrado");
			e.printStackTrace();
		}
		setBounds(0, 0, TAMANYO_MARIO, TAMANYO_MARIO);
		Espejo=true;

	}

	public void setComponentOrientationNormal() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/MarioB.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Mario.png no encontrado");
			e.printStackTrace();
		}
		setBounds(0, 0, TAMANYO_MARIO, TAMANYO_MARIO);
		Espejo=false;

	}
	
	public void setComponentOrientationSalto() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/MarioS.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Mario.png no encontrado");
			e.printStackTrace();
		}
		setBounds(0, 0, TAMANYO_MARIO, TAMANYO_MARIO);
		Espejo=false;

	}

	public void setComponentOrientationSaltoEspejo() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/MarioSEspejo.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Mario.png no encontrado");
			e.printStackTrace();
		}
		setBounds(0, 0, TAMANYO_MARIO, TAMANYO_MARIO);
		Espejo=true;
	}
	
	public boolean EsEspejo(){
		return Espejo;
	}
	
	
}
