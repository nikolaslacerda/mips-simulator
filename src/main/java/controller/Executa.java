package controller;

public class Executa {
	private MemoriaDeDados memoriaDeDados = MemoriaDeDados.getInstance();
	private MemoriaDeInstrucoes memoriaDeInstrucoes = MemoriaDeInstrucoes.getInstance();
	private BancoDeRegistradores bancoDeRegistradores = BancoDeRegistradores.getInstance();
	private ULA ula = ULA.getInstance();
	
	public Executa() {
	
		for(int i=0;i<memoriaDeInstrucoes.getMemoria().length;i++){
			String instrucao = memoriaDeInstrucoes.getInstrucao(i);
			
			if(instrucao.substring(0,7).equals("000000") && instrucao.substring(26,32).equals("100001")){//addu
				String rs = instrucao.substring(7,12);
				String rt = instrucao.substring(12,17);
				String rd = instrucao.substring(17,22);
				int soma = ula.Soma2Binarios(rs,rt);
				bancoDeRegistradores.setRegistrador(rd,soma);
			
			}
			else if(instrucao.substring(0,7).equals("000000") && instrucao.substring(26,32).equals("100100")){//and
			
			}
			else if(instrucao.substring(0,12).equals("00000000000") && instrucao.substring(26,32).equals("000010")){//srl
				
			}
			else if(instrucao.substring(0,12).equals("00000000000") && instrucao.substring(26,32).equals("000000")){//sll
				
			}
			else if(instrucao.substring(0,7).equals("001001")) {//addiu
	
			}
			else if(instrucao.substring(0,7).equals("000100")) {//beq
	
			}
			else if(instrucao.substring(0,7).equals("000010")) {//j
				
			}
			else if(instrucao.substring(0,7).equals("100011")) {//lw
				//usa lui ou ori
			}
			else if(instrucao.substring(0,7).equals("101011")) {//sw
				//usa lui ou ori
			}
			else {System.out.println("Erro: Classe Executa.java");}
		}
	}

}
