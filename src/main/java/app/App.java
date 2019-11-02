package app;

import controller.LeitorDeArquivo;
import controller.Registradores2;
import controller.SinaisDeControle;

public class App {

	public static void main(String[] args) {
		SinaisDeControle controle = SinaisDeControle.getInstance();
		Registradores2 regs = Registradores2.getInstance();

		LeitorDeArquivo l = new LeitorDeArquivo();

		try {
			l.lePrograma();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
}
