/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbUtil;

/**
 *
 * @author Claudiu
 */
public class Formatare {
    public static double formatStringAsDouble(String s){
        double d = 0;
        if (s.matches("^[0-9]+([,.][0-9]{1,4})?")) {
            if (s.matches("^[0-9]+([.][0-9]{1,4})?")) {
                d = Double.parseDouble(s);
                return d;
            } else {
                s = s.replace(",", ".");
                d = Double.parseDouble(s);
                return d;
            }
        } else {
            return -1;
        }
    }
}
