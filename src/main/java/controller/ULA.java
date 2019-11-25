package controller;

public class ULA {
    //private int tagZero = 0;

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

    public String calcula(String aluResult, String readData1, String readData2) throws Exception {
        if(aluResult.equals("010")){	//addu
            //System.out.println(Integer.toBinaryString(Integer.parseInt(readData1,2) + Integer.parseInt(readData2,2)));
            return converte.to32Bits(Integer.toBinaryString(Integer.parseInt(readData1,2) + Integer.parseInt(readData2,2)));
        }else if(aluResult.equals("110")){ //sub
            //System.out.println(Integer.toBinaryString(Integer.parseInt(readData1,2) - Integer.parseInt(readData2,2)));
            return converte.to32Bits(Integer.toBinaryString(Integer.parseInt(readData1,2) - Integer.parseInt(readData2,2)));
        }else if(aluResult.equals("000")) { //and
        	return converte.to32Bits(Integer.toBinaryString(Integer.parseInt(readData1,2) & Integer.parseInt(readData2,2)));
        }else if(aluResult.equals("001")) { //ori
			System.out.println("AA:" + readData1 + readData2);
        	return converte.to32Bits(Integer.toBinaryString(Integer.parseInt(readData1,2) | Integer.parseInt(readData2,2)));
        }else if(aluResult.equals("111")) { //sll
        	return converte.to32Bits(Integer.toBinaryString(Integer.parseInt(readData1,2) << Integer.parseInt(readData2,2)));
        }else if(aluResult.equals("011")) { //srl
        	return converte.to32Bits(Integer.toBinaryString(Integer.parseInt(readData1,2) >> Integer.parseInt(readData2,2)));
        }else if(aluResult.equals("")) { //lui
        	return "";
        }else{
            return "ULA>Calcula>EDITANDO";
        }
    }

/**
	public void Soma4Pc() throws Exception {
		int x=bancoDeRegistradores.getValue("pc")+4;
		bancoDeRegistradores.setValue("pc", x);
	}
	public void Soma2Binarios(String b1,String b2,String rd) throws Exception {
		int x = bancoDeRegistradores.getValue(b1);
		int y = bancoDeRegistradores.getValue(b2);
		int soma =x+y;
		bancoDeRegistradores.setValue(rd,soma); //salva no banco de registradores em decimal
	}

	public void CalculaEnderecoDeSalto() {}

	public void And2Binarios(String b1,String b2,String rd) throws Exception { //salva no banco de registradores em decimal
		int x = bancoDeRegistradores.getValue(b1);
		int y = bancoDeRegistradores.getValue(b2);
		int and = x & y;
		bancoDeRegistradores.setValue(rd,and);
	}

	public void ShiftDireita(String b,String shamt,String rd) throws Exception {
		int x = bancoDeRegistradores.getValue(b);
		int srl = x >> Integer.parseInt(shamt,2);
		bancoDeRegistradores.setValue(rd,srl);
	}

	public void ShiftEsquerda(String b,String shamt,String rd) throws Exception {
		int x = bancoDeRegistradores.getValue(b);
		int sll = x << Integer.parseInt(shamt,2);
		bancoDeRegistradores.setValue(rd,sll);
	}
**/
}
