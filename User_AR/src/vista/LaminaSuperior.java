package vista;


import java.awt.FlowLayout;


import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class LaminaSuperior  extends JPanel {
	JTextField textoDireccion=new JTextField(10);
	JTextField textoNombre=new JTextField(10);
	JTextField textoTelefono=new JTextField(10);
	JTextField textoHora=new JTextField("Sin horario",10);
	JTextField textoAbona=new JTextField("0",10);
	public LaminaSuperior() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel direccion=new JLabel("Direccion");
		JLabel nombre=new JLabel("Nombre");
		JLabel telefono=new JLabel("Telefono");
		JLabel abonar=new JLabel("Abona");
		JLabel hora=new JLabel("Hora entrega");

		
		add(direccion);
		add(textoDireccion);
		add(nombre);
		add(textoNombre);
		add(telefono);
		add(textoTelefono);
		add(abonar);
		add(textoAbona);
		add(hora);
		add(textoHora);
	}
	


	public String getTelefono() {
		return textoTelefono.getText().trim();
	}
	public String getNombre() {
		return textoNombre.getText().trim();
	}
	public String getDireccion() {
		return textoDireccion.getText().trim();
	}
	public String getHora() {
		return textoHora.getText().trim();
	}
	public String getAbona() {
		return textoAbona.getText().trim();
	}
}
