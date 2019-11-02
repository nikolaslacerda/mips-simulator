package app;


import controller.*;

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
	
	public void LeituraArquivo() {
		
	}

	
}
