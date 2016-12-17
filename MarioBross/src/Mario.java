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
			if(this.getPosY() == 420){
				cont = false;
				caida = true;
			}
		}
		
		if(caida){
			if(this.getPosY() == 840){
				this.setPosY(840);
				salto=false;
				caida=false;
			}
			gravedad = gravedad + 20;
			this.setPosY(gravedad);
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