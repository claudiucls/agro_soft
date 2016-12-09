/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import models.Angajat;
import models.BonConsum;
import models.Document;
import models.Event;
import models.Factura;
import models.Registru;
import services.DBQueries;
import services.Sarbatori;

/**
 *
 * @author Claudiu
 */
public class NewClass {

    private static DBQueries db = new DBQueries();

    public static void main(String[] ags) {
        Sarbatori s = new Sarbatori();
        LocalDate date = LocalDate.now();
        Angajat angajat = db.getAngajatById(1);
        List<Event> evs = db.getEventByIdAngajat(angajat.getId());
        int zile = 0;
        if (!evs.isEmpty()) {
            for (Event e : evs) {
                LocalDate d = e.getDataDeLa();
                LocalDate p = e.getDataPanaLa();
                if (d.getMonth() == date.getMonth() && p.getMonth() == date.getMonth()) {
                    if (d.getMonth() == date.getMonth() && p.getMonth() != date.getMonth()) {
                        int i = d.getDayOfMonth();
                        while (i <= date.lengthOfMonth()) {
                            if (!(d.getDayOfWeek() == DayOfWeek.SUNDAY || d.getDayOfWeek() == DayOfWeek.SATURDAY)) {
                                zile++;
                            }
                            i++;
                            d = d.plusDays(1);
                        }
                    } else if (d.getMonth() != date.getMonth() && p.getMonth() == date.getMonth()) {
                        int i = 1;
                        LocalDate x = LocalDate.of(date.getYear(), date.getMonthValue(), 1);
                        while (i <= p.getDayOfMonth()) {
                            if (!(x.getDayOfWeek() == DayOfWeek.SUNDAY || x.getDayOfWeek() == DayOfWeek.SATURDAY)) {
                                zile++;
                            }
                            i++;
                            x = x.plusDays(1);

                        }
                    } else if (d.getMonth() == date.getMonth() && p.getMonth() == date.getMonth()) {
                        int i = p.getDayOfMonth();
                        int j = d.getDayOfMonth();
                        while (j <= i) {
                            if (!(d.getDayOfWeek() == DayOfWeek.SUNDAY || d.getDayOfWeek() == DayOfWeek.SATURDAY)) {
                                zile++;
                            }
                            j++;
                            d = d.plusDays(1);
                        }
                    }
                }
            }
            System.out.println(angajat.getNume() + " a lucrat :" + zile + " zile");

        }
    }
}
