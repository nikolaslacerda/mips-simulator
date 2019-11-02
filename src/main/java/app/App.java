package app;

import controller.BancoDeRegistradores;
import controller.BlocoDeControle;
import controller.LeitorDeArquivo;
import controller.MemoriaDeDados;
import controller.MemoriaDeInstrucoes;


public class App {

	public static void main(String[] args) {
        BancoDeRegistradores listaDeRegistradores = BancoDeRegistradores.getInstance();
		BlocoDeControle controle = BlocoDeControle.getInstance();

        //Iniciando a memoria de instrucoes
		MemoriaDeInstrucoes memoriaDeInstrucoes = MemoriaDeInstrucoes.getInstance();

		//Iniciando a memoria de dados
		MemoriaDeDados memoriaDeDados = MemoriaDeDados.getInstance();

		//Iniciando o leitor de arquivo
		LeitorDeArquivo l = new LeitorDeArquivo();

		try {

			l.lePrograma();
			//memoriaDeInstrucoes.imprime();
			memoriaDeDados.imprime();
			//listaDeRegistradores.imprime();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
}
