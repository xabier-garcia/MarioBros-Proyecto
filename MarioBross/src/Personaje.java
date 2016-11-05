
/**
 * Clase para definir instancias lógicas de un Peraonaje
 */
public class Personaje {
	protected double posX; // Posición en X (horizontal)
	protected double posY; // Posición en Y (vertical)
	protected String nombre; // Nombre del personaje

	public Personaje() {
		this.posX = posX;
		this.posY = posY;
		this.nombre = nombre;

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
