import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class JLabelGoomba extends JLabel{
	private boolean iden;
	private static final long serialVersionUID = 1L; // Para serializaci�n
	
	public static final int TAMANYO_GOOMBA = 115; // p�xels (igual ancho que largo)

	private static final boolean DIBUJAR_RECTANGULO_BLOQUE = false; // Dibujado (paradepuraci�n)del bounding rectangle del goomba
	
	

	/**
	 * Construye y devuelve el JLabel del goomba con su gr�fico y tama�o
	 */
	
	public JLabelGoomba() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/Goomba1SinFondo.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Goomba1SinFondo.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_GOOMBA, TAMANYO_GOOMBA);

	}
	
	/**
	 * M�todo que construye el JLabel del goomba con su gr�fico y tama�o, 
	 * pero con una orientacion diferente a la inicial
	 */
	
	public void setComponentOrientationGoomba1() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/Goomba1SinFondo.png").toURI().toURL()));
			iden = false;
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Goomba1SinFondo.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_GOOMBA, TAMANYO_GOOMBA);
		
	}
	
	/**
	 * M�todo que construye el JLabel del goomba con su gr�fico y tama�o, 
	 * pero con una orientacion diferente a la inicial
	 */
	
	public void setComponentOrientationGoomba2() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("Imagenes/Goomba2SinFondo.png").toURI().toURL()));
			iden = true;
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Goomba2SinFondo.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_GOOMBA, TAMANYO_GOOMBA);

	}
	
	/**
	 * M�todo que cambia la imagen del goomba
	 */
	
	public void cambiarImgGoomba(){
		if(iden){
			setComponentOrientationGoomba1();
		}
		else{
			setComponentOrientationGoomba2();
		}
	}
	
	/**
	 * M�todo para pintar el componente del goomba
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
		g2.drawImage(img, 0, 0, TAMANYO_GOOMBA, TAMANYO_GOOMBA, null);
		
		if (DIBUJAR_RECTANGULO_BLOQUE)
			g2.drawRect(0,0,TAMANYO_GOOMBA,TAMANYO_GOOMBA);	
			}

}
