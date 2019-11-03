package controller;

public class ConversorDeBits {

    public ConversorDeBits() {
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

}
