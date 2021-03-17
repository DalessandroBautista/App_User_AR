package modelo;

import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class crearArchivo {
	String ruta=new File("").getAbsolutePath();
	public crearArchivo() {
		
	}
	 Document pedido=new Document();
		
	 	
	public void hacerArchivo(String pVuelto, String pTotal, String pNombre, String pDireccion, String pAbona, String pTelefono, String pHoraEntrega, String pEnvio, ArrayList<registroHamburgesa> pListaHamburgesas) {
			 Document pedido=new Document();
			 try {
				 Calendar c = new GregorianCalendar();
				 String dia = Integer.toString(c.get(Calendar.DATE));
				 String mes = Integer.toString(c.get(Calendar.MONTH));
				 String annio = Integer.toString(c.get(Calendar.YEAR));
				 LocalDateTime locaDate = LocalDateTime.now();
				 int hours  = locaDate.getHour();
				 int minutes = locaDate.getMinute();
				 int seconds = locaDate.getSecond();
				
				 
				 String nombre=("UltimoPedido.pdf");
				 FileOutputStream fichero=new FileOutputStream(nombre);
				 PdfWriter.getInstance(pedido, fichero);
				 pedido.open();
				 String pNombreLocal= "AR Burger's";
				 String pTitulo= "Pedido del " +dia+ "-" + (mes+1) + "-"+ (annio);
				 String hora= "Pedido a las "+ hours + ":"+ minutes + ":"+ seconds;
				 Paragraph n2= new Paragraph (pNombreLocal);
				 Paragraph titulo= new Paragraph (pTitulo);
				 Paragraph d= new Paragraph (pDireccion);
				 Paragraph n= new Paragraph (pNombre);
				 Paragraph t2= new Paragraph (pTelefono);
				 Paragraph h= new Paragraph (hora);
				 Paragraph he= new Paragraph (pHoraEntrega);
				 pedido.add(n2);
				 pedido.add(titulo);
				 pedido.add(d);
				 pedido.add(n);
				 pedido.add(t2);
				 pedido.add(h);
				 pedido.add(he);
				 Paragraph separador= new Paragraph ("Hamburgesas:");
				 pedido.add(separador);
				 for (registroHamburgesa i : pListaHamburgesas) {
					 Paragraph p= new Paragraph ("  " + i.getHamburgesa() + " $" + i.getPrecio());
					 pedido.add(p);
					 
				 }
				 Paragraph envio= new Paragraph (pEnvio);
				 Paragraph abona= new Paragraph (pAbona);
				 Paragraph t= new Paragraph (pTotal);
				 Paragraph vuelto= new Paragraph ("Vuelto: $"+ pVuelto);
				 pedido.add(envio);
				 pedido.add(abona);
				 pedido.add(t);
				 pedido.add(vuelto);
				 
				 pedido.close();
				 JOptionPane.showMessageDialog(null, "Pedido creado");
				 
			 } catch(Exception e2){
				System.out.println("fallo crear archivo");
				e2.printStackTrace();
			 }
			 pedido.close();
			 print();
		}

	public void print(){
		PrinterJob job = PrinterJob.getPrinterJob();
	    job.printDialog();
	    String impresora=job.getPrintService().getName();
		java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
		java.io.File fichero = new java.io.File(ruta + "/UltimoPedido.pdf");

		try {
		desktop.print(fichero);
		} catch (Exception e){
		System.out.print("El sistema no permite imprimir usando la clase Desktop");
		e.printStackTrace();
		}

	}
	
}
