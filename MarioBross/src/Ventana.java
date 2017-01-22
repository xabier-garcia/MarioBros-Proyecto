

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.synth.SynthSpinnerUI;

import BaseDeDatos.BaseDeDatos;

public class Ventana extends JFrame {
	private static final long serialVersionUID = 1L; // Para serialización
	JPanel pPrincipal; // Panel del juego (layout nulo)
	Mundo Mundo; // Mundo del juego
	Mario Mario; // Mario del juego
	static VentanaMenuPrincipal vp;
	static Ventana v;
	BaseDeDatos bd;
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
	
	// MAIN
	
	public static void main(String[] args) {
		v.obtenerUsuariosBD();
		vp.inicializarMenuPrincipal();
	}

	/**
	 * Programa principal de la ventana de juego
	 * 
	 * @param args
	 */
	
	public void Arranque() {
		// Crea y visibiliza la ventana con el Mario7
			this.Mundo = new Mundo(this.pPrincipal);
			this.Mario = new Mario();
			this.Mundo.creaMario(620, 860);
			this.Mario = this.Mundo.getMario();
			this.Mundo.creaBloque();
			this.Mundo.creaBloqueA();
			this.Mundo.crearTuberia();
			this.Mundo.crearTuberiaGrande();
			this.Mundo.crearCaida();
			this.Mundo.creaCorazon();
			this.Mundo.crearGoomba();
			this.Mundo.creaMoneda();
			this.Mundo.creaCV();
			this.Mundo.crearSetaVida();
			if(vp.nombreMario.get(0) != null){
				Mario.setNombre(vp.nombreMario.get(0));
				vp.nombreMario.remove(0);
			}
			
			this.miHilo = this.new MiRunnable(); // Sintaxis de new
			this.miHilo2 = this.new MiRunnable2();
			this.miHilo3 = this.new MiRunnable3();
			this.miHilo4 = this.new MiRunnable4();
			this.miHilo5 = this.new MiRunnable5();// para clase
			// interna
			Thread nuevoHilo = new Thread(this.miHilo);
			Thread nuevoHilo2 = new Thread(this.miHilo2);
			Thread nuevoHilo3 = new Thread(this.miHilo3);
			Thread nuevoHilo4 = new Thread(this.miHilo4);
			Thread nuevoHilo5 = new Thread(this.miHilo5);
			nuevoHilo.start();
			nuevoHilo2.start();
			nuevoHilo3.start();
			nuevoHilo4.start();
			nuevoHilo5.start();
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
				Mundo.elevarMoneda();
				if(Mundo.crearMiniMonedasBoolean){
				Mundo.creaMiniMoneda();
				Mundo.crearMiniMonedasBoolean = false;
				}
				
//					try {
//						Thread.sleep(300);
//						Mundo.SaleMoneda();
//						Mundo.eliminaMoneda();
//						pPrincipal.repaint();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
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
				if (!Mundo.aCR.isEmpty()) {
					for (int i = 0; i < Mundo.aCR.size(); i++) {
						if (Mundo.aCR.get(i) != null) {
							if (Ventana.this.Mundo.interseccionCR()) {
								Ventana.this.Mundo.eliminarCR();
							}
						}
					}
				}

				if (Mario.getVida() == 0) {
					sigo = false;
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
				if (Mundo.choqueCV() || Mundo.choqueCR() || Mundo.perderVidaGoomba|| Mundo.ganarVidaSeta) {
					try {
						Thread.sleep(1000);
						if(Mundo.ganarVidaSeta){
							Mario.setVida(Mario.getVida() + 1);
							Mundo.creaCorazon();
							Mundo.ganarVidaSeta = false;
						}
						else{
						Mario.setVida(Mario.getVida() - 1);
						Mundo.eliminaCorazon();
						pPrincipal.repaint();
						Mundo.perderVidaGoomba = false;
						}
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
			
				// Relacionado con las setas
				Mundo.SaleSetaVida();
				Mundo.eliminarSetaVida();
				Mundo.cambioBloqueAmarilloBloqueUsado();

				// Relacionado con los Goombas
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
				
				// Mover "Mario"(Realmente lo que movemos es el fondo creando un
				// efecto óptico de movimiento
				if(Mario.salto == false && Mario.caida== false && !aPulsada[0] && !aPulsada[1] && !aPulsada[2]){
				Mario.getGrafico().setComponentOrientationMarioQuieto();
				}
				
				Mario.saltoMario();
				if (aPulsada[0]) {
					if (!Mario.salto && !Mundo.choqueV() && !Mario.caida && !Mundo.caida()) {
						Mario.gravedad = Mario.getPosY();
						Mario.gravedadFija = Mario.getPosY();
						Mario.salto = true;
						Mario.cont = true;
						if (Mario.getGrafico().EsEspejo()) {
							Mario.getGrafico().setComponentOrientationSalto();
						} else {
							Mario.getGrafico().setComponentOrientationSaltoEspejo();
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
					Mario.caida = false;
					Mario.salto = false;
					sigo=false;
					}
				
				if (((JPanelFondo) pPrincipal).getVar() == -18840) {
					VentanaHasGanado G = new VentanaHasGanado(Mario);
					G.setVisible(true);
					dispose();
					((JPanelFondo) pPrincipal).setVar(0);
					//Borramos todo lo de los arrayList
					 bd.aMonedas.clear();
					 bd.aNombre.clear();
					 bd.aVidas.clear();
					guardarEnLaBaseDeDatos();
					obtenerUsuariosBD();
					sigo = false;
				}
				
				if( Mario.getVida()==0){
					VentanaHasPerdido V = new VentanaHasPerdido();
					V.setVisible(true);
					dispose();
					//Borramos todo lo de los arrayList
					 bd.aMonedas.clear();
					 bd.aNombre.clear();
					 bd.aVidas.clear();
					guardarEnLaBaseDeDatos();
					obtenerUsuariosBD();
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
	
	// -- BASE DE DATOS --
	
	// Guardamos los datos en la base de datos
	public void guardarEnLaBaseDeDatos() {
		Connection con = BaseDeDatos.initBD( "Usuario.bd" );
		Statement st = BaseDeDatos.usarCrearTablasBD( con );
		BaseDeDatos.usuarioInsert(st, this.Mario.getNombre(), this.Mario.getMonedas(), this.Mario.getVida());
//		BaseDeDatos.reiniciarBD(con);
		BaseDeDatos.cerrarBaseDeDatos(con, st);
	}
	
	// Obtener los datos
	public static void obtenerUsuariosBD(){
		Connection con = BaseDeDatos.initBD( "Usuario.bd" );
		Statement st = BaseDeDatos.usarCrearTablasBD( con );
		BaseDeDatos.ObtenerUsuarios(st);
		BaseDeDatos.cerrarBaseDeDatos(con, st);
	}
}