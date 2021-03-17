package vista;

import modelo.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import controlador.*;

public class LaminaExtras extends JPanel {
	ControladorAgregarProducto controlador;
	JTextField textoCMedallon=new JTextField("0",1);
	Map<String, Integer> map = new HashMap<String, Integer>();

	ArrayList<JCheckBox> array_Extras= new ArrayList();
	public LaminaExtras() {
		setLayout(new GridLayout(7,6));

		controlador= new ControladorAgregarProducto(this);
		controlador.AgregarProductosE("extras", "extra", array_Extras, map);
		JLabel CMedallon=new JLabel("Extra Medallon");
		add(CMedallon);
		add(textoCMedallon);
		ActionListener oyente2=new condimentoSeleccionado();
		for (JCheckBox i : array_Extras) {
			i.addActionListener(oyente2);
		}	
	}
	private class condimentoSeleccionado implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			for (JCheckBox i : array_Extras) {
				if(i.isSelected()) {
					 i.setBackground(Color.GREEN);
				}else
					i.setBackground(Color.GRAY);
			}
		}
	}
	public ArrayList<JCheckBox> getArrayExtras(){
		return array_Extras;
	}
	public Map<String, Integer> getPreciosExtras() {
		return map;
	}
	public String getNHamburgesas() {
		return textoCMedallon.getText();
	}
	public void setNHamburgesas(String n) {
		textoCMedallon.setText(n);
	}
	
}


