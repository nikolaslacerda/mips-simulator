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
        }else if(blocoDeControle.getAluOp0() == 01){
            return "110";
        }else if(blocoDeControle.getAluOp0() == 10) {
            if (bitsDeFuncao.equals("100000")) {
                return "010";
            } else if (bitsDeFuncao.equals("100010")) {
                return "110";
            } else if (bitsDeFuncao.equals("100100")) {
                return "000";
            } else if (bitsDeFuncao.equals("100101")) {
                return "001";
            } else if (bitsDeFuncao.equals("101010")) {
                return "111";
            }
        }
        return "ERRO";
    }
}
