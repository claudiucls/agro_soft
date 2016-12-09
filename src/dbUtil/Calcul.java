/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbUtil;

import java.time.LocalDate;
import java.util.List;
import models.Angajat;
import models.Retineri;
import services.DBQueries;

/**
 *
 * @author Stroe Ion
 */
public class Calcul {
    
    DBQueries db = new DBQueries();
    
     public double valoareRetineri(Angajat a, LocalDate date){
        double retinere = 0;
        List<Retineri> rets = db.getRetineriByIdAngajat(a.getId());
        if(!rets.isEmpty())
        for(Retineri r:rets){
            if(r.getData().getMonth()==date.getMonth() && r.getData().getYear()== date.getYear()){
                retinere+=r.getValoare();
            }
        }
        return retinere;
    }
    
}
