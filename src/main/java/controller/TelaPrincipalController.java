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
import model.TabelaMemoria;
import model.TabelaControle;
import model.TabelaBarramentos;

import java.net.URL;
import java.util.Comparator;
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

    //Tabela de Memória
    @FXML
    TableView<TabelaMemoria> TabelaMemoria;
    @FXML
    TableColumn<TabelaMemoria, String> TabMemColEndereco;
    @FXML
    TableColumn<TabelaMemoria, String> TabMemColValor;

    //Tabela de Sinais De Controle
    @FXML
    TableView<TabelaControle> TabelaControle;
    @FXML
    TableColumn<TabelaControle, String> TabConColNome;
    @FXML
    TableColumn<TabelaControle, String> TabConColSinal;

    //Tabela Barramentos
    @FXML
    TableView<TabelaBarramentos> TabelaBarramentos;
    @FXML
    TableColumn<TabelaBarramentos, String> TabBarramentosNome;
    @FXML
    TableColumn<TabelaBarramentos, String> TabBarramentosValor;

    //Botoes

    @FXML
    private Button btn_next;

    @FXML
    private Button btn_close;

    Executa executa = Executa.getInstance();

    public ObservableList<TabelaRegistradores> data = FXCollections.observableArrayList();
    public ObservableList<TabelaInstrucoes> data2 = FXCollections.observableArrayList();
    public ObservableList<TabelaMemoria> data3 = FXCollections.observableArrayList();
    public ObservableList<TabelaControle> data4 = FXCollections.observableArrayList();
    public ObservableList<TabelaBarramentos> data5 = FXCollections.observableArrayList();

    ConversorDeBits converte = new ConversorDeBits();
    CustomComparator customComparator = new CustomComparator();
    MemoriaDeInstrucoes memoriaDeInstrucoes = MemoriaDeInstrucoes.getInstance();
    MemoriaDeDados memoriaDeDados = MemoriaDeDados.getInstance();
    BancoDeRegistradores bancoDeRegistradores = BancoDeRegistradores.getInstance();
    BlocoDeControle blocoDeControle = BlocoDeControle.getInstance();
    HashMap<String, String> listaDeRegistradores = bancoDeRegistradores.getListaDeRegistradores();
    HashMap<String, Integer> listaDeRegistradoresNumeros = bancoDeRegistradores.getListaDeRegistradoresNumeros();
    HashMap<String, Integer> sinaisDeControle = blocoDeControle.getSinaisDeControle();
    Barramentos barramento = Barramentos.getInstance();


    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            TabRegColNome.setCellValueFactory(new PropertyValueFactory<TabelaRegistradores, String>("rowNome"));
            TabRegColNumero.setCellValueFactory(new PropertyValueFactory<TabelaRegistradores, String>("rowNumero"));
            TabRegColValor.setCellValueFactory(new PropertyValueFactory<TabelaRegistradores, String>("rowValor"));

            TabInstColEndereco.setCellValueFactory(new PropertyValueFactory<TabelaInstrucoes, String>("rowEndereco"));
            TabInstColCodigo.setCellValueFactory(new PropertyValueFactory<TabelaInstrucoes, String>("rowCodigo"));
            TabInstColInstrucao.setCellValueFactory(new PropertyValueFactory<TabelaInstrucoes, String>("rowInstrucao"));

            TabMemColEndereco.setCellValueFactory(new PropertyValueFactory<TabelaMemoria, String>("rowEndereco"));
            TabMemColValor.setCellValueFactory(new PropertyValueFactory<TabelaMemoria, String>("rowValor"));

            TabConColNome.setCellValueFactory(new PropertyValueFactory<TabelaControle, String>("rowNome"));
            TabConColSinal.setCellValueFactory(new PropertyValueFactory<TabelaControle, String>("rowSinal"));

            TabBarramentosNome.setCellValueFactory(new PropertyValueFactory<TabelaBarramentos, String>("rowNome"));
            TabBarramentosValor.setCellValueFactory(new PropertyValueFactory<TabelaBarramentos, String>("rowValor"));

            //MemoriaDeInstrucoes memoriaDeInstrucoes = MemoriaDeInstrucoes.getInstance();
            String[] memoriaI = memoriaDeInstrucoes.getMemoria();
            String[] instrucoesI = memoriaDeInstrucoes.getInstrucoes();
            String[] memoriaD = memoriaDeDados.getMemoria();
            String[] barramentos = barramento.getBarramentos();

            for (int i = 0; i < memoriaDeInstrucoes.getPosAtual(); i++) {
                this.data2.add(new TabelaInstrucoes("0x" + converte.to32BitsH(Integer.toHexString(4194304 + i*4)), memoriaI[i], instrucoesI[i]));
            }

            for (Map.Entry<String, String> registrador : listaDeRegistradores.entrySet()) {
                this.data.add(new TabelaRegistradores(registrador.getKey(), String.valueOf(listaDeRegistradoresNumeros.get(registrador.getKey())), "0x" + converte.to32BitsH(converte.binToHex(registrador.getValue()))));
            }

            for (int i = 0; i < memoriaD.length; i++) {
                this.data3.add(new TabelaMemoria("0x" + Integer.toString(10010000+i*4), memoriaD[i]));
            }

            for (Map.Entry<String, Integer> sinal : sinaisDeControle.entrySet()) {
                this.data4.add(new TabelaControle(sinal.getKey(), Integer.toString(sinal.getValue())));
            }

            for (int i = 0; i < barramentos.length; i++) {
                String s[]=barramentos[i].split(" ");
                this.data5.add(new TabelaBarramentos(s[0],Integer.toString(Integer.parseInt(s[1],2))));
            }

            TabelaRegistradores.setItems(data);
            TabelaInstrucao.setItems(data2);
            TabelaMemoria.setItems(data3);
            TabelaControle.setItems(data4);
            TabelaBarramentos.setItems(data5);

            TabRegColNumero.setComparator(customComparator);
            TabelaRegistradores.getSortOrder().add(TabRegColNumero);
            TabelaControle.getSortOrder().add(TabConColNome);


            styleRowColor();

        } catch (Exception e) {
        }

    }

    private void styleRowColor() {
        try {
            Callback<TableColumn<TabelaInstrucoes, String>, TableCell<TabelaInstrucoes, String>> cellFactory
                    = //
                    new Callback<TableColumn<TabelaInstrucoes, String>, TableCell<TabelaInstrucoes, String>>() {
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
                                        if (row.getItem().getRowInstrucao() != null) {
                                            if (row.getItem().getRowInstrucao().equals(memoriaDeInstrucoes.getInstrucaoNome())) {
                                                row.getStyleClass().clear();
                                                row.setStyle("-fx-background-color: palegreen");
                                            }
                                        }
                                    }
                                }
                            };
                            return cell;
                        }
                    };
            TabInstColInstrucao.setCellFactory(cellFactory);
        } catch (Exception e) {
            System.out.println("Sdasdasd" + e);
        }
    }

    public void next() {
        try {


            executa.ExecutaPrograma();
            atualizaControle();

            Callback<TableColumn<TabelaInstrucoes, String>, TableCell<TabelaInstrucoes, String>> cellFactory
                    = //
                    new Callback<TableColumn<TabelaInstrucoes, String>, TableCell<TabelaInstrucoes, String>>() {
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
                                        if (row.getItem().getRowInstrucao().equals(memoriaDeInstrucoes.getInstrucaoNome())) {
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
            atualizaMemoria();
            atualizaBarramentos();

        } catch (Exception e) {
        }
    }

    public void atualizaRegistradores() {
        try {
            TabelaRegistradores.getItems().clear();

            for (Map.Entry<String, String> registrador : listaDeRegistradores.entrySet()) {
                this.data.add(new TabelaRegistradores(registrador.getKey(), String.valueOf(listaDeRegistradoresNumeros.get(registrador.getKey())), "0x" + converte.to32BitsH(converte.binToHex(registrador.getValue()))));
            }
            TabelaRegistradores.setItems(data);
            TabRegColNumero.setComparator(customComparator);
            TabelaRegistradores.getSortOrder().add(TabRegColNumero);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void atualizaMemoria() {
        try {
            TabelaMemoria.getItems().clear();
            String[] memoriaD = memoriaDeDados.getMemoria();
            for (int i = 0; i < memoriaD.length; i++) {
                this.data3.add(new TabelaMemoria("0x" + Integer.toString(10010000+i*4), memoriaD[i]));
            }

            TabelaMemoria.setItems(data3);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void atualizaControle() {
        try {
            HashMap<String, Integer> sinaisDeControle = blocoDeControle.getSinaisDeControle();

            TabelaControle.getItems().clear();

            for (Map.Entry<String, Integer> sinal : sinaisDeControle.entrySet()) {
                this.data4.add(new TabelaControle(sinal.getKey(), Integer.toString(sinal.getValue())));
            }

            TabelaControle.setItems(data4);
            TabelaControle.getSortOrder().add(TabConColNome);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void atualizaBarramentos() {
        try {
            TabelaBarramentos.getItems().clear();
            String[] barramentos=barramento.getBarramentos();
            for (int i = 0; i < barramentos.length; i++) {
                String s[]=barramentos[i].split(" ");
                this.data5.add(new TabelaBarramentos(s[0],Integer.toString(Integer.parseInt(s[1],2))));
            }
            TabelaBarramentos.setItems(data5);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void exit() {
        System.exit(0);
    }
}
