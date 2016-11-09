import javax.swing.JPanel;

public class Mario extends Personaje{
	
	private JLabelMario Grafico; //Etiueta gráfica para mario
	
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
	
	public void saltoVertical(Mario Mario){
		
		int i =0;
		
		do{
			if(i==10000000){
				Mario.setPosY(Mario.getPosY()-20);
				i=0;
			}
			else{
				i++;
			}
			
		}while(Mario.getPosY()>520);
		i=0;
		do{
			if(i==10000000){
				Mario.setPosY(Mario.getPosY()+20);
				i=0;
			}
			else{
				i++;
			}
			
		}while(Mario.getPosY()<860);
	}
	
	public void saltoOblicuoDerecha(Mario Mario, JPanel pPrincipal){
		
	int i =0;
		
		do{
			if(i==7000000){
				Mario.setPosY( Mario.getPosY()-15);
				((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() - 10);
				if (((JPanelFondo) pPrincipal).getVar() >= -60) {
					((JPanelFondo) pPrincipal).setVar(-60);
				}
				Mario.setPosX(Mario.getPosX());
				pPrincipal.repaint();
				i=0;
			}
			else{
				i++;
			}
			
		}while(Mario.getPosY()>520);
		i=0;
		do{
			if(i==7000000){
				Mario.setPosY( Mario.getPosY()+15);
				((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() - 10);
				if (((JPanelFondo) pPrincipal).getVar() >= -60) {
					((JPanelFondo) pPrincipal).setVar(-60);
				}
				Mario.setPosX(Mario.getPosX());
				pPrincipal.repaint();
				i=0;
			}
			else{
				i++;
			}
			
		}while(Mario.getPosY()<860);
	}
	
	public void saltoOblicuoIzquierda(Mario Mario, JPanel pPrincipal ){
		
		int i =0;
			
			do{
				if(i==7000000){
					Mario.setPosY( Mario.getPosY()-15);
					((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() + 10);
					if (((JPanelFondo) pPrincipal).getVar() >= -60) {
						((JPanelFondo) pPrincipal).setVar(-60);
					}
					Mario.setPosX(Mario.getPosX());
					pPrincipal.repaint();
					i=0;
				}
				else{
					i++;
				}
				
			}while(Mario.getPosY()>520);
			i=0;
			do{
				if(i==7000000){
					Mario.setPosY(Mario.getPosY()+15);
					((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() + 10);
					if (((JPanelFondo) pPrincipal).getVar() >= -60) {
						((JPanelFondo) pPrincipal).setVar(-60);
					}
					Mario.setPosX(Mario.getPosX());
					pPrincipal.repaint();
					i=0;
				}
				else{
					i++;
				}
				
			}while(Mario.getPosY()<860);
		}
	
}
