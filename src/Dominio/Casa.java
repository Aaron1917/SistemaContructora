package Dominio;

public class Casa {
	
	private int numero;
	private float precio;
	private String tipoCasa;
	private String dimensiones;
	
	public Casa() {
	}


	public Casa(int numero, float precio, String tipoCasa, String dimensiones) {
		this.numero = numero;
		this.precio = precio;
		this.tipoCasa = tipoCasa;
		this.dimensiones = dimensiones;
	}


	@Override
	public String toString() {
		return "Casa [numero=" + numero + ", precio=" + precio + ", tipoCasa=" + tipoCasa + ", dimensiones="
				+ dimensiones + "]\n";
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public String getTipoCasa() {
		return tipoCasa;
	}


	public void setTipoCasa(String tipoCasa) {
		this.tipoCasa = tipoCasa;
	}


	public String getDimensiones() {
		return dimensiones;
	}


	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}
}
