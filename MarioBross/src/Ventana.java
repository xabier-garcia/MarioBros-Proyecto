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
	MiRunnable2 miHilo2 = null;
	MiRunnable3 miHilo3= null;
	Boolean[] aPulsada = new Boolean[3]; // Array que almacena estado de la
											// tecla


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
			Ventana.Mundo.creaBloque();
			Ventana.Mundo.creaBloqueA();
			Ventana.Mundo.crearTuberia();
			Ventana.Mundo.crearTuberiaGrande();
			Ventana.Mundo.crearCaida();
			Ventana.Mundo.creaCorazon();
			Ventana.Mario.setNombre("Mario Bros");
			Ventana.miHilo = Ventana.new MiRunnable(); // Sintaxis de new
			Ventana.miHilo2 = Ventana.new MiRunnable2();
			Ventana.miHilo3 = Ventana.new MiRunnable3();// para clase
			// interna
			Thread nuevoHilo = new Thread(Ventana.miHilo);
			Thread nuevoHilo2 = new Thread(Ventana.miHilo2);
			Thread nuevoHilo3 = new Thread(Ventana.miHilo3);
			nuevoHilo.start();
			nuevoHilo2.start();
			nuevoHilo3.start();
		} catch (Exception e) {
			System.exit(1); // Error anormal
		}
	}

	class MiRunnable3 implements Runnable {
		boolean sigo = true;

		@Override
		public void run() {

			while (sigo) {
				if (Mundo.choque()) {
					try {
						Thread.sleep(900);
						Mario.setVida(Mario.getVida() - 1);
						Mundo.eliminaCorazon();
						pPrincipal.repaint();

					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (Mario.getVida() == 0) {
						sigo = false;
					}

				}

				// Dormir el hilo 20 milisegundos
				try {
					pPrincipal.repaint();
					Thread.sleep(20);
					pPrincipal.repaint();
				} catch (Exception e) {
				}

			}
		}

		public void acaba() {
			sigo = false;
		}
	}
	
	class MiRunnable2 implements Runnable {
		boolean sigo = true;

		@Override
		public void run() {

			while (sigo) {
				Ventana.this.Mundo.creaCV();
				Ventana.this.Mundo.moverCV();

				if (aPulsada[1] && !aPulsada[0] && ((JPanelFondo) pPrincipal).getVar() != -18840) {
					Mundo.CV.move(Mundo.CV.getX() - 20, Mundo.CV.getY());
				}

				if (aPulsada[2] && !aPulsada[0] && ((JPanelFondo) pPrincipal).getVar() != -60) {
					Mundo.CV.move(Mundo.CV.getX() + 20, Mundo.CV.getY());
				}

				if (aPulsada[1] && aPulsada[0] && ((JPanelFondo) pPrincipal).getVar() != -18840) {
					Mundo.CV.move(Mundo.CV.getX() - 20, Mundo.CV.getY());
					Mundo.CV.move(Mundo.CV.getX() + 10, Mundo.CV.getY());
				}

				if (aPulsada[2] && aPulsada[0] && ((JPanelFondo) pPrincipal).getVar() != -60) {
					Mundo.CV.move(Mundo.CV.getX() + 20, Mundo.CV.getY());
					Mundo.CV.move(Mundo.CV.getX() - 10, Mundo.CV.getY());
				}
				
				if(Mario.getVida()==0){
					sigo=false;
				}

				// Dormir el hilo 40 milisegundos
				try {
					pPrincipal.repaint();
					Thread.sleep(30);
					pPrincipal.repaint();
				} catch (Exception e) {
				}
			}
		}

		public void acaba() {
			sigo = false;
		}

	}

	/**
	 * Clase interna para implementación de bucle principal del juego como un
	 * hilo
	 */

	class MiRunnable implements Runnable {
		boolean sigo = true;

		@Override
		public void run() {
			InicializadorArray();
			// Bucle principal forever hasta que se pare el juego...
			while (sigo) {
				pPrincipal.repaint();
				Mario.saltoMario();
				// Mover "Mario"(Realmente lo que movemos es el fondo creando un
				// efecto óptico de movimiento
				Mundo.apoyo();
				Mundo.choqueV();
				if (aPulsada[0]) {
					if (!Mario.salto) {
						Mario.gravedad = 840;
						Mario.salto = true;
						Mario.cont = true;
						if (Mario.getGrafico().EsEspejo()) {
							Mario.getGrafico().setComponentOrientationSaltoEspejo();
						} else {
							Mario.getGrafico().setComponentOrientationSalto();
							repaint();
						}
					}
					Mario.setPosX(620);
				}

				if (!Mundo.interseccion()) {
					if ((aPulsada[1] && !aPulsada[0]) || (aPulsada[1] && aPulsada[0])) {
						Mario.getGrafico().setComponentOrientationNormal();
						((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() - 20);
						if (((JPanelFondo) pPrincipal).getVar() <= -18840) {
							((JPanelFondo) pPrincipal).setVar(-18840);
						} else {
							if (aPulsada[1] && !aPulsada[2]) {
								Mundo.moverObjetoI();

							}
						}
						Mario.setPosX(620);
					}
				}

				if (!Mundo.interseccion2()) {
					if ((aPulsada[2] && !aPulsada[0]) || (aPulsada[2] && aPulsada[0])) {
						Mario.getGrafico().setComponentOrientationEspejo();
						((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() + 20);

						if (((JPanelFondo) pPrincipal).getVar() >= -60) {
							((JPanelFondo) pPrincipal).setVar(-60);
						} else {
							if (aPulsada[2] && !aPulsada[1]) {
								Mundo.moverObjetoD();
							}
						}
						Mario.setPosX(620);
					}

				}
				
				Mario.setPosX(620);
				Mundo.caida();
				if (Mario.getPosY() >= 1100) {
					Mario.setVida(0);
					Mundo.eliminaCorazon();
					
				}
				
				if(Mario.getVida()==0){
					sigo=false;
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