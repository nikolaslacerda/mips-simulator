package controller;

public class ULA {
	private static ULA uniqueInstance;
	private static BancoDeRegistradores regs = BancoDeRegistradores.getInstance();
	
	public static ULA getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ULA();
        }
        return uniqueInstance;
    }
	
	public ULA(){}
	
	public void Soma4Pc() throws Exception { 
		int x=regs.getValue("pc")+4;
		regs.setValue("pc", x);
	}
	public int Soma2Binarios(String b1,String b2) {
		int x = Integer.parseInt(b1,2);
		int y = Integer.parseInt(b2,2);
		return x+y; 
	}
	public void CalculaEndereçoDeSalto() {}
	
	
}
