package Usuarios;


public class Categoria {

	private String nombre;
	private float consumo;
	private float cargoFijo;
	private float cargoVariable;
	
	//constructor
	public Categoria(String nombre, float consumo, float cargoFijo, float cargoVariable) {
		super();
		this.nombre = nombre;
		this.consumo = consumo;
		this.cargoFijo = cargoFijo;
		this.cargoVariable = cargoVariable;
	}

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