package app;

import controller.*;

import controller.LeitorDeArquivo;
import controller.BancoDeRegistradores;
import controller.SinaisDeControle;

public class App {

	public static void main(String[] args) {
		SinaisDeControle controle = SinaisDeControle.getInstance();
		//Registradores2 regs = Registradores2.getInstance();
        BancoDeRegistradores listaDeRegistradores = BancoDeRegistradores.getInstance();
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
