package Dispositivo;


import javax.persistence.*;



@Entity
@Table(name = "DISPOSITIVO")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO", discriminatorType = DiscriminatorType.STRING)
public abstract class Dispositivo {
	
	@Id
	@GeneratedValue
	@Column(name="ID_DISP")
	protected long id;
	
	@Column(name="NOMBRE")
	protected String nombre;
	
	@Column(name="CONS_FIJO")
	protected double consumoFijo;
	
	@Column(name="MIN_HORAS")
	protected double minimoHoras;
	
	@Column(name="MAX_HORAS")
	protected double maximoHoras;
	
	@Transient
	protected double consumoIdeal;
	
	
	@Transient
	protected double consumoActual;
	
	//constructor>
	public Dispositivo(String nombre, double consumoFijo, double minimoHoras, double maximoHoras) {
		super();
		this.nombre = nombre;
		this.consumoFijo = consumoFijo;
		this.minimoHoras = minimoHoras;
		this.maximoHoras = maximoHoras;
	}

	public Dispositivo() {};
	
	//getters and setters
	
	
	
	
	public long getId() {
		return id;
	}


	public double getConsumoActual() {
		return consumoActual;
	}

	public void setConsumoActual(double consumoActual) {
		this.consumoActual = consumoActual;
	}

	public double getConsumoIdeal() {
		return consumoIdeal;
	}

	public void setConsumoIdeal(double consumoIdeal) {
		this.consumoIdeal = consumoIdeal;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getConsumoFijo() {
		return consumoFijo;
	}


	public void setConsumoFijo(double consumoFijo) {
		this.consumoFijo = consumoFijo;
	}


	public double getMinimoHoras() {
		return minimoHoras;
	}


	public void setMinimoHoras(double minimoHoras) {
		this.minimoHoras = minimoHoras;
	}


	public double getMaximoHoras() {
		return maximoHoras;
	}


	public void setMaximoHoras(double maximoHoras) {
		this.maximoHoras = maximoHoras;
	}
	
	public String esInteligente() {
		
		return "NO";
	}

	//metodos 
//	public void estasEncendido(){
//		
//		this.getTipo().estasEncendido();
//	}	
//
//	public void estasApagado(){
//		
//		this.getTipo().estasApagado();
//	}
//	
//	public void estasAhorro(){
//		
//		this.getTipo().estasAhorro();
//		
//	}
//	
//	public void encender() throws IOException{
//		
//		this.getTipo().encender();
//	}
//	public void apagar() throws IOException{
//		
//		this.getTipo().apagar();
//	}
//	
//	public void ahorro() throws IOException{
//
//		this.getTipo().ahorro();
//	}
//	
//	// opcion 2
//	
//	public void cambiarEstado(String estado) throws IOException{
//
//		this.getTipo().cambiarEstado(estado);
//	}
//	
//	public double consumoUltimasHoras(int horas){
//		
//		double consumo = this.getTipo().consumoUltimasHoras(this, horas);
//		
//		return consumo;
//	}
//	
//	public double consumoPeriodo(String fecha1, String fecha2){
//		
//		double consumo = this.getTipo().consumoPeriodo(this, fecha1, fecha2);
//		
//		return consumo;
//	}
//	
//	public float consumo(){
//		
//		return this.getTipo().consumo(this.consumoFijo);
//		
//	}

	public abstract String getEstado();
	
	public abstract int getCantHoras();
	
	public abstract String obtenerFlag();
	
	public abstract double consumoPeriodo(String fecha1, String fecha2);


	public abstract double consumo();
	
}


