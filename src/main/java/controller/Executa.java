package controller;

public class Executa {
	private MemoriaDeDados memoriaDeDados = MemoriaDeDados.getInstance();
	private MemoriaDeInstrucoes memoriaDeInstrucoes = MemoriaDeInstrucoes.getInstance();
	private BancoDeRegistradores bancoDeRegistradores = BancoDeRegistradores.getInstance();
	private ULA ula = ULA.getInstance();
	private BlocoDeControle blocoDeControle = BlocoDeControle.getInstance();
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
			String opcode = instrucao.substring(0,6); 
			String func = instrucao.substring(26,32);
			
			blocoDeControle.iniciaBlocoDeControle(opcode);
			
			if(opcode.equals("000000") && func.equals("100001")){//addu
				String rs = instrucao.substring(6,11);
				String rt = instrucao.substring(11,16);
				String rd = instrucao.substring(16,21);
				ula.Soma2Binarios(rs,rt,rd);
			}
			else if(opcode.equals("000000") && func.equals("100100")){//and
				String rs = instrucao.substring(6,11);
				String rt = instrucao.substring(11,16);
				String rd = instrucao.substring(16,21);
				ula.And2Binarios(rs,rt,rd);
			
			}
			else if(opcode.equals("000000") && func.equals("000010")){//srl
				
			}
			else if(opcode.equals("000000") && func.equals("000000")){//sll
				
			}
			else if(opcode.equals("001001")) {//addiu
	
			}
			else if(opcode.equals("000100")) {//beq
	
			}
			else if(opcode.equals("000010")) {//j
				
			}
			else if(opcode.equals("100011")) {//lw
				//usa lui ou ori
			}
			else if(opcode.equals("101011")) {//sw
				//usa lui ou ori
			}
			else {System.out.println("Erro: Classe Executa.java");}
		}
	}

}
