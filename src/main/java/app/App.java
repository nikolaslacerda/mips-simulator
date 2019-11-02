package app;


import controller.*;
import controller.LeitorDeArquivo;
import controller.BlocoDeControle;


public class App {

	public static void main(String[] args) {
		BlocoDeControle controle = BlocoDeControle.getInstance();

		//Iniciando registradores
        Registradores listaDeRegistradores = Registradores.getInstance();

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
