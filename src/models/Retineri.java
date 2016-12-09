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
public class Retineri {
    private int id;
    private String descriere;
    private double valoare;
    private LocalDate data;
    private int angajat;

    public Retineri(int id, String descriere,double valoare, LocalDate data, int angajat) {
        this.id = id;
        this.descriere = descriere;
        this.valoare = valoare;
        this.data = data;
        this.angajat = angajat;
    }   
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public double getValoare() {
        return valoare;
    }

    public void setValoare(double valoare) {
        this.valoare = valoare;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getAngajat() {
        return angajat;
    }

    public void setAngajat(int angajat) {
        this.angajat = angajat;
    }
    
    
   
    
}
