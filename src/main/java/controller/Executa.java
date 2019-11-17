package controller;

public class Executa {
	private MemoriaDeInstrucoes memoriaDeInstrucoes = MemoriaDeInstrucoes.getInstance();
	private ULA ula = ULA.getInstance();
	private AluControl aluControl = AluControl.getInstance();
    private BlocoDeControle blocoDeControle = BlocoDeControle.getInstance();
    private BancoDeRegistradores bancoDeRegistradores = BancoDeRegistradores.getInstance();
	private MemoriaDeDados memoriaDeDados = MemoriaDeDados.getInstance();
	private ConversorDeBits converte = new ConversorDeBits();

	private static Executa instance = Executa.getInstance();

	 public static Executa getInstance() {
	        if (instance == null) {
	            instance = new Executa();
	        }
	        return instance;
	}

	public Executa() {	}

	public void ExecutaPrograma() throws Exception {

	     //String no assemble começa no bit 31 e vai até o 0

	 	//PC
        int pc = 0;

        String instrucao = memoriaDeInstrucoes.getInstrucao(0);

        System.out.println("EXECUTANDO INSTRUÇÃO: " + instrucao);

		String opcode = instrucao.substring(0, 6);

        System.out.println("OPCODE: " + opcode);

        String bitsDeFuncao = instrucao.substring(26,32);

        System.out.println("BITS DE FUNCAO: " + bitsDeFuncao);

		// Inicia bloco de controles
        blocoDeControle.iniciaBlocoDeControle(opcode);

        // ************ ETAPA DECODER ***************** //

        String readRegister1 = instrucao.substring(6, 11);
        //System.out.println(readRegister1);
        System.out.println("R1: " + bancoDeRegistradores.getRegisterByBin(readRegister1));

        String readRegister2 = instrucao.substring(11, 16);
        System.out.println("R2: " + bancoDeRegistradores.getRegisterByBin(readRegister2));

        //System.out.println(blocoDeControle.getRegDst());
        String writeRegister = (blocoDeControle.getRegDst() == 0)?instrucao.substring(11,16):instrucao.substring(16,21); // MUTEX
        System.out.println("WR: " + bancoDeRegistradores.getRegisterByBin(writeRegister));

        String aluControlResult = aluControl.executa(bitsDeFuncao);
        System.out.println("AluCONTROL: " + aluControlResult);

        String signExtend = converte.to32Bits(instrucao.substring(16,32)); //signExtend

        String readData1 = bancoDeRegistradores.getValue(readRegister1); //trocar para string(32 bits)
        System.out.println("Valor do R1: " + readData1);
        String readData2 = (blocoDeControle.getAluSrc() == 0)?bancoDeRegistradores.getValue(readRegister2):signExtend; // MUTEX
        System.out.println("Valor do R2: " + readData2);

        String aluResult = ula.calcula(aluControlResult, readData1, readData2);
        System.out.println("Resultado Calculado na ULA: " + aluResult);

        // ************ ETAPA MEMORY ***************** //

        String address = aluResult;

        //String readDataMemory = (blocoDeControle.getMemWrite() == 1)?memoriaDeDados.readDado(address):"null";
        String writeDataMemory = (blocoDeControle.getMemRead() == 1)?readData2:"null"; //trocar para string(32 bits)
        String writeDataRegister = (blocoDeControle.getMemToReg() == 1)?writeDataMemory:aluResult; //trocar 32

        if (blocoDeControle.getRegWrite() == 1){
            bancoDeRegistradores.setValue(writeRegister, writeDataRegister);
        }

        System.out.println("Valor no registrador write: " + bancoDeRegistradores.getValue(writeRegister));
        // ********** FIM DA EXECUCAO ***********/

        pc++;
	}

}
