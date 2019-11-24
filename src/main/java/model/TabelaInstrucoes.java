package model;

import javafx.beans.property.SimpleStringProperty;

public class TabelaInstrucoes {

    private final SimpleStringProperty rowEndereco;
    private final SimpleStringProperty rowCodigo;
    private final SimpleStringProperty rowInstrucao;

    public TabelaInstrucoes(String rowEndereco, String rowCodigo, String rowInstrucao) {
        this.rowEndereco = new SimpleStringProperty(rowEndereco);
        this.rowCodigo = new SimpleStringProperty(rowCodigo);
        this.rowInstrucao = new SimpleStringProperty(rowInstrucao);
    }

    public String getRowEndereco() {
        return rowEndereco.get();
    }

    public void setRowEndereco(String rowEndereco) {
        this.rowEndereco.set(rowEndereco);
    }

    public String getRowCodigo() {
        return rowCodigo.get();
    }

    public void setRowCodigo(String rowCodigo) {
        this.rowCodigo.set(rowCodigo);
    }

    public String getRowInstrucao(){
        return rowInstrucao.get();
    }

    public void setRowInstrucao(String rowInstrucao) {
        this.rowInstrucao.set(rowInstrucao);
    }
}
