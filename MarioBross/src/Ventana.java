
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Ventana extends JFrame {
	private static final long serialVersionUID = 1L; // Para serialización
	JPanel pPrincipal; // Panel del juego (layout nulo)
	Mundo Mundo; // Mundo del juego
	Mario Mario; // Mario del juego
	MiRunnable miHilo = null; // Hilo del bucle principal de juego
	Boolean[] aPulsada = new Boolean[3]; // Array que almacena estado de la
											// tecla
	JLabel resultado;

	public void InicializadorArray() {
		for (int i = 0; i < aPulsada.length; i++) {
			aPulsada[i] = false;
		}
	}

	/**
	 * Constructor de la ventana de juego. Crea y devuelve la ventana
	 * inicializada sin coches dentro
	 */
	public Ventana() {
		// Liberación de la ventana por defecto al cerrar
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Creación contenedores y componentes
		pPrincipal = new JPanelFondo();
		// Formato y layouts
		pPrincipal.setLayout(null);
		pPrincipal.setBackground(Color.white);
		// Añadido de componentes a contenedores
		add(pPrincipal, BorderLayout.CENTER);
		// Formato de ventana
		setSize(2000, 1500);
		setResizable(false);

		// Añadido para que también se gestione por teclado con el KeyListener

		pPrincipal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP: {
					aPulsada[0] = true;
					break;
				}
				case KeyEvent.VK_RIGHT: {
					aPulsada[1] = true;
					break;
				}
				case KeyEvent.VK_LEFT: {
					aPulsada[2] = true;
					break;
				}
				}
			}
		});

		pPrincipal.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP: {
					aPulsada[0] = false;
					break;
				}
				case KeyEvent.VK_RIGHT: {
					aPulsada[1] = false;
					break;
				}
				case KeyEvent.VK_LEFT: {
					aPulsada[2] = false;
					break;
				}

				}
			}

		});

		pPrincipal.setFocusable(true);
		pPrincipal.requestFocus();
		pPrincipal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				pPrincipal.requestFocus();
			}
		});

		// Cierre del hilo al cierre de la ventana
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (miHilo != null)
					miHilo.acaba();
			}
		});
	}

	/**
	 * Programa principal de la ventana de juego
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Crea y visibiliza la ventana con el coche
		try {
			final Ventana Ventana = new Ventana();
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					Ventana.setVisible(true);
				}
			});
			Ventana.Mundo = new Mundo(Ventana.pPrincipal);
			Ventana.Mundo.creaMario(620, 860);
			Ventana.Mario = Ventana.Mundo.getMario();
			Ventana.Mario.setNombre("Mario Bros");
			// Crea el hilo de movimiento del coche y lo lanza
			Ventana.miHilo = Ventana.new MiRunnable(); // Sintaxis de new
														// para clase
														// interna
			Thread nuevoHilo = new Thread(Ventana.miHilo);
			nuevoHilo.start();
		} catch (Exception e) {
			System.exit(1); // Error anormal
		}
	}

	/**
	 * Clase interna para implementación de bucle principal del juego como un
	 * hilo
	 * 
	 * @author Andoni Eguíluz Facultad de Ingeniería - Universidad de Deusto
	 *         (2014)
	 */
	class MiRunnable implements Runnable {
		boolean sigo = true;

		@Override
		public void run() {
			InicializadorArray();

			// Bucle principal forever hasta que se pare el juego...
			while (sigo) {
				pPrincipal.repaint();
				// Mover "Mario"(Realmente lo que movemos es el fondo creando un
				// efecto óptico de movimiento

				if (aPulsada[0]) {
					if (Mario.getGrafico().EsEspejo()) {
						Mario.getGrafico().setComponentOrientationSaltoEspejo();
						Mario.salto(Mario);
						pPrincipal.repaint();
					} else {
						Mario.getGrafico().setComponentOrientationSalto();
						Mario.salto(Mario);
						pPrincipal.repaint();
					}
				}

				if (aPulsada[1] && !aPulsada[0]) {
					Mario.getGrafico().setComponentOrientationNormal();
					((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() - 20);
					Mario.setPosX(Mario.getPosX());
					if (((JPanelFondo) pPrincipal).getVar() <= -18840) {
						((JPanelFondo) pPrincipal).setVar(-18840);
					}
				}

				if (aPulsada[2] && !aPulsada[0]) {
					Mario.getGrafico().setComponentOrientationEspejo();
					((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() + 20);
					if (((JPanelFondo) pPrincipal).getVar() >= -60) {
						((JPanelFondo) pPrincipal).setVar(-60);
					}
					Mario.setPosX(Mario.getPosX());
				}

				Ventana.this.Mundo.creaCV();
				Mundo.CV.move(Mundo.CV.getX(),Mundo.CV.getY()+10);
				if (aPulsada[1] && !aPulsada[0]&&((JPanelFondo) pPrincipal).getVar()!=-18840){
					Mundo.CV.move(Mundo.CV.getX()-20,Mundo.CV.getY());	
				}
				if (aPulsada[2] && !aPulsada[0]&&((JPanelFondo) pPrincipal).getVar()!=-60) {
					Mundo.CV.move(Mundo.CV.getX()+20,Mundo.CV.getY());
				}
				
				
				

				// Dormir el hilo 40 milisegundos
				try {
					pPrincipal.repaint();
					Thread.sleep(40);
					pPrincipal.repaint();
				} catch (Exception e) {
				}
			}
		}

		/**
		 * Ordena al hilo detenerse en cuanto sea posible
		 */
		public void acaba() {
			sigo = false;
		}
	};

}
