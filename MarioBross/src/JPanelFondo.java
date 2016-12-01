
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelFondo extends JPanel {

	private int var=0;
	
	public JPanelFondo(){
		//this.setSize(1000, 750);
	}
	
	
	@Override
	public void paintComponent (Graphics g){
	//
	//Dimension tama�o = getSize();
	//Como no estamos usando un Jlabel no podemos utilizar el set Icon, asi que lo crearemos con el m�todo ImageIcon
	ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Imagenes/FondoMarioLV1.jpg"));
	g.drawImage(imagenFondo.getImage(),var,0,20760, 1080, null);
	setOpaque(false);
	super.paintComponent(g);
	}


	public int getVar() {
		return var;
	}


	public void setVar(int var) {
		this.var = var;
	}	
	
	
}
