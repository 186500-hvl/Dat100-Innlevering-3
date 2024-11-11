package no.hvl.dat100.oppgave2;

public class Bilde extends Tekst {

    private String url;

    public Bilde(int id, String bruker, String dato, String tekst, String url) {
        super(id, bruker, dato, tekst);
        this.url = url;
    }

    public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
        super(id, bruker, dato, likes, tekst); 

        this.url = url;
    }

    public Bilde(int id, String bruker, String dato, int likes, String url2) {
		// TODO Auto-generated constructor stub
	}

	public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString()  
 {
        return "BILDE\n" + 
               super.getId() + "\n" + 
               super.getBruker() + "\n" +
               super.getDato() + "\n" + 
               super.getLikes() + "\n" +
               super.getTekst() + "\n" + 
               url + "\n";
    }

    // Metoden nedenfor er kun for valgfri oppgave 6
    public String toHTML() {
        throw new UnsupportedOperationException("TODO.method()"); 

    }
}