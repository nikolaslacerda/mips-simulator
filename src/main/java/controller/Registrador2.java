package controller;

public class Registrador2 {
    private String nome;
    private int id;
    private int valor;

    public Registrador2(String nome, int id, int val) {
        this.nome = nome;
        this.id = id;
        this.valor = val;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
