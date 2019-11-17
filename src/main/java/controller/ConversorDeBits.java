package controller;

import java.util.HashMap;

public class ConversorDeBits {

    public ConversorDeBits() {}

    //Converte um binario para 5 bits
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

    //Converte um binario para 16 bits
    public String to16Bits(String bin) throws Exception {
        if (bin.length() < 16) {
            int zerosFaltantes = 16 - bin.length();
            String resultado = "";
            for (int i = 0; i < zerosFaltantes; i++) {
                resultado += "0";
            }
            return resultado + bin;
        } else if (bin.length() > 16) {
            while (bin.length() > 16) {
                bin = bin.substring(1); //Retira bit menos significativo
            }
        }
        return bin;
    }

    //Converte um binario para 16 bits
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

    //Converte um hexadecimal para binario
    public String hexaToBin(String hex) {
        HashMap<Character, String> hexas = new HashMap();
        hexas.put('0', "0000");
        hexas.put('2', "0010");
        hexas.put('3', "0011");
        hexas.put('4', "0100");
        hexas.put('5', "0101");
        hexas.put('6', "0110");
        hexas.put('7', "0111");
        hexas.put('8', "1000");
        hexas.put('9', "1001");
        hexas.put('A', "1010");
        hexas.put('B', "1011");
        hexas.put('C', "1100");
        hexas.put('D', "1101");
        hexas.put('E', "1110");
        hexas.put('F', "1111");
        hexas.put('a', "1010");
        hexas.put('b', "1011");
        hexas.put('c', "1100");
        hexas.put('d', "1101");
        hexas.put('e', "1110");
        hexas.put('f', "1111");

        String bin = "";
        for (int i = 0; i < hex.length(); i++) {
            bin += hexas.get(hex.charAt(i));
        }
        return bin;
    }

    public String binToHex(String bin) {
        int decimal = Integer.parseInt(bin,2);
        return "0x" + Integer.toString(decimal,16);
    }

}
