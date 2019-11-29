package model;

import javafx.beans.property.SimpleStringProperty;

public class TabelaControle {

    private final SimpleStringProperty rowNome;
    private final SimpleStringProperty rowSinal;

    public TabelaControle(String rowNome, String rowSinal) {
        this.rowNome = new SimpleStringProperty(rowNome);
        this.rowSinal = new SimpleStringProperty(rowSinal);

    }

    public String getRowNome() {
        return rowNome.get();
    }

    public void setRowNome(String rowEndereco) {
        this.rowNome.set(rowEndereco);
    }

    public String getRowSinal() {
        return rowSinal.get();
    }

    public void setRowSinal(String rowCodigo) {
        this.rowSinal.set(rowCodigo);
    }

}
