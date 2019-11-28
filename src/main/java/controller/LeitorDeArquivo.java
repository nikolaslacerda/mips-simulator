package controller;

import java.io.File;
import java.util.Scanner;

public class LeitorDeArquivo {

    //Caminho do arquivo .mips
    private String caminho;

    //Memoria de Instrucoes
    private MemoriaDeInstrucoes memoriaDeIntrucoes = MemoriaDeInstrucoes.getInstance();

    //Memoria de Dados
    private MemoriaDeDados memoriaDeDados = MemoriaDeDados.getInstance();

    //Construtor
    public LeitorDeArquivo(String c) {
        caminho = c;
    }

    //Executa a leitura do arquivo armazenando os dados e as instrucoes na memoria
    public void lePrograma() throws Exception {
        Scanner in = new Scanner(new File(LeitorDeArquivo.class.getResource(caminho).toURI()));
        String linhaAtual;
        while (in.hasNextLine()) {
            linhaAtual = in.nextLine();
            //Busca a area de dados
            while (!linhaAtual.equals(".data")) {
                linhaAtual = in.nextLine();
            }
            //Adiciona os dados na memoria
            if (linhaAtual.equals(".data")) {
                while (in.hasNextLine()) {
                    if (linhaAtual.length() == 0 || linhaAtual.charAt(0) == '#') {
                        continue; //Ignora linha em branco e comentÃ¡rio
                    }
                    linhaAtual = in.nextLine();
                    //System.out.println(linhaAtual);
                    String label = linhaAtual.split(".word")[0];

                    String valor = linhaAtual.split(".word")[1];

                    memoriaDeDados.writeDado(label, valor);
                }
            }
        }
        in.close();
        in = new Scanner(new File(LeitorDeArquivo.class.getResource(caminho).toURI()));
        String linhaAtual2;
        //Le instrucoes
        while (in.hasNextLine()) {
            linhaAtual = in.nextLine();
            if (linhaAtual.equals(".text")) {
                linhaAtual = in.nextLine();
                while (!linhaAtual.equals(".data")) {
                    linhaAtual = in.nextLine();
                    if (linhaAtual.split(" ").length == 1) {
                        continue; //Ignora label
                    }
                    if (linhaAtual.length() == 0 || linhaAtual.equals(".globl main") || linhaAtual.charAt(0) == '#') {
                        continue; //Ignora linha em branco, comentario e o globl main
                    }
                    System.out.println(linhaAtual);
                    String instrucaoBin = codificaInstrucao(linhaAtual);
                    memoriaDeIntrucoes.addInstruction(linhaAtual, instrucaoBin);
                }
            }
            break;
        }
        in.close();
    }

