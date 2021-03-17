package modelo;

import java.sql.*;

public class Conexion {

	Connection miConexion=null;
	public Conexion() {
		
	}
	public Connection dameConexion() {
		try {
			//miConexion=DriverManager.getConnection("jdbc:mysql://utkcmulfwnitj1ww:5ii44vI9G3pt8OJJfvRq@bbb7cgkosnifhxrskddy-mysql.services.clever-cloud.com:3306/bbb7cgkosnifhxrskddy","utkcmulfwnitj1ww", "5ii44vI9G3pt8OJJfvRq");
			//miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/arburgers","root","1003");
			miConexion=DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10398137","sql10398137", "abDeg5CQle");

		}catch(Exception e) {
			System.out.println("error en Conexion");
			e.printStackTrace();
		}
		return miConexion;
		
	}
}
