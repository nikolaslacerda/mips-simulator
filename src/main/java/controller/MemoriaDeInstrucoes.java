package controller;

public class MemoriaDeInstrucoes {

    //Singleton
    private static MemoriaDeInstrucoes instance;

    //Array da memoria de instrucoes
    private String[] instrucoesEmBin;

    //Array da memoria de instrucoes
    private String[] instrucoesEmTxt;

    //Tamanho da memoria
    private static int SIZE = 100000;

    //Posicao do ultimo dado
    private int posAtual = 0;

    private int PC = 0;


    //Construtor
    private MemoriaDeInstrucoes() {
        instrucoesEmBin = new String[SIZE];
        instrucoesEmTxt = new String[SIZE];
    }

    //Singleton
    public static MemoriaDeInstrucoes getInstance() {
        if (instance == null)
            instance = new MemoriaDeInstrucoes();
        return instance;
    }

    //Adiciona uma instrução na memória
    public void addInstruction(String i, String instruction) {
        this.instrucoesEmTxt[posAtual] = i;
        this.instrucoesEmBin[posAtual] = instruction;
        posAtual++;
    }

    //Recupera uma instrução da memória
    public String getInstrucao() {
        return this.instrucoesEmBin[PC];
    }

    //Recupera uma instrução da memória
    public String getInstrucaoNome() { return this.instrucoesEmTxt[PC]; }

    //Posicao que esta a ulltima instrucao
    public int getPosAtual() {
        return this.posAtual;
    }

    public String[] getMemoria() {
        return instrucoesEmBin;
    }

    public String[] getInstrucoes() {
        return instrucoesEmTxt;
    }

    public void pc4(){
        PC++;
    }

    //Imprime
    public void imprime() {
        System.out.println("### Memoria de Instrucoes ###");
        for (int i = 0; i < posAtual; i++) {
            System.out.println(instrucoesEmBin[i]);
        }
    }
}
