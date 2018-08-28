package Simplex;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Usuarios.Cliente;

public abstract class TimerSimplex {
	
	public static void ejecutarTimerCombinacionDispositivosCliente(Cliente cliente, int segundos) {
		Runnable tarea = new Runnable() {
			public void run() {
				cliente.mejorCombinacionDispositivos();
				System.out.println();
			}
		};
		
		ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
		timer.scheduleAtFixedRate(tarea, 1, segundos, TimeUnit.SECONDS);
	} 

}
