package modelo;

import java.sql.*;

public class Conexion {

	Connection miConexion=null;
	public Conexion() {
		
	}
	public Connection dameConexion() {
		try {
			
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/arburgers","root","1003");
			

		}catch(Exception e) {
			System.out.println("error en Conexion");
			e.printStackTrace();
		}
		return miConexion;
		
	}
}
