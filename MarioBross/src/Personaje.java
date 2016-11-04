
/**
 * Clase para definir instancias l�gicas de coches con posici�n, direcci�n y
 * velocidad.
 */
public class Personaje {
	protected double posX; // Posici�n en X (horizontal)
	protected double posY; // Posici�n en Y (vertical)
	protected String nombre; // Nombre del personaje
	protected double Direccion; // Direcci�n en la que estoy mirando en grados
								// (de 0 a 360)

	public Personaje() {
		this.posX = posX;
		this.posY = posY;
		this.nombre = nombre;

	}

	public double getDireccion() {
		return Direccion;
	}

	public void setDireccion(double direccion) {
		Direccion = direccion;
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
