package app;

<<<<<<< HEAD
import controller.LeitorDeArquivo;
=======
import controller.Registradores2;
>>>>>>> d66abc5818e58e4944dbb2f958d419091d8e8e4d
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
	
	public void LeituraArquivo() {
		
	}

	
}
