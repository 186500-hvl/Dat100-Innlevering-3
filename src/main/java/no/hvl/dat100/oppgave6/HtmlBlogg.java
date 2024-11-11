package no.hvl.dat100.oppgave6;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
	private int nesteledig;
	private Innlegg[] innleggtabell;
	
	@Override
	public String toString() {
		String resultat = nesteledig + "\n";
        for (int i = 0; i < nesteledig; i++) {
            resultat += innleggtabell[i].toHTML();
        }
        return HTMLPREFIX + resultat + HTMLPOSTFIX;
		
	}
}
