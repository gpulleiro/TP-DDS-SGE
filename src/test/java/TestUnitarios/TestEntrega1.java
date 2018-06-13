package TestUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import Acciones.AccionApagar;
import Dispositivo.Dispositivo;
import Dispositivo.Estandar;
import Dispositivo.Inteligente;
import Observer.Regla;
import Sensores.SensorDeMovimiento;
import Usuarios.Cliente;

public class TestEntrega1 {

@Test
public void estaEncendidoDispositivoInteligente() {
Dispositivo licuadora = new Dispositivo("licuadora",20,new Inteligente("encendido"));

assertTrue(licuadora.getTipo().estasEncendido());
}

@Test
public void estaApagadoDispositivoInteligente() {
Dispositivo licuadora = new Dispositivo("licuadora",20,new Inteligente("apagado"));

assertTrue(licuadora.getTipo().estasApagado());
}

@Test
public void estaApagadoDispositivoConvertido() {
Cliente pepe = new Cliente();

Dispositivo licuadora = new Dispositivo("licuadora",20,new Estandar(3));
Dispositivo split = new Dispositivo("split",60,new Estandar(4));

pepe.convertirDispositivo(licuadora);
pepe.convertirDispositivo(split);

assertTrue(licuadora.getTipo().estasApagado());
assertTrue(split.getTipo().estasApagado());
}

@Test
public void estaEnModoAhorroDeEnergia() throws IOException {
Dispositivo licuadora = new Dispositivo("licuadora",20,new Inteligente("apagado"));

licuadora.ahorro();

assertTrue(licuadora.getTipo().estasAhorro());
}

@Test
public void tiene10Puntos() throws IOException {
Cliente pepe = new Cliente();

Dispositivo licuadora = new Dispositivo("licuadora",20,new Estandar(3));

pepe.convertirDispositivo(licuadora);

assertTrue(pepe.getPuntos() == 10);
}

@Test
public void losDispositivosSinMovimientoEstanApagados1() {

	Dispositivo luz = new Dispositivo("luz",20,new Inteligente("encendido"));
	Dispositivo luz1 = new Dispositivo("luz1",20,new Inteligente("encendido"));
	Dispositivo luz2 = new Dispositivo("luz2",20,new Inteligente("encendido"));
	Dispositivo luz3 = new Dispositivo("luz3",20,new Inteligente("apagado"));
	
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

assertTrue(luz.getTipo().estasApagado());
assertTrue(luz1.getTipo().estasApagado());
assertTrue(luz2.getTipo().estasApagado());
assertEquals("apagado",luz3.getTipo().getEstado());
}
}

