package app;

import controller.BancoDeRegistradores;
import controller.BlocoDeControle;
import controller.Executa;
import controller.LeitorDeArquivo;
import controller.MemoriaDeDados;
import controller.MemoriaDeInstrucoes;


public class App {

	public static void main(String[] args) {
        BancoDeRegistradores registradores = BancoDeRegistradores.getInstance();
		BlocoDeControle controle = BlocoDeControle.getInstance();
		MemoriaDeInstrucoes memoriaDeInstrucoes = MemoriaDeInstrucoes.getInstance();
		MemoriaDeDados memoriaDeDados = MemoriaDeDados.getInstance();
		LeitorDeArquivo leitorDeArquivo = new LeitorDeArquivo("/mipsTest2.mips");

		Executa executa= Executa.getInstance();

		try {
            leitorDeArquivo.lePrograma();
			//memoriaDeInstrucoes.imprime();
			//System.out.println(memoriaDeInstrucoes.getPosAtual());
			//executa.ExecutaPrograma();
			//memoriaDeDados.imprime();
			//registradores.imprime();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
}
