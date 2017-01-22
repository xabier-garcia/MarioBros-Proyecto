
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VentanaHasPerdido extends JFrame {
	private static final long serialVersionUID = 1L; // Para serialización
	JPanel pPrincipal; // Panel del juego (layout nulo)
	VentanaHasPerdido Ventana; // Ventana del menu principal
	VentanaMenuPrincipal vmp;

	public VentanaHasPerdido() {
		// Liberación de la ventana por defecto al cerrar
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Creación contenedores y componentes
		pPrincipal = new JPanelFondoL();
		// Formato y layouts
		pPrincipal.setLayout(null);
		pPrincipal.setBackground(Color.white);
		// Añadido de componentes a contenedores
		add(pPrincipal, BorderLayout.CENTER);
		// Formato de ventana
		setSize(1920, 1080);
		setResizable(false);
		JButton bMenuPrincipal= new JButton();
		bMenuPrincipal.setText("Menu principal");
		bMenuPrincipal.setFocusable(false);
		bMenuPrincipal.setBounds(1050, 558, 500, 142);
		bMenuPrincipal.setForeground(Color.BLACK);
		bMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 50));
		pPrincipal.add(bMenuPrincipal);
		bMenuPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				vmp.inicializarMenuPrincipal();
			}
		});

	}

//	public static void main(String[] args) {
//		// Crea y visibiliza la ventana con el coche
//		try {
//			final VentanaHasPerdido Ventana = new VentanaHasPerdido();
//			SwingUtilities.invokeAndWait(new Runnable() {
//				@Override
//				public void run() {
//					Ventana.setVisible(true);
//				}
//			});
//		} catch (Exception e) {
//			System.exit(1); // Error anormal
//		}
//	}

}