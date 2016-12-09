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
public class BonConsum {
    private int id;
    private int nrBon;
    private LocalDate data;
    private String comanda;
    private int gestiune;

    public BonConsum(int id, int nrBon, LocalDate data, String comanda, int gestiune) {
        this.id = id;
        this.nrBon = nrBon;
        this.data = data;
        this.comanda = comanda;
        this.gestiune = gestiune;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNrBon() {
        return nrBon;
    }

    public void setNrBon(int nrBon) {
        this.nrBon = nrBon;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getComanda() {
        return comanda;
    }

    public void setComanda(String comanda) {
        this.comanda = comanda;
    }

    public int getGestiune() {
        return gestiune;
    }

    public void setGestiune(int gestiune) {
        this.gestiune = gestiune;
    }

    
    
    
}
