package Aplicacion;

import java.io.IOException;
<<<<<<< HEAD
import java.text.ParseException;
=======
import java.util.ArrayList;
>>>>>>> remotes/origin/Entrega-2

import com.google.maps.errors.ApiException;

import Dispositivo.Dispositivo;
import Dispositivo.Estandar;
import Repositorio.Repositorio;

public class Main {
	
<<<<<<< HEAD
	public static void main( String[] args ) throws IOException, ApiException, InterruptedException, ParseException{
			
			Repositorio repositorio = Repositorio.getInstance();
=======
	public static void main( String[] args ) throws IOException, ApiException, InterruptedException{
		/*	Repositorio repositorio = Repositorio.getInstance();
>>>>>>> remotes/origin/Entrega-2
			repositorio.importarLog();
			repositorio.importarDispositivos();
			repositorio.importarZona();
			repositorio.importarTransformadores();
			repositorio.importarClientes();
<<<<<<< HEAD
	
=======
		
			
			System.out.println(repositorio.getClientes());
			System.out.println(repositorio.getZonas());			*/
		
		ArrayList<Dispositivo> dispositivos = new ArrayList<Dispositivo>();

		Cliente roberto = new Cliente(dispositivos);

		Dispositivo aireAcondicionado = new Dispositivo("AA de 3500 frigorias",(float) 1.613 ,90,360,new Estandar(10));
		Dispositivo lampara = new Dispositivo("lampara halogena de 40w",(float) 0.04,90,360,new Estandar(9));
		Dispositivo lavarropas = new Dispositivo("lavarropas 5kg",(float) 0.175,6,40,new Estandar(6));


		dispositivos.add(aireAcondicionado);
		dispositivos.add(lampara);
		dispositivos.add(lavarropas);
		
		roberto.setDispositivos(dispositivos);
		
		/*roberto.getDispositivos().add(aireAcondicionado);
		roberto.getDispositivos().add(lampara);
		roberto.getDispositivos().add(lavarropas);*/


		System.out.println(roberto.getDispositivos());

		roberto.mejorCombinacionDispositivos();
			
			
>>>>>>> remotes/origin/Entrega-2
	}
}
