/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.projekt;

import java.util.ArrayList;

/**
 *
 * @author pleca
 */
public class Databaze {
    
    public ArrayList<Pojistenec> seznamPojistencu = new ArrayList();
    
    // Metoda přídání pojištěnce
    public Pojistenec pridatPojistence(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        return new Pojistenec(jmeno, prijmeni, vek, telefonniCislo);
    }
    
    // Metoda pro výpis pojištěnců
    public void vypisPojistenych() {
        for(int i = 0; i < seznamPojistencu.size(); ++i) {
            System.out.println(seznamPojistencu.get(i));
        }

    }
    
    // Metoda pro vyhledání pojištěnce
    public void vyhledatPojistence(String jmeno, String prijmeni) {
        boolean nalezen = false;

        for(int i = 0; i < seznamPojistencu.size(); ++i) {
            if (((Pojistenec)seznamPojistencu.get(i)).getJmeno().equals(jmeno) && ((Pojistenec)seznamPojistencu.get(i)).getPrijmeni().equals(prijmeni)) {
                System.out.println(seznamPojistencu.get(i));
                nalezen = true;
            }
        }

        if (!nalezen) {
            System.out.println("Pojištěný neexistuje!");
        }

    }
    
}
