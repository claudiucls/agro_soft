/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Stroe Ion
 */
public class Document {
    private int id;
    private String nrDoc;
    private String explicatie;
    private double intrare;
    private double iesire;
    private int registru;

    public Document(int id, String nrDoc, String explicatie, double intrare, double iesire) {
        this.id = id;
        this.nrDoc = nrDoc;
        this.explicatie = explicatie;
        this.intrare = intrare;
        this.iesire = iesire;
    }

    public Document(int id, String nrDoc, String explicatie, double intrare, double iesire, int registru) {
        this.id = id;
        this.nrDoc = nrDoc;
        this.explicatie = explicatie;
        this.intrare = intrare;
        this.iesire = iesire;
        this.registru = registru;
    }

    public Document(String nrDoc, String explicatie, double intrare, double iesire) {
       this.nrDoc = nrDoc;
        this.explicatie = explicatie;
        this.intrare = intrare;
        this.iesire = iesire;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNrDoc() {
        return nrDoc;
    }

    public void setNrDoc(String nrDoc) {
        this.nrDoc = nrDoc;
    }

    public String getExplicatie() {
        return explicatie;
    }

    public void setExplicatie(String explicatie) {
        this.explicatie = explicatie;
    }

    public double getIntrare() {
        return intrare;
    }

    public void setIntrare(double intrare) {
        this.intrare = intrare;
    }

    public double getIesire() {
        return iesire;
    }

    public void setIesire(double iesire) {
        this.iesire = iesire;
    }

    public int getRegistru() {
        return registru;
    }

    public void setRegistru(int registru) {
        this.registru = registru;
    }
    
     @Override
    public boolean equals(Object obj) {
        if (obj instanceof Document) {
            return ((Document) obj).getId()==(this.getId());          
        }
        return false;
    }
     
}
