package controller;

import java.util.ArrayList;

public class Registradores2 {
    private ArrayList<Registrador2> ListaDeRegistradores;
    private static Registradores2 instance;

    public static Registradores2 getInstance() {
        if (instance == null) {
            instance = new Registradores2();
        }
        return instance;
    }

    public Registradores2() {
        ListaDeRegistradores = new ArrayList<Registrador2>();
        ListaDeRegistradores.add(new Registrador2("$zero", 0, 0));
        ListaDeRegistradores.add(new Registrador2("$at", 1, 0));
        ListaDeRegistradores.add(new Registrador2("$v0", 2, 0));
        ListaDeRegistradores.add(new Registrador2("$v1", 3, 0));
        ListaDeRegistradores.add(new Registrador2("$a0", 4, 0));
        ListaDeRegistradores.add(new Registrador2("$a1", 5, 0));
        ListaDeRegistradores.add(new Registrador2("$a2", 6, 0));
        ListaDeRegistradores.add(new Registrador2("$a3", 7, 0));
        ListaDeRegistradores.add(new Registrador2("$t0", 8, 0));
        ListaDeRegistradores.add(new Registrador2("$t1", 9, 0));
        ListaDeRegistradores.add(new Registrador2("$t2", 10, 0));
        ListaDeRegistradores.add(new Registrador2("$t3", 11, 0));
        ListaDeRegistradores.add(new Registrador2("$t4", 12, 0));
        ListaDeRegistradores.add(new Registrador2("$t5", 13, 0));
        ListaDeRegistradores.add(new Registrador2("$t6", 14, 0));
        ListaDeRegistradores.add(new Registrador2("$t7", 15, 0));
        ListaDeRegistradores.add(new Registrador2("$s0", 16, 0));
        ListaDeRegistradores.add(new Registrador2("$s1", 17, 0));
        ListaDeRegistradores.add(new Registrador2("$s2", 18, 0));
        ListaDeRegistradores.add(new Registrador2("$s3", 19, 0));
        ListaDeRegistradores.add(new Registrador2("$s4", 20, 0));
        ListaDeRegistradores.add(new Registrador2("$s5", 21, 0));
        ListaDeRegistradores.add(new Registrador2("$s6", 22, 0));
        ListaDeRegistradores.add(new Registrador2("$s7", 23, 0));
        ListaDeRegistradores.add(new Registrador2("$t8", 24, 0));
        ListaDeRegistradores.add(new Registrador2("$t9", 25, 0));
        ListaDeRegistradores.add(new Registrador2("$k0", 26, 0));
        ListaDeRegistradores.add(new Registrador2("$k1", 27, 0));
        ListaDeRegistradores.add(new Registrador2("$gp", 28, 0));
        ListaDeRegistradores.add(new Registrador2("$sp", 29, 0));
        ListaDeRegistradores.add(new Registrador2("$fp", 30, 0));
        ListaDeRegistradores.add(new Registrador2("$ra", 31, 0));
    }

    public ArrayList<Registrador2> getListaDeRegistradores() {
        return ListaDeRegistradores;
    }

    public void setListaDeRegistradores(ArrayList<Registrador2> listaDeRegistradores) {
        ListaDeRegistradores = listaDeRegistradores;
    }

}
