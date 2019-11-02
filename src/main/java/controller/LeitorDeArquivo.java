package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorDeArquivo {

    //Caminho do arquivo .mips
    private String caminho;

    //Memória de Instruções
    private MemoriaDeInstrucoes memoriaDeIntrucoes = MemoriaDeInstrucoes.getInstance();

    //Memória de Dados
    private MemoriaDeDados memoriaDeDados = MemoriaDeDados.getInstance();

    //Construtor
    public LeitorDeArquivo() {
        caminho = "/mipsTest.mips";
    }

    //Executa a leitura do arquivo armazenando os dados e as instruções na memória
    public void lePrograma() throws Exception {
        Scanner in = new Scanner(new File(LeitorDeArquivo.class.getResource("/mipsTest.mips").toURI()));
        String linhaAtual;
        while (in.hasNextLine()) {
            linhaAtual = in.nextLine();
            System.out.println(linhaAtual);

            if (linhaAtual.equals(".text")) {

                while (!linhaAtual.equals(".data")) {
                    linhaAtual = in.nextLine();
                    System.out.println(linhaAtual);
                    if(linhaAtual.split(" ").length == 1){
                        continue; //Ignora label
                    }
                    if (linhaAtual.length() == 0 || linhaAtual.equals(".globl main") || linhaAtual.charAt(0) == '#') {
                        continue; //Ignora linha em branco, comentário e o globl main
                    }

                    String instrucaoBin = codificaInstrucao(linhaAtual);
                    memoriaDeIntrucoes.addInstruction(instrucaoBin);
                }
            }
            if (linhaAtual.equals(".data")) {
                while (in.hasNextLine()) {
                    if (linhaAtual.length() == 0 || linhaAtual.charAt(0) == '#') {
                        continue; //Ignora linha em branco e comentário
                    }
                    linhaAtual = in.nextLine();
                    String label = linhaAtual.split(".word")[0];
                    String valor = linhaAtual.split(".word")[1];
                    memoriaDeDados.addDado(valor);
                }
            }
            break;
        }
    }

    //Converte uma instrução para sua representação binária
    public String codificaInstrucao(String instrucao) throws Exception {

        Registradores listaDeR = Registradores.getInstance();

        String instrucaoAtual = instrucao.split(" ")[0];
        String[] registradores = instrucao.split(" ")[1].split(",");

        if (instrucaoAtual.equals("lui")) {
            return "Tem que implementar";

        } else if (instrucaoAtual.equals("ori")) {
            return "Tem que implementar";

        } else if (instrucaoAtual.equals("addu")) {
            String opcode = "000000";
            String rs = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[1]));
            String rd = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[0]));
            String rt = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[2]));
            return opcode + to5Bits(rs) + to5Bits(rt) + to5Bits(rd) + "00000" + "010101";

        } else if (instrucaoAtual.equals("addiu")) {
            String opcode = "001001";
            String rs = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[1]));
            String rt = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[0]));
            String imm = Integer.toBinaryString(Integer.parseInt(registradores[2]));
            return opcode + to5Bits(rs) + to5Bits(rt) + to16Bits(imm);

        } else if (instrucaoAtual.equals("lw")) {
            return "Tem que implementar";

        } else if (instrucaoAtual.equals("sw")) {
            return "Tem que implementar";

        } else if (instrucaoAtual.equals("beq")) {
            String opcode = "000100";
            String rs = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[0]));
            String rt = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[1]));
            String offset = getOffset(registradores[2]);
            return opcode + to5Bits(rs) + to5Bits(rt) + to16Bits(offset);

        } else if (instrucaoAtual.equals("j")) {
            String opcode = "000010";
            String target = getTarget(registradores[0]);
            return opcode + to26Bits(target);

        } else if (instrucaoAtual.equals("and")) {
            return "Tem que implementar";

        } else if (instrucaoAtual.equals("sll")) {
            return "Tem que implementar";

        } else if (instrucaoAtual.equals("srl")) {
            return "Tem que implementar";

        } else {
            throw new Exception("Instrução Inválida!");
        }
    }

    //Converte um binário para 5 bits
    public String to5Bits(String bin) throws Exception {
        if (bin.length() < 5) {
            int zerosFaltantes = 5 - bin.length();
            String resultado = "";
            for (int i = 0; i < zerosFaltantes; i++) {
                resultado += "0";
            }
            return resultado + bin;
        } else if (bin.length() == 5) {
            return bin;
        } else {
            throw new Exception("Registrador maior que 31????");
        }
    }

    //Converte um binário para 16 bits
    public String to16Bits(String bin) throws Exception {
        if (bin.length() < 16) {
            int zerosFaltantes = 16 - bin.length();
            String resultado = "";
            for (int i = 0; i < zerosFaltantes; i++) {
                resultado += "0";
            }
            return resultado + bin;
        } else if (bin.length() == 16) {
            return bin;
        } else {
            throw new Exception("Overflow");
        }
    }

    //Converte um binário para 16 bits
    public String to26Bits(String bin) throws Exception {
        if (bin.length() < 26) {
            int zerosFaltantes = 26 - bin.length();
            String resultado = "";
            for (int i = 0; i < zerosFaltantes; i++) {
                resultado += "0";
            }
            return resultado + bin;
        } else if (bin.length() == 26) {
            return bin;
        } else {
            throw new Exception("Overflow");
        }
    }

    //Retorna o número de linhas da label para a instrução j
    public String getTarget(String label) throws FileNotFoundException {
        int contador = 0;
        Scanner in2 = new Scanner(new File(caminho));
        String linhaAtual;
        while (in2.hasNextLine()) {
            linhaAtual = in2.nextLine();
            if (linhaAtual.equals(".text")) {
                while (!linhaAtual.equals(".data")) {
                    if (linhaAtual.length() == 0 || linhaAtual.equals(".globl main") || linhaAtual.charAt(0) == '#') {
                        continue; //Ignora linha em branco, comentário e o globl main
                    }
                    if(linhaAtual.equals(label + ":")){
                        return Integer.toBinaryString(contador);
                    }
                    linhaAtual = in2.nextLine();
                    String[] aux = linhaAtual.split(" ");
                    if(aux.length > 1){
                        contador++;
                    }
                }
            }
        }
        return Integer.toBinaryString(contador);
    }

    //Retorna o número de linhas da label para a instrução beq
    public String getOffset(String label) {
        return "Tem que implementar";
    }
}
