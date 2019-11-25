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
        if(blocoDeControle.getAluOp0() == 0 && blocoDeControle.getAluOp1() == 0){ // load & store
            return "010";
        }else if(blocoDeControle.getAluOp0() == 1 &&  blocoDeControle.getAluOp1() == 0){ // beq
            return "110";
        }else if(blocoDeControle.getAluOp0() == 1 &&  blocoDeControle.getAluOp1() == 1){ // ori
            return "001";
        }else if(blocoDeControle.getAluOp0() == 0 && blocoDeControle.getAluOp1() == 1) { // tipo R
            if (bitsDeFuncao.equals("100001")) { // addu
                return "010";
            } else if (bitsDeFuncao.equals("100010")) {// sub
                return "110";
            } else if (bitsDeFuncao.equals("100100")) { //and
                return "000";
            } else if (bitsDeFuncao.equals("100101")) { // or
                return "001";
            } else if (bitsDeFuncao.equals("000000")) { // sll
                return "111";
            } else if (bitsDeFuncao.equals("000010")) { // srl
            	return "011";
            } else if (bitsDeFuncao.equals("")) { // lui
            	return "";
            }
        }
        return "AluControl>ERRO";
    }
}
