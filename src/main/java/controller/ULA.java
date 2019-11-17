package controller;

public class ULA {
    private int tagZero = 0;
    private String AluResult = "";

    private static ULA uniqueInstance;
    private static BancoDeRegistradores bancoDeRegistradores = BancoDeRegistradores.getInstance();
    private static AluControl aluControl = AluControl.getInstance();

    public static ULA getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ULA();
        }
        return uniqueInstance;
    }

    public ULA() {
    } //PRECISA FAZER A VERIFICACOES PRA VER SE O RESULTADO DA ULA VAI DAR MAIS QUE 32 BITS

    public String calcula(String readData1, String readData2) {
        String aluC = aluControl.getResult();
        return "";
    }

	public String getAluResult() {
		return AluResult;
	}

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

}
