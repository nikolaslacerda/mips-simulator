package controller;

import java.util.HashMap;

public class MemoriaDeDados {

    ConversorDeBits converte = new ConversorDeBits();
    //Singleton
    private static MemoriaDeDados instance;

    //Array da memoria de dados
    private String[] memoria;

    //referencia
    private HashMap<String, Integer> referencia;

    //Proxima posicao livre
    private int posicaoAtual;

    //Tamanho da memoria
    private static int SIZE = 10000;

    //Construtor
    private MemoriaDeDados() {
        this.posicaoAtual = 0;
        this.memoria = new String[SIZE];
        this.referencia = new HashMap<>();
    }

    //Singleton
    public static MemoriaDeDados getInstance() {
        if (instance == null)
            instance = new MemoriaDeDados();
        return instance;
    }

    //Recupera um dado da memoria dada uma posicao
    public String readData(int pos) throws Exception {
        System.out.println(memoria);
        //pos = (pos / 4); // Como a memoria do mips e de 4 em 4 temos que dividir por 4 para obter o valor equivalente no nosso array de 1 em 1
        if (this.memoria[pos] == null) { // Endereco de memoria vazio, logo retorna 0 em 32 bits
            return "00000000000000000000000000000000";
        }
        return converte.to32Bits(Integer.toBinaryString(Integer.parseInt(this.memoria[pos])));
    }

    //Adiciona um dado na memoria
    public void writeDado(String label, String dado) {
        String[] dados = dado.replace(" ", "").split(",");
        referencia.put(label, posicaoAtual);
        if (dados.length > 1) {
            for (int i = 0; i < dados.length; i++) {
                this.memoria[posicaoAtual] = dados[i];
                posicaoAtual++;
            }
        } else {
            this.memoria[posicaoAtual] = dado.replace(" ", "");
            posicaoAtual++;
        }

        while (memoria[posicaoAtual] != null) { //Busca a proxima posicao de memoria livre
            posicaoAtual++;
        }

        System.out.println(referencia);
    }

    //Adiciona um dado na memoria dada uma posicao
    public void writeDado(String dado, int pos) {
        if (pos > SIZE) {
            throw new ArrayIndexOutOfBoundsException("Overflow de memoria");
        }
        this.memoria[pos] = Integer.toString(Integer.parseInt(dado, 2)); //Se tiver um dado sera sobreescrito
    }

    //Retorna memoria
    public String[] getMemoria() {
        return this.memoria;
    }

    //Imprime
    public void imprime() {
        System.out.println("### Memoria de Dados ###");
        for (int i = 0; i < SIZE; i++) {
            if (memoria[i] != null) {
                System.out.println(i + " = " + memoria[i]);
            } else {
                System.out.println(i + " = " + "00000000000000000000000000000000");
            }
        }
    }


}
