public class Pasient {
	private String navn;
	private String adresse;
	private String postnr;
	private String fnummer;
	private static int pasientnummer;
	private int dettepasientnummer;


	public Pasient(String navn, String adresse, String postnr, String fnummer) {
		this.navn = navn;
		this.adresse = adresse;
		this.postnr = postnr;
		this.fnummer = fnummer;
		this.dettepasientnummer = pasientnummer++;
	}

	public int getPasientNummer(){
		return pasientnummer;
	}

	public String toString(){
		return "Navn: " + navn + System.lineSeparator() + "Adresse: " + adresse +
		       System.lineSeparator() + "Pasientnummer: " + pasientnummer;
	}

	}
