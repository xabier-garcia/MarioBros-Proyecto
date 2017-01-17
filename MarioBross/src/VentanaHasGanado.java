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

public class VentanaHasGanado extends JFrame {
	private static final long serialVersionUID = 1L; // Para serialización
	JPanel pPrincipal; // Panel del juego (layout nulo)
	JButton bJugar;
	VentanaResultadoFinal ventanaR;

	public VentanaHasGanado() {
		// Liberación de la ventana por defecto al cerrar
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Creación contenedores y componentes
		pPrincipal = new JPanelFondoW();
		// Formato y layouts
		pPrincipal.setLayout(null);
		pPrincipal.setBackground(Color.white);
		// Añadido de componentes a contenedores
		add(pPrincipal, BorderLayout.CENTER);
		// Formato de ventana
		setSize(1920, 1080);
		setResizable(false);
		JButton bJugar= new JButton();
		bJugar.setText("Ver Resultados");
		bJugar.setFocusable(false);
		bJugar.setBounds(100, 558, 500, 142);
		bJugar.setForeground(Color.BLACK);
		bJugar.setFont(new Font("Tahoma", Font.PLAIN, 50));
		pPrincipal.add(bJugar);
		bJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaResultadoFinal ventanaR = new VentanaResultadoFinal();
				ventanaR.setVisible(true);
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		// Crea y visibiliza la ventana con el coche
		try {
			final VentanaHasGanado Ventana = new VentanaHasGanado();
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