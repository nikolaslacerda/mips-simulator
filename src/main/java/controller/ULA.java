package controller;

public class ULA {
    private int tagZero = 0;

    private static ULA uniqueInstance;
    ConversorDeBits converte = new ConversorDeBits();

    public static ULA getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ULA();
        }
        return uniqueInstance;
    }

    public ULA() {
    } //PRECISA FAZER A VERIFICACOES PRA VER SE O RESULTADO DA ULA VAI DAR MAIS QUE 32 BITS

    public String calcula(String aluResult, String readData1, String readData2, String shamt) throws Exception {
        if(aluResult.equals("010")){	//addu
            //System.out.println(Integer.toBinaryString(Integer.parseInt(readData1,2) + Integer.parseInt(readData2,2)));
            return converte.to32Bits(Integer.toBinaryString(Integer.parseInt(readData1,2) + Integer.parseInt(readData2,2)));
        }else if(aluResult.equals("110")){ //sub
            this.tagZero = Integer.parseInt(readData1, 2) - Integer.parseInt(readData2, 2);
            return converte.to32Bits(Integer.toBinaryString(Integer.parseInt(readData1,2) - Integer.parseInt(readData2,2)));
        }else if(aluResult.equals("000")) { //and
        	return converte.to32Bits(Integer.toBinaryString(Integer.parseInt(readData1,2) & Integer.parseInt(readData2,2)));
        }else if(aluResult.equals("001")) { //ori
			System.out.println("AA:" + readData1 + readData2);
        	return converte.to32Bits(Integer.toBinaryString(Integer.parseInt(readData1,2) | Integer.parseInt(readData2,2)));
        }else if(aluResult.equals("111")) { //sll
        	return converte.to32Bits(Integer.toBinaryString(Integer.parseInt(readData2,2) << Integer.parseInt(shamt,2)));
        }else if(aluResult.equals("011")) { //srl
        	return converte.to32Bits(Integer.toBinaryString(Integer.parseInt(readData2,2) >> Integer.parseInt(shamt,2)));
        }else if(aluResult.equals("")) { //lui
        	return "";
        }else{
            return "ULA>Calcula>EDITANDO";
        }
    }

    public int getTagZero(){
    	return this.tagZero;
	}

}
