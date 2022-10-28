package control;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Producto;
import modelo.Proveedor;
import modelo.Mercado;

public class Menu {
	public static void main(String[] args) {
		// estado
		float precio, nuevoPrecio;
		String tipo, marca, vencimiento, nombre, apellido;
		int codigo, stock, dni, codigoProducto, codigoProveedor, codigoVender, codigoRemove;
		
		Scanner teclado = new Scanner(System.in);
		int opcion;
		boolean salir = false;
		
		// productos
		ArrayList <Producto> listaProductos = new ArrayList<Producto>();
		listaProductos.add(new Producto("Fideos", "Marolio", 1, 101, 1, (float) 25.5, "2022-12-25"));
		listaProductos.add(new Producto("Aceite", "Marolio", 2, 101, 1, (float) 30.0, "2022-12-25"));
		listaProductos.add(new Producto("Salsa", "Marolio", 3, 101, 0, (float) 40.5, "2022-12-25"));
		listaProductos.add(new Producto("Yerba", "Marolio", 4, 102, 1, (float) 10.5, "2022-09-25"));
		listaProductos.add(new Producto("Surtido", "Terrabusi", 5, 102, 1, (float) 5.5, "2022-09-25"));
		listaProductos.add(new Producto("Rhodesia", "Terrabusi", 6, 102, 0, (float) 35.5, "2022-09-25"));
		listaProductos.add(new Producto("Chocolate", "Aguila", 7, 103, 1, (float) 45.5, "2022-08-25"));
		listaProductos.add(new Producto("Minitorta", "Aguila", 8, 103, 2, (float) 50.0, "2022-08-25"));
		listaProductos.add(new Producto("Aceitunas", "Vegadeo", 9, 103, 1, (float) 25.0, "2022-08-25"));
		listaProductos.add(new Producto("Aceitunas", "Nucete", 10, 104, 1, (float) 2.5, "2022-12-25"));
		listaProductos.add(new Producto("Oregano", "Alicante", 11, 104, 1, (float) 4.5, "2022-10-25"));
		listaProductos.add(new Producto("Comino", "Alicante", 12, 104, 1, (float) 6.5, "2022-08-25"));
		
		
		// proveedores
		ArrayList <Proveedor> listaProveedores = new ArrayList<Proveedor>();
		listaProveedores.add(new Proveedor("Juan", "Ruiz", 16123234, 101));
		listaProveedores.add(new Proveedor("Carlos", "Sainz", 18123234, 102));
		listaProveedores.add(new Proveedor("Felipe", "Massa", 20123234, 103));
		listaProveedores.add(new Proveedor("Checo", "Perez", 22123234, 104));

		
		// menu
		while(!salir) {
			System.out.println("1. Ver lista de productos");
			System.out.println("2. Ver productos vencidos");
			System.out.println("3. Ver lista de proveedores");
			System.out.println("4. Ver producto por codigo de proveedor");
			System.out.println("5. Modificar precio de un producto");
			System.out.println("6. Ver info de un producto");
			System.out.println("7. Ver info de un proveedor");
			System.out.println("8. Vender un producto");
			System.out.println("9. Agregar un producto");
			System.out.println("10. Quitar un producto");
			System.out.println("11. Agregar un proveedor");
			System.out.println("12. Quitar un proveedor");
			System.out.println("13. Salir");
			
			System.out.println("Elija una opcion");
			opcion = teclado.nextInt();
			
			switch(opcion) {
			case 1:
				Mercado.getListaProductos(listaProductos);
				break;
			case 2:
				Mercado.getProductosVencidos(listaProductos);
				break;
			case 3:
				Mercado.getListaProveedores(listaProveedores);
				break;
			case 4:
				System.out.println("Ingrese codigo del proveedor");
				codigoProveedor = teclado.nextInt();
				Mercado.getProductoProveedor(listaProductos, listaProveedores, codigoProveedor);
				break;
			case 5:
				System.out.println("Elija producto por numero de codigo");
				codigoProducto = teclado.nextInt();
				System.out.println("Ingrese nuevo precio");
				nuevoPrecio = teclado.nextFloat();
				Mercado.setProductoPrecio(listaProductos, codigoProducto, nuevoPrecio);
				break;
			case 6:
				System.out.println("Elija producto por numero de codigo");
				codigoProducto = teclado.nextInt();
				Mercado.getProducto(listaProductos, codigoProducto);
				break;
			case 7:
				System.out.println("Elija un proveedor por numero de codigo");
				codigoProveedor = teclado.nextInt();
				Mercado.getProveedor(listaProveedores, listaProductos, codigoProveedor);
				break;
			case 8:
				System.out.println("Vender producto por numero de codigo");
				codigoVender = teclado.nextInt();
				Mercado.venderProducto(listaProductos, codigoVender);
				break;
			case 9:
				System.out.println("Ingrese tipo de producto");
				tipo = teclado.next();
				System.out.println("Ingrese marca");
				marca = teclado.next();
				System.out.println("Ingrese codigo del proveedor");
				codigoProveedor = teclado.nextInt();
				System.out.println("Ingrese stock");
				stock = teclado.nextInt();
				System.out.println("Ingrese precio");
				precio = teclado.nextFloat();
				System.out.println("Ingrese fecha de vencimiento en formato yyyy-mm-dd");
				vencimiento = teclado.next();
				codigo = listaProductos.size() + 1;
				Mercado.addProducto(listaProductos, tipo, marca, codigo, codigoProveedor, stock, precio, vencimiento);
				System.out.println("Producto agregado con éxito");
				break;
			case 10:
				System.out.println("Eliminar producto por numero de codigo");
				codigoRemove = teclado.nextInt();
				Mercado.removeProducto(listaProductos, codigoRemove);
			case 11:
				System.out.println("Ingrese nombre del nuevo proveedor");
				nombre = teclado.next();
				System.out.println("Ingrese apellido del nuevo proveedor");
				apellido = teclado.next();
				System.out.println("Ingrese dni");
				dni = teclado.nextInt();
				System.out.println("Ingrese codigo para el nuevo proveedor");
				codigo = teclado.nextInt();
				Mercado.addProveedor(listaProveedores, nombre, apellido, dni, codigo);
				System.out.println("Proveedor agregado con éxito");
				break;
			case 12:
				System.out.println("Eliminar proveedor por numero de codigo");
				codigoRemove = teclado.nextInt();
				Mercado.removeProveedor(listaProveedores, codigoRemove);
				break;
			case 13:
				salir = true;
				break;
			default:
				System.out.println("Debe ingresar un numero entre 1 y 13.");
			}
		}	
		
	}
}
