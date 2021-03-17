package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MarcoTextoAR extends JFrame{
	String ruta=new File("").getAbsolutePath();
	public MarcoTextoAR() {
		setTitle("ARBurger's");
		Toolkit miPantalla=Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla=miPantalla.getScreenSize();
		int H=tamanoPantalla.height;
		int W=tamanoPantalla.width;
		setBounds(0,0,W,H/2);
		Image icono=miPantalla.getImage(ruta + "/logo.JPG");
		setIconImage(icono);
		
		LaminaTextoUser_AR lamina=new LaminaTextoUser_AR();
		add(lamina);
		setVisible(true);
	}
}