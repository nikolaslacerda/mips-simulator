package controller;

public class AluControl {

    private static AluControl instance;
    private BlocoDeControle blocoDeControle = BlocoDeControle.getInstance();

    public AluControl() { }

    public static AluControl getInstance() {
        if (instance == null) {
            instance = new AluControl();
        }
        return instance;
    }

    public String executa(String bitsDeFuncao){
        if(blocoDeControle.getAluOp0() == 00){ // load & store
            return "010";
        }else if(blocoDeControle.getAluOp0() == 01){ // beq
            return "110";
        }else if(blocoDeControle.getAluOp0() == 10) { // tipo R
            if (bitsDeFuncao.equals("100000")) { // add
                return "010";
            } else if (bitsDeFuncao.equals("100010")) {// sub
                return "110";
            } else if (bitsDeFuncao.equals("100100")) { //and
                return "000";
            } else if (bitsDeFuncao.equals("100101")) { // or
                return "001";
            }
        }
        return "AluControl>ERRO";
    }
}
