package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import modelo.*;
import controlador.*;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.awt.print.*;
import java.sql.*;

public class LaminaTextoUser_AR extends JPanel{
		JButton agregar=new JButton("Agregar Hamburguesa");
		JButton quitar=new JButton("Quitar Hamburguesa");
	
		JButton imprimir=new JButton("Imprimir");
		JButton imprimir2=new JButton("Imprimir2");
		String pNombre;
		String pTelefono;
		String pHoraEntrega;
		String pDireccion;
		String pHamburgesa;
		String pTotal;
		String pEnvio;
		String pVuelto;
		String pAbona;
		String nEnvio;
		int total=0;
		ArrayList<registroHamburgesa> pListaHamburgesas = new ArrayList<registroHamburgesa>();
		ButtonGroup envio=new ButtonGroup();
		int tEnvio;

		String ruta=new File("").getAbsolutePath();
		LaminaPedido laminaPedido=new LaminaPedido();
		LaminaSuperior laminaSuperior=new LaminaSuperior();
		LaminaExtras laminaExtras=new LaminaExtras();
		LaminaHamburgesas laminaHamburgesas=new LaminaHamburgesas();
	
		
		Map<String, Integer> mapE = new HashMap<String, Integer>();
		Statement  miStatement;
	public LaminaTextoUser_AR() {
	
		setLayout(new FlowLayout());
		
		//Leer2();
		
		Toolkit miPantalla=Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla=miPantalla.getScreenSize();
		int H=tamanoPantalla.height;
		int W=tamanoPantalla.width;
		
		ActionListener oyente=new imprimir();
		ActionListener oyente2=new envioSeleccionado();
		imprimir.addActionListener(oyente);
		add(laminaSuperior, BorderLayout.NORTH);
		add(imprimir, BorderLayout.EAST);
		ponerBoton2("Envio corto",oyente2);
		ponerBoton2("Envio largo",oyente2);
		ponerBoton2("Sin envio",oyente2);
	
		add(laminaHamburgesas, BorderLayout.EAST);
		add(laminaExtras, BorderLayout.WEST);
		
		
		ActionListener oyente3=new AgregarHamburgesa();
		agregar.addActionListener(oyente3);
		add(agregar);
		
		ActionListener oyente4=new QuitarHamburgesa();
		quitar.addActionListener(oyente4);
		add(quitar);
		
	
		

		
		add(laminaPedido, BorderLayout.SOUTH);
		
		mapE=laminaExtras.getPreciosExtras();
		
	}
	private void ponerBoton2(String nombre, ActionListener oyente) {
		JRadioButton boton=new JRadioButton(nombre,false);

		boton.addActionListener(oyente);
		envio.add(boton);
		add(boton,BorderLayout.WEST);
	
	}
	
	private class AgregarHamburgesa implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ControladorAgregarHamburgesa c= new ControladorAgregarHamburgesa();
			c.AgregarHamburgesa(laminaHamburgesas.getHamburgesa(), laminaHamburgesas.getPreciosHamburgesa(), laminaExtras.getPreciosExtras(), laminaExtras.getArrayExtras(), laminaExtras.getNHamburgesas(), pListaHamburgesas);
			
			laminaPedido.actualizarUI(pListaHamburgesas);
			laminaExtras.setNHamburgesas("0");
			
		}
	}
	private class QuitarHamburgesa implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			pListaHamburgesas.remove((pListaHamburgesas.size()) - (1));
			laminaPedido.actualizarUI(pListaHamburgesas);
			}
		}
	
	private class envioSeleccionado implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String entrada=e.getActionCommand();
			nEnvio=entrada;
			if (!nEnvio.equals("Sin envio")) {
				tEnvio=mapE.get(nEnvio);
				laminaPedido.agregarEnvio(tEnvio, pListaHamburgesas);
			}else laminaPedido.agregarEnvio(0, pListaHamburgesas);
		}
	}
	private class imprimir implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			 String nombre="Nombre: " + laminaSuperior.getNombre(); 
			 String telefono="Telefono: " + laminaSuperior.getTelefono(); 
			 String horaEntrega="Hora entrega: " + laminaSuperior.getHora(); 
			 String direccion="Direccion: " + laminaSuperior.getDireccion(); 
			 String abona=laminaSuperior.getAbona();
			 pEnvio=Integer.toString(tEnvio);
			 
			ControladorImprimir c= new ControladorImprimir();
			c.ejecutarImprimir(nombre, direccion, abona, telefono, horaEntrega, tEnvio, pListaHamburgesas);
			 
			 new MarcoAR();
			 Window w = SwingUtilities.getWindowAncestor(LaminaTextoUser_AR.this);
		     w.setVisible(false);
			
				
		}
		}


}