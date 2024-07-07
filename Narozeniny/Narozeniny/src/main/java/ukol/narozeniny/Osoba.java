/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ukol.narozeniny;

/**
 *
 * @author pleca
 */

import java.util.Scanner;
import java.time.temporal.ChronoUnit;


import java.time.LocalDate;

public class Osoba {
     private LocalDate narozeniny;
   
    public Osoba(LocalDate narozeniny) {
        this.narozeniny = narozeniny;
    }
    
   
    public int spoctiVek() {
        LocalDate dnes = LocalDate.now();
        int vek = (int) narozeniny.until(dnes, ChronoUnit.YEARS);
        return vek;
    }
    
   
    public int zbyvaDni() {
        LocalDate dnes = LocalDate.now();
        LocalDate dalsiNarozeniny = narozeniny.withYear(dnes.getYear());
        if (dalsiNarozeniny.isBefore(dnes)) {
            dalsiNarozeniny = dalsiNarozeniny.plusYears(1);
        }
        int dniDoNarozenin = (int) dnes.until(dalsiNarozeniny, ChronoUnit.DAYS);
        return dniDoNarozenin;
    }

   
    public LocalDate getNarozeniny() {
        return narozeniny;
    }

   
    public void setNarozeniny(LocalDate narozeniny) {
        this.narozeniny = narozeniny;
    }
}