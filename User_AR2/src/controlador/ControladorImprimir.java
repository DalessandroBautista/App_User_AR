package controlador;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import modelo.*;

import vista.*;


public class ControladorImprimir {
	public ControladorImprimir(){
		}
	public void ejecutarImprimir (String nombre, String direccion, String abona, String telefono, String horaEntrega, int envio, ArrayList<registroHamburgesa> pListaHamburgesas){
			 int total=0;
			 for (registroHamburgesa i : pListaHamburgesas) {
				 total+=i.getPrecio();
					}
			 total+=envio;
			 String pVuelto=Integer.toString( (Integer.parseInt(abona) )- (total));
			 String vuelto=pVuelto;
			 int envioBD= envio;
			 int totalBD=total;
			 String pEnvio= "Envio $" + envio;
			 String pAbona= "Abona $"+ abona;
			 String pTotal=  "Total $" + total;
			 pVuelto= "Vuelto $" + pVuelto;
			 setPedidoBD setpedido= new setPedidoBD();
			 setpedido.subirPedidoBD(totalBD, envioBD);

			crearArchivo archivo=new crearArchivo();
			archivo.hacerArchivo(vuelto, pTotal, nombre, direccion, pAbona, telefono, horaEntrega, pEnvio, pListaHamburgesas);
				
		}
}
