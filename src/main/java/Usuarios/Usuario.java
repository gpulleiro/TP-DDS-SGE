package Usuarios;


import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO", discriminatorType = DiscriminatorType.STRING)
public abstract class Usuario {

	@Id
	@GeneratedValue
	@Column(name="ID_USU")
	protected long id;
	
	@Column(name="NOMBRE")
	protected String nombre;
	
	@Column(name="APELLIDO")
	protected String apellido;
	
	@Column(name="DOMICILIO")
	protected String domicilio;
	
	@Column(name="FECHA_ALTA")
	protected String fechaAlta;
	
	@Column(name="USUARIO")
	protected String usuario;
	
	@Column(name="CONTRASENIA")
	protected String contrasenia;
	
	//constructor

	public Usuario(String nombre, String apellido, String domicilio, String fechaAlta, String usuario,
			String contrasenia) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.fechaAlta = fechaAlta;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	
	public Usuario() {
	}

	//getters-setters
	

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

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public boolean esAdmin() {
		return false;
	}
	//metodos
	
}
