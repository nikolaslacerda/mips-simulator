package model;

import javafx.beans.property.SimpleStringProperty;

public class TabelaRegistradores {

    private final SimpleStringProperty rowNome;
    private final SimpleStringProperty rowNumero;
    private final SimpleStringProperty rowValor;

    public TabelaRegistradores(String rowNome, String rowNumero, String rowValor) {
        this.rowNome = new SimpleStringProperty(rowNome);
        this.rowNumero = new SimpleStringProperty(rowNumero);
        this.rowValor = new SimpleStringProperty(rowValor);
    }

    public String getRowNome() {
        return rowNome.get();
    }

    public void setRowNome(String rowNome) {
        this.rowNome.set(rowNome);
    }

    public String getRowNumero() {
        return rowNumero.get();
    }

    public void setRowNumero(String rowNumero) {
        this.rowNumero.set(rowNumero);
    }

    public String getRowValor() {
        return rowValor.get();
    }

    public void setRowValor(String rowValor) {
        this.rowValor.set(rowValor);
    }
}
