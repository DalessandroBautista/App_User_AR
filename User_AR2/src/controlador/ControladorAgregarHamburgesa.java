package controlador;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import modelo.registroHamburgesa;

public class ControladorAgregarHamburgesa {
	public ControladorAgregarHamburgesa() {
		
	}
	public void AgregarHamburgesa(String nHamburgesa,Map<String, Integer> preciosH , Map<String, Integer> preciosC, ArrayList<JCheckBox> Acondimentos, String NHamburgesas, ArrayList<registroHamburgesa> listaHamburgesas) {
		int total=0;
		total+= preciosH.get(nHamburgesa);
		String condimentos="";
		int medallones=0;
		for (JCheckBox i : Acondimentos) {
			
			
			String condimento=i.getText();
			if(i.isSelected()) {
				
				condimentos+=",";
				condimentos+=" ";
				condimentos+=condimento;
				total+=preciosC.get(condimento);
				i.setBackground(Color.GRAY);
				i.setSelected(false);
			}
		}
		String hamburgesa=" ";
		if(NHamburgesas !="" ) {
			medallones=Integer.parseInt(NHamburgesas);
			System.out.println(medallones);
		}
			if(medallones != 0) {
				total+=(preciosC.get("Medallones") * medallones);
				hamburgesa=(nHamburgesa + ", medallones +" + medallones + condimentos);
				listaHamburgesas.add(new registroHamburgesa(hamburgesa, total));
				condimentos="";
				medallones=0;
		 }
		else {
			 hamburgesa=(nHamburgesa + condimentos);
			
			listaHamburgesas.add(new registroHamburgesa(hamburgesa, total));
			condimentos="";
			
		}
		
		
	}
}
