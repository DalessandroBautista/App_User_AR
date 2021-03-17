package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AgregarProducto {
	Statement  miStatement;
	Conexion miConexion;
	public ResultSet miResultset;
	public AgregarProducto() {
			miConexion=new Conexion();
			
		
	}
	public void ejecutarAgregarProductos(String tabla) {
		
		Connection accesoBD=miConexion.dameConexion();
		
		try {
			String x= "SELECT * FROM " + tabla;
			PreparedStatement sentencia=accesoBD.prepareStatement(x);
			miResultset=sentencia.executeQuery();
			
		}catch(Exception ex){
			System.out.println("Fallo la conexion en ejecutarAgregarProductos en la tabla: " + tabla);
			ex.printStackTrace();
		}
	}
}

