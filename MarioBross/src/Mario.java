import javax.swing.JPanel;

public class Mario extends Personaje{
	
	private JLabelMario Grafico; //Etiueta gráfica para mario
	
	public boolean salto = false;
	public boolean caida = false;
	public boolean cont = true;
	
	public double gravedad = 859;
	
	/**  Crea un nuevo personaje de juego (Mario)
	 */
	public Mario() {
		Grafico = new JLabelMario();
	}
	

	
	/** Devuelve el JLabel gráfico asociado al Mario de juego
	 * @return	Etiqueta gráfica del Mario
	 */
	public JLabelMario getGrafico() {
		return Grafico;
	}

	public void setPosX(double posX) {
		super.setPosX(posX);
		Grafico.setLocation((int) posX, (int) posY);

	}

	public void setPosY(double posY) {
		super.setPosY(posY);
		Grafico.setLocation((int) posX, (int) posY);
	}
	

	public void saltoMario(){ 

		if(salto && cont){
			gravedad = gravedad - 10;
			this.setPosY(gravedad);
			if(this.getPosY() == 520){
				cont = false;
				caida = true;
			}
		}
		
		if(caida){
			if(this.getPosY() == 860){
				this.setPosY(860);
				salto=false;
				caida=false;
			}
			gravedad = gravedad + 10;
			this.setPosY(gravedad);
		}
		
	}
	
//	public void salto(Mario Mario){
//		Mario.setPosY(Mario.getPosY()-0.0001);
//	}
//	
//	public void saltoDerecha(Mario Mario){
//		Mario.setPosicion(Mario.getPosX()+0.0001, Mario.getPosY()-0.0001);
//		
//	}
//	
//	public void saltoIzq(Mario Mario){
//		Mario.setPosicion(Mario.getPosX()-0.0001, Mario.getPosY()-0.0001);
//		
//	}
//	
//	public void descenso(Mario Mario){
//		Mario.setPosY(Mario.getPosY()+0.0001);
//	}
//	
//	public void saltoVertical(Mario Mario){
//		
//		int i =0;
//		
//		do{
//			if(i==600000){
//				Mario.setPosY(Mario.getPosY()-20);
//				i=0;
//			}
//			else{
//				i++;
//				Mario.setPosX(Mario.getPosX());
//			}
//			
//		}while(Mario.getPosY()>520);
//		i=0;
//		do{
//			if(i==600000){
//				Mario.setPosY(Mario.getPosY()+20);
//				i=0;
//			}
//			else{
//				i++;
//				Mario.setPosX(Mario.getPosX());
//			}
//			
//		}while(Mario.getPosY()<860);
//		Mario.setPosX(Mario.getPosX());
//	}
//
//	public void saltoOblicuoDerecha(Mario Mario, JPanel pPrincipal){
//		
//	int i =0;
//		
//		do{
//			if(i==400000){
//				Mario.setPosY( Mario.getPosY()-15);
//				((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() - 10);
//				if (((JPanelFondo) pPrincipal).getVar() >= -60) {
//					((JPanelFondo) pPrincipal).setVar(-60);
//				}
//				Mario.setPosX(Mario.getPosX());
//				pPrincipal.repaint();
//				i=0;
//			}
//			else{
//				i++;
//				Mario.setPosX(Mario.getPosX());
//			}
//			
//		}while(Mario.getPosY()>520);
//		i=0;
//		do{
//			if(i==400000){
//				Mario.setPosY( Mario.getPosY()+15);
//				((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() - 10);
//				if (((JPanelFondo) pPrincipal).getVar() >= -60) {
//					((JPanelFondo) pPrincipal).setVar(-60);
//				}
//				Mario.setPosX(Mario.getPosX());
//				pPrincipal.repaint();
//				i=0;
//			}
//			else{
//				i++;
//				Mario.setPosX(Mario.getPosX());
//			}
//			
//		}while(Mario.getPosY()<860);
//		Mario.setPosX(Mario.getPosX());
//	}
//	
//	public void saltoOblicuoIzquierda(Mario Mario, JPanel pPrincipal ){
//		
//		int i =0;
//			
//			do{
//				if(i==400000){
//					Mario.setPosY( Mario.getPosY()-15);
//					((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() + 10);
//					if (((JPanelFondo) pPrincipal).getVar() >= -60) {
//						((JPanelFondo) pPrincipal).setVar(-60);
//					}
//					Mario.setPosX(Mario.getPosX());
//					pPrincipal.repaint();
//					i=0;
//				}
//				else{
//					i++;
//					Mario.setPosX(Mario.getPosX());
//				}
//				
//			}while(Mario.getPosY()>520);
//			i=0;
//			do{
//				if(i==400000){
//					Mario.setPosY(Mario.getPosY()+15);
//					((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() + 10);
//					if (((JPanelFondo) pPrincipal).getVar() >= -60) {
//						((JPanelFondo) pPrincipal).setVar(-60);
//					}
//					Mario.setPosX(Mario.getPosX());
//					pPrincipal.repaint();
//					i=0;
//				}
//				else{
//					i++;
//					Mario.setPosX(Mario.getPosX());
//				}
//				
//			}while(Mario.getPosY()<860);
//			Mario.setPosX(Mario.getPosX());
//			
//		}
	
}
