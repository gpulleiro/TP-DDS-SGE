package Usuarios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA")
public class Categoria {

	@Id
	@GeneratedValue
	@Column(name="ID_CAT")
	private long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="CONSUMO")
	private float consumo;
	
	@Column(name="CARGO_FIJO")
	private float cargoFijo;
	
	@Column(name="CARGO_VAR")
	private float cargoVariable;
	
	//constructor
	public Categoria(String nombre, float consumo, float cargoFijo, float cargoVariable) {
		super();
		this.nombre = nombre;
		this.consumo = consumo;
		this.cargoFijo = cargoFijo;
		this.cargoVariable = cargoVariable;
	}

	public Categoria() {}
	
	//getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getConsumo() {
		return consumo;
	}

	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}

	public float getCargoFijo() {
		return cargoFijo;
	}

	public void setCargoFijo(float cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	public float getCargoVariable() {
		return cargoVariable;
	}

	public void setCargoVariable(float cargoVariable) {
		this.cargoVariable = cargoVariable;
	}
	
	
	
	//metodos	
	
}