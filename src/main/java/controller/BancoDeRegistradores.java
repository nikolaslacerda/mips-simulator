package controller;

import java.util.HashMap;
import java.util.Map;

public class BancoDeRegistradores {

    private HashMap<String, String> listaDeRegistradores;
    private HashMap<String, Integer> listaDeRegistradoresNumeros;
    private HashMap<String, String> listaDeRegistradoresBin;
    private static BancoDeRegistradores instance;

    private BancoDeRegistradores() {
        this.listaDeRegistradores = new HashMap<String, String>();
        this.listaDeRegistradoresNumeros = new HashMap<String, Integer>();
        this.listaDeRegistradoresBin = new HashMap<String, String>();

        listaDeRegistradores.put("$zero", "00000000000000000000000000000000");
        listaDeRegistradores.put("$at", "00000000000000000001111111111111");
        listaDeRegistradores.put("$v0", "00000000000000000000000000000000");
        listaDeRegistradores.put("$v1", "00000000000000000000000000000000");
        listaDeRegistradores.put("$a0", "00000000000000000000000000000000");
        listaDeRegistradores.put("$a1", "00000000000000000000000000000000");
        listaDeRegistradores.put("$a2", "00000000000000000000000000000000");
        listaDeRegistradores.put("$a3", "00000000000000000000000000000000");
        listaDeRegistradores.put("$t0", "00000000000000000000000000000000");
        listaDeRegistradores.put("$t1", "00000000000000000000000000000001");
        listaDeRegistradores.put("$t2", "00000000000000000000000000000010");
        listaDeRegistradores.put("$t3", "00000000000000000000000000000000");
        listaDeRegistradores.put("$t4", "00000000000000000000000000000000");
        listaDeRegistradores.put("$t5", "00000000000000000000000000000000");
        listaDeRegistradores.put("$t6", "00000000000000000000000000000000");
        listaDeRegistradores.put("$t7", "00000000000000000000000000000000");
        listaDeRegistradores.put("$s0", "00000000000000000000000000000000");
        listaDeRegistradores.put("$s1", "00000000000000000000000000000000");
        listaDeRegistradores.put("$s2", "00000000000000000000000000000000");
        listaDeRegistradores.put("$s3", "00000000000000000000000000000000");
        listaDeRegistradores.put("$s4", "00000000000000000000000000000000");
        listaDeRegistradores.put("$s5", "00000000000000000000000000000000");
        listaDeRegistradores.put("$s6", "00000000000000000000000000000000");
        listaDeRegistradores.put("$s7", "00000000000000000000000000000000");
        listaDeRegistradores.put("$t8", "00000000000000000000000000000000");
        listaDeRegistradores.put("$t9", "00000000000000000000000000000000");
        listaDeRegistradores.put("$k0", "00000000000000000000000000000000");
        listaDeRegistradores.put("$k1", "00000000000000000000000000000000");
        listaDeRegistradores.put("$gp", "00000000000000000000000000000000");
        listaDeRegistradores.put("$sp", "00000000000000000000000000000000");
        listaDeRegistradores.put("$fp", "00000000000000000000000000000000");
        listaDeRegistradores.put("$ra", "00000000000000000000000000000000");
        //listaDeRegistradores.put("pc", "00000000000000000000000000000000");
        //listaDeRegistradores.put("hi", "00000000000000000000000000000000");
        //listaDeRegistradores.put("lo", "00000000000000000000000000000000");

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

        listaDeRegistradoresBin.put("00000", "$zero");
        listaDeRegistradoresBin.put("00001", "$at");
        listaDeRegistradoresBin.put("00010", "$v0");
        listaDeRegistradoresBin.put("00011", "$v1");
        listaDeRegistradoresBin.put("00100", "$a0");
        listaDeRegistradoresBin.put("00101", "$a1");
        listaDeRegistradoresBin.put("00110", "$a2");
        listaDeRegistradoresBin.put("00111", "$a3");
        listaDeRegistradoresBin.put("01000", "$t0");
        listaDeRegistradoresBin.put("01001", "$t1");
        listaDeRegistradoresBin.put("01010", "$t2");
        listaDeRegistradoresBin.put("01011", "$t3");
        listaDeRegistradoresBin.put("01100", "$t4");
        listaDeRegistradoresBin.put("01101", "$t5");
        listaDeRegistradoresBin.put("01110", "$t6");
        listaDeRegistradoresBin.put("01111", "$t7");
        listaDeRegistradoresBin.put("10000", "$s0");
        listaDeRegistradoresBin.put("10001", "$s1");
        listaDeRegistradoresBin.put("10010", "$s2");
        listaDeRegistradoresBin.put("10011", "$s3");
        listaDeRegistradoresBin.put("10010", "$s4");
        listaDeRegistradoresBin.put("10101", "$s5");
        listaDeRegistradoresBin.put("10110", "$s6");
        listaDeRegistradoresBin.put("10111", "$s7");
        listaDeRegistradoresBin.put("11000", "$t8");
        listaDeRegistradoresBin.put("11001", "$t9");
        listaDeRegistradoresBin.put("11010", "$k0");
        listaDeRegistradoresBin.put("11011", "$k1");
        listaDeRegistradoresBin.put("11100", "$gp");
        listaDeRegistradoresBin.put("11101", "$sp");
        listaDeRegistradoresBin.put("11110", "$fp");
        listaDeRegistradoresBin.put("11111", "$ra");

    }

    public static BancoDeRegistradores getInstance() {
        if (instance == null) {
            instance = new BancoDeRegistradores();
        }
        return instance;
    }

    public HashMap<String, String> getListaDeRegistradores() {
        return listaDeRegistradores;
    }

    public HashMap<String, Integer> getListaDeRegistradoresNumeros() {
        return listaDeRegistradoresNumeros;
    }

    public void setValue(String bin, String valor) throws Exception {
        if (listaDeRegistradoresBin.containsKey(bin)) {
            listaDeRegistradores.put(listaDeRegistradoresBin.get(bin), valor);
        } else {
            throw new Exception("BancoDeRegistradores>setValue>Registrador Invalido!");
        }
    }

    public String getValue(String bin) throws Exception {
        if (listaDeRegistradoresBin.containsKey(bin)) {
            return listaDeRegistradores.get(listaDeRegistradoresBin.get(bin));
        } else {
            throw new Exception("BancoDeRegistradores>getValue>Registrador Invalido!");
        }
    }

    public int getRegisterNumber(String registrador) throws Exception {
        if (listaDeRegistradoresNumeros.containsKey(registrador)) {
            return listaDeRegistradoresNumeros.get(registrador);
        } else {
            throw new Exception("BancoDeRegistradores>getRegisterNumber>Registrador Invalido!");
        }
    }

    public String getRegisterByBin(String bin) throws Exception {
        if (listaDeRegistradoresBin.containsKey(bin)) {
            return listaDeRegistradoresBin.get(bin);
        } else {
            throw new Exception("BancoDeRegistradores>getRegisterBin>Binario Invalido!");
        }
    }
    
    public void imprime() {
        System.out.println("### Registradores ###");
        for (Map.Entry<String, String> entry : listaDeRegistradores.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
