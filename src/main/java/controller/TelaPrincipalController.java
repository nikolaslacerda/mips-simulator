package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.TabelaInstrucoes;
import model.TabelaRegistradores;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class TelaPrincipalController implements Initializable {

    //Tabela Registradores
    @FXML
    TableView<TabelaRegistradores> TabelaRegistradores;
    @FXML
    TableColumn<TabelaRegistradores, String> TabRegColNome;
    @FXML
    TableColumn<TabelaRegistradores, String> TabRegColNumero;
    @FXML
    TableColumn<TabelaRegistradores, String> TabRegColValor;

    //Tabela Instrucoes
    @FXML
    TableView<TabelaInstrucoes> TabelaInstrucao;
    @FXML
    TableColumn<TabelaInstrucoes, String> TabInstColEndereco;
    @FXML
    TableColumn<TabelaInstrucoes, String> TabInstColCodigo;
    @FXML
    TableColumn<TabelaInstrucoes, String> TabInstColInstrucao;


    public ObservableList<TabelaRegistradores> data = FXCollections.observableArrayList();
    public ObservableList<TabelaInstrucoes> data2 = FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle resourceBundle) {

        TabRegColNome.setCellValueFactory(new PropertyValueFactory<TabelaRegistradores, String>("rowNome"));
        TabRegColNumero.setCellValueFactory(new PropertyValueFactory<TabelaRegistradores, String>("rowNumero"));
        TabRegColValor.setCellValueFactory(new PropertyValueFactory<TabelaRegistradores, String>("rowValor"));

        TabInstColEndereco.setCellValueFactory(new PropertyValueFactory<TabelaInstrucoes, String>("rowEndereco"));
        TabInstColCodigo.setCellValueFactory(new PropertyValueFactory<TabelaInstrucoes, String>("rowCodigo"));
        TabInstColInstrucao.setCellValueFactory(new PropertyValueFactory<TabelaInstrucoes, String>("rowInstrucao"));

        ConversorDeBits converte = new ConversorDeBits();

        BancoDeRegistradores bancoDeRegistradores = BancoDeRegistradores.getInstance();
        HashMap<String, String> listaDeRegistradores = bancoDeRegistradores.getListaDeRegistradores();
        HashMap<String, Integer> listaDeRegistradoresNumeros = bancoDeRegistradores.getListaDeRegistradoresNumeros();

        MemoriaDeInstrucoes memoriaDeInstrucoes = MemoriaDeInstrucoes.getInstance();
        String[] memoriaI = memoriaDeInstrucoes.getMemoria();
        String[] instrucoesI = memoriaDeInstrucoes.getInstrucoes();

        for(Map.Entry<String, String> registrador: listaDeRegistradores.entrySet()) {
            this.data.add(new TabelaRegistradores(registrador.getKey(), String.valueOf(listaDeRegistradoresNumeros.get(registrador.getKey())), converte.binToHex(registrador.getValue())));
        }

        for (int i = 0; i < memoriaDeInstrucoes.getPosAtual(); i++) {
            this.data2.add(new TabelaInstrucoes("0", memoriaI[i], instrucoesI[i]));
        }

        TabelaRegistradores.setItems(data);
        TabelaInstrucao.setItems(data2);
    }
}
