/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/**
 * ZADÁNÍ:
 * Naprogramujte aplikaci, která si vyžádá od uživatele datum narození. 
 * Aplikace následně vypíše, jak je uživatel starý a za kolik dnů má nejbližší narozeniny. 
 * Zamyslete se nad tím, jak vypočítat věk opravdu správně, dělení počtu dnů 365.25 není správné řešení, jelikož není přesné.
 *
 */

package ukol.narozeniny;

/**
 *
 * @author pleca
 */

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class Narozeniny
{
 	public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadej datum narození: ");
        String datumText = scanner.nextLine();
        LocalDate datumNarozeni;
        try {
            datumNarozeni = Datum.naparsuj(datumText);
            Osoba osoba = new Osoba(datumNarozeni);
            int vek = osoba.spoctiVek();
            int dni = osoba.zbyvaDni();
            System.out.printf("Je ti %d let a narozeniny máš za %d dní.", vek, dni);
        } catch (DateTimeParseException ex) {
            System.err.println("Chybně zadané datum.");
        }
    }
}