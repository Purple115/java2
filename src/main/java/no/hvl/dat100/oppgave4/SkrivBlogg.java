package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.oppgave3.Blogg;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn) {

        PrintWriter writer = null;

        try {
            String filepath;

            if (mappe == null || mappe.equals("")) {
                filepath = filnavn;
            } else if (mappe.endsWith("/") || mappe.endsWith("\\")) {
                filepath = mappe + filnavn;
            } else {
                filepath = mappe + "/" + filnavn;
            }

            writer = new PrintWriter(filepath);
            writer.print(samling.toString());
            return true;

        } catch (FileNotFoundException e) {
            return false;

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
