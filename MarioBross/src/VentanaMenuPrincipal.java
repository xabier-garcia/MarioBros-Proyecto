
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class VentanaMenuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L; // Para serialización
	JPanel pPrincipal; // Panel del juego (layout nulo)
	VentanaMenuPrincipal Ventana; // Ventana del menu principal
	public static ArrayList<String> nombreMario = new ArrayList<String>();
	Mario mario;
	static Ventana v;
	JtableTabla jtt = new JtableTabla();

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
		final JButton bEntrar= new JButton();
		bEntrar.setText("Entrar");
		bEntrar.setFocusable(false);
		bEntrar.setBounds(850, 500, 300, 142);
		bEntrar.setForeground(Color.BLACK);
		bEntrar.setFont(new Font("Tahoma", Font.PLAIN, 60));
		
		final JButton bJugar= new JButton();
		bJugar.setText("Jugar");
		bJugar.setFocusable(false);
		bJugar.setBounds(850, 400, 300, 142);
		bJugar.setForeground(Color.BLACK);
		bJugar.setFont(new Font("Tahoma", Font.PLAIN, 100));
		pPrincipal.add(bJugar);
		
		final JTextField tNombre = new JTextField();
	 	tNombre.setBounds(900, 320, 300, 100);
	 	tNombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
	 	tNombre.setForeground(Color.BLACK);
	 	tNombre.setHorizontalAlignment(SwingConstants.CENTER); 
//		pPrincipal.add(bEntrar); 
//		pPrincipal.add(tNombre);
		
		final JTextField escrbirNombre = new JTextField();
		escrbirNombre.setFocusable(false);
		escrbirNombre.setBounds(750, 320, 130, 100);
		escrbirNombre.setForeground(Color.BLACK);
		escrbirNombre.setText("Nombre: ");
		escrbirNombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
//		pPrincipal.add(escrbirNombre);
		
		JButton bSalir= new JButton();
		bSalir.setText("Salir");
		bSalir.setFocusable(false);
		bSalir.setBounds(170, 800, 300, 100);
		bSalir.setForeground(Color.BLACK);
		bSalir.setFont(new Font("Tahoma", Font.PLAIN, 60));
		pPrincipal.add(bSalir);
		
		JButton bEstadisticas= new JButton();
		bEstadisticas.setText("Estadísticas");
		bEstadisticas.setFocusable(false);
		bEstadisticas.setBounds(100, 680, 450, 100);
		bEstadisticas.setForeground(Color.BLACK);
		bEstadisticas.setFont(new Font("Tahoma", Font.PLAIN, 60));
		pPrincipal.add(bEstadisticas);
		
	 	
		bJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					bJugar.setVisible(false);
					bJugar.disable();
					pPrincipal.add(bEntrar); 
					bEntrar.setVisible(true);
					pPrincipal.add(tNombre); 
					tNombre.setVisible(true);
					pPrincipal.add(escrbirNombre);
					escrbirNombre.setVisible(true);
					repaint();
					bEntrar.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent arg0) {
							if(tNombre.getText().length()>0){
							nombreMario.add(tNombre.getText());
							Ventana ventana2 = new Ventana();
							ventana2.dispose();
							ventana2.setVisible(true);
							ventana2.Arranque();
							dispose();
							}
							else{
								JOptionPane.showMessageDialog( pPrincipal, "¡Nombre incorrecto!.");
							}
						}
					});
			}
		});
		
		bSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		
		bEstadisticas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				jtt.abrirJTable();
				dispose();
		
			}
		});

	}

	public static void inicializarMenuPrincipal(){
		final VentanaMenuPrincipal Ventana = new VentanaMenuPrincipal();
		Ventana.setVisible(true);
//		// Crea y visibiliza la ventana con el coche
//		try {
//			final VentanaMenuPrincipal Ventana = new VentanaMenuPrincipal();
//			SwingUtilities.invokeAndWait(new Runnable() {
//				@Override
//				public void run() {
//					Ventana.setVisible(true);
//				}
//			});
//		} catch (Exception e) {
//			System.exit(1); // Error anormal
//		}
	}

}
