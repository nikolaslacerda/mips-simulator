package controller;

public class SinaisDeControle {
	private int RegDst;
	private int Jump;
	private int Branch;
	private int MemRead;
	private int MemToReg;
	private int AluOp;
	private int MemWrite;
	private int AluSrc;
	private int RegWrite;
	private static SinaisDeControle uniqueInstance;
	
	public static SinaisDeControle getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SinaisDeControle(0,0,0,0,0,0,0,0,0);
        }
        return uniqueInstance;
    }
	
	public SinaisDeControle(int s1, int s2, int s3, int s4, int s5, int s6, int s7, int s8, int s9) {
		this.RegDst=s1;
		this.Jump=s2;
		this.Branch=s3;
		this.MemRead=s4;
		this.MemToReg=s5;
		this.AluOp=s6;
		this.MemWrite=s7;
		this.AluSrc=s8;
		this.RegWrite=s9;
	}

	public int getRegDst() {
		return RegDst;
	}

	public void setRegDst(int regDst) {
		RegDst = regDst;
	}

	public int getJump() {
		return Jump;
	}

	public void setJump(int jump) {
		Jump = jump;
	}

	public int getBranch() {
		return Branch;
	}

	public void setBranch(int branch) {
		Branch = branch;
	}

	public int getMemRead() {
		return MemRead;
	}

	public void setMemRead(int memRead) {
		MemRead = memRead;
	}

	public int getMemToReg() {
		return MemToReg;
	}

	public void setMemToReg(int memToReg) {
		MemToReg = memToReg;
	}

	public int getAluOp() {
		return AluOp;
	}

	public void setAluOp(int aluOp) {
		AluOp = aluOp;
	}

	public int getMemWrite() {
		return MemWrite;
	}

	public void setMemWrite(int memWrite) {
		MemWrite = memWrite;
	}

	public int getAluSrc() {
		return AluSrc;
	}

	public void setAluSrc(int aluSrc) {
		AluSrc = aluSrc;
	}

	public int getRegWrite() {
		return RegWrite;
	}

	public void setRegWrite(int regWrite) {
		RegWrite = regWrite;
	}
}
