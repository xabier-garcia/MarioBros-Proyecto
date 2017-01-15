
/**
 * Clase para definir instancias lógicas de un Personaje
 */
public class Personaje {
	protected double posX; // Posición en X (horizontal)
	protected double posY; // Posición en Y (vertical)
	protected String nombre; // Nombre del personaje
	protected boolean caida;
	protected int vida=5;
	protected int monedas=0;

	public int getVida() {
		return vida;
	}
	
	@Override
	public String toString() {
		return "[" + vida + "]";
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public Personaje() {
		this.posX = posX;
		this.posY = posY;
		this.nombre = nombre;
		this.caida=false;
		this.vida=vida;
		this.monedas=monedas;

	}

	public int getMonedas() {
		return monedas;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}

	public boolean isCaida() {
		return caida;
	}

	public void setCaida(boolean caida) {
		this.caida = caida;
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosicion(double posX, double posY) {
		setPosX(posX);
		setPosY(posY);
	}

	public String getNombre() {
		return nombre;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
