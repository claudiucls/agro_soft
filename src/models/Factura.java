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
public class Factura {
    private int id;
    private int nrFact;
    private LocalDate data;
    private String client;
    private int gestiune;
    private int zileScad;
    private String delegNume;
    private String delegCi;
    private String delegTrans;
    private String chitanta;
    private double total;

    public Factura(int id, int nrFact, LocalDate data, String client, int gestiune) {
        this.id = id;
        this.nrFact = nrFact;
        this.data = data;
        this.client = client;
        this.gestiune = gestiune;
    }
    
      public Factura(int id, int nrFact, LocalDate data, String client, int gestiune,double total) {
        this.id = id;
        this.nrFact = nrFact;
        this.data = data;
        this.client = client;
        this.gestiune = gestiune;
        this.total = total;
    }

    
    
    public Factura(int id, int nrFact, LocalDate data, String client, int gestiune, int zileScad, String delegNume, String delegCi, String delegTrans,String chitanta) {
        this.id = id;
        this.nrFact = nrFact;
        this.data = data;
        this.client = client;
        this.gestiune = gestiune;
        this.zileScad = zileScad;
        this.delegNume = delegNume;
        this.delegCi = delegCi;
        this.delegTrans = delegTrans;
        this.chitanta = chitanta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

  
    
    
    public int getZileScad() {
        return zileScad;
    }

    public void setZileScad(int zileScad) {
        this.zileScad = zileScad;
    }

    public String getDelegNume() {
        return delegNume;
    }

    public void setDelegNume(String delegNume) {
        this.delegNume = delegNume;
    }

    public String getDelegCi() {
        return delegCi;
    }

    public void setDelegCi(String delegCi) {
        this.delegCi = delegCi;
    }

    public String getDelegTrans() {
        return delegTrans;
    }

    public void setDelegTrans(String delegTrans) {
        this.delegTrans = delegTrans;
    }

    public String getChitanta() {
        return chitanta;
    }

    public void setChitanta(String chitanta) {
        this.chitanta = chitanta;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNrFact() {
        return nrFact;
    }

    public void setNrFact(int nrFact) {
        this.nrFact = nrFact;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getGestiune() {
        return gestiune;
    }

    public void setGestiune(int gestiune) {
        this.gestiune = gestiune;
    }

    
    
    
}
