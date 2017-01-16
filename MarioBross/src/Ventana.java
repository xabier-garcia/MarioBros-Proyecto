
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
	JLabelGoomba Goomba; // Atributo que contiene el Jlabel del goomba
	MiRunnable miHilo = null; // Hilo del bucle principal de juego
	MiRunnable2 miHilo2 = null; // Hilo para los caparazones verdes 
	MiRunnable3 miHilo3= null; // Hilo para los caparazones rojos
	MiRunnable4 miHilo4= null; // Hilo para la vida de Mario
	MiRunnable5 miHilo5= null; // Hilo para las monedas
	Boolean[] aPulsada = new Boolean[3]; // Array que almacena estado de la tecla
	
	/**
	 * Constructor que inicializa el array de teclas
	 */

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
		setSize(1920, 1080);
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
		// Crea y visibiliza la ventana con el Mario
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
			Ventana.Mundo.crearGoomba();
			Ventana.Mundo.creaMoneda();
			Ventana.Mundo.creaCV();
			Ventana.Mario.setNombre("Mario Bros");
			Ventana.miHilo = Ventana.new MiRunnable(); // Sintaxis de new
			Ventana.miHilo2 = Ventana.new MiRunnable2();
			Ventana.miHilo3 = Ventana.new MiRunnable3();
			Ventana.miHilo4 = Ventana.new MiRunnable4();
			Ventana.miHilo5 = Ventana.new MiRunnable5();// para clase
			// interna
			Thread nuevoHilo = new Thread(Ventana.miHilo);
			Thread nuevoHilo2 = new Thread(Ventana.miHilo2);
			Thread nuevoHilo3 = new Thread(Ventana.miHilo3);
			Thread nuevoHilo4 = new Thread(Ventana.miHilo4);
			Thread nuevoHilo5 = new Thread(Ventana.miHilo5);
			nuevoHilo.start();
			nuevoHilo2.start();
			nuevoHilo3.start();
			nuevoHilo4.start();
			nuevoHilo5.start();
		} catch (Exception e) {
			System.exit(1); // Error anormal
		}
	}
	
	/**
	 * Clase que implementa la interfaz Runnable, 
	 * inicializa el hilo de las monedas
	 */
	
	class MiRunnable5 implements Runnable {
		boolean sigo = true;

		@Override
		public void run() {

			while (sigo) {

				Mundo.SaleMoneda();
				if(Mundo.SaleMoneda()){
					try {
						Thread.sleep(300);
						Mundo.eliminaMoneda();
						pPrincipal.repaint();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// Dormir el hilo 1 milisegundos
				try {
					pPrincipal.repaint();
					Thread.sleep(1);
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
	}
	
	/**
	 * Clase que implementa la interfaz Runnable, 
	 * inicializa el hilo de los caparazones rojos
	 */

	class MiRunnable4 implements Runnable {
		boolean sigo = true;

		@Override
		public void run() {

			while (sigo) {
				Ventana.this.Mundo.creaCR();
				Ventana.this.Mundo.moverCR();
				if (Ventana.this.Mundo.interseccionCR()) {
					Ventana.this.Mundo.eliminarCR();
				}
				
				if(aPulsada[2]){
					Ventana.this.Mundo.moverCR2();
				}
				
				if(Mario.getVida()==0){
					sigo=false;
				}
				
				

				// Dormir el hilo 10 milisegundos
				try {
					pPrincipal.repaint();
					Thread.sleep(10);
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

	}
	
	/**
	 * Clase que implementa la interfaz Runnable, 
	 * inicializa el hilo de la vida
	 */
	
	class MiRunnable3 implements Runnable {
		boolean sigo = true;

		@Override
		public void run() {

			while (sigo) {
				if (Mundo.choqueCV() || Mundo.choqueCR() || Mundo.perderVidaGoomba) {
					try {
						Thread.sleep(1000);
						Mario.setVida(Mario.getVida() - 1);
						Mundo.eliminaCorazon();
						pPrincipal.repaint();
						Mundo.perderVidaGoomba = false;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (Mario.getVida() == 0) {
						sigo = false;
					}

				}
				
				// Dormir el hilo 15 milisegundos
				try {
					pPrincipal.repaint();
					Thread.sleep(15);
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
	}
	
	/**
	 * Clase que implementa la interfaz Runnable, inicializa el hilo de los
	 * caparazones verdes
	 */

	class MiRunnable2 implements Runnable {
		boolean sigo = true;

		@Override
		public void run() {

			while (sigo) {

				Ventana.this.Mundo.moverCV();

				if (Mario.getVida() == 0) {
					sigo = false;
				}

				// Dormir el hilo 30 milisegundos
				try {
					pPrincipal.repaint();
					Thread.sleep(30);
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
				Mundo.choqueV();
				Mundo.interaccionGoomba();
				
				if(Mundo.caidaGoomba){
					Mundo.caidaDeLosGoombas(Mundo.caidaGoombaNumero);
				}
				
				if(!Mundo.movGoomba){
					Mundo.moverGoombaD();
				}
				else{
					Mundo.moverGoombaI();
				}
				
				if (aPulsada[0]) {
					if (!Mario.salto && !Mundo.choqueV() && !Mario.caida) {
						Mario.gravedad = Mario.getPosY();
						Mario.gravedadFija = Mario.getPosY();
						Mario.salto = true;
						Mario.cont = true;
						if (Mario.getGrafico().EsEspejo()) {
							Mario.getGrafico().setComponentOrientationSaltoEspejo();
						} else {
							Mario.getGrafico().setComponentOrientationSalto();
							repaint();
						}
					}
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
					}

				}
				
				Mundo.caida();
				if (Mario.getPosY() >= 1100) {
					Mario.setVida(0);
					Mundo.eliminaCorazon();
					
				}
				
				if(Mario.getVida()==0){
					sigo=false;
					}

				// Dormir el hilo 30 milisegundos
				try {
					pPrincipal.repaint();
					Thread.sleep(27);
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