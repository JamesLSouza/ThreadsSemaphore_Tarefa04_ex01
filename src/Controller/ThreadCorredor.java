package Controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread {
	private int id;
	private Semaphore sem;
	private static int p = 0;
	Random r = new Random();

	public ThreadCorredor(int idpessoa, Semaphore semaforo) {
		this.id = idpessoa;
		this.sem = semaforo;

	}

	public void run() {
		Caminhada();
		try{
			sem.acquire();
			Porta();
			sem.release();
		}catch (Exception e) {
			e.printStackTrace();
		}
		saida();
		
	}

	private void Caminhada() {
		int tempo = 1000;
		int DistanciaPercorrida = 0;
		while (DistanciaPercorrida < 200) {
			DistanciaPercorrida += ((int) (Math.random() * 6) + 4);
			while (DistanciaPercorrida > 200) {
				if (DistanciaPercorrida >= 200) {
					DistanciaPercorrida -= 1;
				}
				

			} 
			if(DistanciaPercorrida < 200)
			{
				try {
					Thread.sleep(tempo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Pessoa " + id + " Caminhou " + DistanciaPercorrida + " metros");
		}
		
	}

	private void Porta() 
	{
		System.out.println("Pessoa " + id + " chegou na porta");
		double tempinicio = System.nanoTime();
		int tempoparado = (r.nextInt(2)+1);
		try {
			Thread.sleep(tempoparado);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		double tempofim = System.nanoTime();
		double tempototal = tempofim - tempinicio;
		tempototal = (tempototal / Math.pow(10, 9));
		System.out.println("Pessoa " + id + " o tempo de espera é de: " + tempototal);
		
	}
	
	private void saida() {
		p++;
		System.out.println("A Pessoa " + id + " cruzou a porta na " + p + " ª posição");
		
	}
	
	
}
