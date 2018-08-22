package Helpers;

import TipoDato.Coordenadas;

public class FuncionesHelper {

	public static double calcularDistancia(Coordenadas coordCliente, Coordenadas coordTrafo) {
		// TODO Auto-generated method stub
		double diffLatitud = coordCliente.getLatitud() - coordTrafo.getLatitud();
		double diffLongitud = coordCliente.getLongitud() - coordTrafo.getLongitud();
		return Math.sqrt(Math.pow( diffLatitud, 2)  + Math.pow( diffLongitud,2));
	}

}
