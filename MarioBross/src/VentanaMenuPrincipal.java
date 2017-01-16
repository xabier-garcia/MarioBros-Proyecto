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

public class VentanaMenuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L; // Para serialización
	JPanel pPrincipal; // Panel del juego (layout nulo)
	VentanaMenuPrincipal Ventana; // Ventana del menu principal

	public VentanaMenuPrincipal() {
		// Liberación de la ventana por defecto al cerrar
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Creación contenedores y componentes
		pPrincipal = new JPanelFondoP();
		// Formato y layouts
		pPrincipal.setLayout(null);
		pPrincipal.setBackground(Color.white);
		// Añadido de componentes a contenedores
		add(pPrincipal, BorderLayout.CENTER);
		// Formato de ventana
		setSize(1920, 1080);
		setResizable(false);
		JButton bJugar= new JButton();
		bJugar.setText("Jugar");
		bJugar.setFocusable(false);
		bJugar.setBounds(850, 358, 300, 142);
		bJugar.setForeground(Color.BLACK);
		bJugar.setFont(new Font("Tahoma", Font.PLAIN, 100));
		pPrincipal.add(bJugar);
		bJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Ventana ventana2 = new Ventana();
				ventana2.setVisible(true);
				ventana2.Arranque();
			}
		});

	}

	public static void main(String[] args) {
		// Crea y visibiliza la ventana con el coche
		try {
			final VentanaMenuPrincipal Ventana = new VentanaMenuPrincipal();
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					Ventana.setVisible(true);
				}
			});
		} catch (Exception e) {
			System.exit(1); // Error anormal
		}
	}

}
