package controller;

public class Executa {
	private MemoriaDeDados memoriaDeDados = MemoriaDeDados.getInstance();
	private MemoriaDeInstrucoes memoriaDeInstrucoes = MemoriaDeInstrucoes.getInstance();
	private BancoDeRegistradores bancoDeRegistradores = BancoDeRegistradores.getInstance();
	private ULA ula = ULA.getInstance();
	private static Executa instance = Executa.getInstance();
	
	 public static Executa getInstance() {
	        if (instance == null) {
	            instance = new Executa();
	        }
	        return instance;
	}
	
	public Executa() {	}
	
	public void ExecutaPrograma() {
		for(int i=0;i<memoriaDeInstrucoes.getPosAtual();i++){
			String instrucao = memoriaDeInstrucoes.getInstrucao(i);
			if(instrucao.substring(0,6).equals("000000") && instrucao.substring(26,32).equals("100001")){//addu
				String rs = instrucao.substring(6,11);
				String rt = instrucao.substring(11,16);
				String rd = instrucao.substring(16,21);
				int soma = ula.Soma2Binarios(rs,rt);
				bancoDeRegistradores.setRegBin(rd,soma);
			
			}
			else if(instrucao.substring(0,6).equals("000000") && instrucao.substring(26,32).equals("100100")){//and
			
			}
			else if(instrucao.substring(0,12).equals("00000000000") && instrucao.substring(26,32).equals("000010")){//srl
				
			}
			else if(instrucao.substring(0,12).equals("00000000000") && instrucao.substring(26,32).equals("000000")){//sll
				
			}
			else if(instrucao.substring(0,6).equals("001001")) {//addiu
	
			}
			else if(instrucao.substring(0,6).equals("000100")) {//beq
	
			}
			else if(instrucao.substring(0,6).equals("000010")) {//j
				
			}
			else if(instrucao.substring(0,6).equals("100011")) {//lw
				//usa lui ou ori
			}
			else if(instrucao.substring(0,6).equals("101011")) {//sw
				//usa lui ou ori
			}
			else {System.out.println("Erro: Classe Executa.java");}
		}
	}

}
