

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VentanaResultadoFinal extends JFrame {
	private static final long serialVersionUID = 1L; // Para serialización
	JPanel pPrincipal; // Panel del juego (layout nulo)
	JTextField tResultado;
	VentanaMenuPrincipal vmp;

	public VentanaResultadoFinal(Mario mario) {
		// Liberación de la ventana por defecto al cerrar
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Creación contenedores y componentes
		pPrincipal = new JPanelR();
		// Formato y layouts
		pPrincipal.setLayout(null);
		pPrincipal.setBackground(Color.white);
		// Añadido de componentes a contenedores
		add(pPrincipal, BorderLayout.CENTER);
		// Formato de ventana
		setSize(1920, 1080);
		setResizable(false);
		JTextField tResultado = new JTextField();
		tResultado.setFocusable(false);
		tResultado.setBounds(870, 100, 750, 142);
		tResultado.setForeground(Color.BLACK);
		tResultado.setText(mario.toString());
		tResultado.setFont(new Font("Tahoma", Font.PLAIN, 30));
		pPrincipal.add(tResultado);
		
		JButton bSalir= new JButton();
		bSalir.setText("Salir");
		bSalir.setFocusable(false);
		bSalir.setBounds(1050, 650, 360, 100);
		bSalir.setForeground(Color.BLACK);
		bSalir.setFont(new Font("Tahoma", Font.PLAIN, 50));
		pPrincipal.add(bSalir);
		
		JButton bMenuPrincipal= new JButton();
		bMenuPrincipal.setText("Menu principal");
		bMenuPrincipal.setFocusable(false);
		bMenuPrincipal.setBounds(1050, 500, 360, 100);
		bMenuPrincipal.setForeground(Color.BLACK);
		bMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 50));
		pPrincipal.add(bMenuPrincipal);
		

		bSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}});
		
		bMenuPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				vmp.inicializarMenuPrincipal();
			}});
		
	}

//	public static void main(String[] args) {
//		// Crea y visibiliza la ventana con el coche
//		Mario mario = new Mario();
//		try {
//			final VentanaResultadoFinal Ventana = new VentanaResultadoFinal(mario);
//			SwingUtilities.invokeAndWait(new Runnable() {
//				@Override
//				public void run() {
//					Ventana.setVisible(true);
//					
//				}
//			});
//		} catch (Exception e) {
//			System.exit(1); // Error anormal
//		}
//	}

}