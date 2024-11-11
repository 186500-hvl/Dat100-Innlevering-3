package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.oppgave3.Blogg;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn) {

        boolean skrevet = false;

        try (PrintWriter writer = new PrintWriter(mappe + filnavn)) {

            writer.print(samling.toString());
            skrevet = true;

        } catch (FileNotFoundException e) {
            System.out.println("Feil ved skriving til fil: " + e.getMessage());
        }

        return skrevet;
    }
}