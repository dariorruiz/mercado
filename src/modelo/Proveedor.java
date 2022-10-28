package modelo;

public class Proveedor {
	// estado
	private String nombre, apellido;
	private int dni, codigo;
	
	// constructor
	public Proveedor(String nombre, String apellido, int dni, int codigo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.codigo = codigo;
	}

	// getters setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
}
