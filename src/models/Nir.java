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
public class Nir {
    private int id;
    private int nrNir;
    private LocalDate date;
    private String tipDoc;
    private String factura;
    private String furnizor;
    private int gestiune;

    public Nir() {
    }

    public Nir(int id,int nrNir, LocalDate date,String tipDoc, String factura, String furnizor, int gestiune) {
        this.id = id;
        this.nrNir = nrNir;
        this.date = date;
        this.tipDoc=tipDoc;
        this.factura = factura;
        this.furnizor = furnizor;
        this.gestiune = gestiune;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNrNir() {
        return nrNir;
    }

    public void setNrNir(int nrNir) {
        this.nrNir = nrNir;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getFurnizor() {
        return furnizor;
    }

    public void setFurnizor(String furnizor) {
        this.furnizor = furnizor;
    }

    public int getGestiune() {
        return gestiune;
    }

    public void setGestiune(int gestiune) {
        this.gestiune = gestiune;
    }
    
    
}
