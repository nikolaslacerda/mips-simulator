package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
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
        styleRowColor();

    }

    private void styleRowColor() {
        Callback<TableColumn<TabelaInstrucoes, String>, TableCell<TabelaInstrucoes, String>> cellFactory
                = //
                new Callback<TableColumn<TabelaInstrucoes, String>, TableCell<TabelaInstrucoes, String>>() {
                    @Override
                    public TableCell<TabelaInstrucoes, String> call(final TableColumn<TabelaInstrucoes, String> param) {
                        final TableCell<TabelaInstrucoes, String> cell = new TableCell<TabelaInstrucoes, String>() {

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    setText(item);
                                    TableRow<TabelaInstrucoes> row = getTableRow();
                                    if (row.getItem().getRowEndereco().equals("0")) {
                                        System.out.println("corrrrrrrrr");
                                        row.getStyleClass().clear();
                                        row.getStyleClass().add("red-row");
                                    }
                                }
                            }
                        };
                        return cell;
                    }
                };
        TabInstColEndereco.setCellFactory(cellFactory);

    }
}
