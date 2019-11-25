package controller;

public class BlocoDeControle {
    private int RegDst;
    private int Jump;
    private int Branch;
    private int MemRead;
    private int MemToReg;
    private int AluOp0;
    private int AluOp1;
    private int MemWrite;
    private int AluSrc;
    private int RegWrite;
    private static BlocoDeControle instance;

    public static BlocoDeControle getInstance() {
        if (instance == null) {
            instance = new BlocoDeControle();
        }
        return instance;
    }

    public BlocoDeControle() {
        this.RegDst = 0;
        this.Jump = 0;
        this.Branch = 0;
        this.MemRead = 0;
        this.MemToReg = 0;
        this.AluOp0 = 0;
        this.AluOp1 = 0;
        this.MemWrite = 0;
        this.AluSrc = 0;
        this.RegWrite = 0;
    }

    public int getRegDst() {
        return RegDst;
    }

    public int getJump() {
        return Jump;
    }

    public int getBranch() {
        return Branch;
    }

    public int getMemRead() {
        return MemRead;
    }

    public int getMemToReg() {
        return MemToReg;
    }

    public int getAluOp0() {
        return AluOp0;
    }

    public int getAluOp1() {
        return AluOp1;
    }

    public int getMemWrite() {
        return MemWrite;
    }

    public int getAluSrc() {
        return AluSrc;
    }

    public int getRegWrite() {
        return RegWrite;
    }

    public void iniciaBlocoDeControle(String instrucao) {

        String opcode = instrucao.substring(0, 6);

        if (opcode.equals("000000")) { //Tipo-R
            this.RegDst = 1;
            this.Jump = 0;
            this.Branch = 0;
            this.MemRead = 0;
            this.MemToReg = 0;
            this.AluOp1 = 1;
            this.AluOp0 = 0;
            this.MemWrite = 0;
            this.AluSrc = 0;
            this.RegWrite = 1;
        } else if (opcode.equals("100011")) { //lw
            this.RegDst = 0;
            this.Jump = 0;
            this.Branch = 0;
            this.MemRead = 1;
            this.MemToReg = 1;
            this.AluOp1 = 0;
            this.AluOp0 = 0;
            this.MemWrite = 0;
            this.AluSrc = 1;
            this.RegWrite = 1;
        } else if (opcode.equals("101011")) { //sw
            this.RegDst = 0; //X
            this.Jump = 0;
            this.Branch = 0;
            this.MemRead = 0;
            this.MemToReg = 0; //X
            this.AluOp1 = 0;
            this.AluOp0 = 0;
            this.MemWrite = 1;
            this.AluSrc = 1;
            this.RegWrite = 0;
        } else if (opcode.equals("000100")) { //beq
            this.RegDst = 0; //X
            this.Jump = 0;
            this.Branch = 1;
            this.MemRead = 0;
            this.MemToReg = 0; //X
            this.AluOp1 = 0;
            this.AluOp0 = 1;
            this.MemWrite = 0;
            this.AluSrc = 0;
            this.RegWrite = 0;
        } else if (opcode.equals("001001")) { //addiu
            this.RegDst = 0;
            this.Jump = 0;
            this.Branch = 0;
            this.MemRead = 0;
            this.MemToReg = 0;
            this.AluOp1 = 0;
            this.AluOp0 = 0;
            this.MemWrite = 0;
            this.AluSrc = 1;
            this.RegWrite = 1;
        } else if (opcode.equals("000100")) { //j
            this.RegDst = 0; //X
            this.Jump = 1;
            this.Branch = 0; //X
            this.MemRead = 0;
            this.MemToReg = 0; //X
            this.AluOp1 = 0; //X
            this.AluOp0 = 0; //X
            this.MemWrite = 0;
            this.AluSrc = 0; //X
            this.RegWrite = 0;
        } else if (opcode.equals("001101")) { //ori
            this.RegDst = 0; //MUDAR PQ TÁ AO CONTRARIO EM TODASSSSSSSSSSS
            this.Jump = 0;
            this.Branch = 0; //X
            this.MemRead = 0;
            this.MemToReg = 0; //X
            this.AluOp1 = 1; //X
            this.AluOp0 = 1; //X
            this.MemWrite = 0;
            this.AluSrc = 1; //X
            this.RegWrite = 1;
        }
    }

    public void reset() {
        this.RegDst = 0;
        this.Jump = 0;
        this.Branch = 0;
        this.MemRead = 0;
        this.MemToReg = 0;
        this.AluOp0 = 0;
        this.AluOp1 = 0;
        this.MemWrite = 0;
        this.AluSrc = 0;
        this.RegWrite = 0;
    }
    
    public void imprime() {
    	System.out.println("### Sinais de controle ###");
    	System.out.println("Jump: " + this.Jump);
    	System.out.println("RegDst: " + this.RegDst);
    	System.out.println("RegWrite: " + this.RegWrite);
    	System.out.println("Branch: " + this.Branch);
    	System.out.println("MemRead: " + this.MemRead);
    	System.out.println("MemWrite: " + this.MemWrite);
    	System.out.println("MemToReg: " + this.MemToReg);
    	System.out.println("AluOp0 - AluOp1: " + this.AluOp0 + " - "+ this.AluOp1);
    	System.out.println("AluSrc: " + this.AluSrc);
    }

}

