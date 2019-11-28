package controller;

public class Executa {
	private MemoriaDeInstrucoes memoriaDeInstrucoes = MemoriaDeInstrucoes.getInstance();
	private ULA ula = ULA.getInstance();
	private AluControl aluControl = AluControl.getInstance();
	private MemoriaDeDados memoriaDeDados = MemoriaDeDados.getInstance();
    private BlocoDeControle blocoDeControle = BlocoDeControle.getInstance();
    private BancoDeRegistradores bancoDeRegistradores = BancoDeRegistradores.getInstance();
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

	     //LUI []
         //ORI [FEITO]
	     //ADDU [FEITO]
         //ADDIU [FEITO]
         //LW []
         //SW []
         //BEQ []
         //J [FEITO]
         //AND [FEITO]
         //SLL [FEITO]
         //SRL [FEITO]

	    //String no assemble começa no bit 31 e vai até o 0

	 	//PC

        String instrucao = memoriaDeInstrucoes.getInstrucao();

        System.out.println("EXECUTANDO INSTRUÇÃO: " + instrucao + " / " + memoriaDeInstrucoes.getInstrucaoNome());

        memoriaDeInstrucoes.pc4();

		String opcode = instrucao.substring(0, 6);

        System.out.println("OPCODE: " + opcode);

        String bitsDeFuncao = instrucao.substring(26,32);
        String shamt = instrucao.substring(21, 26);

        System.out.println("SHAMT: " + shamt);
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

        String signExtend = converte.to32Bits(instrucao.substring(16,32)); //signExtend
        System.out.println("Imediato: " + signExtend);

        String shiftLeafJump = (instrucao.substring(6,32)); //
        System.out.println("J[25-0]: " + shiftLeafJump);

        //Shif left 2 jump
        shiftLeafJump = "00" + shiftLeafJump;
        String pc4bitsjump = memoriaDeInstrucoes.getPC().substring(0, 4);
        String jumpAddress = pc4bitsjump + shiftLeafJump;

        String aluControlResult = aluControl.executa(bitsDeFuncao);
        System.out.println("AluCONTROL: " + aluControlResult);

        String readData1 = bancoDeRegistradores.getValue(readRegister1); //trocar para string(32 bits)
        System.out.println("Valor do R1: " + readData1);
        String readData2 = (blocoDeControle.getAluSrc() == 0)?bancoDeRegistradores.getValue(readRegister2):signExtend; // MUTEX
        System.out.println("Valor do R2: " + readData2);

        String aluResult = ula.calcula(aluControlResult, readData1, readData2, shamt);
        System.out.println("Resultado Calculado na ULA: " + aluResult);

        if(blocoDeControle.getJump() == 1){
            memoriaDeInstrucoes.setPC(jumpAddress);
            System.out.println("JUMP ADRESS " +jumpAddress);
        }

        // ************ ETAPA MEMORY ***************** //

        String address = aluResult;

        String readDataMemory = (blocoDeControle.getMemRead() == 1)?memoriaDeDados.readData(Integer.parseInt(address, 2)):"00000000000000000000000000000000";
        System.out.println("READDATA: " + readDataMemory);
        System.out.println("READDATA: " + readRegister2);


        String writeDataMemory = (blocoDeControle.getMemWrite() == 1)?bancoDeRegistradores.getValueByRegister(bancoDeRegistradores.getRegisterByBin(readRegister2)):"00000000000000000000000000000000"; //trocar para string(32 bits)
        String writeDataRegister = (blocoDeControle.getMemToReg() == 1)?readDataMemory:aluResult;

        System.out.println("writeDataMemory: " + writeDataMemory);
        if (blocoDeControle.getRegWrite() == 1){
            bancoDeRegistradores.setValue(writeRegister, writeDataRegister);
        }

        if (blocoDeControle.getMemWrite() == 1){
            memoriaDeDados.writeDado(writeDataMemory, Integer.parseInt(address, 2));
        }

        System.out.println("Valor no registrador write: " + bancoDeRegistradores.getValue(writeRegister));
        // ********** FIM DA EXECUCAO ***********/


	}

}
