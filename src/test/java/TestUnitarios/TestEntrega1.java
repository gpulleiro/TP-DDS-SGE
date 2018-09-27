package TestUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import Acciones.AccionApagar;
import Dispositivo.Dispositivo;
import Dispositivo.Estandar;
import Dispositivo.Inteligente;
import Observer.Regla;
import Repositorio.Repositorio;
import Sensores.SensorDeMovimiento;
import Usuarios.Cliente;

public class TestEntrega1 {
	
@Test
public void elConsumoEnElPeriodoFue110KW() throws IOException{
	
	Repositorio repo = Repositorio.getInstance();
	repo.importarLog();
	
	Inteligente licuadora = new Inteligente("licuadora",20,2,3,"apagado");
	
	double consumo = licuadora.consumoPeriodo("06/06/2018 02:30:00", "06/06/2018 11:00:00");
	
	assertTrue(consumo == 110);
	
}

@Test
public void elConsumoEnLasUltimas3HorasFue60KW() throws IOException{
	
	Repositorio repo = Repositorio.getInstance();
	repo.importarLog();
	
	Inteligente licuadora = new Inteligente("licuadora",20,3,5,"encendido");
	
	double consumo = licuadora.consumoUltimasHoras(3);
	
	assertTrue(consumo == 60);
	
}
	
@Test
public void estaEncendidoDispositivoInteligente() {
Inteligente licuadora = new Inteligente("licuadora",20,2,4,"encendido");

assertTrue(licuadora.estasEncendido());
}

@Test
public void estaApagadoDispositivoInteligente() {
Inteligente licuadora = new Inteligente("licuadora",20,2,6,"apagado");

assertTrue(licuadora.estasApagado());
}

@Test
public void estaApagadoDispositivoConvertido() {
Cliente pepe = new Cliente();

Estandar licuadora = new Estandar ("licuadora",20,4,5,32);
Estandar split = new Estandar ("split",60,2,5,6);

Inteligente licu = pepe.convertirDispositivo(licuadora);
Inteligente spl = pepe.convertirDispositivo(split);

assertTrue(licu.estasApagado());
assertTrue(spl.estasApagado());
}

@Test
public void estaEnModoAhorroDeEnergia() throws IOException {
Inteligente licuadora = new Inteligente("licuadora",20,2,4,"apagado");

licuadora.ahorro();

assertTrue(licuadora.estasAhorro());
}

@Test
public void tiene10Puntos() throws IOException {
Cliente pepe = new Cliente();

Estandar licuadora = new Estandar("licuadora",20,4,6,43);

pepe.convertirDispositivo(licuadora);

assertTrue(pepe.getPuntos() == 10);
}

@Test
public void losDispositivosSinMovimientoEstanApagados1() {

	Inteligente luz = new Inteligente ("luz",20,3,5,"encendido");
	Inteligente luz1 = new Inteligente ("luz1",20,3,5,"encendido");
	Inteligente luz2 = new Inteligente ("luz2",20,3,5,"encendido");
	Inteligente luz3 = new Inteligente ("luz3",20,3,5,"apagado");
	
	SensorDeMovimiento sensorLuces = new SensorDeMovimiento();
	AccionApagar apagar = new AccionApagar();
	Regla sinMovimientoApagar = new Regla("menor",1, apagar );

	sensorLuces.agregarDispositivo(luz);
	sensorLuces.agregarDispositivo(luz1);
	sensorLuces.agregarDispositivo(luz2);
	sensorLuces.agregarDispositivo(luz3);
	

	sinMovimientoApagar.agregarSensor(sensorLuces); 
	sinMovimientoApagar.setActuador(apagar);
	
	try {
		sensorLuces.realizarMedicion();
	} catch (IOException e) {
		e.printStackTrace();
	}

	assertTrue(luz.estasApagado());
	assertTrue(luz1.estasApagado());
	assertTrue(luz2.estasApagado());
	assertEquals("apagado",luz3.getEstado());

}


}

