package Inferface;

import java.util.List;
import Dominio.Casa;

public interface Metodos {
	public void guardar(Casa casa);

	public List<Casa> mostrar();

	public Casa buscar(int indice);

	public void editar(int indice, Casa casa);

	public void eliminar(int indice);
	
	public Casa buscarXNum(int num);
	
	public List<Casa> buscarXTipo(String tipo);
	
	public float totalInvertido();
	
	public void eliminarXNum(int num);
	
	public void editarXNum(int num, Casa casa);
}
