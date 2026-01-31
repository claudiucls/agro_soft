/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;

import java.util.List;
import models.Angajat;
import models.Event;

import services.DBQueries;
import services.Sarbatori;

/**
 *
 * @author Claudiu
 */
public class NewClass {

    private static DBQueries db = new DBQueries();

    public static void main(String[] ags) {
       Calcul calcul = new Calcul();
       Angajat a = db.getAngajatById(11);
      double valoare =  calcul.valoareRetineri(a, LocalDate.now().minusMonths(1));
      System.out.println(a.getNume()+" are retineri pentru noiembrie 2016 de "+valoare+" lei");
    }
}
