package vista;

import modelo.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;


import controlador.*;

public class LaminaHamburgesas extends JPanel {
	ControladorAgregarProducto controlador;
	
	Map<String, Integer> map = new HashMap<String, Integer>();
	
	ButtonGroup hamburgesas=new ButtonGroup();
	ArrayList<JRadioButton> array_Hamburgesas= new ArrayList();
	String nHamburgesa;
	public  LaminaHamburgesas() {
		setLayout(new GridLayout(7,6));
		controlador= new ControladorAgregarProducto(this);
		controlador.AgregarProductosH("hamburgesas", "hamburgesa", array_Hamburgesas, map);
		updateUI();
		ActionListener oyente=new hamburgesaSeleccionada();
		for (JRadioButton i : array_Hamburgesas) {
			hamburgesas.add(i);
			i.addActionListener(oyente);

			
		}
		
		
		
	}
	private class hamburgesaSeleccionada implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String entrada=e.getActionCommand();
			nHamburgesa=entrada;
		}
	}
	public String getHamburgesa() {
		return nHamburgesa;
	}
	public Map<String, Integer> getPreciosHamburgesa() {
		return map;
	}

}

