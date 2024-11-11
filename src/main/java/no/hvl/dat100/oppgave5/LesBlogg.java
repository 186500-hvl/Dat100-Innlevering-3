package no.hvl.dat100.oppgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import no.hvl.dat100.oppgave3.Blogg;
import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave2.Bilde;
import no.hvl.dat100.oppgave2.Tekst;

public class LesBlogg {

    private static String TEKST = "TEKST";
    private static String BILDE = "BILDE";

    public static Blogg les(String mappe, String filnavn) {

        Blogg blogg = null;

        try {
            File file = new File(mappe + filnavn);
            Scanner scanner = new Scanner(file);

            int antallInnlegg = Integer.parseInt(scanner.nextLine());
            blogg = new Blogg(antallInnlegg);

            for (int i = 0; i < antallInnlegg; i++) {
                int id = Integer.parseInt(scanner.nextLine());
                String bruker = scanner.nextLine();
                String dato = scanner.nextLine();
                int likes = Integer.parseInt(scanner.nextLine());
                String type = scanner.nextLine();

                Innlegg innlegg;

                if (type.equals(TEKST)) {
                    String tekst = scanner.nextLine();
                    innlegg = new Tekst(id, bruker, dato, likes, tekst);
                } else if (type.equals(BILDE)) {
                    String url = scanner.nextLine();
                    innlegg = new Bilde(id, bruker, dato, likes, url);
                } else {
                    
                    scanner.close();
                    throw new IOException("Ugyldig innleggstype i filen.");
                }

                blogg.leggTil(innlegg);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fil ikke funnet: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Feil under lesing av fil: " + e.getMessage());
        }

        return blogg;
    }
}