package controller;

import java.util.HashMap;
import java.util.Map;

public class Registradores {

    private Map<String, Integer> listaDeRegistradores;
    private Map<String, Integer> listaDeRegistradoresNumeros;

    public Registradores() {
        this.listaDeRegistradores = new HashMap<String, Integer>();
        this.listaDeRegistradoresNumeros = new HashMap<String, Integer>();

        listaDeRegistradores.put("$zero", 0);
        listaDeRegistradores.put("$at", 0);
        listaDeRegistradores.put("$v0", 0);
        listaDeRegistradores.put("$v1", 0);
        listaDeRegistradores.put("$a0", 0);
        listaDeRegistradores.put("$a1", 0);
        listaDeRegistradores.put("$a2", 0);
        listaDeRegistradores.put("$a3", 0);
        listaDeRegistradores.put("$t0", 0);
        listaDeRegistradores.put("$t1", 0);
        listaDeRegistradores.put("$t2", 0);
        listaDeRegistradores.put("$t3", 0);
        listaDeRegistradores.put("$t4", 0);
        listaDeRegistradores.put("$t5", 0);
        listaDeRegistradores.put("$t6", 0);
        listaDeRegistradores.put("$t7", 0);
        listaDeRegistradores.put("$s0", 0);
        listaDeRegistradores.put("$s1", 0);
        listaDeRegistradores.put("$s2", 0);
        listaDeRegistradores.put("$s3", 0);
        listaDeRegistradores.put("$s4", 0);
        listaDeRegistradores.put("$s5", 0);
        listaDeRegistradores.put("$s6", 0);
        listaDeRegistradores.put("$s7", 0);
        listaDeRegistradores.put("$t8", 0);
        listaDeRegistradores.put("$t9", 0);
        listaDeRegistradores.put("$k0", 0);
        listaDeRegistradores.put("$k1", 0);
        listaDeRegistradores.put("$gp", 0);
        listaDeRegistradores.put("$sp", 0);
        listaDeRegistradores.put("$fp", 0);
        listaDeRegistradores.put("$ra", 0);
        listaDeRegistradores.put("pc", 0);
        listaDeRegistradores.put("hi", 0);
        listaDeRegistradores.put("lo", 0);

        listaDeRegistradoresNumeros.put("$zero", 0);
        listaDeRegistradoresNumeros.put("$at", 1);
        listaDeRegistradoresNumeros.put("$v0", 2);
        listaDeRegistradoresNumeros.put("$v1", 3);
        listaDeRegistradoresNumeros.put("$a0", 4);
        listaDeRegistradoresNumeros.put("$a1", 5);
        listaDeRegistradoresNumeros.put("$a2", 6);
        listaDeRegistradoresNumeros.put("$a3", 7);
        listaDeRegistradoresNumeros.put("$t0", 8);
        listaDeRegistradoresNumeros.put("$t1", 9);
        listaDeRegistradoresNumeros.put("$t2", 10);
        listaDeRegistradoresNumeros.put("$t3", 11);
        listaDeRegistradoresNumeros.put("$t4", 12);
        listaDeRegistradoresNumeros.put("$t5", 13);
        listaDeRegistradoresNumeros.put("$t6", 14);
        listaDeRegistradoresNumeros.put("$t7", 15);
        listaDeRegistradoresNumeros.put("$s0", 16);
        listaDeRegistradoresNumeros.put("$s1", 17);
        listaDeRegistradoresNumeros.put("$s2", 18);
        listaDeRegistradoresNumeros.put("$s3", 19);
        listaDeRegistradoresNumeros.put("$s4", 20);
        listaDeRegistradoresNumeros.put("$s5", 21);
        listaDeRegistradoresNumeros.put("$s6", 22);
        listaDeRegistradoresNumeros.put("$s7", 23);
        listaDeRegistradoresNumeros.put("$t8", 24);
        listaDeRegistradoresNumeros.put("$t9", 25);
        listaDeRegistradoresNumeros.put("$k0", 26);
        listaDeRegistradoresNumeros.put("$k1", 27);
        listaDeRegistradoresNumeros.put("$gp", 28);
        listaDeRegistradoresNumeros.put("$sp", 29);
        listaDeRegistradoresNumeros.put("$fp", 30);
        listaDeRegistradoresNumeros.put("$ra", 31);

    }

    public void setValue(String registrador, int valor) throws Exception {
        if (listaDeRegistradores.containsKey(registrador)) {
            listaDeRegistradores.put(registrador, valor);
        } else {
            throw new Exception("Registrador Inválido!");
        }
    }

    public int getValue(String registrador) throws Exception {
        if (listaDeRegistradores.containsKey(registrador)) {
            return listaDeRegistradores.get(registrador);
        } else {
            throw new Exception("Registrador Inválido!");
        }
    }

    public int getRegisterNumber(String registrador) throws Exception {
        if (listaDeRegistradoresNumeros.containsKey(registrador)) {
            return listaDeRegistradoresNumeros.get(registrador);
        } else {
            throw new Exception("Registrador Inválido!");
        }
    }

    public String getRegisterBin(String registrador) throws Exception {
        if (listaDeRegistradoresNumeros.containsKey(registrador)) {
            return Integer.toBinaryString(listaDeRegistradoresNumeros.get(registrador));
        } else {
            throw new Exception("Registrador Inválido!");
        }
    }

    public void printRegisters() {
        for (Map.Entry<String, Integer> entry : listaDeRegistradores.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

}
