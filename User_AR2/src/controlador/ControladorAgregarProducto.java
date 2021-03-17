package controlador;
import vista.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import modelo.*;

public class ControladorAgregarProducto {
	ButtonGroup hamburguesas=new ButtonGroup();
	AgregarProducto producto= new AgregarProducto();
	LaminaExtras laminaE;
	LaminaHamburgesas laminaH;
	public ControladorAgregarProducto(LaminaExtras lamina) {
		laminaE=lamina;

	}
	public ControladorAgregarProducto(LaminaHamburgesas lamina) {
		laminaH=lamina;
	
	}
	
	public void AgregarProductosE(String tabla, String columna, ArrayList<JCheckBox>  arreglo,  Map<String, Integer> map2) {
		producto.ejecutarAgregarProductos(tabla);
		try {	
			
				while (producto.miResultset.next()){
				String nombre=producto.miResultset.getString(columna);
				String precio=producto.miResultset.getString("precio");
				int PrecioV=Integer.parseInt(precio);

				map2.put(nombre,PrecioV);
				if(!nombre.equals("Envio corto") && (!nombre.equals("Envio largo") ) && (!nombre.equals("Medallones") ) ) {
						ponerBotonE(nombre,arreglo);
				}
			}
		}catch(Exception ex){
		System.out.println("Error en  ControladorActualizarPrecios con: " + tabla);
		ex.getMessage();

		ex.printStackTrace();
		}
	}
	
	
	
	public void AgregarProductosH(String tabla, String columna, ArrayList<JRadioButton>  arreglo, Map<String, Integer> map) {
		producto.ejecutarAgregarProductos(tabla);
		try {	
			
	
					while (producto.miResultset.next()){
						String nombre=producto.miResultset.getString(columna);
						String precio=producto.miResultset.getString("precio");
						int PrecioV=Integer.parseInt(precio);
						map.put(nombre,PrecioV);
						ponerBotonH(nombre,arreglo);
				}
		}catch(Exception ex){
		System.out.println("Error en  ControladorActualizarPrecios con: " + tabla);
		ex.getMessage();

		ex.printStackTrace();
		}
	}
	public void ponerBotonH(String nombre, ArrayList<JRadioButton> arreglo){
			JRadioButton boton=new JRadioButton(nombre,false);

			arreglo.add(boton);
			laminaH.add(boton);
		
		}
		
	public void ponerBotonE(String nombre, ArrayList<JCheckBox> arregloE){
		JCheckBox boton=new JCheckBox(nombre,false);
		arregloE.add(boton);
		laminaE.add(boton);
		boton.setBackground(Color.GRAY);
	}
	
	
	

}
 
