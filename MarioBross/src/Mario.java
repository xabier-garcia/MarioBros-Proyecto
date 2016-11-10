
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
	
	public void salto(Mario Mario){
		int i=0;
		while(i<800000){
		Mario.setPosY(760);
		i++;
		}
		Mario.setPosY(860);
	}
	
	
}
