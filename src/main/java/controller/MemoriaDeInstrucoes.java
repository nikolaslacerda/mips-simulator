package controller;

public class MemoriaDeInstrucoes {

    //Singleton
    private static MemoriaDeInstrucoes instance;

    //Array da memória de instruções
    private String[] memoria;

    //Tamanho da memória
    private static int SIZE = 100000;

    //Posição do último dado
    private int posAtual = 0;

    //Construtor
    private MemoriaDeInstrucoes() {
        memoria = new String[SIZE];
    }

    //Singleton
    public static MemoriaDeInstrucoes getInstance() {
        if (instance == null)
            instance = new MemoriaDeInstrucoes();
        return instance;
    }

    //Adiciona uma instrução na memória
    public void addInstruction(String instruction){
        this.memoria[posAtual] = instruction;
        posAtual++;
    }

    //Recupera uma instrução da memória
    public String getInstrucao(int pos){
        return this.memoria[pos];
    }

    //Posição que está a última instrução
    public int getPosAtual(){
        return this.posAtual;
    }
}
