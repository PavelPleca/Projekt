/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cz.itnetwork.projekt;

import java.util.Scanner;

/**
 *
 * @author pleca
 */
public class Projekt {
 
    static Scanner sc = new Scanner(System.in);
        
 public static void main(String[] args) {
     
     Databaze databaze = new Databaze();
        
        int volba;
        do {
            volba = menu();
            switch (volba) {
                case 1 -> {
                    System.out.print("Zadejte jméno: ");
                    String jmeno = sc.nextLine();
                    System.out.print("Zadejte prijmeni: ");
                    String prijmeni = sc.nextLine();
                    System.out.print("Zadejte vek: ");
                    int vek = Integer.parseInt(sc.nextLine());
                    System.out.print("Zadejte telefonni cislo: ");
                    String telefonniCislo = sc.nextLine();
                    databaze.seznamPojistencu.add(databaze.pridatPojistence(jmeno, prijmeni, vek, telefonniCislo));
                    System.out.print("Data uložena. ");
                    zmackneteKlavesu();
             }
                case 2 -> {
                    databaze.vypisPojistenych();
                    zmackneteKlavesu();
             }
                case 3 -> {
                    System.out.print("Zadejte jmeno pojisteneho: ");
                    String jmeno = sc.nextLine();
                    System.out.print("Zadejte prijmeni pojisteneho: ");
                    String prijmeni = sc.nextLine();
                    databaze.vyhledatPojistence(jmeno, prijmeni);
                    zmackneteKlavesu();
             }
                case 4 -> System.out.close();
            }
        } while(volba != 4);

    }

    // Metoda pro stisknutí klávesy ENTER
    public static void zmackneteKlavesu() {
        System.out.println("Pro pokračování stiskněte Enter...");
        sc.nextLine();
    }

    public static int menu() {
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Přidat nového pojištěnce");
        System.out.println("2 - Vypsat všechny pojištěnce");
        System.out.println("3 - Vyhledat pojištěnce");
        System.out.println("4 - Konec");
        return Integer.parseInt(sc.nextLine());
    }
}