/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ukol.statistikyfirmy;

/**
 *
 * @author pleca
 */

import java.util.Scanner;


    class MesicniVydelek
    {
    private String mesic;
    private double vydelek;

    public MesicniVydelek(String mesic, double vydelek){
        this.mesic = mesic;
        this.vydelek = vydelek;
    }

    public String getMesic() { return this.mesic; }
    public double getVydelek() { return this.vydelek; }

}