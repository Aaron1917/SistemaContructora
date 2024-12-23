package Implementacion;

import java.util.ArrayList;
import java.util.List;
import Dominio.Casa;
import Inferface.Metodos;

public class LogicaMetodos implements Metodos{
	private List<Casa> lista = new ArrayList<Casa>();
	@Override
	public void guardar(Casa casa) {
		// TODO Auto-generated method stub
		for (Casa c:lista) {
			if(c.getNumero() == casa.getNumero()) {
				System.out.println("El Num. casa ya existe, no se puede guardar");
				return;
			}
		}
		if (casa != null) {
			lista.add(casa);
			System.out.println("Se guardo registro");
		}
	}

	@Override
	public List<Casa> mostrar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Casa buscar(int indice) {
		// TODO Auto-generated method stub
		return lista.get(indice);
	}

	@Override
	public void editar(int indice, Casa casa) {
		// TODO Auto-generated method stub
		lista.set(indice, casa);
	}

	@Override
	public void eliminar(int indice) {
		// TODO Auto-generated method stub
		lista.remove(indice);
	}

	
	@Override
	public Casa buscarXNum(int num) {
		// TODO Auto-generated method stub
		for (Casa casa : lista) {
			if (casa.getNumero() == num) {
				return casa;
			}
		}
		return null;
	}

	@Override
	public List<Casa> buscarXTipo(String tipo) {
		// TODO Auto-generated method stub
		List<Casa> retorno = new ArrayList<Casa>();
		for (Casa casa : lista) {
			if (casa.getTipoCasa().equalsIgnoreCase(tipo)) {
				retorno.add(casa);
			}
		}
		return retorno;
	}

	@Override
	public float totalInvertido() {
		// TODO Auto-generated method stub
		float inversion = 0.0f;
		for (Casa casa : lista) {
			inversion += casa.getPrecio();
		}
		return inversion;
	}

	@Override
	public void eliminarXNum(int num) {
		// TODO Auto-generated method stub
		if (lista == null) {
	        return;
	    }
		
		Casa aEliminar = null ;
		
		for (Casa casa : lista) {
			if (casa.getNumero() == num) {
				aEliminar = casa;
				System.out.println("Casa encontrada");
				break;
			}
		}
		if (aEliminar != null) {
			lista.remove(aEliminar);
			System.out.println("Casa eliminada");
		}
			
	}

	@Override
	public void editarXNum(int num, Casa casa) {
		// TODO Auto-generated method stub
		for (int i = 0; i < lista.size(); i++) {
			if (num == lista.get(i).getNumero()) {
				lista.set(i, casa);
				break;
			}
		}
	}

}
