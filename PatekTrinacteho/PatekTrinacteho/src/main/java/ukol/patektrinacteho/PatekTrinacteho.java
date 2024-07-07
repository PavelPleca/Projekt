/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/**
 * ZADÁNÍ:
 * Naprogramujte aplikaci, která pro zadaný interval datumů vypíše všechny pátky 13.
 */


package ukol.patektrinacteho;

/**
 *
 * @author pleca
 */

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class PatekTrinacteho
{
 	public static void main(String[] args) {

        DateTimeFormatter formatData = DateTimeFormatter.ofPattern("d.M.yyyy");

        Scanner scanner = new Scanner(System.in, "Windows-1250");
        System.out.println("Pro zadaný interval datumů vypíše všechny pátky 13.:");
        System.out.println("Zadejte 1. datum: ");

       LocalDate zacatek;
        try {
            zacatek = LocalDate.parse(scanner.nextLine(), formatData);
        } catch (DateTimeParseException ex) {
            System.out.println("Nezadali jste datum ve správném formátu!" + ex.getMessage());
            return;
        }
        System.out.println("Zadejte 2. datum: ");
        LocalDate konec;
        try {
            konec = LocalDate.parse(scanner.nextLine(), formatData);
        } catch (DateTimeParseException ex) {
            System.out.println("Nezadali jste datum ve správném formátu!" + ex.getMessage());
            return;
        }
        System.out.println("Pátky 13.: ");

        while (zacatek.getDayOfWeek() != DayOfWeek.FRIDAY) {
            zacatek = zacatek.plusDays(1);
        }
        while (zacatek.isBefore(konec)) {
            if (zacatek.getDayOfMonth() == 13) {
                System.out.printf("%s, ", formatData.format(zacatek));
            }
            zacatek = zacatek.plusDays(7);
        }
    }
}