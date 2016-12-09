/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Claudiu
 */
public class ProdusStoc {
    private int id;
    private double stoc;

    public ProdusStoc(int id, double stoc) {
        this.id = id;
        this.stoc = stoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getStoc() {
        return stoc;
    }

    public void setStoc(double stoc) {
        this.stoc = stoc;
    }

   
    
}
