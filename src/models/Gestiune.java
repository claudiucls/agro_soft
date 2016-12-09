/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;

/**
 *
 * @author Claudiu
 */
public class Gestiune implements Comparable<Gestiune> {

    private int id;
    private String nume;

    public Gestiune(String nume) {
        this.nume = nume;
    }

    public Gestiune(int id, String nume) {
        this.id = id;
        this.nume = nume;
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

    @Override
    public int compareTo(Gestiune g) {
        return nume.compareTo(g.getNume());
    }

}
