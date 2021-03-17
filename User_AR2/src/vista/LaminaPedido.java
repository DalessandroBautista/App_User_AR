package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.*;

public class LaminaPedido extends JPanel {
	JLabel texto=new JLabel("");
	int totalEnvio=0;

	public LaminaPedido() {
		setLayout(new GridLayout(10,1));
		this.setBackground(Color.WHITE);
		
	}
	public void actualizarUI(ArrayList<registroHamburgesa> listaHamburgesas){
		Font letra=new Font("Serif",Font.PLAIN,15);
		//registroHamburgesa r= new registroHamburgesa("a", 0);
		//r=listaHamburgesas.get(listaHamburgesas.size() -1 );
		//JLabel texto=new JLabel(r.getHamburgesa() + ".");
		this.removeAll();
		int total=0;
		for (registroHamburgesa i : listaHamburgesas) {
			JLabel texto=new JLabel(i.getHamburgesa() + ".");
			total+= i.getPrecio();
			 texto.setFont(letra);
			 add(texto);
				}
		total+=totalEnvio;
		JLabel texto2=new JLabel("Total actual es: $" + total);
		add(texto2);
		total=0;
		//texto.setFont(letra);
		//add(texto);
		updateUI();
		
	}
	public void agregarEnvio(int valorEnvio,ArrayList<registroHamburgesa> listaHamburgesas){
		totalEnvio=valorEnvio;
		actualizarUI(listaHamburgesas);
		
	}
}

