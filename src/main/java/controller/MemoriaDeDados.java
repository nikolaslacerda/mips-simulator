package controller;

public class MemoriaDeDados {

    //Singleton
    private static MemoriaDeDados instance;

    //Array da memoria de dados
    private String[] memoria;

    //Tamanho da memoria
    private static int SIZE = 100000;

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

    //Recupera um dado da memoria dada uma posicao
    public String readDado(int pos){
        pos = (pos / 4); // Como a memoria do mips e de 4 em 4 temos que dividir por 4 para obter o valor equivalente no nosso array de 1 em 1
        if(this.memoria[pos] == null){ // Endereco de memoria vazio, logo retorna 0 em 32 bits
            return "00000000000000000000000000000000";
        }
        return this.memoria[pos];
    }

    //Adiciona um dado na memoria dada uma posicao
    public void writeDado(String dado, int pos){
        pos = (pos / 4);
        if(pos > SIZE){
            throw new ArrayIndexOutOfBoundsException("Overflow de memoria");
        }
        this.memoria[pos] = dado;
    }

    //Imprime
    public void imprime(){
        System.out.println("### Memoria de Dados ###");
        for (int i = 0; i < SIZE; i++) {
            if(memoria[i] != null) {
                System.out.println(i + " = " + memoria[i]);
            }else {
                System.out.println(i + " = " + "00000000000000000000000000000000");
            }
        }
    }
}
