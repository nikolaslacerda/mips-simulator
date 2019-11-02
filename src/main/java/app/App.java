package app;

<<<<<<< HEAD

import controller.*;
=======
import controller.LeitorDeArquivo;
import controller.Registradores2;
import controller.SinaisDeControle;
>>>>>>> aa268149ac66266644dd150c0b9b1ee39fb6260c

public class App {

	public static void main(String[] args) {
		SinaisDeControle controle = SinaisDeControle.getInstance();
		//Registradores2 regs = Registradores2.getInstance();
        Registradores listaDeRegistradores = Registradores.getInstance();
		MemoriaDeInstrucoes m = MemoriaDeInstrucoes.getInstance();


		LeitorDeArquivo l = new LeitorDeArquivo();

		try {

			l.lePrograma();
			m.imprime();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
}
