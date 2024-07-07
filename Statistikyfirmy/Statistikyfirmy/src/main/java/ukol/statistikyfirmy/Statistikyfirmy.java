/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 * ZADÁNÍ:
 * Vytvořte program, který si nechá od uživatele zadat výdělek, případně ztrátu, nějaké firmy nebo obchodu za každý měsíc v roce. 
 * Následně vypište:
    Celkový roční výdělek
    Průměrný výdělek
    Nejmenší výdělek
    Největší výdělek
    Počet výdělečných měsíců
    Počet prodělečných měsíců
    První výdělečný měsíc
    Poslední výdělečný měsíc
 * 
 */


package ukol.statistikyfirmy;

/**
 *
 * @author pleca
 */

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Statistikyfirmy
{
 	public static void main(String[] args) {

     String[] mesice = { "leden", "únor", "březen", "duben", "květen", "červen", "červenec", "srpen", "září", "říjen", "listopad", "prosinec" };
        List<MesicniVydelek> vydelky = new ArrayList<MesicniVydelek>(); 
        Scanner sc = new Scanner(System.in);

        for(String mesic : mesice){
            double vydelek;
        
            boolean jeSpravne = false; 
               
            while (!jeSpravne){
                try{
                    System.out.print(mesic + ": ");
                    vydelek = Double.parseDouble(sc.nextLine());
                    vydelky.add(new MesicniVydelek(mesic, vydelek));
                    jeSpravne = true; 
    
                }catch (Exception e ){
                       
                    System.out.println("Zadej znovu: ");
                }
            }
        }
        sc.close();

        System.out.println();

        double celkovyVydelek = vydelky.stream().map(v -> v.getVydelek()).collect(Collectors.summingDouble(Double::doubleValue));
        OptionalDouble prumernyVydelek = vydelky.stream().mapToDouble(v -> v.getVydelek()).average();

        double nejmensiVydelek = vydelky.stream().map(v -> v.getVydelek()).min(Double::compareTo).get();
        double nejvetsiVydelek = vydelky.stream().map(v -> v.getVydelek()).max(Double::compareTo).get();

        int pocetVydelecnychMesicu = (int) vydelky.stream().filter(v -> v.getVydelek() > 0).count();
        int pocetProdelecnychMesicu = (int) vydelky.stream().filter(v -> v.getVydelek() < 0).count();

        String prvniVydelecnyMesic = vydelky.stream().filter(v -> v.getVydelek() > 0).findFirst().get().getMesic();
        String posledniVydelecnyMesic = vydelky.stream().filter(v -> v.getVydelek() > 0).reduce((prvni, druhy) -> druhy).get().getMesic();

        System.out.println("Celkový výdělek: " + (int)celkovyVydelek + " Kč" );
        System.out.println("Průměrný výdělek: " + prumernyVydelek.getAsDouble() + " Kč");
        System.out.println("Nejmenší výdělek: " + (int)nejmensiVydelek + " Kč");
        System.out.println("Největší výdělek: " + (int)nejvetsiVydelek + " Kč");
        System.out.println("Počet výdělečných měsíců: " + pocetVydelecnychMesicu);
        System.out.println("Počet prodělečných měsíců: " + pocetProdelecnychMesicu);
        System.out.println("První výdělečný měsíc: " +  prvniVydelecnyMesic);
        System.out.println("Poslední výdělečný měsíc: " + posledniVydelecnyMesic);
  
    }
}
