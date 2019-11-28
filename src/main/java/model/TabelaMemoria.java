package model;

import javafx.beans.property.SimpleStringProperty;

public class TabelaMemoria {

    private final SimpleStringProperty rowEndereco;
    private final SimpleStringProperty rowValor;

    public TabelaMemoria(String rowEndereco, String rowValor) {
        this.rowEndereco = new SimpleStringProperty(rowEndereco);
        this.rowValor = new SimpleStringProperty(rowValor);
    }

    public String getRowEndereco() {
        return rowEndereco.get();
    }

    public void setRowEndereco(String rowEndereco) {
        this.rowEndereco.set(rowEndereco);
    }

    public String getRowValor() {
        return rowValor.get();
    }

    public void setRowValor(String rowValor) {
        this.rowValor.set(rowValor);
    }
}
