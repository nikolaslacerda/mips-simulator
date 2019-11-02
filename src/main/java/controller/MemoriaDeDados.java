package controller;

public class MemoriaDeDados {

    //Singleton
    private static MemoriaDeDados instance;

    //Array da memoria de dados
    private String[] memoria;

    //Tamanho da memoria
    private static int SIZE = 100000;

    //Posicao do ultimo dado
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

    //Adiciona um dado na memoria
    public void addDado(String dado){
        this.memoria[posAtual] = dado;
        posAtual++;
    }

    //Recupera um dado da memoria
    public String getDado(int pos){
        return this.memoria[pos];
    }

    //Posicao que esta o ultimo dado
    public int getPosAtual(){
        return this.posAtual;
    }

}
