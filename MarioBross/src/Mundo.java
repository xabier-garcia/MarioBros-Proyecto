import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;




public class Mundo {
	private JPanel panel; // panel visual del juego
	Mario Mario; // Mario del juego
	private static long UltimaHora; // Para saber la última hora de creación de
									// los caparazones verdes
	
	private Random numR = new Random(); //Nuevo generador de números random
	JLabelCaparazonVerde CV = new JLabelCaparazonVerde(); //Nuevo Jlabel Para capazaron
	ArrayList<JLabelBloque> aBloques = new ArrayList();
	ArrayList<JLabelBloqueA> aBloquesA = new ArrayList();
	ArrayList<JLabelTuberia> aTuberias = new ArrayList();
	ArrayList<JLabelCaida> aCaida = new ArrayList();

	/**
	 * Construye un mundo de juego
	 * 
	 * @param panel
	 *            Panel visual del juego
	 */
	public Mundo(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * Crea un Mario nuevo y lo añade al mundo y al panel visual
	 * 
	 * @param posX
	 *            Posición X de pixel del nuevo Mario
	 * @param posY
	 *            Posición Y de píxel del nuevo Mario
	 */
	public void creaMario(int posX, int posY) {
		// Crear y añadir el Mario a la ventana
		Mario = new Mario();
		Mario.setPosicion(posX, posY);
		panel.add(Mario.getGrafico()); // Añade al panel visual
		Mario.getGrafico().repaint(); // Refresca el dibujado de Mario
		
	}
	
	//TODO
	
	/**
	 * Crea un nuevo Bloque y lo añade al panel visual
	 */

	
	public void creaBloque(){
		JLabelBloque Bloque = new JLabelBloque();
		Bloque.setLocation(1220, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		JLabelBloque Bloque2 = new JLabelBloque();
		Bloque2.setLocation(1020, 660);
		panel.add(Bloque2);
		aBloques.add(Bloque2);
		
		JLabelBloque Bloque3= new JLabelBloque();
		Bloque3.setLocation(2020, 660);
		panel.add(Bloque3);
		aBloques.add(Bloque3);
		JLabelBloque Bloque4= new JLabelBloque();
		Bloque4.setLocation(2120, 660);
		panel.add(Bloque4);
		aBloques.add(Bloque4);
		JLabelBloque Bloque5= new JLabelBloque();
		Bloque5.setLocation(2220, 660);
		panel.add(Bloque5);
		aBloques.add(Bloque5);
		
		JLabelBloque Bloque6= new JLabelBloque();
		Bloque6.setLocation(3220, 660);
		panel.add(Bloque6);
		aBloques.add(Bloque6);
		JLabelBloque Bloque7= new JLabelBloque();
		Bloque7.setLocation(3320, 660);
		panel.add(Bloque7);
		aBloques.add(Bloque7);
		JLabelBloque Bloque8= new JLabelBloque();
		Bloque8.setLocation(3420, 660);
		panel.add(Bloque8);
		aBloques.add(Bloque8);
		JLabelBloque Bloque9= new JLabelBloque();
		Bloque9.setLocation(3520, 660);
		panel.add(Bloque9);
		aBloques.add(Bloque9);
		JLabelBloque Bloque10= new JLabelBloque();
		Bloque10.setLocation(3620, 660);
		panel.add(Bloque10);
		aBloques.add(Bloque10);
		
		JLabelBloque Bloque11= new JLabelBloque();
		Bloque11.setLocation(4920, 660);
		panel.add(Bloque11);
		aBloques.add(Bloque11);
		JLabelBloque Bloque12= new JLabelBloque();
		Bloque12.setLocation(5020, 660);
		panel.add(Bloque12);
		aBloques.add(Bloque12);
		JLabelBloque Bloque13= new JLabelBloque();
		Bloque13.setLocation(5120, 660);
		panel.add(Bloque13);;
		aBloques.add(Bloque13);
		JLabelBloque Bloque14= new JLabelBloque();
		Bloque14.setLocation(5220, 660);
		panel.add(Bloque14);
		aBloques.add(Bloque14);
		
		JLabelBloque Bloque15= new JLabelBloque();
		Bloque15.setLocation(6320, 900);
		panel.add(Bloque15);
		aBloques.add(Bloque15);
		JLabelBloque Bloque16= new JLabelBloque();
		Bloque16.setLocation(6320, 800);
		panel.add(Bloque16);
		aBloques.add(Bloque16);
		
		JLabelBloque Bloque17= new JLabelBloque();
		Bloque17.setLocation(7920, 900);
		panel.add(Bloque17);
		aBloques.add(Bloque17);
		JLabelBloque Bloque18= new JLabelBloque();
		Bloque18.setLocation(8020, 900);
		panel.add(Bloque18);
		aBloques.add(Bloque18);
		JLabelBloque Bloque19= new JLabelBloque();
		Bloque19.setLocation(8020, 800);
		panel.add(Bloque19);
		aBloques.add(Bloque19);
		
		
		
	}
	
	public void crearCaida(){
		JLabelCaida Caida = new JLabelCaida();
		Caida.setLocation(2005, 995);
		panel.add(Caida);
		aCaida.add(Caida);
		
		JLabelCaida Caida1 = new JLabelCaida();
		Caida1.setLocation(4980, 995);
		panel.add(Caida1);
		aCaida.add(Caida1);
	}
	//TODO
	
	/**
	 * Crea un nuevo Bloque Amarillo y lo añade al panel visual
	 */
	public void creaBloqueA(){
		JLabelBloqueA BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(3420, 260);
		panel.add(BloqueA);	
		aBloquesA.add(BloqueA);
		
		JLabelBloqueA BloqueA1 = new JLabelBloqueA();
		BloqueA1.setLocation(1120, 660);
		panel.add(BloqueA1);
		aBloquesA.add(BloqueA1);
		
		JLabelBloqueA BloqueA2 = new JLabelBloqueA();
		BloqueA2.setLocation(6320, 260);
		panel.add(BloqueA2);
		aBloquesA.add(BloqueA2);
	}
	
//	//TODO
//	
//	/**
//	 * Crea una tubería y la añade al panel visual
//	 */

	public void creaTuberia(){
		JLabelTuberia Tuberia = new JLabelTuberia();
		Tuberia.setLocation(1820, 650);
		panel.add(Tuberia);
		aTuberias.add(Tuberia);
		
		JLabelTuberia Tuberia1 = new JLabelTuberia();
		Tuberia1.setLocation(8110, 650);
		panel.add(Tuberia1);
		aTuberias.add(Tuberia1);
	}
	
	

	
	/**
	 * Si han pasado más de 1,2 segundos desde la última, * crea un caparazon nuevo
	 * nuevo en una posición aleatoria y la añade al mundo y al panel visual
	 */

	public void creaCV() {

		if (System.currentTimeMillis() - UltimaHora > 12000) {
			CV.setLocation(numR.nextInt(panel.getWidth() - CV.TAMANYO_CV), this.panel.getHeight() - 1080);
			panel.add(CV);
			CV.repaint();
			
			UltimaHora = System.currentTimeMillis();
		}

	}
	
	//Método para mover caparazón verde
	
	public void moverCV(){
		CV.move(CV.getX(),CV.getY()+10);
	}
	

	//TODO
	
	//Método para mover Bloque Izquierda
	
	public void moverObjetoI(){
		for(int i=0;i<aBloques.size();i++){
		
			aBloques.get(i).move(aBloques.get(i).getX()-20, (aBloques.get(i).getY()));
		
		}
	for(int a=0;a<aBloquesA.size();a++){
		
			aBloquesA.get(a).move(aBloquesA.get(a).getX()-20, (aBloquesA.get(a).getY()));
		}
			
		for(int e=0;e<aTuberias.size();e++){
	
			aTuberias.get(e).move(aTuberias.get(e).getX()-20, (aTuberias.get(e).getY()));
		}
			
		for(int o=0;o<aCaida.size();o++){
	
			aCaida.get(o).move(aCaida.get(o).getX()-20, (aCaida.get(o).getY()));
		
			}
	}
	
	//TODO
	
	//Método para mover Bloque Derecha
	
		public void moverObjetoD(){
			for(int i=0;i<aBloques.size();i++){
				aBloques.get(i).move(aBloques.get(i).getX()+20, (aBloques.get(i).getY()));
				}
			for(int a=0;a<aBloquesA.size();a++){
				aBloquesA.get(a).move(aBloquesA.get(a).getX()+20, (aBloquesA.get(a).getY()));
				}
			for(int e=0;e<aTuberias.size();e++){
				aTuberias.get(e).move(aTuberias.get(e).getX()+20, (aTuberias.get(e).getY()));
				}
			for(int o=0;o<aCaida.size();o++){
				aCaida.get(o).move(aCaida.get(o).getX()+20, (aCaida.get(o).getY()));
				}
			
		}
	
	
	
	
	/**
	 * Devuelve el Mario del mundo
	 * 
	 * @return Mario en el mundo. Si no lo hay, devuelve null
	 */
	public Mario getMario() {
		return Mario;
	}
	
}