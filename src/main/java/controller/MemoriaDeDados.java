package controller;

public class MemoriaDeDados {

    //Singleton
    private static MemoriaDeDados instance;

    //Array da memória de dados
    private String[] memoria;

    //Tamanho da memória
    private static int SIZE = 100000;

    //Posição do último dado
    private int posAtual = 0;

    //Construtor
    private MemoriaDeDados() {
        memoria = new String[SIZE];
    }

    //Singleton
    public static MemoriaDeDados getInstance() {
        if (instance == null)
            instance = new MemoriaDeDados();
        return instance;
    }

    //Adiciona um dado na memória
    public void addDado(String dado){
        this.memoria[posAtual] = dado;
        posAtual++;
    }

    //Recupera um dado da memória
    public String getDado(int pos){
        return this.memoria[pos];
    }

    //Posição que está o último dado
    public int getPosAtual(){
        return this.posAtual;
    }

}
