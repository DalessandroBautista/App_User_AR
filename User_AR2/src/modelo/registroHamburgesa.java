package modelo;

public class registroHamburgesa {
	String hamburgesa;
	int precio;
	public registroHamburgesa(String hamburgesa2, int precio2) {
		hamburgesa=hamburgesa2;
		precio=precio2;
		
	}
	public int getPrecio() {
		return precio;
	}
	public String getHamburgesa() {
		return hamburgesa;
	}
}
