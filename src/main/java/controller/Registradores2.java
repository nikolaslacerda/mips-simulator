package controller;

import java.util.ArrayList;

public class Registradores2 {
	private ArrayList<Registrador2> ListaDeRegistradores;
	private static Registradores2 uniqueInstance;
	
	public static Registradores2 getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Registradores2();
        }
        return uniqueInstance;
    }
	
	public Registradores2() {
		ListaDeRegistradores = new ArrayList<Registrador2>();
		Registrador2 reg0 = new Registrador2("$zero",0,0);
		Registrador2 reg1 = new Registrador2("$at",1,0);
		Registrador2 reg2 = new Registrador2("$v0",2,0);
		Registrador2 reg3 = new Registrador2("$v1",3,0);
		Registrador2 reg4 = new Registrador2("$a0",4,0);
		Registrador2 reg5 = new Registrador2("$a1",5,0);
		Registrador2 reg6 = new Registrador2("$a2",6,0);
		Registrador2 reg7 = new Registrador2("$a3",7,0);
		Registrador2 reg8 = new Registrador2("$t0",8,0);
		Registrador2 reg9 = new Registrador2("$t1",9,0);
		Registrador2 reg10 = new Registrador2("$t2",10,0);
		Registrador2 reg11 = new Registrador2("$t3",11,0);
		Registrador2 reg12 = new Registrador2("$t4",12,0);
		Registrador2 reg13 = new Registrador2("$t5",13,0);
		Registrador2 reg14 = new Registrador2("$t6",14,0);
		Registrador2 reg15 = new Registrador2("$t7",15,0);
		Registrador2 reg16 = new Registrador2("$s0",16,0);
		Registrador2 reg17 = new Registrador2("$s1",17,0);
		Registrador2 reg18 = new Registrador2("$s2",18,0);
		Registrador2 reg19 = new Registrador2("$s3",19,0);
		Registrador2 reg20 = new Registrador2("$s4",20,0);
		Registrador2 reg21 = new Registrador2("$s5",21,0);
		Registrador2 reg22 = new Registrador2("$s6",22,0);
		Registrador2 reg23 = new Registrador2("$s7",23,0);
		Registrador2 reg24 = new Registrador2("$t8",24,0);
		Registrador2 reg25 = new Registrador2("$t9",25,0);
		Registrador2 reg26 = new Registrador2("$k0",26,0);
		Registrador2 reg27 = new Registrador2("$k1",27,0);
		Registrador2 reg28 = new Registrador2("$gp",28,0);
		Registrador2 reg29 = new Registrador2("$sp",29,0);
		Registrador2 reg30 = new Registrador2("$fp",30,0);
		Registrador2 reg31 = new Registrador2("$ra",31,0);
		ListaDeRegistradores.add(reg0);
		ListaDeRegistradores.add(reg1);
		ListaDeRegistradores.add(reg2);
		ListaDeRegistradores.add(reg3);
		ListaDeRegistradores.add(reg4);
		ListaDeRegistradores.add(reg5);
		ListaDeRegistradores.add(reg6);
		ListaDeRegistradores.add(reg7);
		ListaDeRegistradores.add(reg8);
		ListaDeRegistradores.add(reg9);
		ListaDeRegistradores.add(reg10);
		ListaDeRegistradores.add(reg11);
		ListaDeRegistradores.add(reg12);
		ListaDeRegistradores.add(reg13);
		ListaDeRegistradores.add(reg14);
		ListaDeRegistradores.add(reg15);
		ListaDeRegistradores.add(reg16);
		ListaDeRegistradores.add(reg17);
		ListaDeRegistradores.add(reg18);
		ListaDeRegistradores.add(reg19);
		ListaDeRegistradores.add(reg20);
		ListaDeRegistradores.add(reg21);
		ListaDeRegistradores.add(reg22);
		ListaDeRegistradores.add(reg23);
		ListaDeRegistradores.add(reg24);
		ListaDeRegistradores.add(reg25);
		ListaDeRegistradores.add(reg26);
		ListaDeRegistradores.add(reg27);
		ListaDeRegistradores.add(reg28);
		ListaDeRegistradores.add(reg29);
		ListaDeRegistradores.add(reg30);
		ListaDeRegistradores.add(reg31);
	}
	public ArrayList<Registrador2> getListaDeRegistradores() {
		return ListaDeRegistradores;
	}
	public void setListaDeRegistradores(ArrayList<Registrador2> listaDeRegistradores) {
		ListaDeRegistradores = listaDeRegistradores;
	}
	
}
