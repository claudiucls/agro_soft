/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author Stroe Ion
 */
public class Registru {
    private int id;
    private int nrReg;
    private LocalDate date;
    private double sorldI;
    private double soldF;

    public Registru( int nrReg, LocalDate date, double sorldI, double soldF) {
       
        this.nrReg = nrReg;
        this.date = date;
        this.sorldI = sorldI;
        this.soldF = soldF;
    }

    public Registru(int id, int nrReg, LocalDate date, double sorldI, double soldF) {
        this.id = id;
        this.nrReg = nrReg;
        this.date = date;
        this.sorldI = sorldI;
        this.soldF = soldF;
    }

    public Registru(int id, int nrReg, LocalDate date) {
        this.id = id;
        this.nrReg = nrReg;
        this.date = date;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNrReg() {
        return nrReg;
    }

    public void setNrReg(int nrReg) {
        this.nrReg = nrReg;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getSorldI() {
        return sorldI;
    }

    public void setSorldI(double sorldI) {
        this.sorldI = sorldI;
    }

    public double getSoldF() {
        return soldF;
    }

    public void setSoldF(double soldF) {
        this.soldF = soldF;
    }
    
    
}
