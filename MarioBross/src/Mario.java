import javax.swing.JPanel;

public class Mario extends Personaje{
	
	private JLabelMario Grafico; //Etiueta gráfica para mario
	
	public boolean salto = false;
	public boolean caida = false;
	public boolean cont = true;
	public double gravedadFija = 0;
	public double gravedad = 859;
	private Mundo mundo;
	
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
		Grafico.setLocation((int) posX, Grafico.getY());

	}

	public void setPosY(double posY) {
		super.setPosY(posY);
		Grafico.setLocation((Grafico.getX()), (int) posY);
	}
	
	
	public boolean isCaida() {
		return caida;
	}



	public boolean isCont() {
		return cont;
	}



	public void setCaida(boolean caida) {
		this.caida = caida;
	}



	public void setCont(boolean cont) {
		this.cont = cont;
	}



	public void saltoMario(){ 	
		if(salto && cont){
			gravedad = gravedad - 20;
			this.setPosY(gravedad);
			if(this.getPosY() == this.gravedadFija - 440 || this.getPosY()<= 0){
				cont = false;
				caida = true;
			}
		}
		if(!mundo.apoyo() && this.getPosY()!= 860 && !salto){
			caida = true;
		}
		if(caida && !mundo.apoyo()){
			if(this.getPosY() == 860 && !mundo.caida()){
				caida = false;
			}
			else if(caida){
			gravedad = gravedad + 20;
			this.setPosY(gravedad);
			if(this.getPosY() == 860 || mundo.apoyo()){
				salto=false;
				caida=false;
			}		
			}
		}
	}



	public boolean isSalto() {
		return salto;
	}



	public void setSalto(boolean salto) {
		this.salto = salto;
	}



	public double getGravedad() {
		return gravedad;
	}



	public void setGravedad(double gravedad) {
		this.gravedad = gravedad;
	}



	public void setGrafico(JLabelMario grafico) {
		Grafico = grafico;
	}	
}


