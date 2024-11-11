package no.hvl.dat100.oppgave3;

import no.hvl.dat100.oppgave1.*;

public class Blogg {

    private Innlegg[] innleggtabell;
    private int nesteledig;

    public Blogg() {
        innleggtabell = new Innlegg[20];
        nesteledig = 0;
    }

    public Blogg(int lengde) {
        innleggtabell = new Innlegg[lengde];
        nesteledig = 0;
    }

    public int getAntall() {
        return nesteledig;
    }

    public Innlegg[] getSamling() {
        return innleggtabell;
    }

    public int finnInnlegg(Innlegg innlegg) {
        for (int i = 0; i < nesteledig; i++) {
            if (innleggtabell[i].erLik(innlegg)) {
                return i;
            }
        }
        return -1;
    }

    public boolean finnes(Innlegg innlegg) {
        return finnInnlegg(innlegg) != -1;
    }

    public boolean ledigPlass() {
        return nesteledig < innleggtabell.length;
    }

    public boolean leggTil(Innlegg innlegg) {
        if (!finnes(innlegg) && ledigPlass()) {
            innleggtabell[nesteledig] = innlegg;
            nesteledig++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String resultat = nesteledig + "\n";
        for (int i = 0; i < nesteledig; i++) {
            resultat += innleggtabell[i].toString();
        }
        return resultat;
    }

    public void utvid() {
        Innlegg[] nyTabell = new Innlegg[innleggtabell.length * 2];
        for (int i = 0; i < innleggtabell.length; i++) {
            nyTabell[i] = innleggtabell[i];
        }
        innleggtabell = nyTabell;
    }

    public boolean leggTilUtvid(Innlegg innlegg) {
        if (!finnes(innlegg)) {
            if (!ledigPlass()) {
                utvid();
            }
            innleggtabell[nesteledig] = innlegg;
            nesteledig++;
            return true;
        }
        return false;
    }

    public boolean slett(Innlegg innlegg) {
        int indeks = finnInnlegg(innlegg);
        if (indeks != -1) {
            for (int i = indeks; i < nesteledig - 1; i++) {
                innleggtabell[i] = innleggtabell[i + 1];
            }
            nesteledig--;
            return true;
        }
        return false;
    }

    public int[] search(String keyword) {
        int[] funnetId = new int[nesteledig];
        int antallFunnet = 0;
        for (int i = 0; i < nesteledig; i++) {
            if (innleggtabell[i].getTekst().contains(keyword)) {
                funnetId[antallFunnet] = innleggtabell[i].getId();
                antallFunnet++;
            }
        }

        int[] resultat = new int[antallFunnet];
        System.arraycopy(funnetId, 0, resultat, 0, antallFunnet);
        return resultat;
    }
}