    //Converte uma instrucao para sua representacao binaria
    public String codificaInstrucao(String instrucao) throws Exception {

        ConversorDeBits converte = new ConversorDeBits();
        BancoDeRegistradores listaDeR = BancoDeRegistradores.getInstance();

        String instrucaoAtual = instrucao.split(" ")[0];
        String[] registradores = instrucao.split(" ")[1].split(",");

        if (instrucaoAtual.equals("lui")) { //lui rt, imm
        	String opcode = "001111";
	    	String rt = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[0]));
	        String imm = Integer.toBinaryString(Integer.parseInt(registradores[1]));
	        return opcode + "00000" + converte.to5Bits(rt) + converte.to16Bits(imm);

        } else if (instrucaoAtual.equals("ori")) { //ori rt, rs, imm
        	String opcode = "00‭1101‬"; // Da um erro inexplicavel
	    	String rt = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[0]));
	        String rs = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[1]));
	        String imm = Integer.toBinaryString(Integer.parseInt(registradores[2]));
	        return "001101" + converte.to5Bits(rs) + converte.to5Bits(rt) + converte.to16Bits(imm);

        } else if (instrucaoAtual.equals("addu")) {
            String opcode = "000000";
            String rs = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[1]));
            String rd = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[0]));
            String rt = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[2]));
            return opcode + converte.to5Bits(rs) + converte.to5Bits(rt) + converte.to5Bits(rd) + "00000" + "100001";

        } else if (instrucaoAtual.equals("addiu")) {
            String opcode = "001001";
            String rs = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[1]));
            String rt = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[0]));
            String imm = Integer.toBinaryString(Integer.parseInt(registradores[2]));
            return opcode + converte.to5Bits(rs) + converte.to5Bits(rt) + converte.to16Bits(imm);

        } else if (instrucaoAtual.equals("lw")) {
            String opcode = "100011";
            String rs = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[1].split("\\(")[1].replace(")", "")));
            String offset = registradores[1].split("\\(")[0];
            String rt = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[0]));
            return opcode + converte.to5Bits(rs) + converte.to5Bits(rt) + converte.to16Bits(offset);

        } else if (instrucaoAtual.equals("sw")) {
            String opcode = "101011";
            String rs = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[1].split("\\(")[1].replace(")", "")));
            String offset = registradores[1].split("\\(")[0];
            String rt = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[0]));
            return opcode + converte.to5Bits(rs) + converte.to5Bits(rt) + converte.to16Bits(offset);

        } else if (instrucaoAtual.equals("beq")) {
            String opcode = "000100";
            String rs = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[0]));
            String rt = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[1]));
            String offset = getOffset(instrucao, registradores[2]);
            //System.out.println(offset);
            return opcode + converte.to5Bits(rs) + converte.to5Bits(rt) + converte.to16Bits(offset);

        } else if (instrucaoAtual.equals("j")) {
            String opcode = "000010";
            String target = getTarget(registradores[0]);
            return opcode + converte.to26Bits(target);

        } else if (instrucaoAtual.equals("and")) {
            String opcode = "000000";
            String rs = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[1]));
            String rd = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[0]));
            String rt = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[2]));
            return opcode + converte.to5Bits(rs) + converte.to5Bits(rt) + converte.to5Bits(rd) + "00000" + "100100";

        } else if (instrucaoAtual.equals("sll")) {
            String opcode = "000000";
            String rt = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[1]));
            String rd = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[0]));
            String shamt = Integer.toBinaryString(Integer.parseInt(registradores[2]));
            return opcode + "00000" + converte.to5Bits(rt) + converte.to5Bits(rd) + converte.to5Bits(shamt) + "000000";

        } else if (instrucaoAtual.equals("srl")) {
            String opcode = "000000";
            String rt = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[1]));
            String rd = Integer.toBinaryString(listaDeR.getRegisterNumber(registradores[0]));
            String shamt = Integer.toBinaryString(Integer.parseInt(registradores[2]));
            return opcode + "00000" + converte.to5Bits(rt) + converte.to5Bits(rd) + converte.to5Bits(shamt) + "000010";

        } else {
            System.out.println(instrucaoAtual);
            throw new Exception("LeitorDeArquivo>CodificaInstrucao>Instrucao Invalida!");
        }
    }

    //Retorna o numero de linhas da label para a instrucao j
    public String getTarget(String label) throws Exception {
        ConversorDeBits converte = new ConversorDeBits();
        int inicioDaMemoria = 0;
        int labelNum = getNumeroDaLinha(label + ":");
        //System.out.println(label);
        //System.out.println(labelNum);
        int enderecoDeSalto = inicioDaMemoria + labelNum;
        System.out.println("Endereço de salto: "+enderecoDeSalto);
        //System.out.println(enderecoDeSalto);
        //String enderecoEmHexa = "00" + Integer.toHexString(enderecoDeSalto);
        String enderecoEmHexa = Integer.toHexString(enderecoDeSalto);
        System.out.println(enderecoEmHexa);
        String enderecoEmBin = converte.to32Bits(converte.hexaToBin(enderecoEmHexa));
        System.out.println(enderecoEmBin);
        return enderecoEmBin.substring(4, enderecoEmBin.length() - 2); //Retira 4 bits mais significativos e 2 bits menos significativos
    }

    //Retorna o numero de linhas da label para a instrucao beq
    public String getOffset(String instrucao, String label) throws Exception {
        return Integer.toBinaryString(getNumeroDaLinha(label + ":") - getNumeroDaLinha(instrucao));
    }

    public int getNumeroDaLinha(String linha) throws Exception {
        int linhaNum = 0;
        Scanner in = new Scanner(new File(LeitorDeArquivo.class.getResource(caminho).toURI()));
        String linhaAtual;
        while (in.hasNextLine()) {
            linhaAtual = in.nextLine();
            if (linhaAtual.equals(".text")) {
                while (!linhaAtual.equals(".data")) {
                    linhaAtual = in.nextLine();
                    if (linhaAtual.length() == 0 || linhaAtual.equals(".globl main") || linhaAtual.charAt(0) == '#') {
                        continue; //Ignora linha em branco, comentario e o globl main
                    }
                    if (linhaAtual.equals(linha)) {
                        return linhaNum;
                    }
                    String[] aux = linhaAtual.split(" ");
                    if (aux.length > 1) { //label nao conta como + uma linha
                        //System.out.println(linhaAtual);
                        linhaNum+=4;
                    }
                }
                throw new Exception("LeitorDeArquivo>getNumeroDaLinha>Label que o beq leva se for verdade nao existe");
            }
        }
        throw new Exception("LeitorDeArquivo>getNumeroDaLinha>Erro!");
    }
}
