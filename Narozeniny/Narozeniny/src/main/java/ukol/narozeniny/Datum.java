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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Datum {
      
        private static DateTimeFormatter formatData = DateTimeFormatter.ofPattern("d.M.yyyy");

    public static String zformatuj(LocalDate datum) {
        return formatData.format(datum);
    }

    
    public static LocalDate naparsuj(String datumText) throws DateTimeParseException {
        return LocalDate.parse(datumText, formatData);
    }
}
