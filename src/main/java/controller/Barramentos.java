package controller;

public class Barramentos {
    private static Barramentos instance;

    private String opcode;
    private String bitsDeFuncao;
    private String shamt;
    private String r1;
    private String r2;
    private String wr;
    private String imm;
    private String j;
    private String aluControl;
    private String valorR1;
    private String valorR2;
    private String aluResult;
    private String jumpAdress;
    private String writeMem;
    private String readMem;
    private String readReg;

    public Barramentos() {
        this.opcode="0";
        this.bitsDeFuncao="0";
        this.r1="0";
        this.r2="0";
        this.wr="0";
        this.imm="0";
        this.aluControl="0";
        this.valorR1="0";
        this.valorR2="0";
        this.aluResult="0";
        this.jumpAdress="0";
        this.writeMem="0";
        this.j="0";
        this.readMem="0";
        this.readReg="0";

    }

    public static Barramentos getInstance() {
        if (instance == null)
            instance = new Barramentos();
        return instance;
    }
    public String[] getBarramentos() {
        String s[] = new String[15];
        s[0]=("ReadRegister1 " + this.r1);
        s[1]=("ReadRegister2 " + this.r2);
        s[2]=("WriteRegister " + this.wr);
        s[3]=("Imediato " + this.imm);
        s[4]=("J " + this.j);
        s[5]=("aluControl " + this.aluControl);
        s[6]=("ValorR1 " + this.valorR1);
        s[7]=("ValorR2 " + this.valorR2);
        s[8]=("AluResult " + this.aluResult);
        s[9]=("JumpAddress " + this.jumpAdress);
        s[10]=("WriteMem " + this.writeMem);
        s[11]=("ReadMem " + this.readMem);
        s[12]=("ReadReg " + this.readReg);
        s[13]=("Opcode " + this.opcode);
        s[14]=("BitsDeFuncao " + this.bitsDeFuncao);
        return s;
    }

    public String getOpcode() {
        return opcode;
    }

    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public String getBitsDeFuncao() {
        return bitsDeFuncao;
    }

    public void setBitsDeFuncao(String bitsDeFuncao) {
        this.bitsDeFuncao = bitsDeFuncao;
    }

    public String getShamt() {
        return shamt;
    }

    public void setShamt(String shamt) {
        this.shamt = shamt;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getWr() {
        return wr;
    }

    public void setWr(String wr) {
        this.wr = wr;
    }

    public String getImm() {
        return imm;
    }

    public void setImm(String imm) {
        this.imm = imm;
    }

    public String getJ() {
        return j;
    }

    public void setJ(String j) {
        this.j = j;
    }

    public String getAluControl() {
        return aluControl;
    }

    public void setAluControl(String aluControl) {
        this.aluControl = aluControl;
    }

    public String getValorR1() {
        return valorR1;
    }

    public void setValorR1(String valorR1) {
        this.valorR1 = valorR1;
    }

    public String getValorR2() {
        return valorR2;
    }

    public void setValorR2(String valorR2) {
        this.valorR2 = valorR2;
    }

    public String getAluResult() {
        return aluResult;
    }

    public void setAluResult(String aluResult) {
        this.aluResult = aluResult;
    }

    public String getJumpAdress() {
        return jumpAdress;
    }

    public void setJumpAdress(String jumpAdress) {
        this.jumpAdress = jumpAdress;
    }

    public String getWriteMem() {
        return writeMem;
    }

    public void setWriteMem(String writeMem) {
        this.writeMem = writeMem;
    }

    public String getReadMem() {
        return readMem;
    }

    public void setReadMem(String readMem) {
        this.readMem = readMem;
    }

    public String getReadReg() {
        return readReg;
    }

    public void setReadReg(String readReg) {
        this.readReg = readReg;
    }

    public static void setInstance(Barramentos instance) {
        Barramentos.instance = instance;
    }



}