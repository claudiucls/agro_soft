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
public class Produs {

    private int id;
    private String denumire;
    private String um;
    private String tva;
    private double pretUnitar;
    private double cantitateIntrare;
    private double stoc;
    private double valoare;
    private int intrare;
    private double cantitateIesire;
    private double cantitateFacturata;
    private int factura;
    private int iesire;

    public Produs() {
    }

    public Produs(String denumire, String um, String tva, double pretUnitar, double stoc, double valoare) {
        this.denumire = denumire;
        this.um = um;
        this.tva = tva;
        this.pretUnitar = pretUnitar;
        this.stoc = stoc;
        this.valoare =pretUnitar * stoc;
    }

    public Produs(int id, String denumire, String um, String tva, double pretUnitar, double cantitateIntrare, double cantitateIesire) {
        this.id = id;
        this.denumire = denumire;
        this.um = um;
        this.tva = tva;
        this.cantitateIntrare = cantitateIntrare;
        this.pretUnitar = pretUnitar;
        this.cantitateIesire = cantitateIesire;
    }

    public Produs(String denumire, String um, String tva, double pretUnitar, double cantitateFacturata) {
        this.denumire = denumire;
        this.um = um;
        this.tva = tva;
        this.pretUnitar = pretUnitar;
        this.cantitateFacturata = cantitateFacturata;
        this.factura = factura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }

    public double getPretUnitar() {
        return pretUnitar;
    }

    public void setPretUnitar(double pretUnitar) {
        this.pretUnitar = pretUnitar;
    }

    public double getCantitateIntrare() {
        return cantitateIntrare;
    }

    public void setCantitateIntrare(double cantitateIntrare) {
        this.cantitateIntrare = cantitateIntrare;
    }

    public double getStoc() {
        return stoc;
    }

    public void setStoc(double stoc) {
        this.stoc = stoc;
    }

    public double getValoare() {
        return valoare;
    }

    public void setValoare(double valoare) {
        this.valoare = valoare;
    }

    public int getIntrare() {
        return intrare;
    }

    public void setIntrare(int intrare) {
        this.intrare = intrare;
    }

    public double getCantitateIesire() {
        return cantitateIesire;
    }

    public void setCantitateIesire(double cantitateIesire) {
        this.cantitateIesire = cantitateIesire;
    }

    public double getCantitateFacturata() {
        return cantitateFacturata;
    }

    public void setCantitateFacturata(double cantitateFacturata) {
        this.cantitateFacturata = cantitateFacturata;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public int getIesire() {
        return iesire;
    }

    public void setIesire(int iesire) {
        this.iesire = iesire;
    }
    
    

   

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Produs) {
            return ((Produs) obj).getDenumire().equals(this.getDenumire()) &&
                    ((Produs) obj).getPretUnitar() == this.getPretUnitar();         
          
        }
        return false;
    }

}
