package Simplex;

import java.util.ArrayList;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import Dispositivo.Dispositivo;

public class SimplexMaximizacionAdapter {
	private SimplexFacade simplex;
	
	public SimplexMaximizacionAdapter() {
		simplex = new SimplexFacade(GoalType.MAXIMIZE, true);
	}
	
	public void realizarCombinacionMaximizacion(ArrayList<Dispositivo> dispositivos) {
		
		int tamanioLista = dispositivos.size();
		int i=0;
		double[] coeficientes = new double[tamanioLista];
		
		//por cada dispositivo creo las restricciones y tomo el consumo fijo en un vector
		for (Dispositivo dis:dispositivos){
			double[] variables = new double[tamanioLista];
			variables[i]=1;
			coeficientes[i]=dis.getConsumoFijo();
			double min = dispositivos.get(i).getMinimoHoras();
			double max = dispositivos.get(i).getMaximoHoras();
			simplex.agregarRestriccion(Relationship.GEQ, min, variables);
			simplex.agregarRestriccion(Relationship.LEQ, max, variables);
			i++;
		}
		//agrego la restriccion general, en este caso el ejemplo es 620
		simplex.agregarRestriccion(Relationship.LEQ, 620, coeficientes);
		//creo la funcion economica
		simplex.crearFuncionEconomica(coeficientes);
	
		//resuelvo y muestro los resultados
		PointValuePair solucion = simplex.resolver();
	
		for(i=0;i<tamanioLista;i++){
		
		System.out.printf(" x%d: %f", i, solucion.getPoint()[i]);
		}
		System.out.printf(" total: %f", solucion.getValue());
		
		
	}
}
