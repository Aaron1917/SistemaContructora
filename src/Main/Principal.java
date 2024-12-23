package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Dominio.Casa;
import Implementacion.LogicaMetodos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Declarar las variables
		Scanner lectura = null;

		int numeroCasa, menuPrinc = 0, subMenu, indice;
		float precio;
		String tipoCasa, dimensiones;

		// Instancia de clase
		Casa casa = null;
		LogicaMetodos imp = new LogicaMetodos();

		do {
			System.out.println("MENU PRINCIPAL");
			System.out.println("1---ALTA");
			System.out.println("2---MOSTRAR");
			System.out.println("3---BUSCAR");
			System.out.println("4---EDITAR");
			System.out.println("5---ELIMINAR");
			System.out.println("6---BUSCAR POR NUM. DE CASA");
			System.out.println("7---BUSCAR POR TIPO");
			System.out.println("8---CALCULAR DINERO INVERTIDO");
			System.out.println("9---ELIMINAR POR NUM. CASA");
			System.out.println("10--EDITAR POR NUM. CASA");
			System.out.println("11--SALIR");

			try {
				lectura = new Scanner(System.in);
				menuPrinc = lectura.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error: " + e.getMessage());
			}
			switch (menuPrinc) {
			case 1: // Alta
				try {
					System.out.println("Ingresa el numero de casa: ");
					lectura = new Scanner(System.in);
					numeroCasa = lectura.nextInt();

					System.out.println("Ingrese el precio: ");
					lectura = new Scanner(System.in);
					precio = lectura.nextFloat();

					System.out.println("Ingrese el tipo de casa");
					lectura = new Scanner(System.in);
					tipoCasa = lectura.nextLine();

					System.out.println("Ingrese las dimensiones");
					lectura = new Scanner(System.in);
					dimensiones = lectura.nextLine();

					// Declarar el objeto con todos los atributos
					casa = new Casa(numeroCasa, precio, tipoCasa, dimensiones);

					// Agregar a la lista
					imp.guardar(casa);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Erro al guardar: " + e.getMessage());
				}
				break;
			case 2: // mostrar
				if (imp.mostrar().isEmpty()) {
					System.out.println("No hay registros");
					break;
				}
				System.out.println(imp.mostrar());
				break;
			case 3: // buscar
				if (imp.mostrar().isEmpty()) {
					System.out.println("No hay registros");
					break;
				}
				System.out.println(imp.mostrar());
				try {
					System.out.println("Ingrese el indice a buscar: ");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();
					if (imp.mostrar().size() > indice) {
						System.out.println(imp.buscar(indice));
					} else {
						System.out.println("Indice fuera de rango");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al guardar: " + e.getMessage());
				}
				break;
			case 4: // Editar por indice
				if (imp.mostrar().isEmpty()) {
					System.out.println("No hay registros");
					break;
				}
				System.out.println(imp.mostrar());
				try {
					System.out.println("Ingrese el indice a editar: ");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					// Buscar
					if (imp.mostrar().size() > indice) {
						casa = imp.buscar(indice);
						System.out.println("Se encontro: " + casa);
					} else {
						System.out.println("Indice fuera de rango");
						break;
					}
					// Editar -- submenu -- casa --precio
					do {
						System.out.println("SUB MENU PARA EDITAR");
						System.out.println("1---NUM.CASA");
						System.out.println("2---PRECIO");
						System.out.println("3---REGRESAR");
						lectura = new Scanner(System.in);
						subMenu = lectura.nextInt();

						switch (subMenu) {
						case 1:
							System.out.println("Ingresa el nuevo numero de casa: ");
							lectura = new Scanner(System.in);
							numeroCasa = lectura.nextInt();

							// Actualizacion
							casa.setNumero(numeroCasa);
							imp.editar(indice, casa);
							System.out.println("Se editó");
							break;

						case 2:
							System.out.println("Ingresa el nuevo precio:");
							lectura = new Scanner(System.in);
							precio = lectura.nextFloat();

							// Actualizacion
							casa.setPrecio(precio);
							imp.editar(indice, casa);
							System.out.println("Se editó");
							break;
						case 3:
							break;
						default:
							subMenu = 0;
							System.out.println("Opción no válida.");
							break;
						}

					} while (subMenu < 3);

				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			case 5: // Eliminar por indice
				if (imp.mostrar().isEmpty()) {
					System.out.println("No hay registros");
					break;
				}
				try {
					System.out.println("Ingrese el indice a eliminar: ");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();
					if (imp.mostrar().size() > indice) {
						System.out.println("Se encontró: " + imp.buscar(indice));
					} else {
						System.out.println("Indice fuera de rango");
						break;
					}
					// Eliminar
					imp.eliminar(indice);
					System.out.println("Se eliminó");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al guardar: " + e.getMessage());
				}
				break;
			case 6: // Buscar por num de casa
				if (imp.mostrar().isEmpty()) {
					System.out.println("No hay registros");
					break;
				}
				System.out.println("Ingrese el numero de casa: ");
				try {
					lectura = new Scanner(System.in);
					numeroCasa = lectura.nextInt();
					casa = imp.buscarXNum(numeroCasa);
					if (casa == null) {
						System.out.println("No se encontró ninguna casa con ese número.");
						break;
					}
					System.out.println("Casa encontrada: " + casa);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al buscar: " + e.getMessage());
				}
				break;
			case 7: // Buscar por tipo
				if (imp.mostrar().isEmpty()) {
					System.out.println("No hay registros");
					break;
				}
				System.out.println("Ingrese el tipo de casa: ");
				try {
					lectura = new Scanner(System.in);
					tipoCasa = lectura.nextLine();
					List<Casa> listaCasas = new ArrayList<Casa>();
					listaCasas.addAll(imp.buscarXTipo(tipoCasa));
					if (listaCasas.isEmpty()) {
						System.out.println("No se encontró ninguna casa de ese tipo.");
						break;
					}
					System.out.println("Casas encontradas: \n" + listaCasas);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al buscar: " + e.getMessage());
				}
				break;
			case 8: // Calcular dinero invertido
				if (imp.mostrar().isEmpty()) {
					System.out.println("No hay registros");
					break;
				}
				System.out.println("El total invertido: " + imp.totalInvertido());
				break;
			case 9: // Eliminar por num casa
				if (imp.mostrar().isEmpty()) {
					System.out.println("No hay registros");
					break;
				}
				System.out.println("Ingrese el numero de casa: ");
				try {
					lectura = new Scanner(System.in);
					numeroCasa = lectura.nextInt();
	
					imp.eliminarXNum(numeroCasa);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al buscar: " + e.getMessage());
				}
				break;
			case 10: // Editar buscando por num de casa // precio 
				if (imp.mostrar().isEmpty()) {
					System.out.println("No hay registros");
					break;
				}
				try {
					System.out.println("Ingresee el numero de casa: ");
					lectura = new Scanner(System.in);
					numeroCasa = lectura.nextInt();
					casa = imp.buscarXNum(numeroCasa);
					if (casa == null) {
						System.out.println("No se encontró ninguna casa con ese número.");
						break;
					}
					System.out.println("Casa encontrada: " + casa);
					
					System.out.println("Ingrese el nuevo precio: ");
					lectura = new Scanner(System.in);
					precio = lectura.nextFloat();
					casa.setPrecio(precio);
					imp.editarXNum(numeroCasa, casa);
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al editar: " + e.getMessage());
				}
				break;
			case 11:
				break;
			default:
				menuPrinc = 0;
				System.out.println("Opción no válida.");
				break;
			}

		} while (menuPrinc != 11);

	}

}
