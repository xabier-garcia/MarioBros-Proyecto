import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;





public class Mundo {
	private JPanel panel; // panel visual del juego
	Mario Mario; // Mario del juego
	private static long UltimaHora; // Para saber la última hora de creación de
									// los caparazones verdes
	private JLabelTuberia t;
	private Random numR = new Random(); //Nuevo generador de números random
	JLabelCaparazonVerde CV = new JLabelCaparazonVerde(); //Nuevo Jlabel Para capazaron
	JLabelTuberia Tuberia = new JLabelTuberia();
	JLabelBloque Bloque = new JLabelBloque();
	ArrayList<JLabelBloque> aBloques = new ArrayList();
	ArrayList<JLabelBloqueA> aBloquesA = new ArrayList();
	ArrayList<JLabelTuberia> aTuberias = new ArrayList();
	ArrayList<JLabelCaida> aCaida = new ArrayList();
	ArrayList<JLabelTuberiaGrande> aTuberiaGrande = new ArrayList();

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
		Bloque.setLocation(1220, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1020, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque= new JLabelBloque();
		Bloque.setLocation(2020, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		JLabelBloque Bloque= new JLabelBloque();
		Bloque.setLocation(2120, 660);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
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
		
		JLabelBloque Bloque20= new JLabelBloque();
		Bloque20.setLocation(9120, 660);
		panel.add(Bloque20);
		aBloques.add(Bloque20);
		JLabelBloque Bloque21= new JLabelBloque();
		Bloque21.setLocation(9320, 660);
		panel.add(Bloque21);
		aBloques.add(Bloque21);
		JLabelBloque Bloque22= new JLabelBloque();
		Bloque22.setLocation(9520, 660);
		panel.add(Bloque22);
		aBloques.add(Bloque22);
		JLabelBloque Bloque23= new JLabelBloque();
		Bloque23.setLocation(9720, 660);
		panel.add(Bloque23);
		aBloques.add(Bloque23);
		JLabelBloque Bloque24= new JLabelBloque();
		Bloque24.setLocation(9920, 660);
		panel.add(Bloque24);
		aBloques.add(Bloque24);
		JLabelBloque Bloque25= new JLabelBloque();
		Bloque25.setLocation(10120, 660);
		panel.add(Bloque25);
		aBloques.add(Bloque25);
		JLabelBloque Bloque26= new JLabelBloque();
		Bloque26.setLocation(10320, 660);
		panel.add(Bloque26);
		aBloques.add(Bloque26);
		
		JLabelBloque Bloque27= new JLabelBloque();
		Bloque27.setLocation(9320, 320);
		panel.add(Bloque27);
		aBloques.add(Bloque27);
		JLabelBloque Bloque28= new JLabelBloque();
		Bloque28.setLocation(9420, 320);
		panel.add(Bloque28);
		aBloques.add(Bloque28);
		JLabelBloque Bloque29= new JLabelBloque();
		Bloque29.setLocation(9520, 320);
		panel.add(Bloque29);
		aBloques.add(Bloque29);
		JLabelBloque Bloque30= new JLabelBloque();
		Bloque30.setLocation(9620, 320);
		panel.add(Bloque30);
		aBloques.add(Bloque30);
		JLabelBloque Bloque31= new JLabelBloque();
		Bloque31.setLocation(9820, 320);
		panel.add(Bloque31);
		aBloques.add(Bloque31);
		JLabelBloque Bloque32= new JLabelBloque();
		Bloque32.setLocation(9920, 320);
		panel.add(Bloque32);
		aBloques.add(Bloque32);
		JLabelBloque Bloque33= new JLabelBloque();
		Bloque33.setLocation(10020, 320);
		panel.add(Bloque33);
		aBloques.add(Bloque33);
		JLabelBloque Bloque34= new JLabelBloque();
		Bloque34.setLocation(10120, 320);
		panel.add(Bloque34);
		aBloques.add(Bloque34);
		
		JLabelBloque Bloque35= new JLabelBloque();
		Bloque35.setLocation(12200, 899);
		panel.add(Bloque35);
		aBloques.add(Bloque35);
		JLabelBloque Bloque36= new JLabelBloque();
		Bloque36.setLocation(12200, 799);
		panel.add(Bloque36);
		aBloques.add(Bloque36);
		
		JLabelBloque Bloque37= new JLabelBloque();
		Bloque37.setLocation(13920, 999);
		panel.add(Bloque37);
		aBloques.add(Bloque37);
		JLabelBloque Bloque38= new JLabelBloque();
		Bloque38.setLocation(14020, 999);
		panel.add(Bloque38);
		aBloques.add(Bloque38);
		JLabelBloque Bloque39= new JLabelBloque();
		Bloque39.setLocation(14120, 999);
		panel.add(Bloque39);
		aBloques.add(Bloque39);
		
		// Primer cuadrado de bloques
		JLabelBloque Bloque40= new JLabelBloque();
		Bloque40.setLocation(14920, 899);
		panel.add(Bloque40);
		aBloques.add(Bloque40);
		JLabelBloque Bloque41= new JLabelBloque();
		Bloque41.setLocation(14920, 799);
		panel.add(Bloque41);
		aBloques.add(Bloque41);
		JLabelBloque Bloque42= new JLabelBloque();
		Bloque42.setLocation(14920, 699);
		panel.add(Bloque42);
		aBloques.add(Bloque42);
		JLabelBloque Bloque43= new JLabelBloque();
		Bloque43.setLocation(15020, 699);
		panel.add(Bloque43);
		aBloques.add(Bloque43);
		JLabelBloque Bloque44= new JLabelBloque();
		Bloque44.setLocation(15120, 699);
		panel.add(Bloque44);
		aBloques.add(Bloque44);
		JLabelBloque Bloque45= new JLabelBloque();
		Bloque45.setLocation(15220, 699);
		panel.add(Bloque45);
		aBloques.add(Bloque45);
		JLabelBloque Bloque46= new JLabelBloque();
		Bloque46.setLocation(15320, 699);
		panel.add(Bloque46);
		aBloques.add(Bloque46);
		JLabelBloque Bloque47= new JLabelBloque();
		Bloque47.setLocation(15320, 799);
		panel.add(Bloque47);
		aBloques.add(Bloque47);
		JLabelBloque Bloque48= new JLabelBloque();
		Bloque48.setLocation(15320, 899);
		panel.add(Bloque48);
		aBloques.add(Bloque48);
		
		//Segundo cuadrado de bloques
		JLabelBloque Bloque50= new JLabelBloque();
		Bloque50.setLocation(16220, 999);
		panel.add(Bloque50);
		aBloques.add(Bloque50);
		JLabelBloque Bloque51= new JLabelBloque();
		Bloque51.setLocation(16220, 899);
		panel.add(Bloque51);
		aBloques.add(Bloque51);
		JLabelBloque Bloque52= new JLabelBloque();
		Bloque52.setLocation(16220, 799);
		panel.add(Bloque52);
		aBloques.add(Bloque52);
		JLabelBloque Bloque53= new JLabelBloque();
		Bloque53.setLocation(16220, 699);
		panel.add(Bloque53);
		aBloques.add(Bloque53);
		JLabelBloque Bloque54= new JLabelBloque();
		Bloque54.setLocation(16320, 699);
		panel.add(Bloque54);
		aBloques.add(Bloque54);
		JLabelBloque Bloque55= new JLabelBloque();
		Bloque55.setLocation(16420, 699);
		panel.add(Bloque55);
		aBloques.add(Bloque55);
		JLabelBloque Bloque56= new JLabelBloque();
		Bloque56.setLocation(16520, 699);
		panel.add(Bloque56);
		aBloques.add(Bloque56);
		JLabelBloque Bloque57= new JLabelBloque();
		Bloque57.setLocation(16520, 799);
		panel.add(Bloque57);
		aBloques.add(Bloque57);
		JLabelBloque Bloque58= new JLabelBloque();
		Bloque58.setLocation(16520, 899);
		panel.add(Bloque58);
		aBloques.add(Bloque58);
		JLabelBloque Bloque59= new JLabelBloque();
		Bloque59.setLocation(16520, 999);
		panel.add(Bloque59);
		aBloques.add(Bloque59);
		
		JLabelBloque Bloque60= new JLabelBloque();
		Bloque60.setLocation(17620, 660);
		panel.add(Bloque60);
		aBloques.add(Bloque60);
		JLabelBloque Bloque61= new JLabelBloque();
		Bloque61.setLocation(17820, 660);
		panel.add(Bloque61);
		aBloques.add(Bloque61);
		
		//Piramide de bloques final
		// -- fila 1
		JLabelBloque Bloque62= new JLabelBloque();
		Bloque62.setLocation(18720, 899);
		panel.add(Bloque62);
		aBloques.add(Bloque62);
		JLabelBloque Bloque63= new JLabelBloque();
		Bloque63.setLocation(18820, 899);
		panel.add(Bloque63);
		aBloques.add(Bloque63);
		JLabelBloque Bloque64= new JLabelBloque();
		Bloque64.setLocation(18920, 899);
		panel.add(Bloque64);
		aBloques.add(Bloque64);
		JLabelBloque Bloque65= new JLabelBloque();
		Bloque65.setLocation(19020, 899);
		panel.add(Bloque65);
		aBloques.add(Bloque65);
		JLabelBloque Bloque66= new JLabelBloque();
		Bloque66.setLocation(19120, 899);
		panel.add(Bloque66);
		aBloques.add(Bloque66);
		JLabelBloque Bloque67= new JLabelBloque();
		Bloque67.setLocation(19220, 899);
		panel.add(Bloque67);
		aBloques.add(Bloque67);
		// -- fila 2
		JLabelBloque Bloque68= new JLabelBloque();
		Bloque68.setLocation(18820, 799);
		panel.add(Bloque68);
		aBloques.add(Bloque68);
		JLabelBloque Bloque69= new JLabelBloque();
		Bloque69.setLocation(18920, 799);
		panel.add(Bloque69);
		aBloques.add(Bloque69);
		JLabelBloque Bloque70= new JLabelBloque();
		Bloque70.setLocation(19020, 799);
		panel.add(Bloque70);
		aBloques.add(Bloque70);
		JLabelBloque Bloque71= new JLabelBloque();
		Bloque71.setLocation(19120, 799);
		panel.add(Bloque71);
		aBloques.add(Bloque71);
		JLabelBloque Bloque72= new JLabelBloque();
		Bloque72.setLocation(19220, 799);
		panel.add(Bloque72);
		aBloques.add(Bloque72);
		// -- fila 3
		JLabelBloque Bloque73= new JLabelBloque();
		Bloque73.setLocation(18920, 699);
		panel.add(Bloque73);
		aBloques.add(Bloque73);
		JLabelBloque Bloque74= new JLabelBloque();
		Bloque74.setLocation(19020, 699);
		panel.add(Bloque74);
		aBloques.add(Bloque74);
		JLabelBloque Bloque75= new JLabelBloque();
		Bloque75.setLocation(19120, 699);
		panel.add(Bloque75);
		aBloques.add(Bloque75);
		JLabelBloque Bloque76= new JLabelBloque();
		Bloque76.setLocation(19220, 699);
		panel.add(Bloque76);
		aBloques.add(Bloque76);
		// -- fila 4
		JLabelBloque Bloque77= new JLabelBloque();
		Bloque77.setLocation(19020, 599);
		panel.add(Bloque77);
		aBloques.add(Bloque77);
		JLabelBloque Bloque78= new JLabelBloque();
		Bloque78.setLocation(19120, 599);
		panel.add(Bloque78);
		aBloques.add(Bloque78);
		JLabelBloque Bloque79= new JLabelBloque();
		Bloque79.setLocation(19220, 599);
		panel.add(Bloque79);
		aBloques.add(Bloque79);
		// -- fila 5
		JLabelBloque Bloque80= new JLabelBloque();
		Bloque80.setLocation(19120, 499);
		panel.add(Bloque80);
		aBloques.add(Bloque80);
		JLabelBloque Bloque81= new JLabelBloque();
		Bloque81.setLocation(19220, 499);
		panel.add(Bloque81);
		aBloques.add(Bloque81);
		// -- fila 6
		JLabelBloque Bloque82= new JLabelBloque();
		Bloque82.setLocation(19220, 399);
		panel.add(Bloque82);
		aBloques.add(Bloque82);
		
		
		
	}
	
	public void crearCaida(){
		JLabelCaida Caida = new JLabelCaida();
		Caida.setLocation(2005, 999);
		panel.add(Caida);
		aCaida.add(Caida);
		
		JLabelCaida Caida1 = new JLabelCaida();
		Caida1.setLocation(4980, 999);
		panel.add(Caida1);
		aCaida.add(Caida1);
	
		JLabelCaida Caida2 = new JLabelCaida();
		Caida2.setLocation(15620, 998);
		panel.add(Caida2);
		aCaida.add(Caida2);
		
		JLabelCaida Caida3 = new JLabelCaida();
		Caida3.setLocation(16300, 998);
		panel.add(Caida3);
		aCaida.add(Caida3);
	
	}
	//TODO
	
	/**
	 * Crea un nuevo Bloque Amarillo y lo añade al panel visual
	 */
	public void creaBloqueA(){
		JLabelBloqueA BloqueA = new JLabelBloqueA();
		BloqueA.setLocation(3420, 320);
		panel.add(BloqueA);	
		aBloquesA.add(BloqueA);
		
		JLabelBloqueA BloqueA1 = new JLabelBloqueA();
		BloqueA1.setLocation(1120, 660);
		panel.add(BloqueA1);
		aBloquesA.add(BloqueA1);
		
		JLabelBloqueA BloqueA2 = new JLabelBloqueA();
		BloqueA2.setLocation(6320, 320);
		panel.add(BloqueA2);
		aBloquesA.add(BloqueA2);
		
		JLabelBloqueA BloqueA3 = new JLabelBloqueA();
		BloqueA3.setLocation(9220, 660);
		panel.add(BloqueA3);
		aBloquesA.add(BloqueA3);
		JLabelBloqueA BloqueA4 = new JLabelBloqueA();
		BloqueA4.setLocation(9420, 660);
		panel.add(BloqueA4);
		aBloquesA.add(BloqueA4);
		JLabelBloqueA BloqueA5 = new JLabelBloqueA();
		BloqueA5.setLocation(9620, 660);
		panel.add(BloqueA5);
		aBloquesA.add(BloqueA5);
		JLabelBloqueA BloqueA6 = new JLabelBloqueA();
		BloqueA6.setLocation(9820, 660);
		panel.add(BloqueA6);
		aBloquesA.add(BloqueA6);
		JLabelBloqueA BloqueA7 = new JLabelBloqueA();
		BloqueA7.setLocation(10020, 660);
		panel.add(BloqueA7);
		aBloquesA.add(BloqueA7);
		JLabelBloqueA BloqueA8 = new JLabelBloqueA();
		BloqueA8.setLocation(10220, 660);
		panel.add(BloqueA8);
		aBloquesA.add(BloqueA8);
		
		JLabelBloqueA BloqueA9 = new JLabelBloqueA();
		BloqueA9.setLocation(9720, 320);
		panel.add(BloqueA9);
		aBloquesA.add(BloqueA9);
		
		JLabelBloqueA BloqueA10 = new JLabelBloqueA();
		BloqueA10.setLocation(12060, 200);
		panel.add(BloqueA10);
		aBloquesA.add(BloqueA10);
		
		// Primer cuadrado de bloques
		JLabelBloqueA BloqueA11 = new JLabelBloqueA();
		BloqueA11.setLocation(15120, 320);
		panel.add(BloqueA11);
		aBloquesA.add(BloqueA11);
		
		JLabelBloqueA BloqueA12 = new JLabelBloqueA();
		BloqueA12.setLocation(17720, 660);
		panel.add(BloqueA12);
		aBloquesA.add(BloqueA12);
		
	}
	
//	//TODO
//	
//	/**
//	 * Crea una tubería y la añade al panel visual
//	 */

	public void crearTuberia(){
		
		Tuberia.setLocation(1820, 650);
		panel.add(Tuberia);
		aTuberias.add(Tuberia);
		
		Tuberia = new JLabelTuberia();
		Tuberia.setLocation(8110, 650);
		panel.add(Tuberia);
		aTuberias.add(Tuberia);
		
		Tuberia = new JLabelTuberia();
		Tuberia.setLocation(11820, 650);
		panel.add(Tuberia);
		aTuberias.add(Tuberia);
		
		Tuberia = new JLabelTuberia();
		Tuberia.setLocation(17920, 650);
		panel.add(Tuberia);
		aTuberias.add(Tuberia);
	}
	
	public void crearTuberiaGrande(){
		JLabelTuberiaGrande TuberiaGrande = new JLabelTuberiaGrande();
		TuberiaGrande.setLocation(12020, 550);
		panel.add(TuberiaGrande);
		aTuberiaGrande.add(TuberiaGrande);
	
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
		for(int u=0;u<aTuberiaGrande.size();u++){
			aTuberiaGrande.get(u).move(aTuberiaGrande.get(u).getX()-20, (aTuberiaGrande.get(u).getY()));
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
			for(int u=0;u<aTuberiaGrande.size();u++){
				aTuberiaGrande.get(u).move(aTuberiaGrande.get(u).getX()+20, (aTuberiaGrande.get(u).getY()));
				}
		}
		
	//Método para el choque con el lado derecho
	
		public boolean hayChoqueHorizontal() {
			for(int i=0;i<aTuberias.size();i++){
				if(Mario.getPosX()>aTuberias.get(i).getX()-140.5 && Mario.getPosY()>aTuberias.get(i).getY()){
					return true;
				}
			}
			
			return false;
		}
		
	public boolean interseccion() {
		for (int i = 0; i < aTuberias.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aTuberias.get(i).getBounds())&& Mario.getPosY()==860) {
				return true;
			}
		}
		return false;
	}
	
	public void apoyo(){
		for (int i = 0; i < aTuberias.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aTuberias.get(i).getBounds())&& Mario.getPosY()<=aTuberias.get(i).getY()){
				Mario.setPosY(aTuberias.get(i).getY()-140);
				Mario.setCaida(false);
				}
			else{
				if(!Mario.getGrafico().getBounds().intersects(aTuberias.get(i).getBounds())&& Mario.getPosY()==aTuberias.get(i).getY()-140)
				Mario.setCaida(true);
			}
			}
		
	}
	
		//Método para apoyo
		
	public void Apoyo() {
			for(int i=0;i<aTuberias.size();i++){
				if(Mario.getPosX()>aTuberias.get(i).getX()-140.5 && Mario.getPosX()<aTuberias.get(i).getX()+140.5&& Mario.getPosY()<aTuberias.get(i).getY()){
					Mario.setPosY(aTuberias.get(i).getY()-140);
					//Mario.setCaida(false);
				}
				else{
					//TODO método para que caiga cuando pase el obstáculo
				}
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