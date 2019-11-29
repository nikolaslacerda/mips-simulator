package model;

import javafx.beans.property.SimpleStringProperty;

public class TabelaBarramentos {

    private final SimpleStringProperty rowNome;
    private final SimpleStringProperty rowValor;

    public TabelaBarramentos(String rowNome, String rowValor) {
        this.rowNome = new SimpleStringProperty(rowNome);
        this.rowValor = new SimpleStringProperty(rowValor);
    }

    public String getRowNome() {
        return rowNome.get();
    }

    public String getRowValor() {
        return rowValor.get();
    }

}