package View;

import java.util.concurrent.Semaphore;

import Controller.ThreadCorredor;

public class Principal 
{

	public static void main(String[] args)
	{
	int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idpessoa = 1; idpessoa < 5; idpessoa++) 
		{
			Thread pessoas = new ThreadCorredor(idpessoa, semaforo);
			pessoas.start();
		}
	}

}
