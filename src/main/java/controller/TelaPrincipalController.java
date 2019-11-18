package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

    //Botoes

    @FXML
    private Button btn_next;

    @FXML
    private Button btn_close;

    Executa executa = Executa.getInstance();

    public ObservableList<TabelaRegistradores> data = FXCollections.observableArrayList();
    public ObservableList<TabelaInstrucoes> data2 = FXCollections.observableArrayList();
    ConversorDeBits converte = new ConversorDeBits();
    CustomComparator customComparator = new CustomComparator();
    BancoDeRegistradores bancoDeRegistradores = BancoDeRegistradores.getInstance();
    HashMap<String, String> listaDeRegistradores = bancoDeRegistradores.getListaDeRegistradores();
    HashMap<String, Integer> listaDeRegistradoresNumeros = bancoDeRegistradores.getListaDeRegistradoresNumeros();



    public void initialize(URL url, ResourceBundle resourceBundle) {

        TabRegColNome.setCellValueFactory(new PropertyValueFactory<TabelaRegistradores, String>("rowNome"));
        TabRegColNumero.setCellValueFactory(new PropertyValueFactory<TabelaRegistradores, String>("rowNumero"));
        TabRegColValor.setCellValueFactory(new PropertyValueFactory<TabelaRegistradores, String>("rowValor"));

        TabInstColEndereco.setCellValueFactory(new PropertyValueFactory<TabelaInstrucoes, String>("rowEndereco"));
        TabInstColCodigo.setCellValueFactory(new PropertyValueFactory<TabelaInstrucoes, String>("rowCodigo"));
        TabInstColInstrucao.setCellValueFactory(new PropertyValueFactory<TabelaInstrucoes, String>("rowInstrucao"));

        MemoriaDeInstrucoes memoriaDeInstrucoes = MemoriaDeInstrucoes.getInstance();
        String[] memoriaI = memoriaDeInstrucoes.getMemoria();
        String[] instrucoesI = memoriaDeInstrucoes.getInstrucoes();

        for (int i = 0; i < memoriaDeInstrucoes.getPosAtual(); i++) {
            this.data2.add(new TabelaInstrucoes("0", memoriaI[i], instrucoesI[i]));
        }

        for(Map.Entry<String, String> registrador: listaDeRegistradores.entrySet()) {
            this.data.add(new TabelaRegistradores(registrador.getKey(), String.valueOf(listaDeRegistradoresNumeros.get(registrador.getKey())), converte.binToHex(registrador.getValue())));
        }

        TabelaRegistradores.setItems(data);
        TabelaInstrucao.setItems(data2);

        TabRegColNumero.setComparator(customComparator);
        TabelaRegistradores.getSortOrder().add(TabRegColNumero);

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
                                    if (row.getItem().getRowInstrucao().equals("addu $t0,$t1,$t2")) {
                                        row.getStyleClass().clear();
                                        row.setStyle("-fx-background-color: palegreen");
                                    }
                                }
                            }
                        };
                        return cell;
                    }
                };
        TabInstColInstrucao.setCellFactory(cellFactory);

    }

    public  void next() throws Exception {

        executa.ExecutaPrograma();

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
                                    if (row.getItem().getRowInstrucao().equals("addu $t3,$t0,$t2")) {
                                        row.getStyleClass().clear();
                                        row.setStyle("-fx-background-color: palegreen");
                                    }
                                }
                            }
                        };
                        return cell;
                    }
                };
        TabInstColInstrucao.setCellFactory(cellFactory);
        atualizaRegistradores();
    }

    public void atualizaRegistradores(){


        System.out.println("Entrou aqui");
        TabelaRegistradores.getItems().clear();

        for(Map.Entry<String, String> registrador: listaDeRegistradores.entrySet()) {
            this.data.add(new TabelaRegistradores(registrador.getKey(), String.valueOf(listaDeRegistradoresNumeros.get(registrador.getKey())), converte.binToHex(registrador.getValue())));
        }

        TabelaRegistradores.setItems(data);
        TabRegColNumero.setComparator(customComparator);
        TabelaRegistradores.getSortOrder().add(TabRegColNumero);

    }

    public void exit(){
        System.exit(0);
    }
}
