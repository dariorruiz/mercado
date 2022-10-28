package modelo;
import java.time.LocalDate;

public class Producto {
	// estado
	private String tipo, marca;
	private int codigo, codigoProveedor, stock;
	private float precio;
	private LocalDate vencimiento;
	
	// constructor
	public Producto (String tipo, String marca, int codigo, int codigoProveedor, int stock, float precio, String vencimiento) {
		this.tipo = tipo;
		this.marca = marca;
		this.codigo = codigo;
		this.codigoProveedor = codigoProveedor;
		this.stock = stock;
		this.precio = precio;
		this.vencimiento = LocalDate.parse(vencimiento);
	}
	
	// getters setters
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(int codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public LocalDate getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(LocalDate vencimiento) {
		this.vencimiento = vencimiento;
	}
}
