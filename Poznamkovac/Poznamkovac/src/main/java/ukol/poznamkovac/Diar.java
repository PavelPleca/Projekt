/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ukol.poznamkovac;

/**
 *
 * @author pleca
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Diar {

    public static final DateTimeFormatter FORMAT_DATA = DateTimeFormatter.ofPattern("d.M.y H:mm");

    public static final DateTimeFormatter FORMAT_DATA_BEZ_CASU = DateTimeFormatter.ofPattern("d.M.y");

    private Databaze databaze;

    private Scanner scanner = new Scanner(System.in);

    public Diar() {
        databaze = new Databaze();
    }

    private LocalDateTime naparsujDatumCas() {
        System.out.println("Zadejte datum a čas ve tvaru [" + LocalDateTime.now().format(FORMAT_DATA) + "]:");
        while (true) {
            try {
                return LocalDateTime.parse(scanner.nextLine(), FORMAT_DATA);
            } catch (Exception ex) {
                System.out.println("Nesprávně zadáno, zadejte prosím znovu.");
            }
        }
    }

    private LocalDateTime naparsujDatum() {
        System.out.println("Zadejte datum ve tvaru [" + LocalDate.now().format(FORMAT_DATA_BEZ_CASU) + "]:");
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine(), FORMAT_DATA_BEZ_CASU).atStartOfDay();
            } catch (Exception ex) {
                System.out.println("Nesprávně zadáno, zadejte prosím znovu.");
            }
        }
    }

    public void vypisZaznamy(LocalDateTime den) {
        ArrayList<Zaznam> zaznamy = databaze.najdiZaznamy(den, false);
        for (Zaznam zaznam : zaznamy) {
            System.out.println(zaznam);
        }
    }

    public void pridejZaznam() {
        LocalDateTime datumCas = naparsujDatumCas();
        System.out.println("Zadejte text záznamu:");
        String text = scanner.nextLine();
        databaze.pridejZaznam(datumCas, text);
    }

    public void vyhledejZaznamy() {
        LocalDateTime datumCas = naparsujDatum();
        ArrayList<Zaznam> zaznamy = databaze.najdiZaznamy(datumCas, false);
        if (zaznamy.size() > 0) {
            System.out.println("Nalezeny tyto záznamy: ");
            for (Zaznam zaznam : zaznamy) {
                System.out.println(zaznam);
            }
        } else {
            System.out.println("Nebyly nalezeny žádné záznamy.");
        }
    }

    public void vymazZaznamy() {
        System.out.println("Budou vymazány záznamy v daný den a hodinu");
        LocalDateTime datumCas = naparsujDatumCas();
        databaze.vymazZaznamy(datumCas);
    }

    public void vypisUvodniObrazovku() {
        System.out.println();
        System.out.println();
        System.out.println("Vítejte v diáři!");
        LocalDateTime dnes = LocalDateTime.now();
        System.out.printf("Dnes je: %s%n", FORMAT_DATA.format(dnes));
        System.out.println();
        System.out.println("Dnes:\n-----");
        vypisZaznamy(dnes);
        System.out.println();
        System.out.println("Zítra:\n------");
        LocalDateTime zitra = LocalDateTime.now().plusDays(1);
        vypisZaznamy(zitra);
        System.out.println();
    }
}
