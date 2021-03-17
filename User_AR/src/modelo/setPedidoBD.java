package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class setPedidoBD {
	public setPedidoBD(){
		
	}
	public void subirPedidoBD(int totalBD, int envioBD) {
	 try {
			Conexion miConexion=new Conexion();
			Connection accesoBD=miConexion.dameConexion();
			PreparedStatement sentencia=accesoBD.prepareStatement("INSERT INTO pedido(fecha,total,envio) VALUES(?, ?,?)");
			sentencia.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			sentencia.setInt(2, totalBD);
			sentencia.setInt(3, envioBD);
			sentencia.executeUpdate();		
		}catch(Exception ex){
			System.out.println("Fallo la suba del pedido a la BD");
			ex.printStackTrace();
		}
	
	}
}
