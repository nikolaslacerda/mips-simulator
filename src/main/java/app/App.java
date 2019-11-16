package app;

import controller.BancoDeRegistradores;
import controller.BlocoDeControle;
import controller.Executa;
import controller.LeitorDeArquivo;
import controller.MemoriaDeDados;
import controller.MemoriaDeInstrucoes;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class App extends Application {

	private double x;
	private double y;

    @Override
    public void start(final Stage stage) throws Exception {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/TelaPrincipal.fxml"));
            stage.setTitle("M.A.R.S");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initStyle(StageStyle.TRANSPARENT);
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    x = event.getSceneX();
                    y = event.getSceneY();
                }
            });
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);
                }
            });
            Scene scene = new Scene(root);
            scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
            Image applicationIcon = new Image(getClass().getResourceAsStream("/img/mars.png"));
            stage.getIcons().add(applicationIcon);
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
			System.out.println("Erro!" + e);
        }
    }

	public static void main(String[] args) {

		BancoDeRegistradores registradores = BancoDeRegistradores.getInstance();
		BlocoDeControle controle = BlocoDeControle.getInstance();
		MemoriaDeInstrucoes memoriaDeInstrucoes = MemoriaDeInstrucoes.getInstance();
		MemoriaDeDados memoriaDeDados = MemoriaDeDados.getInstance();
		LeitorDeArquivo leitorDeArquivo = new LeitorDeArquivo("/files/mipsTest2.mips");

		Executa executa = Executa.getInstance();

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

        launch(args);

	}
}
