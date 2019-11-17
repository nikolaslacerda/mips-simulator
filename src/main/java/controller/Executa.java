package controller;

public class Executa {
	private MemoriaDeInstrucoes memoriaDeInstrucoes = MemoriaDeInstrucoes.getInstance();
	private ULA ula = ULA.getInstance();
	private AluControl aluControl = AluControl.getInstance();
    private BlocoDeControle blocoDeControle = BlocoDeControle.getInstance();
    private BancoDeRegistradores bancoDeRegistradores = BancoDeRegistradores.getInstance();
	private MemoriaDeDados memoriaDeDados = MemoriaDeDados.getInstance()

	private static Executa instance = Executa.getInstance();

	 public static Executa getInstance() {
	        if (instance == null) {
	            instance = new Executa();
	        }
	        return instance;
	}

	public Executa() {	}

	public void ExecutaPrograma() throws Exception {

	 	//PC
        int pc = memoriaDeInstrucoes.getPosAtual();
        String instrucao = memoriaDeInstrucoes.getInstrucao(pc);
		String opcode = instrucao.substring(0,6);
		String func = instrucao.substring(26,32);

		// Inicia bloco de controles
        blocoDeControle.iniciaBlocoDeControle(opcode);

        // ************ ETAPA DECODER ***************** //

        String readRegister1 = instrucao.substring(21,26);
        String readRegister2 = instrucao.substring(16,21);
        String writeRegister = (blocoDeControle.getRegDst() == 0)?instrucao.substring(16,21):instrucao.substring(11,16); // MUTEX

        aluControl.executa(opcode);
        signExtend.executa(instrucao.substring(0,16));

        int readData1 = bancoDeRegistradores.getValue(readRegister1); //trocar para string(32 bits)
        int readData2 = (blocoDeControle.getAluSrc() == 0)?bancoDeRegistradores.getValue(readRegister2):signExtend.getValue(); // MUTEX

        ula.calcula(readData1, readData2);

        // ************ ETAPA MEMORY ***************** //

        String address = ula.getAluResult();
        String readDataMemory = (blocoDeControle.getMemWrite() == 1)?memoriaDeDados.readDado(address):"null";
        int writeDataMemory = (blocoDeControle.getMemRead() == 1)?readData2:"null"; //trocar para string(32 bits)
        int writeDataRegister = (blocoDeControle.getMemToReg() == 1)?writeDataMemory:ula.getAluResult(); //trocar 32 bits
        if (blocoDeControle.getRegWrite() == 1){
            bancoDeRegistradores.setValue(writeRegister, writeDataRegister);
        }

        // ********** FIM DA EXECUCAO ***********//

	}

}
