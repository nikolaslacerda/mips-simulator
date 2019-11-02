package app;

import controller.LeitorDeArquivo;
import controller.SinaisDeControle;

public class App {

	public static void main(String[] args) {
		SinaisDeControle controle = SinaisDeControle.getInstance();

		LeitorDeArquivo l = new LeitorDeArquivo();

		try {
			l.lePrograma();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void LeituraArquivo() {
		
	}

	
}
