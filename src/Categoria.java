
public class Categoria {

	private String nombre;
	private int consumo;
	private int cargoFijo;
	private int cargoVariable;

	//constructor
	
	public Categoria(String nombre, int cargoFijo, int cargoVariable, int consumo) {
	
		this.nombre = nombre;
		this.cargoFijo = cargoFijo;
		this.cargoVariable = cargoVariable;
		this.consumo = consumo;
	}
	
	//getters-setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCargoFijo() {
		return cargoFijo;
	}

	public void setCargoFijo(int cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	public int getCargoVariable() {
		return cargoVariable;
	}

	public void setCargoVariable(int cargoVariable) {
		this.cargoVariable = cargoVariable;
	}

	public int getConsumo() {
		return consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}
	
	//metodos	
	
}
