/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.projekt;

/**
 *
 * @author pleca
 */
public class Pojistenec {
    private final String jmeno;
    private  final String prijmeni;
    private final int vek;
    private final String telefonniCislo;

    public Pojistenec(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
    }

    public String getJmeno(){
        return jmeno;
    }
    
    public String getPrijmeni(){
        return prijmeni;
    }
    
    public int getVek(){
        return vek;
    }
    
    public String getTelefonniCislo(){
        return telefonniCislo;
    }
    
  
    @Override
     public String toString() {
        return this.jmeno + "\t" + this.prijmeni + "\t" + this.vek + "\t" + this.telefonniCislo;
    }
}
