/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author Claudiu
 */
public class Angajat {
    private int id;
    private String nume;
    private String cnp;
    private String functia;
    private LocalDate dataAngajarii;
    private LocalDate dataTerminarii;
    private String contract;
    private double salariu;
    private short persInt;
  

    public Angajat(int id, String nume, String cnp,String functia, LocalDate dataAngajarii, String contract, double salariu, short persInt) {
        this.id = id;
        this.nume = nume;
        this.cnp = cnp;
        this.functia = functia;
        this.dataAngajarii = dataAngajarii;
        this.contract = contract;
        this.salariu = salariu;
        this.persInt = persInt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public LocalDate getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(LocalDate dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public LocalDate getDataTerminarii() {
        return dataTerminarii;
    }

    public void setDataTerminarii(LocalDate dataTerminarii) {
        this.dataTerminarii = dataTerminarii;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public short getPersInt() {
        return persInt;
    }

    public void setPersInt(short persInt) {
        this.persInt = persInt;
    }

    public String getFunctia() {
        return functia;
    }

    public void setFunctia(String functia) {
        this.functia = functia;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
    
    
    
    
}
