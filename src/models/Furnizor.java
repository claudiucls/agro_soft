/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Claudiu
 */
public class Furnizor implements Comparable<Furnizor>{
    
    private String nume;
    private String cui;
    private String reg;
    private String banca;
    private String iban;


    public Furnizor() {
    }

    public Furnizor(String nume, String cui, String reg, String banca, String iban) {
        this.nume = nume;
        this.cui = cui;
        this.reg = reg;
        this.banca = banca;
        this.iban = iban;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getBanca() {
        return banca;
    }

    public void setBanca(String banca) {
        this.banca = banca;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    @Override
    public int compareTo(Furnizor f) {
        return nume.compareTo(f.getNume());
    }
    

    
    
}
