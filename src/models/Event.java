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
public class Event {
    private int id;
    private String descriere;
    private String cod;
    private LocalDate dataDeLa;
    private LocalDate dataPanaLa;
    private int angajat;

    public Event(int id, String descriere, String cod, LocalDate dataDeLa, LocalDate dataPanaLa, int angajat) {
        this.id = id;
        this.descriere = descriere;
        this.cod = cod;
        this.dataDeLa = dataDeLa;
        this.dataPanaLa = dataPanaLa;
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

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public LocalDate getDataDeLa() {
        return dataDeLa;
    }

    public void setDataDeLa(LocalDate dataDeLa) {
        this.dataDeLa = dataDeLa;
    }

    public LocalDate getDataPanaLa() {
        return dataPanaLa;
    }

    public void setDataPanaLa(LocalDate dataPanaLa) {
        this.dataPanaLa = dataPanaLa;
    }

    public int getAngajat() {
        return angajat;
    }

    public void setAngajat(int angajat) {
        this.angajat = angajat;
    }
    
    
}
