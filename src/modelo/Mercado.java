package modelo;
import java.time.LocalDate;
import java.util.ArrayList;

public class Mercado {
	// estado
	private ArrayList <Producto> listaProductos;
	private ArrayList <Proveedor> listaProveedores;
	
	//metodos
	public static void getListaProductos(ArrayList <Producto> listaProductos) {
		for(int i = 0; i < listaProductos.size(); i++) {
			System.out.println(listaProductos.get(i).getTipo());
		}
	}
	
	public static void getProductosVencidos(ArrayList <Producto> listaProductos) {
		LocalDate hoy = LocalDate.now();
		for(int i = 0; i < listaProductos.size(); i++) {
			if(hoy.isAfter(listaProductos.get(i).getVencimiento())) {
				System.out.println("El producto " + listaProductos.get(i).getCodigo() + " está vencido.");
			};
		}
	}
	
	public static void getProducto(ArrayList <Producto> listaProductos, int codigoProducto) {
		for(int i = 0; i < listaProductos.size(); i++) {
			if(listaProductos.get(i).getCodigo() == codigoProducto) {
			int stock = listaProductos.get(i).getStock();
			System.out.println(
					listaProductos.get(i).getTipo() 
					+ " " + listaProductos.get(i).getMarca() 
					+ ", cuesta " + listaProductos.get(i).getPrecio()
					+ " y vence el " + listaProductos.get(i).getVencimiento());

			if(stock > 0) {
				System.out.println("Hay stock disponible");
			} else {
				System.out.println("No hay stock disponible");
			}
			}
		}
	}
	
	public static void getProductoProveedor(ArrayList <Producto> listaProductos, ArrayList <Proveedor> listaProveedores, int codigoProveedor) {
		for(int i = 0; i < listaProductos.size(); i++) {
			if(listaProductos.get(i).getCodigoProveedor() == codigoProveedor) {
				System.out.println(
						listaProductos.get(i).getTipo() 
						+ " " + listaProductos.get(i).getMarca() 
						+ ", su codigo es " + listaProductos.get(i).getCodigo());
			}
		}
	}
	
	public static void setProductoPrecio(ArrayList <Producto> listaProductos, int codigoProducto, float nuevoPrecio) {
		int cp = codigoProducto;
		for(int i = 0; i < listaProductos.size(); i++) {
			if(listaProductos.get(i).getCodigo() == cp) {
				System.out.println("El precio anterior es " + listaProductos.get(i).getPrecio());
				listaProductos.get(i).setPrecio(nuevoPrecio);
				System.out.println("El nuevo precio es " + listaProductos.get(i).getPrecio());
			}
		}
	}
	
	public static void venderProducto(ArrayList <Producto> listaProductos, int codigoVender) {
		for(int i = 0; i < listaProductos.size(); i++) {
			if(listaProductos.get(i).getCodigo() == codigoVender) {
				int stock = listaProductos.get(i).getStock();
				if(stock > 0) {
					int nuevoStock = listaProductos.get(i).getStock() - 1;
					listaProductos.get(i).setStock(nuevoStock);
					System.out.println("Venta realizada con éxito");
				} else {
					System.out.println("No hay stock suficiente para realizar la venta");
				}
			}
		}

	}
	
	public static void addProducto(ArrayList <Producto> listaProductos2, String tipo, String marca, int codigo, int codigoProveedor, int stock, float precio, String vencimiento) {		 
		Producto nuevoProducto = new Producto(tipo, marca, codigo, codigoProveedor, stock, precio, vencimiento);
		listaProductos2.add(nuevoProducto);

	}	
	
	public static void removeProducto(ArrayList <Producto> listaProductos, int codigoRemove) {
		for(int i = 0; i < listaProductos.size(); i++) {
			if(listaProductos.get(i).getCodigo() == codigoRemove) {
				listaProductos.remove(codigoRemove);
			}
		}

	}
		
	// metodos proveedores
	public static void getListaProveedores(ArrayList <Proveedor> listaProveedores) {
		for(int i = 0; i < listaProveedores.size(); i++) {
			System.out.println(listaProveedores.get(i).getNombre() + " " + listaProveedores.get(i).getApellido());
		}
	}
	
	public static void getProveedor(ArrayList <Proveedor> listaProveedores, ArrayList <Producto> listaProductos, int codigoProveedor) {		
				
		for(int i = 0; i < listaProveedores.size(); i++) {
			if(listaProveedores.get(i).getCodigo() == codigoProveedor) {	
			System.out.println(
					listaProveedores.get(i).getNombre() 
					+ " " + listaProveedores.get(i).getApellido() 
					+ " tiene los siguientes productos: ");
						
			}
			if(listaProveedores.get(i).getCodigo() == codigoProveedor) {
				for(int j = 0; j < listaProductos.size(); j++) {
					if(listaProductos.get(j).getCodigoProveedor() == codigoProveedor) {
						System.out.println(listaProductos.get(j).getTipo());
					}
				}
			}
		}
	}
	
	public static void addProveedor(ArrayList <Proveedor> listaProveedores, String nombre, String apellido, int dni, int codigo) {
		Proveedor nuevoProveedor =  new Proveedor(nombre, apellido, dni, codigo);
		listaProveedores.add(nuevoProveedor);

	}
	
	public static void removeProveedor(ArrayList <Proveedor> listaProveedores, int codigoRemove) {
		for(int i = 0; i < listaProveedores.size(); i++) {
			if(listaProveedores.get(i).getCodigo() == codigoRemove) {
				listaProveedores.remove(codigoRemove);
			}
		}
	}
	
	public static void verificarProveedor(ArrayList <Proveedor> listaProveedores, ArrayList <Producto> listaProductos, int codigoProveedor, String nombre, String apellido, int dni, int codigo) {
		for(int i = 0; i < listaProductos.size(); i++) {
			if(listaProductos.get(i).getCodigoProveedor() != codigoProveedor) {
				addProveedor(listaProveedores, nombre, apellido, dni, codigo);
			}
		}
	}
}
