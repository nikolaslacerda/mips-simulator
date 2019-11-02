package controller;

public class Registrador2 {
	private String Nome;
	private int Id;
	private int Valor;
	
	public Registrador2(String nome,int id,int val) {
		this.Nome=nome;
		this.Id=id;
		this.Valor=val;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getValor() {
		return Valor;
	}
	public void setValor(int valor) {
		Valor = valor;
	}
}
